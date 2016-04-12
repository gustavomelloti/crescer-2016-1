public class Personagem
{
    protected String nome;
    protected int experiencia = 0;
    protected double qtdVida = 0;
    protected Inventario inventario = new Inventario();
    protected Status status = Status.VIVO;
    
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
    
    public double getQtdVida()
    {
        return this.qtdVida;
    }
    
    public Status getStatus()
    {
        return this.status;
    }
    
    public int getExperiencia()
    {
        return this.experiencia;
    }
}