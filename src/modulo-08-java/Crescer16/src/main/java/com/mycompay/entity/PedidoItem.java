package com.mycompay.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
    
    public PedidoItem(){}
    
    public PedidoItem(long id, double quantidade, double precoUnitario, char situacao, Produto produto) {
        this(quantidade, precoUnitario, situacao, produto);
        this.id = id;
    }
    public PedidoItem(double quantidade, double precoUnitario, char situacao, Produto produto) {
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
        this.situacao = situacao;
        this.produto = produto;
    }
    
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private char situacao;

    @OneToOne
    @JoinColumn(name = "IDPRODUTO")
    @Basic(optional = false)
    private Produto produto;

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

    public Produto getPessoa() {
        return produto;
    }

    public void setPessoa(Produto pessoa) {
        this.produto = pessoa;
    }
}
