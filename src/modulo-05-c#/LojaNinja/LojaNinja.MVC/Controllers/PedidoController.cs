using LojaNinja.Dominio;
using LojaNinja.MVC.Models;
using LojaNinja.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LojaNinja.MVC.Controllers
{
    public class PedidoController : Controller
    {
        private RepositorioVendas repositorio = new RepositorioVendas();

        public ActionResult Cadastro()
        {
            return View();
        }

        public ActionResult Salvar(PedidoModel model)
        {
            if (model.Estado == "RS" && model.Cidade == "SL")
                ModelState.AddModelError("", "Cidade e Estado inválidos");

            if (model.DataEntrega.AddDays(-7) < DateTime.Today)
                ModelState.AddModelError("DataEntrega", "Data deve ser maior do que 7 dias");

            if (ModelState.IsValid)
            {
                Pedido novoPedido; 

                try
                {
                    novoPedido = new Pedido(model.DataEntrega, model.NomeProduto, model.Valor, model.TipoPagamento, model.NomeCliente, model.Cidade, model.Estado);
                    repositorio.IncluirPedido(novoPedido);
                } 
                catch(ArgumentException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                    return View("Cadastro", model);
                }

                return View("Detalhes", new PedidoModel(novoPedido));
            }
            else
            {
                return View("Cadastro", model);
            }
        }

        public ActionResult Detalhes(int id)
        {
            var pedido = new PedidoModel(repositorio.ObterPedidoPorId(id));

            return View(pedido);
        }

        public ActionResult Listagem()
        {
            List<PedidoModel> pedidos = new List<PedidoModel>();

            foreach (var pedido in repositorio.ObterPedidos())
                pedidos.Add(new PedidoModel(pedido));

            return View(pedidos);
        }

        public ActionResult Deletar(int id)
        {
            repositorio.ExcluirPedido(id);

            return View();
        }

        public ActionResult Editar(int id)
        {
            var pedido = new PedidoModel(repositorio.ObterPedidoPorId(id));
            return View("cadastro",pedido);
        }
    }
}