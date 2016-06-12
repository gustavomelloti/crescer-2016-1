/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Gustavo
 */
public class WriterUtils {
   
    public void writeLines(String fileName, List<String> lines) throws IOException {
        final File file = new File(fileName);
        Arrays.asList(lines);
                
        try (final BufferedWriter writer = getWriter(file);) {
            lines.stream().forEach((string) -> {
                try {
                    writer.append(string);
                    writer.newLine();
                } catch (IOException e) {
                    System.err.format("Erro ao gerar CSV.");
                }
            });
        }
    }

    private BufferedWriter getWriter(File file) throws IOException {
        return new BufferedWriter(new FileWriter(file, true));
    }
}
