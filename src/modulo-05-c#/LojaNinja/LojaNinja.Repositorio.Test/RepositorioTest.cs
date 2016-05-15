using System;
using System.IO;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace LojaNinja.Repositorio.Test
{
    [TestClass]
    public class RepositorioTest
    {
        private const string PATH_ARQUIVO = @"C:\Users\Gustavo\Documents\crescer-2016-1\src\modulo-05-c#\LojaNinja\LojaNinja.Repositorio\vendas.txt";
        private RepositorioVendas _repositorioVendas = new RepositorioVendas();
  
        [TestMethod]
        public void ObterTodosOsPedidosDoCsv()
        {   
            int qtdRegistros = File.ReadAllLines(PATH_ARQUIVO).Length;

            //decrementa a linha do título
            qtdRegistros--;

            Assert.AreEqual(qtdRegistros, _repositorioVendas.ObterPedidos().Count);
        }

        [TestMethod]
        public void ObterPedidoComIdValido()
        {   
            Assert.AreEqual(500, _repositorioVendas.ObterPedidoPorId(500).Id);
        }

        [TestMethod]
        public void ObterPedidoComIdInvalido()
        {
            Assert.IsNull(_repositorioVendas.ObterPedidoPorId(-1));
        }

        [TestMethod]
        public void ExcluirPedidoComIdValido()
        {
            throw new NotImplementedException();
        }

        [TestMethod]
        public void ExcluirPedidoComIdInvalido()
        {
            throw new NotImplementedException();
        }
    }
}
