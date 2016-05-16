using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public class Usuario
    {
        public int Id { get; set; }

        public string Email { get; set; }
        
        public string Senha { get; set; }

        public string Nome { get; set; }

        public string[] Permissoes { get; set; }

        public Usuario(string nome, string email, string senha)
        {
            this.Nome  = nome;
            this.Email = email;
            this.Senha = senha;
        }

        public Usuario(int id, string nome, string email, string senha) : this(nome, email, senha)
        {
            this.Id = id;
        }
    }
}
