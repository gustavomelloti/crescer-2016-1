using CdZ.Dominio;
using CdZ.MVC.Extensions;
using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web.Script.Serialization;

namespace CdZ.MVC.Models.Cavaleiro
{
    public class CavaleiroViewModel
    {
        public int? Id { get; set; }

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
        [DisplayFormat(DataFormatString = "{0:dd/MM/yyyy}", ApplyFormatInEditMode = true)]
        public string DataNascimento { get; set; }
        // Esta annotation [ScriptIgnore] é para "não enviar este campo no JSON"

        [ScriptIgnore]
        public DateTime DataNascimentoObj
        {
            get { return DataNascimento.FromISOToDateTime(); }
            set { DataNascimento = value.FromDateTimeToISOString(); }
        }

        [Display(Name = "Signo")]
        [Range(1, 13, ErrorMessage="O campo Signo é obrigatório")]
        public Signo Signo { get; set; }

        public string SignoDescricao { get; set; }

        [Display(Name = "Tipo Sanguíneo")]
        [Range(1, 6, ErrorMessage="O campo Tipo Sanguíneo é obrigatório")]
        public TipoSanguineo TipoSanguineo { get; set; }
       
        public string TipoSanguineoDescricao { get; set; }

        [Required]
        [Display(Name = "Local Nascimento")]
        public LocalViewModel LocalNascimento { get; set; }

        [Required]
        [Display(Name = "Local Treinamento")]
        public LocalViewModel LocalTreinamento { get; set; }
        
        public IList<GolpeViewModel> Golpes { get; set; }
        public IList<ImagemViewModel> Imagens { get; set; }

        public string UrlThumb { get; set; }
        
        public CavaleiroViewModel()
        {
        }

        public Dominio.Cavaleiro ToModel()
        {
            var golpesObj = Golpes.Select(_ => _.ToModel()).ToList();
            var imagensObj = Imagens.Select(_ => _.ToModel()).ToList();

            return new Dominio.Cavaleiro(Nome, AlturaCm, PesoLb, DataNascimentoObj, Signo, TipoSanguineo, LocalNascimento.ToModel(), LocalTreinamento.ToModel(), golpesObj, imagensObj);
        }

        public Dominio.Cavaleiro ToModelWithId()
        {
            var cavaleiro = this.ToModel();

            cavaleiro.Id = (int)this.Id;

            return cavaleiro;
        }

        public void toVieModel(Dominio.Cavaleiro cavaleiro)
        {
            this.Id = cavaleiro.Id;
            this.Nome = cavaleiro.Nome;
            this.AlturaCm = cavaleiro.AlturaCm;
            this.PesoLb = cavaleiro.PesoLb;
            this.DataNascimentoObj = cavaleiro.DataNascimento;
            this.Signo = cavaleiro.Signo;
            this.TipoSanguineo = cavaleiro.TipoSanguineo;
            this.LocalNascimento = new LocalViewModel(cavaleiro.LocalNascimento.Id, cavaleiro.LocalNascimento.Texto);
            this.LocalTreinamento = new LocalViewModel(cavaleiro.LocalTreinamento.Id, cavaleiro.LocalTreinamento.Texto);
            this.Golpes = cavaleiro.Golpes.Select(_ => new GolpeViewModel(_.Id, _.Nome)).ToList();
            this.Imagens = cavaleiro.Imagens.Select(_ => new ImagemViewModel(_.Id, _.Url, _.IsThumb)).ToList();
        }
    }
}