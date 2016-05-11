using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;


namespace MVC.Controllers   
{
    public class DesafioController : Controller
    {
        public ActionResult Index(string aluno)
        {
            ViewBag.aluno = aluno;

            if (verificarSeArquivoExiste(aluno))
                return View();
            else
                return RedirectToAction("NaoEncontrado");
        }

        public ActionResult NaoEncontrado()
        {
            return View();
        }

        private Boolean verificarSeArquivoExiste(string arquivo)
        {
            return System.IO.File.Exists(
                String.Format(
                    "{0}{1}{2}.css", 
                    System.AppDomain.CurrentDomain.BaseDirectory, 
                    "Content\\Estilos\\", 
                    arquivo
                )
            );
        }
    }
}