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

            Assert.AreEqual(m.ToString(), "Nome: Megaman, Vida: 100, Ataque: 6, Defesa: 0");
        }

        [TestMethod]
        public void ToStringEmProtomanAposLevarUmAtaqueDeMegamab()
        {
            Megaman m = new Megaman();
            Protoman p = new Protoman();

            m.Atacar(p);

            Assert.AreEqual(p.ToString(), "Nome: Protoman, Vida: 96, Ataque: 5, Defesa: 2");
        }
    }
}
