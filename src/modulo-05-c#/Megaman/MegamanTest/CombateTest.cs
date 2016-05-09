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

        [TestMethod]
        public void MegamanComUpgradeDeRushSemUpdgradeAtacaProtoman()
        {
            Megaman  m = new Megaman();
            Protoman p = new Protoman();
            Rush r = new Rush();

            m.EquiparUpgrade(r);

            m.Atacar(p);

            Assert.AreEqual(p.Vida, 92);
        }

        [TestMethod]
        public void MegamanComUpgradeDeRushComUpdgradeCanhaoDePlasmaAtacaProtoman()
        {
            Megaman m = new Megaman();
            Protoman p = new Protoman();
            Rush r = new Rush();

            r.EquiparUpgrade(new CanhaoDePlasma());
            m.EquiparUpgrade(r);

            m.Atacar(p);

            Assert.AreEqual(p.Vida, 90);
        }

        [TestMethod]
        public void MegamanComUpgradeDeRushComUpdgradeCanhaoDePlasmaAtacaProtomanComUpgradeEscudoDeEnergia()
        {
            Megaman m = new Megaman();
            Protoman p = new Protoman();
            Rush r = new Rush();

            r.EquiparUpgrade(new CanhaoDePlasma());
            m.EquiparUpgrade(r);
            p.EquiparUpgrade(new EscudoDeEnergia());

            m.Atacar(p);

            Assert.AreEqual(p.Vida, 92);
        }

        [TestMethod]
        public void MegamanSemUpgradeAtacaProtomanComUpgradeDeRushEscudoDeEnergia()
        {
            Megaman m = new Megaman();
            Protoman p = new Protoman();
            Rush r = new Rush();

            p.EquiparUpgrade(new EscudoDeEnergia());
            p.EquiparUpgrade(r);
            m.Atacar(p);

            Assert.AreEqual(p.Vida, 100);
        }

        [TestMethod]
        public void MegamanComRushDe3UpgradeCanhaDePlasmaAtacaProtoman()
        {
            Megaman m = new Megaman();
            Protoman p = new Protoman();
            Rush r = new Rush();

            r.EquiparUpgrade(new CanhaoDePlasma());
            r.EquiparUpgrade(new CanhaoDePlasma());
            r.EquiparUpgrade(new CanhaoDePlasma());

            m.EquiparUpgrade(r);
            m.Atacar(p);

            Assert.AreEqual(p.Vida, 88);
        }

        [TestMethod]
        public void TentandoEquiparMegamanCom5UpgradeCanhaDePlasmaAtacaProtoman()
        {
            Megaman m = new Megaman();
            Protoman p = new Protoman();

            m.EquiparUpgrade(new CanhaoDePlasma());
            m.EquiparUpgrade(new CanhaoDePlasma());
            m.EquiparUpgrade(new CanhaoDePlasma());
            m.EquiparUpgrade(new CanhaoDePlasma());
            m.EquiparUpgrade(new CanhaoDePlasma());

            m.Atacar(p);

            Assert.AreEqual(p.Vida, 90);
        }

        [TestMethod]
        public void MegamanComUgradeBotasECanhaERushComUpgradeCanhaoDePlasmaAtacaProtoman()
        {
            Megaman m = new Megaman();
            Protoman p = new Protoman();
            Rush r = new Rush();

            r.EquiparUpgrade(new CanhaoDePlasma());
            r.EquiparUpgrade(new CanhaoDePlasma());

            m.EquiparUpgrade(r);
            m.EquiparUpgrade(new CanhaoDePlasma());
            m.EquiparUpgrade(new BotasdeSuperVelocidade());
            m.Atacar(p);

            Assert.AreEqual(p.Vida, 85);
        }

        [TestMethod]
        public void ProtomanComEscudoERushCom2EscudosEhAtacadoPorMegaman()
        {
            Megaman m = new Megaman();
            Protoman p = new Protoman();
            Rush r = new Rush();

            r.EquiparUpgrade(new EscudoDeEnergia());
            r.EquiparUpgrade(new EscudoDeEnergia());
            p.EquiparUpgrade(new EscudoDeEnergia());
            p.EquiparUpgrade(r);

            m.Atacar(p);

            Assert.AreEqual(p.Vida, 100);
        }

        [TestMethod]
        public void ProtomanComEscudoERushCom2EscudosEhAtacadoPorMegamanComUgradeBotasECanhaERushComUpgradeCanhaoDePlasma()
        {
            Megaman m = new Megaman();
            Protoman p = new Protoman();
            Rush rProtoman = new Rush();
            Rush mMegaman = new Rush();

            rProtoman.EquiparUpgrade(new EscudoDeEnergia());
            rProtoman.EquiparUpgrade(new EscudoDeEnergia());
            p.EquiparUpgrade(new EscudoDeEnergia());
            p.EquiparUpgrade(rProtoman);


            mMegaman.EquiparUpgrade(new CanhaoDePlasma());
            mMegaman.EquiparUpgrade(new CanhaoDePlasma());
            m.EquiparUpgrade(mMegaman);
            m.EquiparUpgrade(new CanhaoDePlasma());
            m.EquiparUpgrade(new BotasdeSuperVelocidade());

            m.Atacar(p);

            Assert.AreEqual(p.Vida, 94);
        }

        [TestMethod]
        public void ProtomanReviveEGanha7DeAtaqueEAtacaMegaman()
        {
            Megaman m = new Megaman();
            Protoman p = new Protoman();

            for (int i = 0; i < 25; i++)
            {
                m.Atacar(p);
            }

            p.Atacar(m);

            Assert.AreEqual(m.Vida, 93);
        }

        [TestMethod]
        public void MegamanComChip3AtacaProtoman()
        {
            Megaman m = new Megaman(Chip.Nivel3);
            Protoman p = new Protoman();
        
            m.Atacar(p);

            Assert.AreEqual(p.Vida, 95);
        }

        [TestMethod]
        public void RushTentaAtacarMegaman()
        {
            Megaman m = new Megaman();
            Rush r = new Rush();

            r.Atacar(m);

            Assert.AreEqual(m.Vida, 100);
        }

        [TestMethod]
        public void RushAtacaProtoman()
        {
            Protoman p = new Protoman();
            Rush r = new Rush();

            r.Atacar(p);

            Assert.AreEqual(p.Vida, 97);
        }
    }
}
