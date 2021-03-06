﻿using LojaNinja.Dominio;
using System;
using System.Data.SqlClient;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Transactions;

namespace LojaNinja.Repositorio
{
    public class RepositorioUsuarioADO : RepositorioBase, IUsuarioRepositorio
    {
        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            using (var conexao = new SqlConnection(ConnectionString))
            {
                string sql = "SELECT Usuario.Nome, Usuario.Email, Usuario.Senha, Usuario.Id, Permissao.Permissao, Permissao.Id AS PermissaoId FROM Usuario"
                               + " Join UsuarioPermissao ON UsuarioPermissao.Usuario_Id = Usuario.Id"
                               + " Join Permissao ON Permissao.Id = UsuarioPermissao.Permissao_Id "
                               + " WHERE Usuario.email=@p_email and Usuario.senha=@p_senha";

                var comando = new SqlCommand(sql, conexao);
                comando.Parameters.Add(new SqlParameter("p_email", email));
                comando.Parameters.Add(new SqlParameter("p_senha", senha));

                conexao.Open();

                SqlDataReader leitor = comando.ExecuteReader();

                Usuario usuario = null;

                while (leitor.Read())
                {
                    if (usuario == null)
                    {
                        usuario = new Usuario(Convert.ToInt32(leitor["Id"]), Convert.ToString(leitor["Nome"]), Convert.ToString(leitor["Senha"]), Convert.ToString(leitor["Email"]));
                    }

                    usuario.Permissoes.Add(new Permissao(Convert.ToInt32(leitor["PermissaoId"]), Convert.ToString(leitor["Permissao"])));
                }

                return usuario;
            }
        }

        public void Cadastrar(Usuario usuario)
        {
            using (TransactionScope scope = new TransactionScope())
            {
                using (var conexao = new SqlConnection(ConnectionString))
                {
                    try
                    {
                        string sql = "INSERT INTO Usuario(nome, email, senha) OUTPUT INSERTED.ID Values(@p_nome, @p_email, @p_senha)";

                        var comando = new SqlCommand(sql, conexao);
                        comando.Parameters.Add(new SqlParameter("p_nome", usuario.Nome));
                        comando.Parameters.Add(new SqlParameter("p_email", usuario.Email));
                        comando.Parameters.Add(new SqlParameter("p_senha", usuario.Senha));

                        conexao.Open();

                        int idUsuarioAdicionado = (int)comando.ExecuteScalar();

                        if (idUsuarioAdicionado <= 0)
                        {
                            throw new ArgumentException();
                        }

                        //TODO: tá aceitando somente uma permissão e fixa
                        sql = "INSERT INTO UsuarioPermissao(Usuario_Id, Permissao_Id) Values(@p_usuario_id, @p_permissao_id)";
                        comando = new SqlCommand(sql, conexao);
                        comando.Parameters.Add(new SqlParameter("p_usuario_id", idUsuarioAdicionado));
                        comando.Parameters.Add(new SqlParameter("p_permissao_id", 1));

                        if (comando.ExecuteNonQuery() <= 0)
                        {
                            throw new ArgumentException();
                        }

                        scope.Complete();
                    }
                    catch (ArgumentException)
                    {
                        throw;
                    }
                }
            }
        }
    }
}
