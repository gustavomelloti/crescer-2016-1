public class ElfoNoturno extends Elfo
{
    public ElfoNoturno(String nome)
    {
        super(nome);
    }
    
    public ElfoNoturno(String nome, int qtdFlechas)
    {
        super(nome, qtdFlechas);
    }
    
    public void atirarFlechaEmDwarf(Dwarf d)
    {
        super.atirarFlechaEmDwarf(d);
        this.experiencia+= 2;
        
        this.qtdVida *= 0.95;
        this.status = (int)this.qtdVida == 0 ? Status.MORTO : this.status; 
    }
}