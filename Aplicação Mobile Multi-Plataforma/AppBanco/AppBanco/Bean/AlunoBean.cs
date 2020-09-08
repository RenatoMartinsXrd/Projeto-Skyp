using System;
using System.Collections.Generic;
using System.Text;

namespace AppBanco.Bean
{
   public class AlunoBean
    {
        public int Id_Aluno { get; set; }

        public int Id_Turma { get; set; }
        public string RA { get; set; }
        public string Nome { get; set; }
        public DateTime Data_Nascimento { get; set; }
    }
}
