using CdZ.Dominio;
using CdZ.MVC.Models.Cavaleiro;
using CdZ.MVC.Services;
using System.Net;
using System.Web.Mvc;

namespace CdZ.MVC.Controllers
{
    public class CavaleiroController : Controller
    {
        private ICavaleiroRepositorio _cavaleiros = ServicoInjecaoDeDependecia.CriarCavaleiroRepositorio();

        [HttpGet]
        public ActionResult Index()
        {
            return View();
        }

        [HttpGet]
        public JsonResult Get()
        {
            /* Para simular erro, descomente
                var status = (int)HttpStatusCode.InternalServerError;
                throw new HttpException(status, "Ops");
            */
            return Json(new { data = _cavaleiros.Todos() }, JsonRequestBehavior.AllowGet);
        }

        [HttpPost]
        public JsonResult Post(CavaleiroViewModel cavaleiro)
        {
            var a = 'a';
            var novoId = _cavaleiros.Adicionar(cavaleiro.ToModel());
            Response.StatusCode = (int)HttpStatusCode.Created;
            return Json(new { id = novoId });
        }

        [HttpDelete]
        public JsonResult Delete(int idCavaleiro)
        {
            _cavaleiros.Excluir(idCavaleiro);
            Response.StatusCode = (int)HttpStatusCode.Accepted;
            return Json(new {});
        }

        [HttpGet]
        public ViewResult Cadastrar()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public ViewResult SalvarCavaleiro(CavaleiroViewModel cavaleiroViewModel)
        {
            _cavaleiros.Adicionar(cavaleiroViewModel.ToModel());
            return View();
        }
    }
}
