namespace MegamanProject
{
    public abstract class Robo
    {
        public abstract string Nome { get; }
        public int Vida { get; protected set; }
        protected int Ataque { get;  set; }
        protected int Defesa { get;  set; }

        public Robo()
        {
            Vida = 100;
            Ataque = 5;
            Defesa = 0;
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
    }
}
