using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Repositorio.EF
{
    public class UsuarioRepositorio : IUsuarioRepositorio
    {
        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            using (var db = new ContextoDados())
            {
                return db.Usuario.Include("Permissoes").FirstOrDefault(
                    u => u.Email.Equals(email) && u.Senha.Equals(senha)
                 );
            }
        }

        public void Cadastrar(Usuario usuario)
        {
            using(var contexto = new ContextoDados())
            {
                contexto.Entry<Usuario>(usuario).State = System.Data.Entity.EntityState.Added;
                contexto.SaveChanges();
            }
        }
    }
}
