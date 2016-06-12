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
@Table(name = "CLIENTE")
public class Cliente implements Serializable {
    @Id 
    @GeneratedValue(strategy = SEQUENCE, generator = "SQCLIENTE")
    @SequenceGenerator(name = "SQCLIENTE", sequenceName = "SQCLIENTE", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDCLIENTE")
    private long id;
 
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    
    @Basic(optional = false)
    @Column(name = "RAZAOSOCIAL")
    private String razaoSocial;
    
    @Basic(optional = false)
    @Column(name = "ENDERECO")
    private String endereco;
    
    @Basic(optional = true)
    @Column(name = "BAIRRO")
    private String bairro;
    
    @ManyToOne
    @JoinColumn(name = "IDCIDADE")
    private Cidade cidade;
    
    @Basic(optional = true)
    @Column(name = "CEP")
    private Integer cep;
    
    @Basic(optional = false)
    @Column(name = "SITUACAO")
    private char situacao;

    public Cliente() {}
    
    public Cliente(long id, String nome, String razaoSocial, String endereco, String bairro, Cidade cidade, int cep, char situacao) {
        this(nome, razaoSocial, endereco, bairro, cidade, cep, situacao);
        this.id = id;
    }
    
    public Cliente(String nome, String razaoSocial, String endereco, String bairro, Cidade cidade, int cep, char situacao) {
        this.nome = nome;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.situacao = situacao;
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

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public char getSituacao() {
        return situacao;
    }

    public void setSituacao(char situacao) {
        this.situacao = situacao;
    }
}
