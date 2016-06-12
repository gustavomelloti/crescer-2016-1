package com.mycompay.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "MATERIAL")
public class Material implements Serializable{
    @Id 
    @GeneratedValue(strategy = SEQUENCE, generator = "SQPEDIDO")
    @SequenceGenerator(name = "SQPEDIDO", sequenceName = "SQPEDIDO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDMATERIAL")
    private long id;
    
    @Basic(optional = false)
    @Column(name = "PESOLIQUIDO")
    private double pesoLiquido;
    
    @Basic(optional = false)
    @Column(name = "PRECOCUSTO")
    private double precoCusto;
    
    @Basic(optional = false)
    @Column(name = "DESCRICAO")
    private String descricao;

    public Material() {}
    
    public Material(long id, double pesoLiquido, double precoCusto, String descricao) {
        this(pesoLiquido, precoCusto, descricao);
        this.id = id;
    }
    
    public Material(double pesoLiquido, double precoCusto, String descricao) {
        this.pesoLiquido = pesoLiquido;
        this.precoCusto = precoCusto;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPesoLiquido() {
        return pesoLiquido;
    }

    public void setPesoLiquido(double pesoLiquido) {
        this.pesoLiquido = pesoLiquido;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }
}
