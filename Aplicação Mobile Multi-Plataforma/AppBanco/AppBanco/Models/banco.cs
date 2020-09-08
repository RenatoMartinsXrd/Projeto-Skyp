using AppBanco.Models;
using AppBanco.Repository;
using SQLite;
using System;
using System.Collections.Generic;
using System.Text;

namespace AppBanco
{
   public class banco
    {
       private SQLiteAsyncConnection database { get; set; }
        public TarefaRepository Tarefas { get; set; }
        public banco(string LocalBancoDeDados)
        {
            database=new SQLiteAsyncConnection(LocalBancoDeDados);
            database.CreateTableAsync<TarefaModel>().Wait();
            Tarefas = new TarefaRepository(database);
        }
    }
}
