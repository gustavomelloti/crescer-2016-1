public class Dwarf
{
    private int qtdVida = 110, experiencia = 0;
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
        double numeroSorte = this.getNumeroSorte();
        
        if (numeroSorte < 0) {
            experiencia+=2;
            return;
        }
        
        if (numeroSorte > 100 && this.qtdVida >= 10)
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
    
    public double getNumeroSorte ()
    {   
        double numeroASerRetornado = 101;
        
        if (this.dataNascimento.ehBissexto() && this.qtdVida >= 80 && this.qtdVida <= 90)
             numeroASerRetornado*= -33;
             
        if (!this.dataNascimento.ehBissexto() && (this.nome.equals("Seixas") || this.nome.equals("Meireles")))
            numeroASerRetornado = (numeroASerRetornado * 33) % 100;

        return numeroASerRetornado;
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
