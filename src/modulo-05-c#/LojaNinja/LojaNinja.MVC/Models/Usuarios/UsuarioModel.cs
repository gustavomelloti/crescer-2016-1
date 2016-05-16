using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Models.Usuarios
{
    public class UsuarioModel
    {
        [Required]
        [DisplayName("Nome")]
        [StringLength(120)]
        public string Nome { get; set; }

        [Required]
        [DisplayName("Senha")]
        [DataType(DataType.Password)]
        [StringLength(100)]
        public string Senha { get; set; }

        [Required]
        [DisplayName("Confirma Senha")]
        [DataType(DataType.Password)]
        [Compare("Senha", ErrorMessage="Confirmação de senha não confere com a senha digitada.")]
        public string ConfirmaSenha { get; set; }

        [Required]
        [DisplayName("E-mail")]
        [StringLength(100)]
        [EmailAddress]
        public string Email { get; set; }
    }
}