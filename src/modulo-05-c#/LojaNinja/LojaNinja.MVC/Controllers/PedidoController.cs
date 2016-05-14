﻿using LojaNinja.Dominio;
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
            ViewBag.Operacao = "Novo pedido";

            return View();
        }

        public ActionResult Detalhes(int id)
        {
            var pedido = new PedidoModel(repositorio.ObterPedidoPorId(id));

            return View(pedido);
        }

        [HttpGet]
        public ActionResult Listagem()
        {            
            return View(FormatarPedidosEmPedidosModel(repositorio.ObterPedidos()));
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Listagem(string cliente, string produto)
        {
            ViewBag.ClientePesquisa = cliente;
            ViewBag.ProdutoPesquisa = produto;

            return View(FormatarPedidosEmPedidosModel(repositorio.ObterPedidosComFiltros(cliente, produto)));
        }

        public ActionResult Excluir(int id)
        {
            repositorio.ExcluirPedido(id);

            return View();
        }

        public ActionResult Editar(int id)
        {
            ViewBag.Operacao = "Editar pedido";

            var pedido = new PedidoModel(repositorio.ObterPedidoPorId(id));

            return View("cadastro", pedido);
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
                    if (model.Id <= 0)
                    {
                        var pedido = new Pedido(model.DataEntrega, model.NomeProduto, model.Valor, model.TipoPagamento, model.NomeCliente, model.Cidade, model.Estado);
                        var idPedido = repositorio.IncluirPedido(pedido);
                        pedidoModel = new PedidoModel(pedido);
                        pedidoModel.Id = idPedido;
                    }
                    else
                    {
                        var pedido = new Pedido(model.Id, model.DataPedido, model.DataEntrega, model.NomeProduto, model.Valor, model.TipoPagamento, model.NomeCliente, model.Cidade, model.Estado, model.PedidoUrgente);
                        repositorio.AtualizarPedido(pedido);
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