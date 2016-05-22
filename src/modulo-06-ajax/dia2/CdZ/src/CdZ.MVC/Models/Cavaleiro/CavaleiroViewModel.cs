﻿using CdZ.Dominio;
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
        [DisplayFormat(DataFormatString = "{0:yyyy-MM-dd}", ApplyFormatInEditMode = true)]
        public DateTime DataNascimento { get; set; }

        [Display(Name = "Signo")]
        [Range(1, 13, ErrorMessage="O campo Signo é obrigatório")]
        public Signo Signo { get; set; }

        [Display(Name = "Tipo Sanguíneo")]
        [Range(1, 6, ErrorMessage="O campo Tipo Sanguíneo é obrigatório")]
        public TipoSanguineo TipoSanguineo { get; set; }
       
        [Required]
        [Display(Name = "Local Nascimento")]
        public LocalViewModel LocalNascimento { get; set; }

        [Required]
        [Display(Name = "Local Treinamento")]
        public LocalViewModel LocalTreinamento { get; set; }
        
        public IList<GolpeViewModel> Golpes { get; set; }
        public IList<ImagemViewModel> Imagens { get; set; }
        
        public CavaleiroViewModel()
        {
            // TODO: corrigir model-bind
            DataNascimento = DateTime.Today;
        }

        public Dominio.Cavaleiro ToModel()
        {
            var golpesObj = Golpes.Select(_ => _.ToModel()).ToList();
            var imagensObj = Imagens.Select(_ => _.ToModel()).ToList();

            return new Dominio.Cavaleiro(Nome, AlturaCm, PesoLb, DataNascimento, Signo, TipoSanguineo, LocalNascimento.ToModel(), LocalTreinamento.ToModel(), golpesObj, imagensObj);
        }

        public void toVieModel(Dominio.Cavaleiro cavaleiro)
        {
            this.Nome = cavaleiro.Nome;
            this.AlturaCm = cavaleiro.AlturaCm;
            this.PesoLb = cavaleiro.PesoLb;
            this.DataNascimento = cavaleiro.DataNascimento;
            this.Signo = cavaleiro.Signo;
            this.TipoSanguineo = cavaleiro.TipoSanguineo;
            this.LocalNascimento = new LocalViewModel(cavaleiro.LocalNascimento.Id, cavaleiro.LocalNascimento.Texto);
            this.LocalTreinamento = new LocalViewModel(cavaleiro.LocalTreinamento.Id, cavaleiro.LocalTreinamento.Texto);
            this.Golpes = cavaleiro.Golpes.Select(_ => new GolpeViewModel(_.Id, _.Nome)).ToList();
            this.Imagens = cavaleiro.Imagens.Select(_ => new ImagemViewModel(_.Id, _.Url, _.IsThumb)).ToList();
        }
    }
}