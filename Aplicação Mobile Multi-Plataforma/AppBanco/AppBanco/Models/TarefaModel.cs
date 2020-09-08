using SQLite;
using System;
using System.Collections.Generic;
using System.Text;

namespace AppBanco.Models
{
   public class TarefaModel
    {

        [PrimaryKey,AutoIncrement]

        public int  Id{ get; set; }

        public string Nome { get; set; }

        public string Observacoes { get; set; }

        public string Descricao { get; set; }

        public bool Finalizado { get; set; }


}
}
