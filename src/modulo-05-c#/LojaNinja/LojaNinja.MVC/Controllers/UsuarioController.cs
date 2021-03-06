﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using LojaNinja.Repositorio;
using LojaNinja.MVC.Models.Usuarios;
using LojaNinja.Dominio;
using LojaNinja.Repositorio.EF;

namespace LojaNinja.MVC.Controllers
{
    public class UsuarioController : Controller
    {

        private UsuarioServico _usuarioServico;

        public UsuarioController()
        {
            _usuarioServico = new UsuarioServico(new RepositorioUsuario());
        }

        [HttpGet]
        public ActionResult Cadastrar()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Salvar(UsuarioModel usuarioModel)
        {
            try
            {
                _usuarioServico.AdicionarUsuario(new Usuario(usuarioModel.Nome, usuarioModel.Email, usuarioModel.Senha));

                TempData["CadastroRealizado"] = "Cadastro realizado com sucesso! Agora você pode realizar Login!";
                
                return RedirectToAction("Index", "Autenticacao");
            }
            catch
            {
                return View("Cadastrar");
            }  
        }
    }
}