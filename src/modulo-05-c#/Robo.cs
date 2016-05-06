namespace Megaman
{
    public abstract class Robo
    {
        public abstract string Nome { get; }
        protected int Vida { get; }
        protected virtual int Ataque { get; }
        protected virtual int Defesa { get; }

        public Robo()
        {
            Vida   = 100;
            Ataque = 5;
            Defesa = 0;
        }
    }
}
