using System.Collections.Generic;
namespace MegamanProject
{
    public abstract class Robo
    {
        public abstract string Nome { get; }
        public int Vida { get; protected set; }
        public List<IUpgrade> Upgrades = new List<IUpgrade>();
        protected int ataque;
        protected int Ataque
        {
            get
            {
                int ataquesUp = 0;

                foreach (var up in Upgrades)
                    ataquesUp += up.Ataque;

                return ataque + ataquesUp;
            }

            set {ataque = value;}
        }

        protected int defesa;
        protected int Defesa
        {
            get
            {
                int defesaUp = 0;

                foreach (var up in Upgrades)
                    defesaUp += up.Defesa;

                return defesa + defesaUp;
            }

            set { defesa = value; }
        }

        public Robo()
        {
            Vida = 100;
            ataque = 5;
            defesa = 0;
        }

        public virtual void PerderVida(int ataque)
        {
            int vidaAPerder = ataque - Defesa;

            Vida -= vidaAPerder > Vida ? 0 : vidaAPerder;
        }

        public virtual void Atacar(Robo robo)
        {
            robo.PerderVida(Ataque);
        }

        public override string ToString()
        {
            return string.Format(
                "Nome: {0}, Vida: {1}, Ataque: {2}, Defesa: {3}",
                Nome,
                Vida,
                Ataque,
                Defesa
            );
        }

        public void EquiparUpgrade(IUpgrade upgradeItem)
        {
            if (Upgrades.Count < 3)
                Upgrades.Add(upgradeItem);
        }
    }
}
