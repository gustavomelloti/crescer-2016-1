public class CestoDeLembas
{
    private int qtdLembas;
    
    public CestoDeLembas(int qtdLembas)
    {   
        //verifica se a quaintidade de lembas informada está entre 1 e 100

        if (qtdLembas >= 1 && qtdLembas <= 100)
            this.qtdLembas = qtdLembas;
        else {
            this.qtdLembas = 0;
            System.out.println("Informe um valor inteiro entre 1 e 100");
        }
    }
    
    public boolean podeDividirEmPares() {
        // se a quantidade for inferior a 2, logo é impossível ser divida em um número par
        if (this.qtdLembas <= 2)
            return false;
        
         //verifica se a qtd de lembas é par, logo pode ser divisível em valores pares 
        if (this.qtdLembas % 2 == 0)
            return true;
        
       return false;
    }
}
