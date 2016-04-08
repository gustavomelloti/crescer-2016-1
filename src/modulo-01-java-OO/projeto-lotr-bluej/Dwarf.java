public class Dwarf
{
    private int qtdVida = 110;
    private String nome;
    private Status status = Status.VIVO;
    private Inventario inventario = new Inventario();
    private DataTerceiraEra dataNascimento;
    
    public Dwarf(String nome)
    {
        this.nome = nome;
        this.dataNascimento = new DataTerceiraEra(1, 1, 1);
    }
    
    public Dwarf(String nome, DataTerceiraEra dataNascimento)
    {
         this.nome = nome;
         this.dataNascimento = dataNascimento;
    }
    
    public void receberFlechada()
    {
        if (this.qtdVida >= 10)
            this.qtdVida -= 10;
        
        if (this.qtdVida == 0)
            this.status = Status.MORTO;
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
    
    public int getQtdVida()
    {
        return this.qtdVida;
    }
    
    public Status getStatus()
    {
        return this.status;
    }
    
    public Inventario getInventario()
    {
        return this.inventario;
    }
    
    public DataTerceiraEra getDataNascimento()
    {
        return this.dataNascimento;
    }
}
