public class DataTerceiraEra
{
    private int dia, mes, ano;
    
    public DataTerceiraEra(int dia, int mes, int ano)
    {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public int getDia()
    {
        return this.dia;
    }
    
    public int getMes()
    {
        return this.mes;
    }
    
    public int getAno()
    {
        return this.ano;
    }
    
    public boolean ehBissexto()
    {
        return this.ano % 400 == 0 || this.ano % 4 == 0 && this.ano % 100 != 0;
    }
    
    public boolean equals(Object obj)
    {
        DataTerceiraEra d = (DataTerceiraEra) obj;
        return d != null && this.dia == d.dia && this.mes == d.mes && this.ano == d.ano; 
    }
}
