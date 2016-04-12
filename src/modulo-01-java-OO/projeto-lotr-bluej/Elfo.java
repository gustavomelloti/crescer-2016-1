public class Elfo extends Personagem {
    private int flechas = 42;
    private static int contador = 0;
    
    public Elfo()
    {
        this.contador++;
    }
    
    public Elfo(String nome)
    {
        this.nome = nome;
        this.qtdVida = 100;
        contador++;
    }
    
    public Elfo(String nome, int flechas)
    {
        this(nome);
        this.flechas = flechas;
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
    
    public static int getContador()
    {
        return contador;
    }
}