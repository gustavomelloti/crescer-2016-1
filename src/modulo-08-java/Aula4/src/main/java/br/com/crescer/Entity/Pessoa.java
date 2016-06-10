package br.com.crescer.Entity;

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

    @Id // Identifica a PK
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PESSOA")
    @SequenceGenerator(name = "SEQ_PESSOA", sequenceName = "SEQ_PESSOA")
    @Basic(optional = false)
    @Column(name = "ID")
    private int idPessoa;

    @Basic(optional = false)
    @Column(name = "NOME")
    private String nmPessoa;

    public Pessoa() {
    }

    public Pessoa(String nome) {
        this.nmPessoa = nome;
    }

    public Pessoa(int id, String nome) {
        this.nmPessoa = nome;
        this.idPessoa = id;
    }

    /**
     * @return the idPessoa
     */
    public int getIdPessoa() {
        return idPessoa;
    }

    /**
     * @param idPessoa the idPessoa to set
     */
    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    /**
     * @return the nmPessoa
     */
    public String getNmPessoa() {
        return nmPessoa;
    }

    /**
     * @param nmPessoa the nmPessoa to set
     */
    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
    }
}