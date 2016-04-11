public class Personagem
{
    protected String nome;
    protected int experiencia;
    protected Inventario inventario = new Inventario();
    
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
    
    public void setNome(String nome) 
    {
        this.nome = nome;
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
