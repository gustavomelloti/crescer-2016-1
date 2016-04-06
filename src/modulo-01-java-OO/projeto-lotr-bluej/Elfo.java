public class Elfo {
    private String nome;
    private int experiencia, flechas;
    
    public Elfo(String nome)
    {
        this.nome = nome;
        this.experiencia = 0;
        this.flechas = 42;
    }
    
    public void atirarFlechaEmDwarf(Dwarf d)
    {
        experiencia++;
        flechas--;
        d.receberFlechada();
    }
    
    public int getExperiencia()
    {
        return this.experiencia;
    }
    
    public int getFlechas()
    {
        return this.flechas;
    }
}