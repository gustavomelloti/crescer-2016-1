using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Configuration;

namespace LojaNinja.Repositorio
{
    public abstract class RepositorioBase
    {
        public string ConnectionString
        {
            get
            {
                return ConfigurationManager.ConnectionStrings["Con"].ConnectionString;
            }
        }
    }
}
