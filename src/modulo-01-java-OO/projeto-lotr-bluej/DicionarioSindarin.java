import java.util.*;

public class DicionarioSindarin
{
    public static void main(String[] args)
    {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bem-vindo ao tradutor Sindarin!!");
        System.out.println("[P]ortugês [I]nglês");
        
        String idioma = scanner.nextLine();
        
        TradutorSindarin tradutor = criarTradutorSindarin(idioma);
        
        System.out.println("Digite a palavra desejada: ");
        String palavraASerTraduzida = scanner.nextLine();
        
        String resposta = tradutor.traduzir(palavraASerTraduzida); 
        System.out.println(resposta == null ? "Palavra não encontrada" : resposta);
    }
    
    private static TradutorSindarin criarTradutorSindarin(String idioma)
    {
        switch(idioma.toLowerCase())
        {
            case "i":
                return new SindarinParaIngles();
            default:
                return new SindarinParaPortugues();
        }
    }
    
    public void teste() {
        //declarando
        HashMap<String, String> dicionarioSindarin = new HashMap<>();
       
        //adicionando chave-valor
        dicionarioSindarin.put("terra", "amar");
        dicionarioSindarin.put("fogo", "naur");
        dicionarioSindarin.put("vento", "gwaew");
        dicionarioSindarin.put("água", "nen");
        dicionarioSindarin.put("coração", "gûr");
        
        //pegando a tradução da palavra terra
        String terraEmSindarin = dicionarioSindarin.get("terra");
        
        //sobrepor o valor da posição água
        dicionarioSindarin.put("água", "nÎn");
        
        //remover chave-valor
        dicionarioSindarin.remove("água");
        
        //está vazio?
        boolean estaVazio = dicionarioSindarin.isEmpty();
        
        //tamanho
        int tamanhoDePares = dicionarioSindarin.size();
        
        //contém chave?
        boolean contemAgua = dicionarioSindarin.containsKey("água");
        
        //contém valor?
        boolean contemValor = dicionarioSindarin.containsValue("naur");
      
        //interação por chave
        for(String chave : dicionarioSindarin.keySet())
        {
            System.out.println(chave);
        }
        
        //interação por valor
        int qtdNaur = 0;
        for(String valor : dicionarioSindarin.values())
        {
            if (valor.equals("naur"))
                qtdNaur++;
        }
        
        System.out.println("quantidade de chaves com naur: " + qtdNaur);
        
        qtdNaur = 0;
        //interação por chave e valor
        for (Map.Entry<String, String> chaveValor: dicionarioSindarin.entrySet())
        {
            if (chaveValor.getValue().equals("naur"))
            {
                qtdNaur++;
                System.out.println("A chave " + chaveValor.getKey() + "possui o valor naur");
            }
        }
        
        
        dicionarioSindarin.put("FB", "Facebook");
        dicionarioSindarin.put("Ea", "Badoo");
        
        for (Map.Entry<String, String> chaveValor: dicionarioSindarin.entrySet())
        {
            System.out.println("K: " + chaveValor.getKey() + " V: " + chaveValor.getValue());
        }
    }
}
