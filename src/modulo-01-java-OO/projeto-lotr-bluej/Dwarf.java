public class Dwarf
{
    private int qtdVida;
    private String nome;
    private Status status;
    
    public Dwarf(String nome)
    {
        this.nome    = nome;
        this.qtdVida = 110;
        this.status  = Status.VIVO;
    }
    
    public void receberFlechada()
    {
        if (this.qtdVida >= 10)
            this.qtdVida -= 10;
        
        if (this.qtdVida == 0)
            this.status = Status.MORTO;
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
}
