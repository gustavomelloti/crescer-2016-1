using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Dominio
{
    public interface IPedidoRepositorio
    {
        List<Pedido> ObterPedidosComFiltros(string cliente, string produto);

        List<Pedido> ObterPedidos();

        Pedido ObterPedidoPorId(int id);

        int IncluirPedido(Pedido pedido);

        void AtualizarPedido(Pedido pedido);

        void ExcluirPedido(int id);
    }
}
