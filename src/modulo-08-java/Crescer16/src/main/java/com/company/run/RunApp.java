package com.company.run;

import com.mycompany.dao.*;
import com.mycompay.entity.Material;


public class RunApp {
    public static void main(String[] args) {
        ProdutoMaterialDAO p  = new ProdutoMaterialDAO();
        //CidadeDAO cidadeDAO = new CidadeDAO();
        System.out.println(p.findById((long) 67625).getProduto().getNome());       
    }
}
