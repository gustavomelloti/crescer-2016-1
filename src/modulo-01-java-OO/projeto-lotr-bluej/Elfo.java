public class Elfo {
    private String nome;
    private int experiencia, flechas = 42, danoAtaque = 10;
    
    public Elfo(String nome)
    {
        this.nome = nome;
    }
    
    public void atirarFlechaEmDwarf(Dwarf d)
    {
        experiencia++;
        flechas--;
        d.receberFlechada();
    }
}