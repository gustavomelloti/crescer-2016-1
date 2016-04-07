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
    
}
