public class Elfo extends Personagem {
    private int flechas;
     
    public Elfo(String nome)
    {
        this.nome = nome;
        this.flechas = 42;
        this.qtdVida = 100;
    }
    
    public Elfo(String nome, int flechas)
    {
        this.nome = nome;
        this.flechas = flechas;
        this.qtdVida = 100;
    }
    
    public void atirarFlechaEmDwarf(Dwarf d)
    {
        this.experiencia++;
        this.flechas--;
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