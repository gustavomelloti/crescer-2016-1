namespace MegamanProject
{
    public class Megaman : Robo
    {
        public override string Nome
        {
            get
            {
                return "Megaman";
            }
        }

        public Megaman()
        {
            Ataque = 6;
        }

        public override void Atacar(Robo robo)
        {
            int quantidadeAtaque = Vida < 30 ? Ataque + 3: Ataque;
            robo.PerderVida(quantidadeAtaque);
        }
    }
}
