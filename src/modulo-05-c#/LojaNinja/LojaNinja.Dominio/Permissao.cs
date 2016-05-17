using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public class Permissao
    {
        public List<String> Permissoes { get; private set; }

        public Permissao()
        {
            Permissoes = new List<String>();
        }

        public void AdicionarPermissao(string permissao)
        {
            Permissoes.Add(permissao);
        }

        public void RemoverPermissao(string permissao)
        {
            Permissoes.Remove(permissao);
        }
    }
}
