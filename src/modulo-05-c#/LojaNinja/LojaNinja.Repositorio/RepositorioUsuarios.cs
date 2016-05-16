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
        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            // FINGE QUE ESSA LISTA É NOSSO BANCO DE DADOS =)
            var usuarios = new List<Usuario>();
            usuarios.Add(new Usuario()
            {
                Email = "teste@teste.com",
                Senha = "071c2146d1b620206da608c37e2e923d",
                Nome = "Batata"
            });

            usuarios.Add(new Usuario()
            {
                Email = "teste@abc.com",
                Senha = "c19c8f9b6caad92726f88434d1493ad5",
                Nome = "Super Batata",
                Permissoes = new string[] { "GOLD" }
            });
            // VOCE NUNCA VIU ISSO =P

            return usuarios.FirstOrDefault(
                c => c.Email.Equals(email) && c.Senha.Equals(senha));
        }

    }
}
