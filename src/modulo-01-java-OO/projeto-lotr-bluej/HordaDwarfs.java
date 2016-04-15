import java.util.ArrayList;

public class HordaDwarfs
{
    private ArrayList<Dwarf> horda = new ArrayList<>();
    
    public void adicionar(Dwarf d)
    {
        this.horda.add(d);
    }
    
    public ArrayList<Dwarf> gethorda()
    {
        return this.horda;
    }
}
