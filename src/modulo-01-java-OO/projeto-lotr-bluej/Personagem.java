public abstract class Personagem
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
    
    public boolean equals(Object obj)
    {
        Personagem p = (Personagem) obj;
        
        return 
            p != null &&
            this.nome.equals(p.nome) &&
            this.experiencia == p.experiencia &&
            this.qtdVida == p.qtdVida &&
            this.status == p.status &&
            this.inventario.equals(p.getInventario());      
    }
    
    public abstract void tentarSorte();
}