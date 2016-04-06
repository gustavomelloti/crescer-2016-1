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
}
