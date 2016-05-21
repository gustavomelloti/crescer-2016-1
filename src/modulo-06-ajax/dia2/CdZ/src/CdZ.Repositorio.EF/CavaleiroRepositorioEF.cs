using CdZ.Dominio;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;

namespace CdZ.Repositorio.EF
{
    /*
     * Criamos nosso repositório de pedidos aqui, implementando nossa
     * interface de regras de repositório de pedidos.
     */
    public class CavaleiroRepositorioEF : ICavaleiroRepositorio
    {
        public int Adicionar(Cavaleiro cavaleiro)
        {
            using (var db = new ContextoDeDados())
            {
                db.Entry<Cavaleiro>(cavaleiro).State = EntityState.Added;
                db.SaveChanges();
                return cavaleiro.Id;
            }
        }

        public Cavaleiro Buscar(int id)
        {
            using (var db = new ContextoDeDados())
            {
                return db.Cavaleiro.Include("Imagens").Include("Golpes").Include("LocalTreinamento").Include("LocalNascimento").SingleOrDefault(x => x.Id == id);
            }
        }

        public IEnumerable<Cavaleiro> Todos()
        {
            using (var db = new ContextoDeDados())
            {
                //TODO: paginar
                return db.Cavaleiro.Include("Imagens").Include("Golpes").ToList();
            }
        }

        public void Excluir(int id)
        {
            using (var db = new ContextoDeDados())
            {
                Cavaleiro cavaleiroASerExcluido = this.Buscar(id);
                db.Entry<Cavaleiro>(cavaleiroASerExcluido).State = EntityState.Deleted;
                db.SaveChanges();
            }
        }

        public void Atualizar(Cavaleiro pedido)
        {
            using (var db = new ContextoDeDados())
            {
                db.Entry<Cavaleiro>(pedido).State = EntityState.Modified;
                db.SaveChanges();
            }
        }
    }
}
