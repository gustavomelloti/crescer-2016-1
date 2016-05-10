namespace MegamanProject
{
    public class Protoman : Robo
    {
        private bool jaMorreu;

        public Protoman()
        {
            Defesa = 2;
            jaMorreu = false;
        }

        public Protoman(Chip c) : this() {
            ChipNivel = c;
        }

        public override void PerderVida(int vidaAPerder)
        {
            base.PerderVida(vidaAPerder);

            if (Vida <= 0 && jaMorreu == false) {
                jaMorreu = true;
                Vida = 20;
                Ataque = 7;
            }
        }
    }
}
