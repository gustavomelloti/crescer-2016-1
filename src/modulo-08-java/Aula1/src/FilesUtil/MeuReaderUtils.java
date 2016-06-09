package FilesUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

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
}
