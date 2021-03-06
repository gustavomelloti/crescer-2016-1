import java.util.*;

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
    
    public void aumentar100()
    {
        for (Item item : this.itens) {
            item.aumentar1000Unidades();
        }
    
    }
    
    public void aumentarProporcional()
    {
        for (Item item : this.itens) {
            item.aumentarQuantidadeProporcionalmente();
        }
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
      /*
      int i = this.itens.size()-1;
      while (i > 0) {
          int ultimoTrocado = 0;
          for (int j = 0; j < i; j++) {
              if (this.itens.get(j).getQuantidade() > this.itens.get(j+1).getQuantidade()) {
                  Item t = this.itens.get(j);
                  this.itens.set(j, this.itens.get(j+1));
                  this.itens.set(j+1,t);
                  ultimoTrocado = j;
                }
            }
            i = ultimoTrocado;
        }*/
        Collections.sort(this.itens, new Comparator<Item>() {
            public int compare(Item item1, Item item2) {
                return Integer.compare(item1.getQuantidade(), item2.getQuantidade());
            }
        });
    }
    
    public boolean equals(Object obj)
    {
        Inventario inventarioComparado = (Inventario) obj;
        
        if (inventarioComparado.getItens().size() != this.itens.size())
            return false;
            
        for (Item i: this.itens)
        {
            if (!inventarioComparado.getItens().contains(i))
                return false;
        }
        
        for (Item i: inventarioComparado.getItens())
        {
            if (!this.itens.contains(i))
                return false;
        }
        
        return true;
    }
}
