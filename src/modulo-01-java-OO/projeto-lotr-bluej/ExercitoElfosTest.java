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
    public void teste()
    {
        ElfoVerde elfoNo = new ElfoVerde("Gustavo");
        ElfoVerde elfoNo2 = new ElfoVerde("Paul");
        ExercitoElfos exercito = new ExercitoElfos();
        exercito.alistar(elfoNo);
        exercito.alistar(elfoNo2);
        exercito.agruparPorStatus();
    }
}
