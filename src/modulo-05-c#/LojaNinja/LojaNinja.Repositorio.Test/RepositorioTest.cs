using System;
using System.IO;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using LojaNinja.Dominio;

namespace LojaNinja.Repositorio.Test
{
    [TestClass]
    public class RepositorioTest
    {
        private const string PATH_ARQUIVO = @"C:\Users\Gustavo\Documents\crescer-2016-1\src\modulo-05-c#\LojaNinja\LojaNinja.Repositorio.Test\vendasTest.txt";
        private RepositorioVendas _repositorioVendas = new RepositorioVendas(PATH_ARQUIVO);

        [TestInitialize()]
        public void PopularCsv()
        {
            File.AppendAllText(PATH_ARQUIVO, "Numero Pedido;Data Pedido;Data Desejo Entrega;Nome Produto;Valor Venda;Tipo Pagamento;Nome Cliente;Cidade;Estado;Urgente \n");
            File.AppendAllText(PATH_ARQUIVO, "1;01/01/0001;22/05/2016;Kunai;1200,00;Mastercard;carolina;Basildon;England;false \n");
            File.AppendAllText(PATH_ARQUIVO, "2;01/04/2009 13:17;01/04/2009 13:17;Faca de Gauderio;1200;Mastercard;Nunes;Sao Leopoldo;Rio Grande do Sul;true \n");
            File.AppendAllText(PATH_ARQUIVO, "3;01/04/2009 14:11;01/04/2009 14:11;Katana;1200;Visa;Aidan;Chatou;Ile-de-France;true \n");
            File.AppendAllText(PATH_ARQUIVO, "4;01/02/2009 09:16;01/02/2009 09:16;Kunai;1200;Mastercard;Sean;Shavano Park ;TX;true \n");
        }

        [TestCleanup()]
        public void LimparArquivo()
        {
            File.WriteAllText(PATH_ARQUIVO, "");
        }
        
        [TestMethod]
        public void ObterTodosOsPedidosDoCsvComparandoOTamanhoDoArquivo()
        {
            int qtdRegistros = File.ReadAllLines(PATH_ARQUIVO).Length;

            //decrementa a linha do título
            qtdRegistros--;

            Assert.AreEqual(qtdRegistros, _repositorioVendas.ObterPedidos().Count);
        }

        [TestMethod]
        public void PesquisarPedidoPorId1DeveRetornarPedido()
        {
            Assert.IsNotNull(_repositorioVendas.ObterPedidoPorId(1));
        }

        [TestMethod]
        public void PesquisarPedidoComIdInexistenteDeveRetornarNull()
        {
            Assert.IsNull(_repositorioVendas.ObterPedidoPorId(8));
        }

        [TestMethod]
        public void PesquisarPedidoComFiltrosPassandoNullComoValor()
        {
            var pedidos = _repositorioVendas.ObterPedidosComFiltros(null,null);
            Assert.AreEqual(4, pedidos.Count);
        }

        [TestMethod]
        public void PesquisarPedidoComProdutoKunaiDeveRetornar2()
        {
            var pedidos = _repositorioVendas.ObterPedidosComFiltros(null, "Kunai");
            Assert.AreEqual(2, pedidos.Count);
        }

        [TestMethod]
        public void PesquisarPedidoComClienteAidanDeveRetornar1()
        {
            var pedidos = _repositorioVendas.ObterPedidosComFiltros("Aidan", null);
            Assert.AreEqual(1, pedidos.Count);
        }

        [TestMethod]
        public void PesquisarPedidoComClienteAidanEProdutoKunaiDeveRetornar1()
        {
            var pedidos = _repositorioVendas.ObterPedidosComFiltros("Sean", "Kunai");
            Assert.AreEqual(1, pedidos.Count);
        }

        [TestMethod]
        public void PesquisarPedidoComClienteInexistenteEProdutoKunaiDeveRetornar0()
        {
            var pedidos = _repositorioVendas.ObterPedidosComFiltros("Gustavo", "Kunai");
            Assert.AreEqual(0, pedidos.Count);
        }

        [TestMethod]
        public void PesquisarPedidoComClienteSeanEProdutoFacaDeveRetornar0()
        {
            var pedidos = _repositorioVendas.ObterPedidosComFiltros("Sean", "Faca");
            Assert.AreEqual(0, pedidos.Count);
        }

        [TestMethod]
        public void AdicionarNovoPedidoNoRespositorioEValidarId()
        {
            int idPedidoAdicionado = _repositorioVendas.IncluirPedido(
                new Pedido(DateTime.Today.AddDays(5), "Facao", 120, TipoPagamento.Diners, "Gustavo", "Porto Alegre", "RS")
            );

            Assert.AreEqual(5, idPedidoAdicionado);
        }

        [TestMethod]
        public void ExcluirPedidoComId1EQuandoBuscaloDeveRetornarNull()
        {
            _repositorioVendas.ExcluirPedido(1);

            Assert.IsNull(_repositorioVendas.ObterPedidoPorId(1));
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void ExcluirPedidoComIdInvalidoDeveLancarExcecao()
        {
            _repositorioVendas.ExcluirPedido(-1);
        }

        [TestMethod]
        public void AtualizarNomeDoClienteParaPedroDoPedidoComId1()
        {
            var pedido = _repositorioVendas.ObterPedidoPorId(1);
           
            var pedidoAtualizado = new Pedido(pedido.Id, pedido.DataPedido, pedido.DataEntregaDesejada, pedido.NomeProduto, pedido.Valor, pedido.TipoPagamento, "Pedro", pedido.Cidade, pedido.Estado, pedido.PedidoUrgente);

            _repositorioVendas.AtualizarPedido(pedidoAtualizado);

            Assert.AreEqual("Pedro", _repositorioVendas.ObterPedidoPorId(1).NomeCliente);
        }
    }
}
