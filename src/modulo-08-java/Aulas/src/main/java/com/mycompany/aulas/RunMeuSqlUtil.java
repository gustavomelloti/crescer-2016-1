package com.mycompany.aulas;

import MeuSQLUtils.MeuSQLUtils;

public class RunMeuSqlUtil {
    public static void main(String[] args) {
        try {
            MeuSQLUtils sqlUtils = new MeuSQLUtils();
            sqlUtils.executarArquivoSQL("C:\\Users\\Gustavo\\Documents\\NetBeansProjects\\Aulas\\teste.sql");
            
        }  catch(Exception e) {
           System.out.println("ERRO: "+ e.getMessage());
        }
    }
}
