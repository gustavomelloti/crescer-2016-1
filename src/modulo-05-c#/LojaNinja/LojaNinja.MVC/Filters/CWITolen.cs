﻿using LojaNinja.MVC.Models.Login;
using LojaNinja.MVC.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;

namespace LojaNinja.MVC.Filters
{
    public class CWIToken : AuthorizeAttribute
    {
        private string[] _permissoesRequeridas = null;

        private bool TemAutorizacao
        {
            get
            {
                UsuarioLogadoModel usuarioLogado = SessaoService.UsuarioLogado;

                if (this._permissoesRequeridas != null)
                {
                    foreach (string permissao in _permissoesRequeridas)
                    {
                        if (usuarioLogado.TemPermissao(permissao))
                        {
                            return true;
                        }
                    }
                }
                else
                {
                    return true;
                }

                return false;
            }
        }

        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {
            return SessaoService.EstaLogado && TemAutorizacao;
        }

        public override void OnAuthorization(AuthorizationContext filterContext)
        {
            _permissoesRequeridas = String.IsNullOrWhiteSpace(this.Roles) ?
                null :
                this.Roles.Split(',');

            bool estaAutenticadoEAutorizado = this.AuthorizeCore(filterContext.HttpContext);

            if (!estaAutenticadoEAutorizado)
            {
                filterContext.Result = new RedirectToRouteResult(
                                   new RouteValueDictionary
                                   {
                                       { "action", "Index" },
                                       { "controller", "Autenticacao" }
                                   });
            }
        }
    }
}