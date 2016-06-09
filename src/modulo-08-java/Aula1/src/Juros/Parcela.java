package Juros;

import java.util.Date;

public class Parcela {
    private int numero;
    private Date dataVencimento;
    private double valor;
    
    public Parcela(int numero, Date dataVencimento, double valor) {
        this.numero = numero;
        this.dataVencimento = dataVencimento;
        this.valor = valor;
    }

    public int getNumero() {
        return numero;
    }

    public Date getDataVencimento() {
        return dataVencimento;
    }

    public double getValor() {
        return valor;
    }
}
