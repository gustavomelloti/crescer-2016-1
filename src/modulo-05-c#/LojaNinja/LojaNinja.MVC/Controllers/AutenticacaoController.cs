    using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using LojaNinja.MVC.Models.Login;
using LojaNinja.Dominio;
using LojaNinja.Repositorio;
using LojaNinja.MVC.Services;
using LojaNinja.MVC.Filters;

namespace LojaNinja.MVC.Controllers
{
    public class AutenticacaoController : Controller
    {
        private UsuarioServico _usuarioServico;

        public AutenticacaoController()
        {
            _usuarioServico = new UsuarioServico(new RepositorioUsuarioADO());
        }
        
        [HttpGet]
        public ActionResult Index()
        {
            if (!SessaoService.EstaLogado)
            {
                return View();
            }

            return RedirectToAction("Listagem", "Pedido");
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Login(LoginViewModel loginViewModel)
        {
            if (ModelState.IsValid)
            {
                Usuario usuarioEncontrado =
                    _usuarioServico.BuscarUsuarioPorAutenticacao(
                            loginViewModel.Email, loginViewModel.Senha
                        );

                if (usuarioEncontrado != null)
                {
                    var usuarioLogadoModel = new UsuarioLogadoModel(usuarioEncontrado);

                    SessaoService.CriarSessao(usuarioLogadoModel);
                    return RedirectToAction("Listagem", "Pedido");
                }
                else
                {
                    ModelState.AddModelError("INVALID_USER", "Usuário ou senha inválido.");
                }
            }

            return View("Index", loginViewModel);
        }

        [HttpGet]
        [CWIToken]
        public ActionResult Logout()
        {
            SessaoService.DestruirSessao();

            return View("Index");
        }
    }
}