using LojaNinja.Dominio;
using System;
using System.Configuration;
using System.Data.SqlClient;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Repositorio
{
    public class RepositorioUsuarioADO : IUsuarioRepositorio
    {
        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["Con"].ConnectionString;

            using (var conexao = new SqlConnection(connectionString))
            {
                string sql = "SELECT * FROM Usuarios WHERE email=@p_email and senha=@p_senha";

                var comando = new SqlCommand(sql, conexao);
                comando.Parameters.Add(new SqlParameter("p_email", email));
                comando.Parameters.Add(new SqlParameter("p_senha", senha));

                conexao.Open();

                SqlDataReader leitor = comando.ExecuteReader();

                Usuario usuario = null;

                if (leitor.Read())
                {
                    usuario =  new Usuario(){
                        Nome  = Convert.ToString(leitor["nome"]),
                        Senha = Convert.ToString(leitor["senha"]),
                        Email = Convert.ToString(leitor["email"]),
                        Id    = Convert.ToInt32(leitor["id"])
                    };
                }

                return usuario;
            }
        }

        public void Cadastrar(Usuario usuario)
        {
            throw new NotImplementedException();
        }
    }
}
