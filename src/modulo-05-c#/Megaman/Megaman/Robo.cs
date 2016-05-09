using System.Collections.Generic;
namespace MegamanProject
{
    public abstract class Robo
    {
        public int Vida { get; protected set; }
        protected List<IUpgrade> Upgrades {get;set;}
        protected Chip ChipNivel { get; set; }
        private int ataque;
        protected virtual int Ataque
        {
            get
            {
                int ataquesUp = 0;
                           
                foreach (var up in Upgrades)
                    ataquesUp += up.AtaqueAdicional;

                return AdicionarValorAtaqueChip(ataque + ataquesUp);
            }

            set {ataque = value;}
        }

        protected int defesa;
        protected virtual int Defesa
        {
            get
            {
                int defesaUp = 0;

                foreach (var up in Upgrades)
                    defesaUp += up.DefesaAdicional;

                return AdicionarValorDefesaChip(defesa + defesaUp);
            }

            set { defesa = value; }
        }

        public Robo()
        {
            Vida = 100;
            ataque = 5;
            defesa = 0;
            ChipNivel = Chip.Nivel2;
            Upgrades = new List<IUpgrade>();
        }

        public Robo(Chip c) : this()
        {
            ChipNivel = c;
        }

        public virtual void PerderVida(int ataque)
        {
            int perder = (ataque - Defesa);

            int novaVida = Vida - (perder > 0 ? perder : 0);

            Vida = novaVida > 0 ? novaVida : 0;
        }

        public virtual void Atacar(Robo robo)
        {
            robo.PerderVida(Ataque);
        }

        public override string ToString()
        {
            return string.Format(
                "Vida: {0}, Ataque: {1}, Defesa: {2}",
                Vida,
                Ataque,
                Defesa
            );
        }

        public void EquiparUpgrade(IUpgrade upgradeItem)
        {
            if (verificarSePodeEquiparUpgrade())
                Upgrades.Add(upgradeItem);
        }

        protected virtual bool verificarSePodeEquiparUpgrade()
        {
            return Upgrades.Count < 3;
        }

        private int AdicionarValorAtaqueChip(int valorAtaque)
        {
            if (ChipNivel == Chip.Nivel1)
                return valorAtaque - 1;

            if (ChipNivel == Chip.Nivel3)
                return valorAtaque + 2;

            return valorAtaque;
        }

        private int AdicionarValorDefesaChip(int valorDefesa)
        {
            return ChipNivel == Chip.Nivel3 ? valorDefesa + 1 : valorDefesa;
        }
    }
}
