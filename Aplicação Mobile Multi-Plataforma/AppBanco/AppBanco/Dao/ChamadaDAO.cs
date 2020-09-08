using AppBanco.Bean;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace AppBanco.Dao
{
    public class ChamadaDAO
    {

        public async Task AddChamadaAsync(Chamada ch)
        {
            string url = "http://localhost:8085/WebServiceDiarioTom";
            //converte o objeto para uma string no formato json
            string json = JsonConvert.SerializeObject(ch);
            //converte a string para um conteúdo a ser enviado
            StringContent conteudo = new StringContent(
                json, Encoding.UTF8, "application/json");
            try
            {
                HttpClient client = new HttpClient();
                //envia o conteúdo para a url informada
                HttpResponseMessage response =
                    await client.PostAsync(url + "/webresources/generic/Chamada/inserir", conteudo);
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



        public async Task<List<Chamada>> GetChamada_TurmaAsync(Chamada user)
        {
            HttpClient client = new HttpClient();
            string url = "http://localhost:8085/WebServiceDiarioTom";

            //string json = JsonConvert.SerializeObject(user);

            //converte a string para um conteúdo a ser enviado
            //StringContent conteudo = new StringContent(
            // json, Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.GetAsync(
           url + "/webresources/generic/listarChamadaId_Turma/" + user.Id_Turma);
            if (response.IsSuccessStatusCode)
            {
                var respstring = await response.Content.ReadAsStringAsync();

                List<Chamada> retorno = JsonConvert.DeserializeObject<List<Chamada>>(respstring.ToString());
                return retorno;
            }
            else
            {
                return null;
            }
        }


        public async Task<bool> DeleteAlunoAsync(Chamada user)
        {
            HttpClient client = new HttpClient();
            string url = "http://localhost:8085/WebServiceDiarioTom";

            //string json = JsonConvert.SerializeObject(user);

            //converte a string para um conteúdo a ser enviado
            //StringContent conteudo = new StringContent(
            // json, Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.GetAsync(
           url + "/webresources/generic/DeletarChamada/" + user.Id_Turma);
            if (response.IsSuccessStatusCode)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

      
            HttpClient client = new HttpClient();
            public async Task<bool> GetAutenticarChamadaAsync(Chamada user)
            {
                string url = "http://localhost:8085/WebServiceDiarioTom";

                //string json = JsonConvert.SerializeObject(user);

                //converte a string para um conteúdo a ser enviado
                //StringContent conteudo = new StringContent(
                // json, Encoding.UTF8, "application/json");
                HttpResponseMessage response = await client.GetAsync(
               url + "/webresources/generic/AutenticarChamada/" + user.Nome + "," + user.Numero_Chamada);
                if (response.IsSuccessStatusCode)
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
}
