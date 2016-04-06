public class Dwarf
{
    private int qtdVida;
    
    public Dwarf()
    {
        this.qtdVida = 110;
    }
    
    public void perderVida(int qtdVidaPerdida)
    {
        this.qtdVida = qtdVida - qtdVidaPerdida;
    }
}
