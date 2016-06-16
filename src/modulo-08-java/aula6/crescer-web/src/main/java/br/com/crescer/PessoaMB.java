package br.com.crescer;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name = "pessoa")
@ViewScoped
public class PessoaMB implements Serializable {

    private Pessoa pessoa;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    @PostConstruct
    public void init() {
        this.pessoa = new Pessoa();
    }

    public void process() {
        this.setMsg("Pessoa cadastrada com sucesso!");
        this.clearForm();
        //TODO INSERIR NO BANCO
    }
    
    public void clearForm() {
        this.pessoa.setNome("");
        this.pessoa.setIdade(null);
    }
}