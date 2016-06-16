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
@Table(name = "PESSOA")
public class Pessoa implements Serializable {
    @Id 
    @GeneratedValue(strategy = SEQUENCE, generator = "SQPESSOA")
    @SequenceGenerator(name = "SQPESSOA", sequenceName = "SQPESSOA", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "IDPESSOA")
    private long id;
    
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    
    @Basic(optional = false)
    @Column(name = "IDADE")
    private Integer idade;
    

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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    
    @Override
    public String toString() {
        return nome + " " + idade;
    }

}