import java.util.*;

public class ExercitoElfos
{
    private HashMap<String, Elfo> exercito = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> exercitoOrdenadoPorStatus = new HashMap<>();
    
    public void alistar(Elfo elfo)
    {
        if (elfo instanceof ElfoNoturno || elfo instanceof ElfoVerde)
        {
            exercito.put(elfo.getNome(), elfo);
        }
    }
    
    public Elfo buscarPorNome(String nome)
    {
        return exercito.get(nome);
    }
    
    public HashMap<String, Elfo> getExercito()
    {
        return this.exercito;
    }
    
    public void agruparPorStatus()
    {
        for (Elfo elfo: exercito.values())
        {
            if (!exercito.containsKey(elfo.getStatus()))
                exercitoOrdenadoPorStatus.put(elfo.getStatus(), new ArrayList<Elfo>());
        
            exercitoOrdenadoPorStatus.get(elfo.getStatus()).add(elfo);
        }
    }
}
