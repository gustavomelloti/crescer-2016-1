using CdZ.Dominio;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;

namespace CdZ.Repositorio.EF
{
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
                return db.Cavaleiro
                    .Include("Imagens")
                    .Include("Golpes")
                    .Include("LocalTreinamento")
                    .Include("LocalNascimento")
                    .SingleOrDefault(x => x.Id == id);
            }
        }

        public IEnumerable<Cavaleiro> Todos()
        {
            using (var db = new ContextoDeDados())
            {
                //TODO: paginar
                return db.Cavaleiro.Include("Imagens").ToList();
            }
        }

        public void Excluir(int id)
        {
            using (var db = new ContextoDeDados())
            {
                var cavaleiroASerExcluido = db.Cavaleiro.Find(id);
                var localNascimento = db.Cavaleiro.Include(_ => _.LocalNascimento).Single(_ => _.Id == id).LocalNascimento;
                var localTreinamento = db.Cavaleiro.Include(_ => _.LocalTreinamento).Single(_ => _.Id == id).LocalTreinamento;
                db.Cavaleiro.Remove(cavaleiroASerExcluido);
                db.Local.Remove(localNascimento);
                db.Local.Remove(localTreinamento);
                db.SaveChanges();
            }
        }

        public void Atualizar(Cavaleiro cavaleiro)
        {
            using (var db = new ContextoDeDados())
            {
                db.Entry<Local>(cavaleiro.LocalNascimento).State = cavaleiro.LocalNascimento.Id == default(int) ? EntityState.Added : EntityState.Modified;
                db.Entry<Local>(cavaleiro.LocalTreinamento).State = cavaleiro.LocalTreinamento.Id == default(int) ? EntityState.Added : EntityState.Modified;

                foreach (var golpe in cavaleiro.Golpes)
                {
                    db.Entry<Golpe>(golpe).State = golpe.Id == default(int) ? EntityState.Added : EntityState.Modified;
                }

                foreach (var imagem in cavaleiro.Imagens)
                {
                    db.Entry<Imagem>(imagem).State = imagem.Id == default(int) ? EntityState.Added : EntityState.Modified;
                }

                db.Entry<Cavaleiro>(cavaleiro).State = EntityState.Modified;
                db.SaveChanges();
            }
        }
    }
}
