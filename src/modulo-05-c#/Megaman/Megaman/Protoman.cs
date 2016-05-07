﻿namespace MegamanProject
{
    public class Protoman : Robo
    {
        private bool jaMorreu;

        public override string Nome
        {
            get {
                return "Protoman";
            }
        }

        public Protoman()
        {
            Defesa = 2;
            jaMorreu = false;
        }

        public override void PerderVida(int vidaAPerder)
        {
            base.PerderVida(vidaAPerder);

            if (Vida <= 0 && jaMorreu == false) {
                jaMorreu = true;
                Vida = 20;
            }
        }
    }
}
