public class IrishDwarf extends Dwarf
{
    public IrishDwarf(String nome)
    {
        super(nome);
    }
    
    public IrishDwarf(String nome, DataTerceiraEra dataNascimento)
    {
         super(nome, dataNascimento);
    }
    
    public void tentarSorte()
    {
        double numeroDaSorte = this.getNumeroSorte();
        
        if (numeroDaSorte ==  -3333.0)
            this.inventario.aumentarProporcional();
    }
}
