public class Item
{
    private int quantidade;
    private String descricao;
    
    public Item(int quantidade, String descricao)
    {
        this.quantidade = quantidade;
        this.descricao  = descricao;
    }
    
    public int getQuantidade()
    {
        return this.quantidade;
    }
    
    public String getDescricao()
    {
        return this.descricao;
    }
    
    public void aumentar1000Unidades()
    {
        this.quantidade += 1000;
    }
    
    public void aumentarQuantidadeProporcionalmente()
    {
        int resultado = this.quantidade * (this.quantidade + 1) / 2;
        this.quantidade += (resultado * 1000);
    }
    
    public boolean equals(Object obj)
    {
        Item i = (Item) obj;
        return (this.quantidade == i.getQuantidade() && this.descricao.equals(i.getDescricao()));
    }
}
