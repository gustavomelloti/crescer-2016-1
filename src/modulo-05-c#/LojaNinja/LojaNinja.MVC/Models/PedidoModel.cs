using LojaNinja.Dominio;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Models
{
    public class PedidoModel
    {
        [Display(Name = "ID")]
        public int Id { get; set; }

        [Display(Name = "Data Pedido")]
        [DisplayFormat(DataFormatString = "{0:dd/MM/yyyy}")]
        public DateTime DataPedido { get; set; }

        [Display(Name = "Data de entrega ")]
        [Required(ErrorMessage = "Informe a data de entrega.")]
        [DisplayFormat(DataFormatString = "{0:dd/MM/yyyy}")]
        public DateTime DataEntrega { get; set; }

        [Display(Name = "Valor")]
        [DisplayFormat(DataFormatString = "R$:{0}")]
        [Required(ErrorMessage = "Informe o valor da venda.")]
        public decimal Valor { get; set; }

        [Display(Name = "Nome do produto ")]
        [Required(ErrorMessage = "Informe o nome do produto.")]
        public string NomeProduto { get; set; }

        [Display(Name = "Escolha um tipo de pagamento.")]
        [EnumDataType(typeof(TipoPagamento), ErrorMessage = "Escolha um tipo de pagamento.")]
        public TipoPagamento TipoPagamento { get; set; }

        [Display(Name = "Nome ")]
        [Required(ErrorMessage = "Informe seu nome.")]
        public string NomeCliente { get; set; }

        [Display(Name = "Cidade ")]
        [Required(ErrorMessage = "Informe a cidade.")]
        public string Cidade { get; set; }

        [Display(Name = "Estado ")]
        [StringLength(2, ErrorMessage = "Estado deverá ter 2 caracteres")]
        [Required(ErrorMessage = "Informe o estado.")]
        public string Estado { get; set; }

        [Display(Name = "Urgente?")]
        public bool PedidoUrgente { get; set; }

        public PedidoModel(Pedido pedido)
        {
            this.Id = pedido.Id;
            this.DataPedido = pedido.DataPedido;
            this.DataEntrega = pedido.DataEntregaDesejada;
            this.NomeProduto = pedido.NomeProduto;
            this.Valor = pedido.Valor;
            this.TipoPagamento = pedido.TipoPagamento;
            this.NomeCliente = pedido.NomeCliente;
            this.Cidade = pedido.Cidade;
            this.Estado = pedido.Estado;
            this.PedidoUrgente = pedido.PedidoUrgente;
        }

        public PedidoModel() { }
    }
}