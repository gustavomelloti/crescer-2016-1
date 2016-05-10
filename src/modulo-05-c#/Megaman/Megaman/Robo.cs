using System.Collections.Generic;
using System.Linq;

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
                return ataque + CalcularValorAtaqueUpgrade() + CalcularValorAtaqueChip();
            }

            set {ataque = value;}
        }

        protected int defesa;
        protected virtual int Defesa
        {
            get
            {
                return defesa + CalcularValorDefesaUpgrade() + CalcularValorDefesaChip();
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

        public virtual void PerderVida(int ataqueSofrido)
        {
            int perder = (ataqueSofrido - Defesa);

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

        private int CalcularValorAtaqueChip()
        {
            switch (ChipNivel)
            {
                case Chip.Nivel1:
                    return -1;
                case Chip.Nivel3:
                    return 2;
                default:
                    return 0;
            }
        }

        private int CalcularValorDefesaChip()
        {
            return ChipNivel == Chip.Nivel3 ? 1 : 0;
        }

        private int CalcularValorAtaqueUpgrade()
        {
            return Upgrades.Sum(x => x.AtaqueAdicional);
        }

        private int CalcularValorDefesaUpgrade()
        {
            return Upgrades.Sum(x => x.DefesaAdicional);
        }
    }
}
