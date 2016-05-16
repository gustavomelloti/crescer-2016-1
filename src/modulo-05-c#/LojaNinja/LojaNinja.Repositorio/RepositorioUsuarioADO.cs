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
        private readonly string connectionString = ConfigurationManager.ConnectionStrings["Con"].ConnectionString;

        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            using (var conexao = new SqlConnection(connectionString))
            {
                string sql = "SELECT * FROM Usuario WHERE email=@p_email and senha=@p_senha";

                var comando = new SqlCommand(sql, conexao);
                comando.Parameters.Add(new SqlParameter("p_email", email));
                comando.Parameters.Add(new SqlParameter("p_senha", senha));

                conexao.Open();

                SqlDataReader leitor = comando.ExecuteReader();

                Usuario usuario = null;

                if (leitor.Read())
                {
                    usuario = new Usuario(Convert.ToInt32(leitor["id"]), Convert.ToString(leitor["nome"]), Convert.ToString(leitor["senha"]), Convert.ToString(leitor["email"]));
            
                }

                return usuario;
            }
        }

        public void Cadastrar(Usuario usuario)
        {
            using (var conexao = new SqlConnection(connectionString))
            {
                string sql = "INSERT INTO Usuarios(nome, email, senha) Values(@p_nome, @p_email, @p_senha)";

                var comando = new SqlCommand(sql, conexao);
                comando.Parameters.Add(new SqlParameter("p_nome", usuario.Nome));
                comando.Parameters.Add(new SqlParameter("p_email", usuario.Email));
                comando.Parameters.Add(new SqlParameter("p_senha", usuario.Senha));

                conexao.Open();

                if (comando.ExecuteNonQuery() != 1)
                {
                    throw new ArgumentException();
                }
            }
        }
    }
}
