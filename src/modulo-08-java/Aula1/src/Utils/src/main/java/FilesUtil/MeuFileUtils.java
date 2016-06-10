package FilesUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;

public class MeuFileUtils {
    public void criar(String arquivo) throws IOException {
        new File(arquivo).createNewFile();
    }
    
    public void deletar(String arquivo) throws IllegalArgumentException {
        File file = new File(arquivo);
        
        if (file.isDirectory()) {
            throw new IllegalArgumentException();
        }
        
        file.delete(); 
    }
    
    public void listar(String arquivo) throws FileNotFoundException {
       File file = new File(arquivo);
       
       System.out.print(file.getAbsolutePath() + "\n");
       
        if (file.isDirectory()) {
            for (String a : file.list()) {
                System.out.println(a);
            }
        }
    }
    
    public void mover(String arquivo, String novoCaminho) throws IOException, FileNotFoundException, IllegalArgumentException {
        File file = new File(arquivo);
        File novoCaminhoFile = new File(novoCaminho + arquivo);
        
        if (file.isDirectory()) {
            throw new IllegalArgumentException();
        } 
        
        Files.move(file.toPath(), novoCaminhoFile.toPath());
    }
    
    public void validarExtensao(String arquivo, String extensao) {
        if (!arquivo.endsWith(extensao)) {
            throw new IllegalArgumentException();
        }
    }
}
