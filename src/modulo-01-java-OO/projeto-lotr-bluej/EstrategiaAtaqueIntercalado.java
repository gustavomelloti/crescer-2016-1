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
        
        if (!exercitoAptoAEstrategia(exercito))
            return;
            
        int i = 0;
        Elfo anterior = new Elfo("AUX"), atual = null;
        
        while(exercito.size() != ordemUltimoAtaque.size())
        {
            atual = exercito.get(i);
            
            if (!atual.estaVivo())
                continue;
     
            if (!this.ordemUltimoAtaque.contains(atual))
            {
                if (! (atual.getClass().equals(anterior.getClass())))
                {
                    for (Dwarf dwarf : horda)
                        atual.atirarFlechaEmDwarf(dwarf);
                    this.ordemUltimoAtaque.add(atual);
                    anterior = atual;
                }
            }
            i++;
            if (i == exercito.size())  i = 0;
        }
    }
       
    private boolean verificarPossuiMesmoNumeroDeVerdesENoturnos(ArrayList<Elfo> exercito)
    {
        int qtdNoturnos = 0, qtdVerdes = 0;
        
        for (Elfo elfo : exercito)
        {
            if (elfo.getStatus() == Status.VIVO)
            {
                if (elfo instanceof ElfoVerde)
                    qtdVerdes++;
                else
                    qtdNoturnos++;
            }
        }
        
        return qtdNoturnos == qtdVerdes ? true : false;
    }
}
