package br.com.crescer.Entity;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_USUARIO")
    @SequenceGenerator(name = "SEQ_USUARIO", sequenceName = "SEQ_USUARIO")
    @Basic(optional = false)
    @Column(name = "Id")
    private long id;
    
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    
    @OneToMany(mappedBy="AMIGO")
    private List<Amigo> amigos;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the amigos
     */
    public List<Amigo> getAmigos() {
        return amigos;
    }

    /**
     * @param amigos the amigos to set
     */
    public void setAmigos(List<Amigo> amigos) {
        this.amigos = amigos;
    }
}
