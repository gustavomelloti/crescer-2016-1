import java.util.*;

public class EstrategiaAtaqueNoturnoPorUltimo implements EstrategiaAtaque
{
    private ArrayList<Elfo> ordemUltimoAtaque = new ArrayList<>();
  
    public ArrayList<Elfo> getOrdemUltimoAtaque()
    {
        return this.ordemUltimoAtaque;
    }
    
    private void adicionarElfoHistoricoAtaque(Elfo elfo)
    {
        if (!this.ordemUltimoAtaque.contains(elfo))
            this.ordemUltimoAtaque.add(elfo);
    }
    
    public void executarEstrategia(ArrayList<Elfo> exercito, ArrayList<Dwarf> horda)
    {
        ordemUltimoAtaque.clear();
        this.ordenarNoturnoPorUltimo(exercito);
        
        for (Elfo elfo : exercito)
        {                
            for (Dwarf dwarf : horda)
            {
                if (!elfo.estaVivo())
                    break;
                elfo.atirarFlechaEmDwarf(dwarf);
                this.adicionarElfoHistoricoAtaque(elfo);
            }
        }
    }
    
    private void ordenarNoturnoPorUltimo(ArrayList<Elfo> exercito)
    {
        Collections.sort(exercito, new Comparator<Elfo>() {
            public int compare(Elfo elfo1, Elfo elfo2) {
               if (elfo1 instanceof ElfoNoturno && ! (elfo2 instanceof ElfoNoturno))
                    return 1;
               
               if (! (elfo1 instanceof ElfoNoturno) && elfo2 instanceof ElfoNoturno)
                    return -1;
               
               return 0;
            }
        });
    }
}
