using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using MVC.Models;

namespace MVC.Controllers
{
    public class StreetFighterController : Controller
    {        
        public ActionResult Index()
        {
            return View();
        }

        public ActionResult FichaTecnica()
        {
            return View();
        }

        public ActionResult SobreMim()
        {
            var sobreMim = new SobreMimModel
            {
                Nome = "Gustavo Mello",
                Idade = 19,
                Universidade = "Unisinos",
                Foto = "https://www.piqube.com/home/img/user-icon.png"
            };

            return View(sobreMim);
        }
    }
}