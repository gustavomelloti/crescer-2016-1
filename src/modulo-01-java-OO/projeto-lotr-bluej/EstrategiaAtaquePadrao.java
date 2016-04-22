import java.util.*;

public class EstrategiaAtaquePadrao implements EstrategiaAtaque
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

        int quantidadeNoturnoPodemAtacar = (int) Math.floor((exercito.size() * horda.size()) * 0.3);
        
        for (Elfo elfo : exercito)
        {
            if  (!elfo.estaVivo())
                continue;
                
            for (Dwarf dwarf : horda)
            {
                if (elfo instanceof ElfoNoturno)
                {
                   if (quantidadeNoturnoPodemAtacar <= 0 || !elfo.estaVivo())
                        break;
                   quantidadeNoturnoPodemAtacar--;
                }
                
                elfo.atirarFlechaEmDwarf(dwarf);
                this.adicionarElfoHistoricoAtaque(elfo);
            }
        }
    }
}
