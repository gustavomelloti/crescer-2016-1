public class ElfoVerde extends Elfo
{
    public ElfoVerde(String nome)
    {
        super(nome);
    }
    
    public ElfoVerde(String nome, int qtdFlechas)
    {
        super(nome, qtdFlechas);
    }
    
    public void atirarFlechaEmDwarf(Dwarf d)
    {
        super.atirarFlechaEmDwarf(d);
        this.experiencia++;
    }
    
    public void adicionarItem(Item i)
    {
        if (i.getDescricao().equals("Espada de aço valiriano") || i.getDescricao().equals("Arco e Flecha de Vidro"))
            super.adicionarItem(i);
    }
}
