import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class ExercitoElfosTest
{
    @Test
    public void alistarElfoNoturno()
    {
        ElfoNoturno elfoNo = new ElfoNoturno("Gustavo");
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.alistar(elfoNo);
        assertTrue(elfoNo.equals(exercito.getExercito().get("Gustavo")));
    }
    
    @Test
    public void alistarElfoVerde()
    {
        ElfoVerde elfoNo = new ElfoVerde("Gustavo");
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.alistar(elfoNo);
        assertTrue(elfoNo.equals(exercito.getExercito().get("Gustavo")));
    }
    
    @Test
    public void buscarElfoComNomeGustavo()
    {
        ElfoVerde elfoNo = new ElfoVerde("Gustavo");
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.alistar(elfoNo);
        assertTrue(elfoNo.equals(exercito.buscarPorNome(elfoNo.getNome())));
    }
    
    @Test
    public void buscarElfoComNomeInexistenteNoExercito()
    {
        ElfoVerde elfoNo = new ElfoVerde("Gustavo");
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.alistar(elfoNo);
        assertNull(exercito.buscarPorNome("Pedro"));
    }
    
    @Test
    public void verificarAgrupacaoAposAdicionarElfoVivo()
    {
        ElfoVerde elfo = new ElfoVerde("Paul");
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.alistar(elfo);
        exercito.agruparPorStatus();
        assertTrue(exercito.getExercitoOrdenadoPorStatus().get(Status.VIVO).contains(elfo));
    }
    
    @Test
    public void verificarAgrupacaoAposAdicionarUmElfoVivoEUmElfoMorto()
    {
        ElfoVerde vivo = new ElfoVerde("Paul");
        ElfoNoturno morto = new ElfoNoturno("Jhon");
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.alistar(vivo);
        
        Dwarf d = new Dwarf("Leva Flecha");
        for (int i = 0; i < 90; i++)
           morto.atirarFlechaEmDwarf(d);
        
        exercito.alistar(morto);
        exercito.agruparPorStatus();
        assertTrue(exercito.getExercitoOrdenadoPorStatus().get(Status.MORTO).contains(morto));
        assertTrue(exercito.getExercitoOrdenadoPorStatus().get(Status.VIVO).contains(vivo));
    }
    
     @Test
     public void verificarAgrupacaoSemElfos()
     {
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.agruparPorStatus();
        assertTrue(exercito.getExercitoOrdenadoPorStatus().size() == 0);
     }
     
     @Test
     public void buscarPorStatusVivoComUmElfoVivo()
     {
        ElfoVerde elfo = new ElfoVerde("Paul");
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.alistar(elfo);
        exercito.agruparPorStatus();
        assertTrue(elfo.equals(exercito.buscar(Status.VIVO).get(0)));
     }
     
     @Test
     public void buscarPorStatusMortoComUmElfoVivo()
     {
        ElfoVerde elfo = new ElfoVerde("Paul");
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.alistar(elfo);
        exercito.agruparPorStatus();
        assertNull(exercito.buscar(Status.MORTO));
     }
     
     @Test
     public void buscarPorStatusMortoComUmElfoMorto()
     {
        ElfoNoturno elfo = new ElfoNoturno("Paul");
        ExercitoElfos exercito = new ExercitoElfos();
        Dwarf d = new Dwarf("Leva Flecha");
        for (int i = 0; i < 90; i++)
           elfo.atirarFlechaEmDwarf(d);
        exercito.alistar(elfo);
        exercito.agruparPorStatus();
        assertTrue(elfo.equals(exercito.buscar(Status.MORTO).get(0)));
     }
     
     @Test
     public void pegarExercitoOrdenadoSemOrdenar()
     {
        ElfoVerde elfo = new ElfoVerde("Paul");
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.alistar(elfo);
        assertTrue(exercito.getExercitoOrdenadoPorStatus().get(Status.VIVO).contains(elfo));
     }
     
     @Test
     public void ordenarComElfoVivoEAposMatarElfoEOrdenar()
     {
        ElfoNoturno elfo = new ElfoNoturno("Paul");
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.alistar(elfo);
        exercito.agruparPorStatus();
        Dwarf d = new Dwarf("Leva Flecha");
        for (int i = 0; i < 90; i++)
           elfo.atirarFlechaEmDwarf(d);
        exercito.agruparPorStatus();
        assertTrue(elfo.equals(exercito.buscar(Status.MORTO).get(0)));
        assertNull(exercito.buscar(Status.VIVO));
    }
}
