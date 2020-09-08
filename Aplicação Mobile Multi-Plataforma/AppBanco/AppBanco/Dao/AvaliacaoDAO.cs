using AppBanco.Bean;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace AppBanco.Dao
{
   public class AvaliacaoDAO
    {

        public async Task AddAvaliacaoAsync(Avaliacao a)
        {
            string url = "http://localhost:8085/WebServiceDiarioTom";
            //converte o objeto para uma string no formato json
            string json = JsonConvert.SerializeObject(a);
            //converte a string para um conteúdo a ser enviado
            StringContent conteudo = new StringContent(
                json, Encoding.UTF8, "application/json");
            try
            {
                HttpClient client = new HttpClient();
                //envia o conteúdo para a url informada
                HttpResponseMessage response =
                    await client.PostAsync(url + "/webresources/generic/Avaliacao/inserir", conteudo);
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



        public async Task<List<Avaliacao>> GetAvaliacoes(Avaliacao user)
        {
            HttpClient client = new HttpClient();
            string url = "http://localhost:8085/WebServiceDiarioTom";

            //string json = JsonConvert.SerializeObject(user);

            //converte a string para um conteúdo a ser enviado
            //StringContent conteudo = new StringContent(
            // json, Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.GetAsync(
           url + "/webresources/generic/SelecionarAvaliacao/" + user.Id_Professor+"," + user.Id_Bimestre +","+ user.Id_Turma);
            if (response.IsSuccessStatusCode)
            {
                var respstring = await response.Content.ReadAsStringAsync();

                List<Avaliacao> retorno = JsonConvert.DeserializeObject<List<Avaliacao>>(respstring.ToString());
                return retorno;
            }
            else
            {
                return null;
            }
        }
    }
}
