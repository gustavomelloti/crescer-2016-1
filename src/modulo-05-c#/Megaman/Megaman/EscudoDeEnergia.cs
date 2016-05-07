namespace MegamanProject
{
    public class EscudoDeEnergia : IUpgrade
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
                return 0;
            }
        }

        public int Defesa
        {
            get
            {
                return 2;
            }
        }
    }
}
