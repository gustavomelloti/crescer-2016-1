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
        [Required(ErrorMessage = "O campo nome é obrigatório")]
        [DisplayName("Nome")]
        [StringLength(120)]
        public string Nome { get; set; }

        [Required(ErrorMessage = "O campo senha é obrigatório")]
        [DisplayName("Senha")]
        [RegularExpression(@"^(?=.*\d)(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$", ErrorMessage = "A senha informada deve possuir: tamanho mínimo de 8 caracteres, contendo número, letra minúscula e maiúscula.")]
        [DataType(DataType.Password)]
        [StringLength(100)]
        public string Senha { get; set; }

        [Required(ErrorMessage = "O campo confirma senha é obrigatório")]
        [DisplayName("Confirma Senha")]
        [DataType(DataType.Password)]
        [Compare("Senha", ErrorMessage="Confirmação de senha não confere com a senha digitada.")]
        public string ConfirmaSenha { get; set; }

        [Required(ErrorMessage = "O campo e-mail é obrigatório")]
        [DisplayName("E-mail")]
        [StringLength(100)]
        [EmailAddress]
        public string Email { get; set; }
    }
}