using LojaNinja.Dominio;
using System;
using System.Data.SqlClient;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace LojaNinja.Repositorio
{
    public class RepositorioVendasADO : RepositorioBase
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
    }
}
