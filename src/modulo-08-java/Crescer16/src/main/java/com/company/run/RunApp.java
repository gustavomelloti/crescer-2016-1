package com.company.run;

import com.mycompany.services.*;
import java.io.IOException;

public class RunApp {
    public static void main(String[] args) throws IOException {
        PedidoService p = new PedidoService();
        try {
            p.delete((long)1024);
        } catch (Exception e) {
            System.err.println(e);
        }   
    }
}
