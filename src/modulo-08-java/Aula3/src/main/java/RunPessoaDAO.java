


import java.util.List;

public class RunPessoaDAO {
    public static void main(String[] args) {
        try {
            PessoaDAO pDao = new PessoaDAO(ConnectionUtils.getConnection());
            //pDao.insert(new Pessoa("pEDRO"));
            //pDao.delete(new Pessoa(1, "Gustavo"));
            List <Pessoa> p = pDao.findNome("Gustavo");
            System.out.println(p.size());
        } catch(Exception e) {
            System.err.println("Erro ao realizar operação.");
        }
    }
}
