namespace MegamanProject
{
    public class CanhaoDePlasma : IUpgrade
    {
        public string Nome
        {
            get
            {
                return "Canhão de Plasma";
            }
        }

        public int Ataque
        {
            get
            {
                return 2;
            }
        }

        public int Defesa
        {
            get
            {
                return 0;
            }
        }
    }
}
