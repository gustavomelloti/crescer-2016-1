public class Dwarf
{
    private int qtdVida;
    
    public Dwarf()
    {
        this.qtdVida = 110;
    }
    
    public void receberFlechada()
    {
        this.qtdVida -= 10;
    }
}
