using System;
using System.Collections.Generic;
using System.Text;

namespace AppBanco.Dao
{
    public class Chamada
    {
        
        public int Numero_Chamada { get; set; }
        public  String Nome { get; set; }
        public int Id_Turma { get; set; }
        public int Id_Aluno { get; set; }
    }
}
