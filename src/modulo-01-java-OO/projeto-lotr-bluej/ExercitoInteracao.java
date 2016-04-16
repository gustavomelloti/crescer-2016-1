import java.util.*;

public class ExercitoInteracao
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        ExercitoElfos exercito = new ExercitoElfos();
        HordaDwarfs horda = new HordaDwarfs();
        System.out.println("Bem-Vindo!!");
        System.out.println("Digite a quantidade de Elfos Noturnos");
        
        int qtdElfosNoturno = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < qtdElfosNoturno;i++)
        {
           try {
                exercito.alistar(new ElfoNoturno("noturno"+i));
           } catch (NaoPodeAlistarException e) {
                System.out.println(e.getMessage());
           }
        }
        
        System.out.println("Digite a quantidade de Elfos Verdes");
        
        int qtdElfosVerdes = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < qtdElfosVerdes;i++)
        {
           try {
                exercito.alistar(new ElfoVerde("verde"+i));
           } catch (NaoPodeAlistarException e) {
                System.out.println(e.getMessage());
           }
        }
        
        System.out.println("Digite a quantidade de dwarfs que serão atacados");
        
        int qtdDwarfs = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < qtdDwarfs;i++)
        {
            horda.adicionar(new Dwarf("dwarf"+i));
        }
    
        System.out.println("Selecione a Estratégia de ataque: [P]adrão, I[ntercalada], [N]oturnos por último");
        
        switch(sc.nextLine().toLowerCase())
        {
            case "i":
                exercito.setEstrategia(new EstrategiaAtaqueIntercalado());
                break;
           case "n":
                exercito.setEstrategia(new EstrategiaAtaqueNoturnoPorUltimo());
                break;
           default:
            exercito.setEstrategia(new EstrategiaAtaquePadrao());
        }
        
        exercito.atacar(horda);
        
        System.out.println();
        System.out.println("PUFTTTTTTTTTTTTTT");
        System.out.println("PAHHHHHHHH");
        System.out.println("(Ataque rolando)");
        System.out.println("PUFTTTTTTTTTTTTTT");
        System.out.println("PAHHHHHHHH");
        System.out.println();
        System.out.println("Números do ataque:");
        System.out.println();
        System.out.println("Ordem de ataque e status dos guerreiros");
        System.out.println();
        
        for (Elfo e : exercito.getEstrategiaAtaque().getOrdemUltimoAtaque())
        {
            System.out.println("Nome: " + e.getNome());
            System.out.println("Quantidade de flechas: " + e.getFlechas());
            System.out.println();
        }
        
        System.out.println();
        System.out.println("Dwarfs atacados:");
        System.out.println();
        
        for (Dwarf d : horda.gethorda())
        {
            System.out.println("Nome: " + d.getNome());
            System.out.println("Vida: " + d.getQtdVida());
            System.out.println();
        }
    }
}