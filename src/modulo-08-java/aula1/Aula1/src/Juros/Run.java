package Juros;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Run {
    public static void main(String[] args) {
        Scanner teclado = null;
        Parcelator parcelator = null;
        try {
            teclado = new Scanner(System.in);
            parcelator = new Parcelator();
            
            System.out.println("---------Utilização de recursos------- \n");
            
            System.out.println("Utilização do método simpleInterestCalculator:");
            
            System.out.println("Digite o valor total (Ex: 1200,50): ");
            double valorTotal = teclado.nextDouble();
            
            System.out.println("Digite a taxa de juros (Ex: 0,1): ");
            double taxaJuros = teclado.nextDouble();
            
            System.out.println("Digite a quantidade de meses (Ex: 1): ");
            int meses = teclado.nextInt();
            
            System.out.println("Digite a data inicial da cobrança (Ex: 05/01/2016): ");
            String data = teclado.nextLine();
            
            SimpleDateFormat formatInput = new SimpleDateFormat("dd/MM/yyyy");
            Date dataInformada = formatInput.parse(data);
            
            List<Parcela> parcelas = parcelator.simpleInterestCalculator(valorTotal, taxaJuros, meses, dataInformada);
            
            for(Parcela p : parcelas) {
                System.out.println("Número: " + p.getNumero());
                System.out.println("Data: " + p.getDataVencimento());
                System.out.println("Valor: " + p.getValor());
            }
            
        } catch(Exception e) {
            System.out.println("Erro ao realizar operação.");
        } finally {
            if (teclado != null) {
                teclado.close();
            }    
        }
    }
}