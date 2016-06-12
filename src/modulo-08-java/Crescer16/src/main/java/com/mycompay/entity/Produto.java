package com.mycompay.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {
    @Id 
    @GeneratedValue(strategy = SEQUENCE, generator = "SQPRODUTO")
    @SequenceGenerator(name = "SQPRODUTO", sequenceName = "SQPRODUTO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDPRODUTO")
    private long id;
    
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    
    @Temporal(TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "DATACADASTRO")
    private Date data;
    
    @Basic(optional = false)
    @Column(name = "PRECOCUSTO")
    private double precoCusto;
    
    @Basic(optional = false)
    @Column(name = "PRECOVENDA")
    private double precoVenda;
    
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private char situacao;    

    public Produto() {}
    
    public Produto(String nome, Date data, double precoCusto, double precoVenda, char situacao) {
        this.nome = nome;
        this.data = data;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
        this.situacao = situacao;
    }

    public Produto(long id, String nome, Date data, double precoCusto, double precoVenda, char situacao) {
        this(nome, data, precoCusto, precoVenda, situacao);
        this.id = id;
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }
}
