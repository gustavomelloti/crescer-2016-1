import java.util.*;

public class ExercitoInteracao
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ExercitoElfos exercito = new ExercitoElfos();
        
        System.out.println("Bem-Vindo!!");
        System.out.println("Digite a quantidade de Elfos Noturnos");
        
        int qtdElfosNoturno = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i <= qtdElfosNoturno;i++)
            exercito.alistar(new ElfoNoturno("noturno"+i));
        //implementar classe main
        //alterar passagem de parâmetro do método atacar
        //criar mais cenários de testes
    }
}
