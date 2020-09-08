using AppBanco.Bean;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace AppBanco.Dao
{
    public class MediaDAO
    {

        public async Task<List<Media>> GetMediaBimestre(Media user)
        {
            HttpClient client = new HttpClient();
            string url = "http://localhost:8085/WebServiceDiarioTom";

            //string json = JsonConvert.SerializeObject(user);

            //converte a string para um conteúdo a ser enviado
            //StringContent conteudo = new StringContent(
            // json, Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.GetAsync(
           url + "/webresources/generic/SelecionarMediaBimestre/" + user.Id_Turma + "," + user.Id_Aluno + "," + user.Id_Bimestre);
            if (response.IsSuccessStatusCode)
            {
                var respstring = await response.Content.ReadAsStringAsync();

                List<Media> retorno = JsonConvert.DeserializeObject<List<Media>>(respstring.ToString());
                return retorno;
            }
            else
            {
                return null;
            }
        }
    }
}
