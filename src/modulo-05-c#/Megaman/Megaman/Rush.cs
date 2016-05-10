namespace MegamanProject
{
    public class Rush : Robo, IUpgrade
    {
        public int AtaqueAdicional
        {
            get
            {
                return Ataque;
            }
        }

        public int DefesaAdicional
        {
            get
            {
                return Defesa;
            }
        }

        public Rush()
        {
            Ataque = 4;
            defesa = 3;
        }

        public Rush(Chip c) : this() {
            ChipNivel = c;
        }

        protected override bool verificarSePodeEquiparUpgrade()
        {
            return Upgrades.Count < 2;
        }

        public override void Atacar(Robo robo)
        {
            if (! (robo is Megaman))
                base.Atacar(robo);
        }
    }
}
