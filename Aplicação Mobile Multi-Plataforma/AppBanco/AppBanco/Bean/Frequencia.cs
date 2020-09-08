using System;
using System.Collections.Generic;
using System.Text;

namespace AppBanco.Bean
{
    class Frequencia
    {
        public int Id_Aluno { get; set; }
        public int Id_Turma { get; set; }
        public int Id_Professor { get; set; }


        public int Total_Falta { get; set; }
        public int Id_Bimestre { get; set; }
        public string falta { get; set; }
    }
}
