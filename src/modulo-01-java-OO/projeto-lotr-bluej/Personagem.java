public class Personagem
{
    protected String nome;
    protected int experiencia, qtdVida = 110;
    protected Inventario inventario = new Inventario();
    protected Status status = Status.VIVO;
    
    public int getExperiencia()
    {
        return this.experiencia;
    }
    
    public void adicionarItem(Item item)
    {
        this.inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item)
    {
        this.inventario.removerItem(item);
    }
    
    public String getNome()
    {
        return this.nome;
    }
    
    public Inventario getInventario()
    {
        return this.inventario;
    }
}
