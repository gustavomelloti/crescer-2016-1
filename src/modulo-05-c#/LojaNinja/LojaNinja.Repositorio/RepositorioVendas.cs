using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;

namespace LojaNinja.Repositorio
{
    public class RepositorioVendas
    {
        private const string PATH_ARQUIVO = @"C:\Users\Gustavo\Documents\crescer-2016-1\src\modulo-05-c#\LojaNinja\LojaNinja.Repositorio\vendas.txt";        

        public List<Pedido> ObterPedidos()
        {
            var linhasArquivo = File.ReadAllLines(PATH_ARQUIVO).ToList();

            return ConverteLinhasEmPedidos(linhasArquivo);
        }

        public List<Pedido> ObterPedidosComFiltros(string cliente, string produto)
        {
            var pedidos = ObterPedidos();

            if (!String.IsNullOrWhiteSpace(cliente))
                pedidos = ObterPedidosPorCliente(pedidos, cliente);

            if (!String.IsNullOrWhiteSpace(produto))
                pedidos = ObterPedidosPorProduto(pedidos, produto);

            return pedidos;
        }

        public Pedido ObterPedidoPorId(int id)
        {
            return this.ObterPedidos().FirstOrDefault(x => x.Id == id);
        }

        public int IncluirPedido(Pedido pedido)
        {
            try
            {
                var idPedido = ObterProximoId();
                File.AppendAllText(PATH_ARQUIVO, String.Format("{0}{1}", idPedido, ConvertePedidoParaCSV(pedido).Substring(1)));
                return idPedido;
            }
            catch
            {
                throw new ArgumentException();
            }
        }

        public void AtualizarPedido(Pedido pedido)
        {
            try
            {
                var linhas = File.ReadAllLines(PATH_ARQUIVO).ToList();

                int linhaPedido = RetornarPosicaoPedidoNoCsv(pedido.Id);

                linhas[linhaPedido] = ConvertePedidoParaCSV(pedido).Replace("\n", "");

                File.WriteAllLines(PATH_ARQUIVO, linhas);
            }
            catch
            {
                throw new ArgumentException();
            }
        }

        public void ExcluirPedido(int id)
        {
            try
            {
                var linhas = File.ReadAllLines(PATH_ARQUIVO).ToList();

                linhas.RemoveAt(RetornarPosicaoPedidoNoCsv(id));

                File.WriteAllLines(PATH_ARQUIVO, linhas);
            }
            catch
            {
                throw new ArgumentException();
            }
        }

        private List<Pedido> ObterPedidosPorCliente(List<Pedido> pedidos, string cliente)
        {
            return pedidos.Where(x => x.NomeCliente.ToLower().Equals(cliente.ToLower())).ToList();
        }

        private List<Pedido> ObterPedidosPorProduto(List<Pedido> pedidos, string produto)
        {
            return pedidos.Where(x => x.NomeProduto.ToLower().Equals(produto.ToLower())).ToList();
        }

        private int ObterProximoId()
        {
            var linhas = File.ReadAllLines(PATH_ARQUIVO).ToArray();

            var linha = linhas[linhas.Length - 1];

            return Convert.ToInt16(linha.Split(';')[0]) + 1;
        }

        private int RetornarPosicaoPedidoNoCsv(int idPedido)
        {
            var linhas = File.ReadAllLines(PATH_ARQUIVO).ToList();

            for (int i = 0; i < linhas.Count; i++)
            {
                if (linhas[i].StartsWith(String.Format("{0}{1}", idPedido, ";")))
                {
                    return i;
                }
            }

            throw new ArgumentException();
        }

        private List<Pedido> ConverteLinhasEmPedidos(List<string> linhasArquivo)
        {
            var listaPedidos = new List<Pedido>();

            //Remove linha do cabeçalho
            linhasArquivo.RemoveAt(0);

            foreach (var linha in linhasArquivo)
            {
                var id = Convert.ToInt32(linha.Split(';')[0]);
                var dataPedido = Convert.ToDateTime(linha.Split(';')[1]);
                var dataEntregaDesejada = Convert.ToDateTime(linha.Split(';')[2]);
                var nomeProduto = linha.Split(';')[3];
                var valorVenda = Convert.ToDecimal(linha.Split(';')[4]);
                TipoPagamento tipoPagamento;
                Enum.TryParse(linha.Split(';')[5], out tipoPagamento);
                var nomeCliente = linha.Split(';')[6];
                var cidade = linha.Split(';')[7];
                var estado = linha.Split(';')[8];
                var urgente = Convert.ToBoolean(linha.Split(';')[9]);

                var pedido = new Pedido(id, dataPedido, dataEntregaDesejada, nomeProduto, valorVenda, tipoPagamento, nomeCliente, cidade, estado, urgente);
                listaPedidos.Add(pedido);
            }

            return listaPedidos;
        }

        private string ConvertePedidoParaCSV(Pedido pedido)
        {
            return String.Format(
                "{0};{1};{2};{3};{4};{5};{6};{7};{8};{9} \n",
                pedido.Id,
                pedido.DataPedido.ToString("dd/MM/yyyy"),
                pedido.DataEntregaDesejada.ToString("dd/MM/yyyy"),
                pedido.NomeProduto.ToString().Replace(",", ""),
                pedido.Valor,
                pedido.TipoPagamento,
                pedido.NomeCliente,
                pedido.Cidade,
                pedido.Estado,
                pedido.PedidoUrgente.ToString().ToLower()
            );
        }
    }
}
