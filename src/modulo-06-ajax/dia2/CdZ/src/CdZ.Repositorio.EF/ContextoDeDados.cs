using CdZ.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration.Conventions;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CdZ.Repositorio.EF
{
    class ContextoDeDados : DbContext
    {
        public ContextoDeDados() : base("ConexaoCdZ") { }

        public DbSet<Usuario> Usuario { get; set; }
        public DbSet<Permissao> Permissao { get; set; }
        public DbSet<Cavaleiro> Cavaleiro { get; set; }
        public DbSet<Local> Local { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Conventions.Remove<PluralizingTableNameConvention>();
            modelBuilder.Entity<Cavaleiro>().HasMany(_ => _.Golpes).WithRequired();
            modelBuilder.Entity<Cavaleiro>().HasMany(_ => _.Imagens).WithRequired();
            base.OnModelCreating(modelBuilder);
        }
    }
}
