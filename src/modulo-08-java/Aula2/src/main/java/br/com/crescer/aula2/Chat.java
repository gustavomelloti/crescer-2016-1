package br.com.crescer.aula2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Chat {
    
    private String caminhoArquivo;
    
    public Chat (String arquivo) {
        this.caminhoArquivo = arquivo;
    }
    
    public void exibirMensagens() {
     new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader bufferReader = null;
                try {
                    bufferReader = new BufferedReader(new FileReader(caminhoArquivo));
                    while (true) {
                        String readLine = bufferReader.readLine();
                        if (readLine != null) {
                            System.out.println(readLine);
                        }
                        Thread.sleep(1000l);
                    }
                } catch(Exception e) {
                    
                } finally {
                    try {
                        bufferReader.close();
                    } catch (IOException ex) {
                        Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();
    }
    
    public void cadastrarMensagem(String mensagem) {         
        BufferedWriter bufferWriter = null;

        try {
            bufferWriter = new BufferedWriter(new FileWriter(caminhoArquivo, true));
            bufferWriter.write(mensagem);
            bufferWriter.newLine();
            bufferWriter.flush();
        } catch (Exception e) {

        } finally {
           try {
                bufferWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
