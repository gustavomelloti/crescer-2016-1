public class CestoDeLembas
{
    private int qtdLembas;
    
    public CestoDeLembas(int qtdLembas)
    {   
        if (qtdLembas >= 1 && qtdLembas <= 100)
            this.qtdLembas = qtdLembas;
        else {
            this.qtdLembas = 0;
            System.out.println("Informe um valor inteiro entre 1 e 100");
        }
    }
    
    public boolean podeDividirEmPares()
    {
        if (this.qtdLembas > 2 && this.qtdLembas % 2 == 0)
            return true;
        
       return false;
    }
}
