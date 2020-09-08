using AppBanco.Models;
using SQLite;
using System;
using System.Collections.Generic;
using System.Text;
using System.Threading.Tasks;

namespace AppBanco.Repository
{
   public class TarefaRepository
    {
        private SQLiteAsyncConnection database;

public TarefaRepository(SQLiteAsyncConnection pDatabase)
        {
            database = pDatabase;
        }
public Task <List<TarefaModel>> Listar()
        {
            return database.Table<TarefaModel>().ToListAsync();
        }
public Task<TarefaModel> Consultar(int id)
        {
            return database.Table<TarefaModel>().Where(i=> i.Id == id).FirstOrDefaultAsync();
        }
public Task<int> Salvar(TarefaModel item){
            if (item.Id ==0)
            {
                return database.InsertAsync(item);
            }
            else
            {
                return database.UpdateAsync(item);
            }
                }
public Task<int> Excluir(TarefaModel item)
        {
            return database.DeleteAsync(item);
        }
    }
}

