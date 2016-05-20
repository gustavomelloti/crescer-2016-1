using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace LojaNinja.MVC.Models.Login
{
    public class LoginViewModel
    {
        [Required]
        [DisplayName("E-mail")]
        [Display(Prompt = "numbers only")]
        [StringLength(100)]
        [EmailAddress]
        public string Email { get; set; }

        [Required]
        [Display(Prompt = "numbers only")]
        [DisplayName("Senha")]
        [StringLength(100)]
        public string Senha { get; set; }
    }
}