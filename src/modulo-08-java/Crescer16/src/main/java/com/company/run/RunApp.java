package com.company.run;

import com.mycompany.dao.*;
import com.mycompay.entity.*;

public class RunApp {
    public static void main(String[] args) {
        //ClienteDAO cDAO = new ClienteDAO();
        CidadeDAO cidadeDAO = new CidadeDAO();
        
        for(Cidade c : cidadeDAO.listAll()) {
            System.out.println(c.getNome());
        }
    }
}
