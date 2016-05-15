using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using LojaNinja.Dominio;
using System.Collections;

namespace LojaNinja.Domino.Test
{
    [TestClass]
    public class PedidoTest
    {
        private ArrayList peidoDefault = new ArrayList();

        public PedidoTest()
        {
            peidoDefault.Add(DateTime.Today.AddDays(2));
            peidoDefault.Add("Facão 3 listras");
            peidoDefault.Add(2000);
            peidoDefault.Add(TipoPagamento.Mastercard);
            peidoDefault.Add("Gustavo");
            peidoDefault.Add("Porto Alegre");
            peidoDefault.Add("RS");
        }

        [TestMethod]
        public void GerarPedidoComEntregaParaDoisAposDataAtual()
        {
            Pedido pedido = new Pedido(Convert.ToDateTime(peidoDefault[0]), Convert.ToString(peidoDefault[1]), Convert.ToDecimal(peidoDefault[2]), (TipoPagamento) peidoDefault[3], Convert.ToString(peidoDefault[4]), Convert.ToString(peidoDefault[5]), Convert.ToString(peidoDefault[6]));

            Assert.AreEqual(Convert.ToDateTime(peidoDefault[0]), pedido.DataEntregaDesejada);
            Assert.AreEqual(Convert.ToString(peidoDefault[1]), pedido.NomeProduto);
            Assert.AreEqual( Convert.ToDecimal(peidoDefault[2]), pedido.Valor);
            Assert.AreEqual((TipoPagamento)peidoDefault[3], pedido.TipoPagamento);
            Assert.AreEqual(Convert.ToString(peidoDefault[4]), pedido.NomeCliente);
            Assert.AreEqual(Convert.ToString(peidoDefault[5]), pedido.Cidade);
            Assert.AreEqual(Convert.ToString(peidoDefault[6]), pedido.Estado);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void GerarPedidoComDataEntregaIgualAAtualEDeveLancarExcecao()
        {
            peidoDefault[0] = DateTime.Today;

            Pedido pedido = new Pedido(Convert.ToDateTime(peidoDefault[0]), Convert.ToString(peidoDefault[1]), Convert.ToDecimal(peidoDefault[2]), (TipoPagamento)peidoDefault[3], Convert.ToString(peidoDefault[4]), Convert.ToString(peidoDefault[5]), Convert.ToString(peidoDefault[6]));
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void GerarPedidoComDataEntregaDeDoisDiasAtrasEDeveLancarExcecao()
        {
            peidoDefault[0] = DateTime.Today.AddDays(-2);

            Pedido pedido = new Pedido(Convert.ToDateTime(peidoDefault[0]), Convert.ToString(peidoDefault[1]), Convert.ToDecimal(peidoDefault[2]), (TipoPagamento)peidoDefault[3], Convert.ToString(peidoDefault[4]), Convert.ToString(peidoDefault[5]), Convert.ToString(peidoDefault[6]));
        }

        [TestMethod]
        public void GerarPedidoComDataEntregaMenorDe7Dias()
        {
            peidoDefault[0] = DateTime.Today.AddDays(+2);

            Pedido pedido = new Pedido(Convert.ToDateTime(peidoDefault[0]), Convert.ToString(peidoDefault[1]), Convert.ToDecimal(peidoDefault[2]), (TipoPagamento)peidoDefault[3], Convert.ToString(peidoDefault[4]), Convert.ToString(peidoDefault[5]), Convert.ToString(peidoDefault[6]));

            Assert.IsTrue(pedido.PedidoUrgente);
        }

        [TestMethod]
        public void GerarPedidoComDataEntregaMaiorDe7Dias()
        {
            peidoDefault[0] = DateTime.Today.AddDays(+8);

            Pedido pedido = new Pedido(Convert.ToDateTime(peidoDefault[0]), Convert.ToString(peidoDefault[1]), Convert.ToDecimal(peidoDefault[2]), (TipoPagamento)peidoDefault[3], Convert.ToString(peidoDefault[4]), Convert.ToString(peidoDefault[5]), Convert.ToString(peidoDefault[6]));

            Assert.IsFalse(pedido.PedidoUrgente);
        }

        [TestMethod]
        public void GerarPedidoComDataEntregaIguala7Dias()
        {
            peidoDefault[0] = DateTime.Today.AddDays(+7);

            Pedido pedido = new Pedido(Convert.ToDateTime(peidoDefault[0]), Convert.ToString(peidoDefault[1]), Convert.ToDecimal(peidoDefault[2]), (TipoPagamento)peidoDefault[3], Convert.ToString(peidoDefault[4]), Convert.ToString(peidoDefault[5]), Convert.ToString(peidoDefault[6]));

            Assert.IsFalse(pedido.PedidoUrgente);
        }
    }
}
