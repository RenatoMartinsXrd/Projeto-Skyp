using System;
using System.Collections.Generic;
using System.Text;

namespace AppBanco.Bean
{
   public class Avaliacao
    {
        
        public int Id_Avaliacao { get; set; }
        public int Id_Professor { get; set; }
		public int Id_Bimestre { get; set; }
        public int Id_Turma { get; set; }
        public string Serie { get; set; }
        public string Titulo { get; set; }
        public string Bimestre { get; set; }
        public string Descricao { get; set; }
        public DateTime Data_Avaliacao { get; set; }
    }
}
