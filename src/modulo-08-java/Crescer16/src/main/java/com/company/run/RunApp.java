package com.company.run;

import com.mycompany.services.*;
import com.mycompay.entity.Pedido;
import java.io.IOException;


public class RunApp {
    public static void main(String[] args) throws IOException {
        PedidoService c = new PedidoService();
        Pedido p = (c.findById((long) 162));
        c.delete(p);
    }
}
