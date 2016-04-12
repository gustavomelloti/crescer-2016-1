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
        
        double qtdVidaAposAtirarFlecha = this.qtdVida - 5;
        
        if (qtdVidaAposAtirarFlecha <= 0)
            this.status = Status.MORTO;
            
        this.qtdVida = qtdVidaAposAtirarFlecha <= 0 ? 0 : qtdVidaAposAtirarFlecha;  
    }
}