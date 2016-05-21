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
        [StringLength(160)]
        public string Nome { get; set; }
        public double AlturaCm { get; set; }
        public double PesoLb { get; set; }
        
        [Required]
        public DateTime DataNascimento { get; set; }

        [Required]
        public Signo Signo { get; set; }

        [Required]
        public TipoSanguineo TipoSanguineo { get; set; }
        public Local LocalNascimento { get; set; }
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