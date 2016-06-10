package br.com.crescer.Entity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "AMIGO")
public class Amigo {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_AMIGO")
    @SequenceGenerator(name = "SEQ_AMIGO", sequenceName = "SEQ_AMIGO")
    @Basic(optional = false)
    @Column(name = "Amigo")
    private Long ID;
    
    @ManyToOne
    @JoinColumn(name = "Pessoa")
    private Usuario usuario;
    
    private Usuario usuarioAmigo;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "DataInicioAmizade")
    private Date dataAmizade;
}
