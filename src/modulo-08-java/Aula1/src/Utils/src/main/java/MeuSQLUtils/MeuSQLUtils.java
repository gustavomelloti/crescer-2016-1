package MeuSQLUtils;

import br.com.crescer.aula3.PessoaDAO;
import ConnectionUtils.ConnectionUtils;
import FilesUtil.MeuReaderUtils;
import FilesUtil.MeuFileUtils;
import FilesUtil.MeuWriterUtils;
import br.com.crescer.aula3.Pessoa;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


public class MeuSQLUtils {
    private MeuFileUtils fileUtils;
    private MeuReaderUtils readerUtils;
    private MeuWriterUtils writerUtils;
    private MeuDAOUtils daoUtils;
    private PessoaDAO pessoaDao;
    
    public MeuSQLUtils() throws SQLException {
        readerUtils = new MeuReaderUtils();
        writerUtils = new MeuWriterUtils();
        daoUtils = new MeuDAOUtils(ConnectionUtils.getConnection());
        fileUtils = new MeuFileUtils();
        pessoaDao = new PessoaDAO(ConnectionUtils.getConnection());
    }
    
    public ArrayList<String> executarArquivoSQL(String arquivo) throws IllegalArgumentException, IOException, Exception {
        fileUtils.validarExtensao(arquivo, ".sql");

        String conteudoArquivo = readerUtils.retornarConteudoArquivo(arquivo);
        
        if (conteudoArquivo.toLowerCase().startsWith("select")) {
            return daoUtils.processarQuery(conteudoArquivo);
        } else {
            daoUtils.processarNonQuery(conteudoArquivo);
            return null;
        }
    }
    
    public void importarCsvPessoas(String arquivo) throws IllegalArgumentException, IOException, Exception {
        fileUtils.validarExtensao(arquivo, ".csv");
        daoUtils.importarPessoas(readerUtils.retornarConteudoArquivoArray(arquivo));
    }
    
    public void exportarCsv() throws IOException {
        ArrayList<String> conteudo = new ArrayList<>();
        
        String arquivoCSV = "Pessoas_" + new SimpleDateFormat("dd_MM_yyyy_HH_mm").format(Calendar.getInstance().getTime()) + ".csv";
        fileUtils.criar(arquivoCSV);
        
        //título das colunas
        conteudo.add("ID,NOME");
        
        for (Pessoa p : pessoaDao.listAll()) {
            conteudo.add(p.getId() + "," + p.getNome());
        }

        writerUtils.escreverConteudo(arquivoCSV, conteudo);
    }
}
