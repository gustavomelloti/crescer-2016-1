using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public class Usuario
    {
        public int Id { get; private set; }

        public string Email { get; private set; }
        
        public string Senha { get; private set; }

        public string Nome { get; private set; }

        public Permissao Permissoes { get; set; }

        public Usuario(string nome, string email, string senha)
        {
            this.Nome  = nome;
            this.Email = email;
            this.Senha = senha;
            this.Permissoes = new Permissao();
            this.Permissoes.AdicionarPermissao("COMUM");
        }

        public Usuario(int id, string nome, string email, string senha) : this(nome, email, senha)
        {
            this.Id = id;
        }
    }
}
