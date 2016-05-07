using Microsoft.VisualStudio.TestTools.UnitTesting;
using MegamanProject;

namespace MegamanTest
{
    [TestClass]
    public class CombateTest
    {
        [TestMethod]
        public void MegamanCom100DeVidaAtacaProtomanCom2DeArmadura()
        {
            Megaman  m = new Megaman();
            Protoman p = new Protoman();

            m.Atacar(p);

            Assert.AreEqual(p.Vida, 96);
        }

        [TestMethod]
        public void MegamanCom25DeVidaAtacaProtomanCom2DeArmadura()
        {
            Megaman m = new Megaman();
            Protoman p = new Protoman();

            for (int i = 0; i <= 14; i++)
            {
                p.Atacar(m);
            }

            m.Atacar(p);

            Assert.AreEqual(p.Vida, 93);
        }

        [TestMethod]
        public void MegamanSofrendo20AtaqueProtomanEFicandoCom0DeVida()
        {
            Megaman m = new Megaman();
            Protoman p = new Protoman();

            for (int i = 0; i <= 20; i++)
            {
                p.Atacar(m);
            }

            Assert.AreEqual(m.Vida, 0);
        }

        [TestMethod]
        public void ProtomanAposPerderTodaVidaRecebe20DeVida()
        {
            Megaman m = new Megaman();
            Protoman p = new Protoman();

            for (int i = 0; i < 25; i++)
            {
                m.Atacar(p);
            }

            Assert.AreEqual(p.Vida, 20);
        }

        [TestMethod]
        public void ProtomanAposPerder96DeVidaFicaCom4DeVida()
        {
            Megaman m = new Megaman();
            Protoman p = new Protoman();

            for (int i = 0; i < 24; i++)
            {
                m.Atacar(p);
            }

            Assert.AreEqual(p.Vida, 4);
        }

        [TestMethod]
        public void MagmanComUpgradeCanhaoDePlasmaAtacaProtoman()
        {
            Megaman m = new Megaman();
            Protoman p = new Protoman();
            m.EquiparUpgrade(new CanhaoDePlasma());
            m.Atacar(p);

            Assert.AreEqual(p.Vida, 94);
        }

        [TestMethod]
        public void MagmanAtacaProtomanComUpgradeEscudoDeEnergia()
        {
            Megaman m = new Megaman();
            Protoman p = new Protoman();
            p.EquiparUpgrade(new EscudoDeEnergia());
            m.Atacar(p);

            Assert.AreEqual(p.Vida, 98);
        }

        [TestMethod]
        public void MagmanComUpgradeCanhaoDePlasmaEBotasSuperVelocidadeAtacaProtoman()
        {
            Megaman m = new Megaman();
            Protoman p = new Protoman();
            m.EquiparUpgrade(new CanhaoDePlasma());
            m.EquiparUpgrade(new BotasdeSuperVelocidade());
            m.Atacar(p);

            Assert.AreEqual(p.Vida, 93);
        }

        [TestMethod]
        public void MagmanComUpgradeCanhaoDePlasmaEBotasSuperVelocidadeAtacaProtomanComEscudoDeEnergia()
        {
            Megaman m = new Megaman();
            Protoman p = new Protoman();
            m.EquiparUpgrade(new CanhaoDePlasma());
            m.EquiparUpgrade(new BotasdeSuperVelocidade());
            p.EquiparUpgrade(new EscudoDeEnergia());
            m.Atacar(p);

            Assert.AreEqual(p.Vida, 95);
        }
    }
}
