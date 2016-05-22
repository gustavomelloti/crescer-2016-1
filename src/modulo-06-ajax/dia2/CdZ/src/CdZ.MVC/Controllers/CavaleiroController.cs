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

        [HttpGet]
        public JsonResult GetById(int id)
        {
            return Json(new { data = _cavaleiros.Buscar(id) }, JsonRequestBehavior.AllowGet);
        }

        [HttpPost]
        public JsonResult Post(CavaleiroViewModel cavaleiro)
        {
            if (cavaleiro.Id > 0)
            {
                _cavaleiros.Atualizar(cavaleiro.ToModelWithId());
            }
            else
            {
                _cavaleiros.Adicionar(cavaleiro.ToModel());
            }

            Response.StatusCode = (int)HttpStatusCode.Created;
            return Json(new { });
        }

        [HttpDelete]
        public JsonResult Delete(int idCavaleiro)
        {
            _cavaleiros.Excluir(idCavaleiro);
            Response.StatusCode = (int)HttpStatusCode.Accepted;
            return Json(new {});
        }

        [HttpGet]
        public ViewResult Editar(int id)
        {
            ViewBag.Acao = "Edição de Cavaleiros";

            var cavaleiroViewModel = new CavaleiroViewModel();

            cavaleiroViewModel.toVieModel(_cavaleiros.Buscar(id));

            return View("cadastrar", cavaleiroViewModel);
        }

        [HttpGet]
        public ViewResult Cadastrar()
        {
            ViewBag.Acao = "Cadastro de Cavaleiros";

            return View();
        }
    }
}
