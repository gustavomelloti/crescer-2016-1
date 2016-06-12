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
@Table(name = "PRODUTOMATERIAL")
public class ProdutoMaterial implements Serializable{
    @Id 
    @GeneratedValue(strategy = SEQUENCE, generator = "SQPRODUTOMATERIAL")
    @SequenceGenerator(name = "SQPRODUTOMATERIAL", sequenceName = "SQPRODUTOMATERIAL", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDPRODUTOMATERIAL")
    private long id;
    
    @ManyToOne
    @JoinColumn(name = "IDPRODUTO")
    private Produto produto;
    
    @ManyToOne
    @JoinColumn(name = "IDMATERIAL")
    private Material material;
    
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private double quantidade;

    public ProdutoMaterial() {}
    
    public ProdutoMaterial(long id, Produto produto, Material material, double quantidade) {
        this(produto, material, quantidade);
        this.id = id;
    }
    public ProdutoMaterial(Produto produto, Material material, double quantidade) {
        this.produto = produto;
        this.material = material;
        this.quantidade = quantidade;
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

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
