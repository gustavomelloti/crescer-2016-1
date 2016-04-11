public class Dwarf extends Personagem
{
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
            this.tentarSorte();
            return;
        }
        
        if (numeroSorte > 100 && this.qtdVida >= 10)
            this.qtdVida -= 10;
        
        if (this.qtdVida == 0)
            this.status = Status.MORTO;
    }
    
    public double getNumeroSorte ()
    {
        double numeroASerRetornado = 101;
        
        if (this.dataNascimento.ehBissexto() && this.qtdVida >= 80 && this.qtdVida <= 90)
             numeroASerRetornado*= -33;
        
        if (!this.dataNascimento.ehBissexto() && (this.nome.equals("Seixas") || this.nome.equals("Meireles")))
            numeroASerRetornado= (numeroASerRetornado *33) % 100.00;

        return numeroASerRetornado;
    }
    
    public void tentarSorte()
    {
        double numeroDaSorte = this.getNumeroSorte();
        
        if (numeroDaSorte == -3333.0)
            this.inventario.aumentar100();    
    }
    
    public int getQtdVida()
    {
        return this.qtdVida;
    }
    
    public Status getStatus()
    {
        return this.status;
    }
   
    public DataTerceiraEra getDataNascimento()
    {
        return this.dataNascimento;
    }
}
