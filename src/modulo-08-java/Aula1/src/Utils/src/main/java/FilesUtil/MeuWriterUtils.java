package FilesUtil;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class MeuWriterUtils {
     public void escreverConteudo(String arquivo, List<String> conteudo) throws FileNotFoundException,IllegalArgumentException, IOException {
        BufferedWriter bufferWriter = null;
        Writer writer = null;
         
        try {
            writer = new FileWriter(arquivo);
            bufferWriter = new BufferedWriter(writer);
            
            for (String linha : conteudo) {
                bufferWriter.write(linha);
                bufferWriter.newLine();
            }
           
            bufferWriter.flush();
        } finally {
            if (writer != null) {
                writer.close();
            }
            
            if (bufferWriter != null) {
                bufferWriter.close();
            }
        }
    }
}
