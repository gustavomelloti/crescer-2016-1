using LojaNinja.Dominio;
using LojaNinja.MVC.Filters;
using LojaNinja.MVC.Models;
using LojaNinja.Repositorio.EF;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace LojaNinja.MVC.Controllers
{
    [CWIToken(Roles = "COMUM")]
    public class PedidoController : Controller
    {
        private IPedidoRepositorio _pedidoRepositorio;

        public PedidoController()
        {
            _pedidoRepositorio = new RepositorioVendas();
        }

        [HttpGet]
        public ActionResult Cadastro()
        {
            ViewBag.Operacao = "Novo pedido";

            return View();
        }

        [HttpGet]
        public ActionResult Detalhes(int id)
        {
            try
            {
                var pedido = new PedidoModel(_pedidoRepositorio.ObterPedidoPorId(id));
                return View(pedido);
            }
            catch
            {
                ViewBag.Erro = "Pedido não encontrado.";
                return View("Erro");
            }
        }

        [HttpGet]
        public ActionResult Listagem()
        {
            return View(FormatarPedidosEmPedidosModel(_pedidoRepositorio.ObterPedidos()));
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Listagem(string cliente, string produto)
        {
            ViewBag.ClientePesquisa = cliente;
            ViewBag.ProdutoPesquisa = produto;

            return View(FormatarPedidosEmPedidosModel(_pedidoRepositorio.ObterPedidosComFiltros(cliente, produto)));
        }

        [CWIToken(Roles = "ADMIN")]
        [HttpGet]
        public ActionResult Excluir(int id)
        {
            try
            {
                _pedidoRepositorio.ExcluirPedido(id);
                return View();
            }
            catch
            {
                ViewBag.Erro = "Erro ao excluir pedido";
                return View("Erro");
            }
        }

        [CWIToken(Roles = "ADMIN")]
        [HttpGet]
        public ActionResult Editar(int id)
        {
            try
            {
                ViewBag.Operacao = "Editar pedido";
                var pedido = new PedidoModel(_pedidoRepositorio.ObterPedidoPorId(id));
                return View("cadastro", pedido);
            }
            catch
            {
                ViewBag.Erro = "Pedido não encontrado.";
                return View("Erro");
            }
        }
        
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Salvar(PedidoModel model)
        {
            if (model.Estado == "RS" && model.Cidade == "SL")
                ModelState.AddModelError("", "Cidade e Estado inválidos");

            if (model.DataEntrega.AddDays(-7) < DateTime.Today)
                ModelState.AddModelError("DataEntrega", "Data deve ser maior do que 7 dias");

            if (ModelState.IsValid)
            {
                PedidoModel pedidoModel = null;

                try
                {
                    // cadastro
                    if (model.Id <= 0)
                    {
                        var pedido = new Pedido(model.DataEntrega, model.NomeProduto, model.Valor, model.TipoPagamento, model.NomeCliente, model.Cidade, model.Estado);
                        var idPedido = _pedidoRepositorio.IncluirPedido(pedido);
                        pedidoModel = new PedidoModel(pedido);
                        pedidoModel.Id = idPedido;
                    }
                    // edição
                    else
                    {
                        var pedido = new Pedido(model.Id, model.DataPedido, model.DataEntrega, model.NomeProduto, model.Valor, model.TipoPagamento, model.NomeCliente, model.Cidade, model.Estado, model.PedidoUrgente);
                        _pedidoRepositorio.AtualizarPedido(pedido);
                        pedidoModel = new PedidoModel(pedido);
                    }

                    return RedirectToAction("Detalhes", pedidoModel);

                } 
                catch(ArgumentException ex)
                {
                    ModelState.AddModelError("", ex.Message);
                    return View("Cadastro", model);
                }
            }
            else
            {
                return View("Cadastro", model);
            }
        }

        private List<PedidoModel> FormatarPedidosEmPedidosModel(List<Pedido> pedidos)
        {
            List<PedidoModel> pedidosModel = new List<PedidoModel>();

            foreach (var pedido in pedidos)
                pedidosModel.Add(new PedidoModel(pedido));

            return pedidosModel;
        }
    }
}