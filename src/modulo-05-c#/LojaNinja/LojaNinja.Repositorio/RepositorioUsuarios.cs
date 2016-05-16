using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using LojaNinja.Dominio;

namespace LojaNinja.Repositorio
{
    public class RepositorioUsuarios : IUsuarioRepositorio
    {
        private static List<Usuario> Usuarios = new List<Usuario>(); 

        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            throw new NotImplementedException();
            /*
            Usuarios.Add(new Usuario()
            {
                Email = "teste@teste.com",
                Senha = "071c2146d1b620206da608c37e2e923d",
                Nome = "Batata"
            });

            Usuarios.Add(new Usuario()
            {
                Email = "teste@abc.com",
                Senha = "c19c8f9b6caad92726f88434d1493ad5",
                Nome = "Super Batata",
                Permissoes = new string[] { "GOLD" }
            });

            // VOCE NUNCA VIU ISSO =P
            return Usuarios.FirstOrDefault(
                c => c.Email.Equals(email) && c.Senha.Equals(senha));
             */
        }

        public void Cadastrar(Usuario usuario)
        {
            /* Usuarios.Add(usuario); */
            throw new NotImplementedException();
        }
    }
}
