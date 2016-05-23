using CdZ.Dominio;
using CdZ.MVC.Models;
using CdZ.MVC.Models.Cavaleiro;
using System;
using System.Collections.Generic;
using System.Linq;

namespace CdZ.MVC.Extensions
{
    public static class CavaleiroExtensions
    {
        /// <summary>
        /// Este método visa fazer o mapeamento dos objetos que estão no banco para aqueles que são enviados ou recebidos pelos AJAX.
        /// Colocamos este método de extensão aqui para não "corromper" a "camada" (sic) do domínio.
        /// </summary>
        public static CavaleiroViewModel FromModel(this Cavaleiro cavaleiro)
        {
            var urlThumb = cavaleiro.Imagens.Where(x => x.IsThumb).Select(x => x.Url).FirstOrDefault(); 

            return new CavaleiroViewModel
            {
                Id = cavaleiro.Id,
                Nome = cavaleiro.Nome,
                UrlThumb = urlThumb != null ? urlThumb : "http://data.whicdn.com/images/22194390/tumblr_ly0lu5sxWO1qf8vn3o1_500_large.jpg"
            };
        }

        public static CavaleiroViewModel FromModelAllData(this Cavaleiro cavaleiro)
        {
            return new CavaleiroViewModel
            {
                Id = cavaleiro.Id,
                Nome = cavaleiro.Nome,
                AlturaCm = cavaleiro.AlturaCm,
                PesoLb = cavaleiro.PesoLb,
                DataNascimento = cavaleiro.DataNascimento,
                Signo = cavaleiro.Signo,
                SignoDescricao = ((Signo)cavaleiro.Signo).ToString(),
                TipoSanguineo = cavaleiro.TipoSanguineo,
                TipoSanguineoDescricao = ((TipoSanguineo) cavaleiro.TipoSanguineo).ToString(),
                LocalNascimento = new LocalViewModel(cavaleiro.LocalNascimento.Id, cavaleiro.LocalNascimento.Texto),
                LocalTreinamento = new LocalViewModel(cavaleiro.LocalTreinamento.Id, cavaleiro.LocalTreinamento.Texto),
                Golpes = cavaleiro.Golpes.Select(_ => new GolpeViewModel(_.Id, _.Nome)).ToList(),
                Imagens = cavaleiro.Imagens.Select(_ => new ImagemViewModel(_.Id, _.Url, _.IsThumb)).ToList()
            };
        }

        /// <summary>
        /// Este método visa fazer o mapeamento dos objetos que estão no banco para aqueles que são enviados ou recebidos pelos AJAX.
        /// Colocamos este método de extensão aqui para não "corromper" a "camada" (sic) do domínio.
        /// O objetivo é igual ao método de cima, mas para este método fazemos o mapeamento de uma lista de cavaleiros vindos da tabela do banco para a lista retornada por JSON.
        /// </summary>
        public static IEnumerable<CavaleiroViewModel> FromModel(this IEnumerable<Cavaleiro> cavaleiros)
        {
            var cavaleirosViewModels = new List<CavaleiroViewModel>();

            foreach (var cava in cavaleiros)
            {
                cavaleirosViewModels.Add(cava.FromModel());
            }

            return cavaleirosViewModels;
        }
    }
}