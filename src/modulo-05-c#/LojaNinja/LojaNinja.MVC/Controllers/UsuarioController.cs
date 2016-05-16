using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using LojaNinja.Repositorio;
using LojaNinja.MVC.Models.Usuarios;
using LojaNinja.Dominio;

namespace LojaNinja.MVC.Controllers
{
    public class UsuarioController : Controller
    {

        private UsuarioServico _usuarioServico;

        public UsuarioController()
        {
            _usuarioServico = new UsuarioServico(new RepositorioUsuarioADO());
        }

        public ActionResult Index()
        {
            return View();
        }

        public ActionResult Cadastrar()
        {
            return View();
        }

        public ActionResult Salvar(UsuarioModel usuarioModel)
        {
            try
            {
                ViewBag.CadastroRealizado = "Cadastro realizado com sucesso! Agora você pode realizar Login!";
                
                return RedirectToAction("Login", "Autenticacao");
            }
            catch
            {
                return View();
            }  
        }
    }
}