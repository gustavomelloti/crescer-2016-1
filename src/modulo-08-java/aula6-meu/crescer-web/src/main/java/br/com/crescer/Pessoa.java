package br.com.crescer;

public class Pessoa {

    private String nome;
    private Integer idade;
    private long id;

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