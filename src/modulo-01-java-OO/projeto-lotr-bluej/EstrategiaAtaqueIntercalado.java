import java.util.*;

public class EstrategiaAtaqueIntercalado implements EstrategiaAtaque
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
    
    private boolean exercitoAptoAEstrategia(ArrayList<Elfo> exercito)
    {
        if (exercito.size() % 2 != 0 || !this.verificarPossuiMesmoNumeroDeVerdesENoturnos(exercito))
            return false;
            
        return true;
    }
    
    public void executarEstrategia(ArrayList<Elfo> exercito, ArrayList<Dwarf> horda)
    {
        ordemUltimoAtaque.clear();
        
        if (exercitoAptoAEstrategia(exercito))
            return;
            
        int i = 1;
        Elfo elfoAtacante = null;
        
        while(exercito.size() != ordemUltimoAtaque.size())
        {
            elfoAtacante = exercito.get(i);
            
            if (!this.ordemUltimoAtaque.contains(elfoAtacante))
            {
                if (! (elfoAtacante.getClass().equals(exercito.get(i-1).getClass()))) {
                    for (Dwarf dwarf : horda)
                    {                
                        elfoAtacante.atirarFlechaEmDwarf(dwarf);
                        this.adicionarElfoHistoricoAtaque(elfoAtacante);
                    }
                }
            }
            
            if (i == exercito.size() -1)
                i = 0;
        }
    }
    
    private boolean verificarPossuiMesmoNumeroDeVerdesENoturnos(ArrayList<Elfo> exercito)
    {
        int qtdNoturnos = 0, qtdVerdes = 0;
        
        for (Elfo elfo : exercito)
        {
            if (elfo instanceof ElfoVerde)
                qtdVerdes++;
            else
                qtdNoturnos++;
        }
        
        return qtdNoturnos == qtdVerdes ? true : false;
    }
}
