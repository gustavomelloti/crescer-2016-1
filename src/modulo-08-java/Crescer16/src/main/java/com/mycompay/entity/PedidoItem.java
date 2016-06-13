package com.mycompay.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PEDIDOITEM")
public class PedidoItem implements Serializable {
    @Id 
    @GeneratedValue(strategy = SEQUENCE, generator = "SQPEDIDOITEM")
    @SequenceGenerator(name = "SQPEDIDOITEM", sequenceName = "SQPEDIDOITEM", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDPEDIDOITEM")
    private long id;
    
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private double quantidade;
    
    @Basic(optional = false)
    @Column(name = "PRECOUNITARIO")
    private double precoUnitario;
    
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private char situacao;

    @ManyToOne
    @JoinColumn(name = "IDPRODUTO")
    private Produto produto;
    
    @ManyToOne
    @JoinColumn(name = "IDPEDIDO")
    private Pedido Pedido;
    
    public PedidoItem(){}
    
    public PedidoItem(long id, double quantidade, double precoUnitario, char situacao, Produto produto) {
        this(quantidade, precoUnitario, situacao, produto);
        this.id = id;
    }

    public Pedido getPedido() {
        return Pedido;
    }

    public void setPedido(Pedido Pedido) {
        this.Pedido = Pedido;
    }
    public PedidoItem(double quantidade, double precoUnitario, char situacao, Produto produto) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.situacao = situacao;
        this.produto = produto;
    }
   
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto pessoa) {
        this.produto = pessoa;
    }
}
