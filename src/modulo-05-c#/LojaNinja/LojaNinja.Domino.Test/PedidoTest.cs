using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using LojaNinja.Dominio;

namespace LojaNinja.Domino.Test
{
    [TestClass]
    public class PedidoTest
    {
        [TestMethod]
        public void GerarPedidoComEntregaParaDoisAposDataAtual()
        {
            DateTime dataEntregaDesejada = DateTime.Today.AddDays(2);
            string nomeProduto = "Facão 3 listras";
            decimal valorPedido = 2000;
            TipoPagamento tipoPagamento = TipoPagamento.Mastercard;
            string nomeCliente = "Gustavo";
            string cidade = "Porto Alegre";
            string estado =  "RS";

            Pedido pedido = new Pedido(dataEntregaDesejada, nomeProduto, valorPedido, tipoPagamento, nomeCliente, cidade, estado);

            Assert.AreEqual(dataEntregaDesejada, pedido.DataEntregaDesejada);
            Assert.AreEqual(nomeProduto, pedido.NomeProduto);
            Assert.AreEqual(valorPedido, pedido.Valor);
            Assert.AreEqual(tipoPagamento, pedido.TipoPagamento);
            Assert.AreEqual(nomeCliente, pedido.NomeCliente);
            Assert.AreEqual(cidade, pedido.Cidade);
            Assert.AreEqual(estado, pedido.Estado);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void TentarGerarPedidoComDataEntregaIgualAAtual()
        {
            DateTime dataEntregaDesejada = DateTime.Today;
            string nomeProduto = "Facão 3 listras";
            decimal valorPedido = 2000;
            TipoPagamento tipoPagamento = TipoPagamento.Mastercard;
            string nomeCliente = "Gustavo";
            string cidade = "Porto Alegre";
            string estado = "RS";

            Pedido pedido = new Pedido(dataEntregaDesejada, nomeProduto, valorPedido, tipoPagamento, nomeCliente, cidade, estado);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void TentarGerarPedidoComDataEntregaDeDoisDiasAtras()
        {
            DateTime dataEntregaDesejada = DateTime.Today.AddDays(-2);
            string nomeProduto = "Facão 3 listras";
            decimal valorPedido = 2000;
            TipoPagamento tipoPagamento = TipoPagamento.Mastercard;
            string nomeCliente = "Gustavo";
            string cidade = "Porto Alegre";
            string estado = "RS";

            Pedido pedido = new Pedido(dataEntregaDesejada, nomeProduto, valorPedido, tipoPagamento, nomeCliente, cidade, estado);
        }

        [TestMethod]
        public void GerarPedidoComDataEntregaMenorDe7Dias()
        {
            DateTime dataEntregaDesejada = DateTime.Today.AddDays(+2);
            string nomeProduto = "Facão 3 listras";
            decimal valorPedido = 2000;
            TipoPagamento tipoPagamento = TipoPagamento.Mastercard;
            string nomeCliente = "Gustavo";
            string cidade = "Porto Alegre";
            string estado = "RS";

            Pedido pedido = new Pedido(dataEntregaDesejada, nomeProduto, valorPedido, tipoPagamento, nomeCliente, cidade, estado);

            Assert.IsTrue(pedido.PedidoUrgente);
        }

        [TestMethod]
        public void GerarPedidoComDataEntregaMaiorDe7Dias()
        {
            DateTime dataEntregaDesejada = DateTime.Today.AddDays(+8);
            string nomeProduto = "Facão 3 listras";
            decimal valorPedido = 2000;
            TipoPagamento tipoPagamento = TipoPagamento.Mastercard;
            string nomeCliente = "Gustavo";
            string cidade = "Porto Alegre";
            string estado = "RS";

            Pedido pedido = new Pedido(dataEntregaDesejada, nomeProduto, valorPedido, tipoPagamento, nomeCliente, cidade, estado);

            Assert.IsFalse(pedido.PedidoUrgente);
        }

        [TestMethod]
        public void GerarPedidoComDataEntregaIguala7Dias()
        {
            DateTime dataEntregaDesejada = DateTime.Today.AddDays(+7);
            string nomeProduto = "Facão 3 listras";
            decimal valorPedido = 2000;
            TipoPagamento tipoPagamento = TipoPagamento.Mastercard;
            string nomeCliente = "Gustavo";
            string cidade = "Porto Alegre";
            string estado = "RS";

            Pedido pedido = new Pedido(dataEntregaDesejada, nomeProduto, valorPedido, tipoPagamento, nomeCliente, cidade, estado);

            Assert.IsFalse(pedido.PedidoUrgente);
        }
    }
}
