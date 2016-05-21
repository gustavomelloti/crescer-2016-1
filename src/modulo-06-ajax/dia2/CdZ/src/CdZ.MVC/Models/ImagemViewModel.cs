using CdZ.Dominio;
using System.ComponentModel.DataAnnotations;

namespace CdZ.MVC.Models
{
    public class ImagemViewModel
    {
        public int Id { get; set; }

        [Required]
        public string Url { get; set; }

        [Required]
        public bool IsThumb { get; set; }

        public ImagemViewModel() { }

        public Imagem ToModel()
        {
            return new Imagem(Url, IsThumb);
        }
    }
}