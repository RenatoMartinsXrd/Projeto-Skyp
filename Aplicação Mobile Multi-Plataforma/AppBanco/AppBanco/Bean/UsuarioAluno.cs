using System;
using System.Collections.Generic;
using System.Text;

namespace AppBanco.Bean
{
    public class UsuarioAluno
    {
       
        public int Id_UsuarioAluno { get; set; }
        public int Id_Aluno { get; set; }
        public string Login { get; set; }
        public string Senha { get; set; }
    }
}
