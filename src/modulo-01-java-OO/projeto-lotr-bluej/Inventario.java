import java.util.ArrayList;

public class Inventario
{
    private ArrayList<Item> itens;
    
    public Inventario()
    {
        this.itens = new ArrayList<Item>();
    }
    
    public ArrayList<Item> getItens()
    {
        return this.itens;
    }
    
    public void adicionarItem(Item i)
    {
        this.itens.add(i);
    }
    
    public void removerItem(Item i)
    {
        this.itens.remove(i);
    }
    
    public String getDescricoesItens()
    {
        String descricaoItens = "";
        
        for (int i = 0; i < this.itens.size();i++) {
            if (i != 0)
                descricaoItens+=",";
                
            descricaoItens+=this.itens.get(i).getDescricao();
        }
            
        return descricaoItens;
    }
    
    public Item getItemComMaiorQuantidade()
    {
        int qtdMaior = 0,posicaoMaior = 0;
        
        for (int i = 0; i < this.itens.size();i++) {
            if (this.itens.get(i).getQuantidade() > qtdMaior) {
                qtdMaior = this.itens.get(i).getQuantidade();
                posicaoMaior = i;
            }
        }
        
        return this.itens.isEmpty() ? null : this.itens.get(posicaoMaior);
    }
    
    public void ordenarItens()
    {
        ArrayList<Item> aux = new ArrayList<Item>(this.itens.size());
        
        for (int i = this.itens.size() - 1; i >= 0 ;i--) {
            aux.add(i, this.itens.get(i));
        }
        
        this.itens = aux;
    }
}
