import java.util.*;

public interface EstrategiaAtaque
{
    public void executarEstrategia(ArrayList<Elfo> exercito, ArrayList<Dwarf> horda);
    public ArrayList<Elfo> getOrdemUltimoAtaque();
}
