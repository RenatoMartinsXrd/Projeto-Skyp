using System;
using System.Collections.Generic;
using System.Text;

namespace AppBanco.Bean
{
    class Nota
    {
        public int Id_Aluno { get; set; }
        public int Id_Turma { get; set; }
        public int Id_Professor { get; set; }


        public int Id_Avaliacao { get; set; }
        public int Id_Bimestre { get; set; }
        public double nota { get; set; }

    }
}
