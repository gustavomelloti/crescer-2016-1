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
            try {
                exercito.alistar(new ElfoNoturno("noturno"+i));
            } catch (NaoPodeAlistarException e) {
                System.out.println(e.getMessage());
            }
            
            
        //implementar classe main
        //criar mais cenários de testes
    }
}
