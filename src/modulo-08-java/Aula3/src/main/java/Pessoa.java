

public class Pessoa {
    private int Id;
    private String Nome;
    
    public Pessoa(String nome) {
        this.Nome = nome;
    }
    
    public Pessoa(int id, String nome) {
        this(nome);
        this.Id = id;
    }
    
    public int getId() {
        return Id;
    }

    public String getNome() {
        return Nome;
    }
}
