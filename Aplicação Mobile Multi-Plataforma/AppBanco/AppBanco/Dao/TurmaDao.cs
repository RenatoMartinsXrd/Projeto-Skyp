using AppBanco.Bean;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace AppBanco.Dao
{
    class TurmaDao
    {
        public async Task AddTurmarAsync(Turma turma)
        {
            string url = "http://localhost:8085/WebServiceDiarioTom";
            //converte o objeto para uma string no formato json
            string json = JsonConvert.SerializeObject(turma);
            //converte a string para um conteúdo a ser enviado
            StringContent conteudo = new StringContent(
                json, Encoding.UTF8, "application/json");
            try
            {
                HttpClient client = new HttpClient();
                //envia o conteúdo para a url informada
                HttpResponseMessage response =
                    await client.PostAsync(url + "/webresources/generic/Turma/inserir", conteudo);
                //se foi com sucesso
                if (!response.IsSuccessStatusCode)
                {

                    throw new Exception("Erro ao incluir produto");

                }


            }
            catch (Exception ex)
            {
                //caso ocorra algum erro.
                throw ex;
            }
        }

        HttpClient client = new HttpClient();
        public async Task<List<Turma>> GetTodasTurmasAsync()
        {
            string url = "http://localhost:8085/WebServiceDiarioTom";

            //string json = JsonConvert.SerializeObject(user);

            //converte a string para um conteúdo a ser enviado
            //StringContent conteudo = new StringContent(
            // json, Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.GetAsync(
           url + "/webresources/generic/listarTodasTurmas");
            if (response.IsSuccessStatusCode)
            {
                var respstring = await response.Content.ReadAsStringAsync();
                ProfessorCadastro teste1 = new ProfessorCadastro();

                List<Turma> retorno = JsonConvert.DeserializeObject<List<Turma>>(respstring.ToString());
                return retorno;
            }
            else
            {
                return null;
            }
        }


     
        public async Task<List<Turma>> GetId_TurmaAsync(Turma user)
        {
            string url = "http://localhost:8085/WebServiceDiarioTom";

            //string json = JsonConvert.SerializeObject(user);

            //converte a string para um conteúdo a ser enviado
            //StringContent conteudo = new StringContent(
            // json, Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.GetAsync(
           url + "/webresources/generic/listarId_TurmaSerie/" + user.Serie);
            if (response.IsSuccessStatusCode)
            {
                var respstring = await response.Content.ReadAsStringAsync();

                List<Turma> retorno = JsonConvert.DeserializeObject<List<Turma>>(respstring.ToString());
                return retorno;
            }
            else
            {
                return null;
            }
        }

    }
}
