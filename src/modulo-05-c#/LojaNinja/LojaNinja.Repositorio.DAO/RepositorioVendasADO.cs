using LojaNinja.Dominio;
using System;
using System.Data.SqlClient;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace LojaNinja.Repositorio
{
    public class RepositorioVendasADO : RepositorioBase, IPedidoRepositorio
    {

        public List<Pedido> ObterPedidos()
        {
            using (var conexao = new SqlConnection(ConnectionString))
            {
                string sql = "SELECT * FROM Pedido";

                var comando = new SqlCommand(sql, conexao);

                conexao.Open();

                SqlDataReader leitor = comando.ExecuteReader();

                List<Pedido> pedidos = new List<Pedido>();

                while (leitor.Read())
                {
                    pedidos.Add(
                        new Pedido(
                            Convert.ToInt32(leitor["Id"]),
                            Convert.ToDateTime(leitor["Data_Pedido"]),
                            Convert.ToDateTime(leitor["Data_Entrega_Desejada"]),
                            Convert.ToString(leitor["Nome_Produto"]),
                            Convert.ToDecimal(leitor["Valor"]),
                            (TipoPagamento) leitor["Tipo_Pagamento"],
                            Convert.ToString(leitor["Nome_Cliente"]),
                            Convert.ToString(leitor["Cidade"]),
                            Convert.ToString(leitor["Estado"]),
                            Convert.ToBoolean(leitor["Urgente"])
                        )
                    );
                }

                return pedidos;
            }
        }

        public List<Pedido> ObterPedidosComFiltros(string cliente, string produto)
        {
            using (var conexao = new SqlConnection(ConnectionString))
            {
                string sql = "SELECT * FROM Pedido WHERE Nome_Cliente LIKE'% @p_cliente %' and Nome_Produto LIKE'% @p_produto %'";

                var comando = new SqlCommand(sql, conexao);

                comando.Parameters.Add(new SqlParameter("p_cliente", cliente));
                comando.Parameters.Add(new SqlParameter("p_produto", produto));

                conexao.Open();

                SqlDataReader leitor = comando.ExecuteReader();
                //TODO: Muito código repetido
                List<Pedido> pedidos = new List<Pedido>();

                while (leitor.Read())
                {
                    pedidos.Add(
                        new Pedido(
                            Convert.ToInt32(leitor["Id"]),
                            Convert.ToDateTime(leitor["Data_Pedido"]),
                            Convert.ToDateTime(leitor["Data_Entrega_Desejada"]),
                            Convert.ToString(leitor["Nome_Produto"]),
                            Convert.ToDecimal(leitor["Valor"]),
                            (TipoPagamento) leitor["Tipo_Pagamento"],
                            Convert.ToString(leitor["Nome_Cliente"]),
                            Convert.ToString(leitor["Cidade"]),
                            Convert.ToString(leitor["Estado"]),
                            Convert.ToBoolean(leitor["Urgente"])
                        )
                    );
                }

                return pedidos;
            }
        }

        public Pedido ObterPedidoPorId(int id)
        {
            using (var conexao = new SqlConnection(ConnectionString))
            {
                string sql = "SELECT * FROM Pedido WHERE Id=@p_id";

                var comando = new SqlCommand(sql, conexao);

                comando.Parameters.Add(new SqlParameter("p_id", id));

                conexao.Open();

                SqlDataReader leitor = comando.ExecuteReader();

                Pedido pedido = null;
                //TODO: Muito código repetido
                if (leitor.Read())
                {
                    pedido = new Pedido(
                        Convert.ToInt32(leitor["Id"]),
                        Convert.ToDateTime(leitor["Data_Pedido"]),
                        Convert.ToDateTime(leitor["Data_Entrega_Desejada"]),
                        Convert.ToString(leitor["Nome_Produto"]),
                        Convert.ToDecimal(leitor["Valor"]),
                        (TipoPagamento)leitor["Tipo_Pagamento"],
                        Convert.ToString(leitor["Nome_Cliente"]),
                        Convert.ToString(leitor["Cidade"]),
                        Convert.ToString(leitor["Estado"]),
                        Convert.ToBoolean(leitor["Urgente"])
                    );
                }

                return pedido;
            }
        }

        public void ExcluirPedido(int id)
        {
            using (var conexao = new SqlConnection(ConnectionString))
            {
                string sql = "DELETE FROM Pedido WHERE id=@p_id";

                var comando = new SqlCommand(sql, conexao);

                comando.Parameters.Add(new SqlParameter("p_id", id));

                conexao.Open();

                if (comando.ExecuteNonQuery() != 1)
                {
                    throw new ArgumentException();
                }
            }
        }

        public int IncluirPedido(Pedido pedido)
        {
            using (var conexao = new SqlConnection(ConnectionString))
            {
                string sql = "INSERT INTO Pedido (Data_Pedido, Data_Entrega_Desejada, Nome_Produto, Valor, Tipo_Pagamento, Nome_Cliente, Cidade, Estado, Urgente) OUTPUT INSERTED.ID VALUES (@p_data_pedido, @p_data_entrega_desajada, @p_nome_produto, @p_valor, @p_tipo_pagamento, @p_nome_cliente, @p_cidade, @p_estado, @p_urgente)";
                       
                var comando = new SqlCommand(sql, conexao);

                comando.Parameters.Add(new SqlParameter("@p_data_pedido", pedido.DataPedido));
                comando.Parameters.Add(new SqlParameter("@p_data_entrega_desajada",pedido.DataEntregaDesejada));
                comando.Parameters.Add(new SqlParameter("@p_nome_produto", pedido.NomeProduto));
                comando.Parameters.Add(new SqlParameter("@p_valor", pedido.Valor));
                comando.Parameters.Add(new SqlParameter("@p_tipo_pagamento", pedido.TipoPagamento));
                comando.Parameters.Add(new SqlParameter("@p_nome_cliente", pedido.NomeCliente));
                comando.Parameters.Add(new SqlParameter("@p_cidade", pedido.Cidade));
                comando.Parameters.Add(new SqlParameter("@p_estado", pedido.Estado));
                comando.Parameters.Add(new SqlParameter("@p_urgente", pedido.PedidoUrgente));

                conexao.Open();

                var idPedidoCadastrado = Convert.ToInt32(comando.ExecuteScalar());

                if (idPedidoCadastrado > 0)
                {
                    return idPedidoCadastrado;
                }
                else
                {
                    throw new ArgumentException();
                }
            }
        }

        public void AtualizarPedido(Pedido pedido)
        {
            using (var conexao = new SqlConnection(ConnectionString))
            {
                string sql = "UPDATE Pedido SET Data_Pedido = @p_data_pedido, Data_Entrega_Desejada = @p_data_entrega_desajada, Nome_Produto = @p_nome_produto, Valor = @p_valor, Tipo_Pagamento = @p_tipo_pagamento, Nome_Cliente = @p_nome_cliente, Cidade = @p_cidade, Estado = @p_estado, Urgente = @p_urgente WHERE Id = @p_id";

                var comando = new SqlCommand(sql, conexao);

                comando.Parameters.Add(new SqlParameter("@p_id", pedido.Id));
                comando.Parameters.Add(new SqlParameter("@p_data_pedido", pedido.DataPedido));
                comando.Parameters.Add(new SqlParameter("@p_data_entrega_desajada", pedido.DataEntregaDesejada));
                comando.Parameters.Add(new SqlParameter("@p_nome_produto", pedido.NomeProduto));
                comando.Parameters.Add(new SqlParameter("@p_valor", pedido.Valor));
                comando.Parameters.Add(new SqlParameter("@p_tipo_pagamento", pedido.TipoPagamento));
                comando.Parameters.Add(new SqlParameter("@p_nome_cliente", pedido.NomeCliente));
                comando.Parameters.Add(new SqlParameter("@p_cidade", pedido.Cidade));
                comando.Parameters.Add(new SqlParameter("@p_estado", pedido.Estado));
                comando.Parameters.Add(new SqlParameter("@p_urgente", pedido.PedidoUrgente));

                conexao.Open();

                if (comando.ExecuteNonQuery() != 0)
                {
                    throw new ArgumentException();
                }
            }
        }
    }
}
