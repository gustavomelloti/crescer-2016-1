package com.mycompany.aulas;

import MeuSQLUtils.MeuSQLUtils;

public class RunMeuSqlUtil {
    public static void main(String[] args) {
        try {
            MeuSQLUtils sqlUtils = new MeuSQLUtils();
            //sqlUtils.importarCsvPessoas("C:\\Users\\Gustavo\\Documents\\NetBeansProjects\\Aulas\\teste.csv");
            sqlUtils.exportarCsv();
        }  catch(Exception e) {
           System.out.println("ERRO: "+ e.getMessage());
        }
    }
}
