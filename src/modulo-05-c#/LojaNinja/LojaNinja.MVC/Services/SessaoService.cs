﻿using LojaNinja.MVC.Models.Login;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Services
{
    public static class SessaoService
    {
        private const string COOKIE_AUTENTICACAO = "COOKIE_AUTENTICACAO";
        private const string USUARIO_LOGADO = "USUARIO_LOGADO";
        private static Dictionary<string, string> _usuariosLogados = new Dictionary<string, string>();

        public static UsuarioLogadoModel UsuarioLogado
        {
            get
            {
                return (UsuarioLogadoModel)HttpContext.Current.Session[USUARIO_LOGADO];
            }
        }

        public static bool EstaLogado
        {
            get
            {
                if (UsuarioLogado != null)
                {
                    HttpCookie cookieDeAutenticacao = HttpContext.Current.Request.Cookies.Get(COOKIE_AUTENTICACAO);

                    bool cookieEstaOk = _usuariosLogados.Any(
                            u => u.Key.Equals(cookieDeAutenticacao.Value)
                            && u.Value.Equals(UsuarioLogado.Email)
                        );

                    return cookieEstaOk;
                }

                return false;
            }
        }

        public static void CriarSessao(UsuarioLogadoModel usuario)
        {
            string numeroToken = Guid.NewGuid().ToString();
            _usuariosLogados.Add(numeroToken, usuario.Email);

            HttpContext.Current.Session[USUARIO_LOGADO] = usuario;
            var cookieDeAutenticacao = new HttpCookie(COOKIE_AUTENTICACAO, numeroToken);

            HttpContext.Current.Response.Cookies.Set(cookieDeAutenticacao);
        }

        public static void DestruirSessao()
        {
            var idCoockieAutenticacao = HttpContext.Current.Request.Cookies[COOKIE_AUTENTICACAO].Value;

            _usuariosLogados.Remove(idCoockieAutenticacao);

            HttpContext.Current.Session.Abandon();
        }
    }
}