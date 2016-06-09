package StringUtil;

public class MeuStringUtil {
    
    private String[] vogais = new String[]{"a", "e", "i", "o", "u"};
    
    public boolean isEmpty(String str){
        return str == null || str.trim().length() == 0;
    }
    
    public String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    public boolean isPalindromo(String str) {
        return str.toLowerCase().equals(this.reverse(str).toLowerCase());
    }
     
    public int lengthVogais(String str){
        int qtdLetras = str.length();
        
        str = str.toLowerCase();
        
        for(String vog : vogais) {
            str = str.replace(vog, "");
        }
         
        return qtdLetras - str.length();
    }
}
