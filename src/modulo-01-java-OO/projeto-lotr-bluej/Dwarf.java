public class Dwarf
{
    private int qtdVida;
    private String nome;
    
    public Dwarf(String nome)
    {
        this.nome    = nome;
        this.qtdVida = 110;
    }
    
    public void receberFlechada()
    {
        this.qtdVida -= 10;
    }
    
    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public int getQtdVida()
    {
        return this.qtdVida;
    }
}
