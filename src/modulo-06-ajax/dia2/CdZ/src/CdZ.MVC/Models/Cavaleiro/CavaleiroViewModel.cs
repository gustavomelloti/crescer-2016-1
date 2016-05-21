using CdZ.Dominio;
using System;
using System.Linq;
using System.Collections.Generic;
using Dominio = CdZ.Dominio;
using System.ComponentModel.DataAnnotations;

namespace CdZ.MVC.Models.Cavaleiro
{
    public class CavaleiroViewModel
    {
        public int Id { get; set; }

        [Required]
        [Display(Name="Nome")]
        [StringLength(160)]
        public string Nome { get; set; }

        [Required]
        [Display(Name = "Altura")]
        public double AlturaCm { get; set; }

        [Required]
        [Display(Name = "Peso")]
        public double PesoLb { get; set; }
        
        [Required]
        [Display(Name = "Data Nascimento")]
        public DateTime DataNascimento { get; set; }

        [Display(Name = "Signo")]
        [Range(1, 13, ErrorMessage="O campo Signo é obrigatório")]
        public Signo Signo { get; set; }

        [Display(Name = "Tipo Sanguíneo")]
        [Range(1, 6, ErrorMessage="O campo Tipo Sanguíneo é obrigatório")]
        public TipoSanguineo TipoSanguineo { get; set; }
       
        [Required]
        [Display(Name = "Local Nascimento")]
        public Local LocalNascimento { get; set; }

        [Required]
        [Display(Name = "Local Treinamento")]
        public Local LocalTreinamento { get; set; }
        
        public IList<string> Golpes { get; set; }
        public IList<ImagemViewModel> Imagens { get; set; }
        
        public CavaleiroViewModel()
        {
            // TODO: corrigir model-bind
            DataNascimento = DateTime.Today;
        }

        public Dominio.Cavaleiro ToModel()
        {
            var golpesObj = Golpes.Select(_ => new Golpe(_)).ToList();
            var imagensObj = Imagens.Select(_ => _.ToModel()).ToList();

            return new Dominio.Cavaleiro(Nome, AlturaCm, PesoLb, DataNascimento, Signo, TipoSanguineo, LocalNascimento, LocalTreinamento, golpesObj, imagensObj);
        }
    }
}