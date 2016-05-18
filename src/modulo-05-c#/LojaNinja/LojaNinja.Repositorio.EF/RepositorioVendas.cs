using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LojaNinja.Repositorio.EF
{
    public class RepositorioVendas : IPedidoRepositorio
    {
        public List<Pedido> ObterPedidos()
        {
            using (var contexto = new ContextoDados())
            {
                return contexto.Pedido.ToList();
            }
        }

        public List<Pedido> ObterPedidosComFiltros(string cliente, string produto)
        {
            using (var contexto = new ContextoDados())
            {
                IQueryable<Pedido> query = contexto.Pedido;

                if (!String.IsNullOrWhiteSpace(cliente))
                {
                    query = query.Where(p => p.NomeCliente.Equals(cliente));
                }

                if (!String.IsNullOrWhiteSpace(produto))
                {
                    query = query.Where(p => p.NomeProduto.Equals(produto));
                }

                return query.ToList();
            }
        }

        public Pedido ObterPedidoPorId(int id)
        {
            using (var contexto = new ContextoDados())
            {
                return contexto.Pedido.FirstOrDefault(x => x.Id == id);
            }
        }

        public int IncluirPedido(Pedido pedido)
        {
            using (var contexto = new ContextoDados())
            {
                contexto.Entry<Pedido>(pedido).State = System.Data.Entity.EntityState.Added;
                contexto.SaveChanges();
                return pedido.Id;
            }
        }

        public void AtualizarPedido(Pedido pedido)
        {
            using (var contexto = new ContextoDados())
            {
                contexto.Entry<Pedido>(pedido).State = System.Data.Entity.EntityState.Modified;
                contexto.SaveChanges();
            }
        }

        public void ExcluirPedido(int id)
        {
            using (var contexto = new ContextoDados())
            {
                contexto.Entry<Pedido>(this.ObterPedidoPorId(id)).State = System.Data.Entity.EntityState.Deleted;
                contexto.SaveChanges();
            }
        }
    }
}
