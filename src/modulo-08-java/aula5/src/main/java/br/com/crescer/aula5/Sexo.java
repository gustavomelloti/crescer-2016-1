package br.com.crescer.aula5;

public enum Sexo {
    MASCULINO(1), FEMININO(2), OUTRO(3);
    
    private final int id;

    private Sexo(int id) {
        this.id = id;
    }
}
