package FilesUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Array;
import java.util.stream.Stream;

public class MeuReaderUtils {
    public void exibirConteudo(String arquivo) throws FileNotFoundException,IllegalArgumentException, IOException {
        BufferedReader bufferReader = null;
        Reader reader = null;
         
        try {
            if (arquivo.lastIndexOf(".txt") == -1) {
                throw new IllegalArgumentException();
            }
                
            reader = new FileReader(arquivo);
            bufferReader = new BufferedReader(reader);
            bufferReader.lines().forEach(x -> System.out.println(x));
        } finally {
            if (bufferReader != null) {
                bufferReader.close();
            }
            
            if (reader != null) {
                reader.close();
            }
        }
    }
    
    public String retornarConteudoArquivo(String arquivo) throws FileNotFoundException,IllegalArgumentException, IOException {
        BufferedReader bufferReader = null;
        Reader reader = null;
         
        try { 
            reader = new FileReader(arquivo);
            bufferReader = new BufferedReader(reader);
            return bufferReader.readLine();
        } finally {
            if (bufferReader != null) {
                bufferReader.close();
            }
            
            if (reader != null) {
                reader.close();
            }
        }
    }
    
    //TODO: refatorar
    public String[] retornarConteudoArquivoArray(String arquivo) throws FileNotFoundException,IllegalArgumentException, IOException {
        BufferedReader bufferReader = null;
        Reader reader = null;
         
        try { 
            reader = new FileReader(arquivo);
            bufferReader = new BufferedReader(reader);
            return bufferReader.lines().toArray(String[]::new);
        } finally {
            if (bufferReader != null) {
                bufferReader.close();
            }
            
            if (reader != null) {
                reader.close();
            }
        }
    }
}