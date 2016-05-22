using CdZ.Dominio;
using CdZ.MVC.Models.Cavaleiro;
using CdZ.MVC.Services;
using System.Net;
using System.Web.Mvc;
using PagedList;

namespace CdZ.MVC.Controllers
{
    public class CavaleiroController : Controller
    {
        private ICavaleiroRepositorio _cavaleiros = ServicoInjecaoDeDependecia.CriarCavaleiroRepositorio();

        [HttpGet]
        public ActionResult Index()
        {
            return View("Listagem");
        }

        [HttpGet]
        public ActionResult List(int? page)
        {
            int pageSize = 2;
            int pageNumber = (page ?? 1);
            var cavaleiros = _cavaleiros.Todos().ToPagedList(pageNumber, pageSize);
            return PartialView("_ListagemCaveleiros", cavaleiros);
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
            if (cavaleiro.Id.HasValue)
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
