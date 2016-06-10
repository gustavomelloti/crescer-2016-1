/*
package br.com.crescer.aula3;

import java.sql.SQLException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PessoaDAOTest {
   
    private final PessoaDAO pDao;
    
    public PessoaDAOTest() throws SQLException {
        pDao = new PessoaDAO(ConnectionUtils.getConnection());
    }
    
    @org.junit.Test
    public void inserirPessoaComNomeGustavoDeveAumentarAQuantidadeDePessoasEm1() {
        int qtdAntesInserir = pDao.listAll().size();
        
        Pessoa p = new Pessoa("Gustavo");
        pDao.insert(p);
        
        int qtdDepoisDeInserir = pDao.listAll().size();
        
        assertEquals(qtdAntesInserir + 1, qtdDepoisDeInserir);
    }

    @org.junit.Test
    public void testUpdate() {
        System.out.println("update");
        Pessoa p = null;
        PessoaDAO instance = null;
        instance.update(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    @org.junit.Test
    public void testDelete() {
        System.out.println("delete");
        Pessoa p = null;
        PessoaDAO instance = null;
        instance.delete(p);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    @org.junit.Test
    public void testListAll() {
        List<Pessoa> result = pDao.listAll();
        assertEquals(3, result.size());
    }


    @org.junit.Test
    public void testFindNome() {
        List<Pessoa> result = pDao.findNome("Gustavo");
        assertEquals(2, result.size());
    }
}
*/