using System.Collections.Generic;
namespace MegamanProject
{
    public abstract class Robo
    {
        public abstract string Nome { get; }
        public int Vida { get; protected set; }
        protected List<IUpgrade> Upgrades {get;set;}
        private int ataque;
        protected virtual int Ataque
        {
            get
            {
                int ataquesUp = 0;

                foreach (var up in Upgrades)
                    ataquesUp += up.AtaqueAdicional;

                return ataque + ataquesUp;
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

                return defesa + defesaUp;
            }

            set { defesa = value; }
        }

        public Robo()
        {
            Vida = 100;
            ataque = 5;
            defesa = 0;
            Upgrades = new List<IUpgrade>();
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
                "Nome: {0}, Vida: {1}, Ataque: {2}, Defesa: {3}",
                Nome,
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
    }
}
