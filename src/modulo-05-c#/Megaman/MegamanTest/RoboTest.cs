using Microsoft.VisualStudio.TestTools.UnitTesting;
using MegamanProject;

namespace MegamanTest
{
    [TestClass]
    public class RoboTest
    {
        [TestMethod]
        public void ToStringEmMagmanDefault()
        {
            Megaman m = new Megaman();

            Assert.AreEqual(m.ToString(), "Vida: 100, Ataque: 6, Defesa: 0");
        }

        [TestMethod]
        public void ToStringEmProtomanAposLevarUmAtaqueDeMegaman()
        {
            Megaman m = new Megaman();
            Protoman p = new Protoman();

            m.Atacar(p);

            Assert.AreEqual(p.ToString(), "Vida: 96, Ataque: 5, Defesa: 2");
        }

        [TestMethod]
        public void ToStringEmMegamanComChipNivel3()
        {
            Megaman m = new Megaman(Chip.Nivel3);
          
            Assert.AreEqual(m.ToString(), "Vida: 100, Ataque: 8, Defesa: 1");
        }

        [TestMethod]
        public void ToStringEmMegamanComChipNivel1()
        {
            Megaman m = new Megaman(Chip.Nivel1);

            Assert.AreEqual(m.ToString(), "Vida: 100, Ataque: 5, Defesa: 0");
        }
    }
}
