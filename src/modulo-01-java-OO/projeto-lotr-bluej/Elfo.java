public class Elfo extends Personagem {
    private int flechas;
    
    public Elfo(String nome)
    {
        this.nome = nome;
        this.experiencia = 0;
        this.flechas = 42;
    }
    
    public Elfo(String nome, int flechas)
    {
        this.nome = nome;
        this.experiencia = 0;
        this.flechas = flechas;
    }
    
    public void atirarFlechaEmDwarf(Dwarf d)
    {
        experiencia++;
        flechas--;
        d.receberFlechada();
    }
    
    public String toString()
    {
        return this.nome + " possui " + this.flechas + " flecha(s) e " + this.experiencia + " nívei(s) de experiência.";
    }
    
    public int getFlechas()
    {
        return this.flechas;
    }
}