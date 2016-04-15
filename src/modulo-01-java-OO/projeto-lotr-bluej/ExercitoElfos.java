import java.util.*;

public class ExercitoElfos
{
    private HashMap<String, Elfo> exercito = new HashMap<>();
    private HashMap<Status, ArrayList<Elfo>> exercitoOrdenadoPorStatus = new HashMap<>();
    private boolean alterouExercito = false;
    private EstrategiaAtaque estrategia = new EstrategiaAtaquePadrao();
    
    public void alistar(Elfo elfo) throws NaoPodeAlistarException
    {
        if ( !( elfo instanceof ElfoNoturno) && !(elfo instanceof ElfoVerde))
            throw new NaoPodeAlistarException();
        
        this.exercito.put(elfo.getNome(), elfo);
        alterouExercito = true;
    }
    
    public Elfo buscarPorNome(String nome)
    {
        return this.exercito.get(nome);
    }
    
    public HashMap<String, Elfo> getExercito()
    {
        return this.exercito;
    }
    
    public HashMap<Status, ArrayList<Elfo>> getExercitoOrdenadoPorStatus()
    {
        this.verificarSePrecisaAtualizarExercitoOrdenado();
        return this.exercitoOrdenadoPorStatus;
    }
    
    public ArrayList<Elfo> buscar(Status status)
    {
       this.verificarSePrecisaAtualizarExercitoOrdenado();
       return this.exercitoOrdenadoPorStatus.get(status);
    }
    
    private void verificarSePrecisaAtualizarExercitoOrdenado()
    {
        if (alterouExercito)
            this.agruparPorStatus(); 
    }
    
    public void atacar(HordaDwarfs horda)
    {
        this.verificarSePrecisaAtualizarExercitoOrdenado();
        ArrayList<Elfo> elfosVivos = exercitoOrdenadoPorStatus.get(Status.VIVO);
        estrategia.executarEstrategia(elfosVivos != null ? elfosVivos : new ArrayList<Elfo>(), horda.gethorda());
    }
    
    public void setEstrategia(EstrategiaAtaque estrategia)
    {
        this.estrategia = estrategia;
    }
    
    public EstrategiaAtaque getEstrategiaAtaque()
    {
        return this.estrategia;
    }
    
    public void agruparPorStatus()
    {
        this.exercitoOrdenadoPorStatus.clear();
        
        for (Elfo elfo: exercito.values())
        {
            if (!exercitoOrdenadoPorStatus.containsKey(elfo.getStatus()))
                this.exercitoOrdenadoPorStatus.put(elfo.getStatus(), new ArrayList<Elfo>());
        
            this.exercitoOrdenadoPorStatus.get(elfo.getStatus()).add(elfo);
        }
        
        alterouExercito = false;
    }
}
