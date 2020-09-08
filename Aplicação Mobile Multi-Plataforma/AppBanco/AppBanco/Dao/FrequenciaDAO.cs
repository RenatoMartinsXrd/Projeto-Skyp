using System;
using System.Threading.Tasks;
using Newtonsoft.Json;
using System.Net.Http;
using AppBanco.Bean;

namespace AppBanco.Dao
{
    class FrequenciaDAO
    {
        HttpClient client = new HttpClient();
        public async Task<Frequencia> GetFrequenciaBimestreAsync(Frequencia user)
        {
            string url = "http://localhost:8085/WebServiceDiarioTom";

            //string json = JsonConvert.SerializeObject(user);

            //converte a string para um conteúdo a ser enviado
            //StringContent conteudo = new StringContent(
            // json, Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.GetAsync(
           url + "/webresources/generic/SelecionarFrequenciaBimestre/" + user.falta + "," + user.Id_Professor + "," + user.Id_Aluno + "," + user.Id_Turma + "," + user.Id_Bimestre);
            if (response.IsSuccessStatusCode)
            {
                var respstring = await response.Content.ReadAsStringAsync();

                Frequencia retorno = JsonConvert.DeserializeObject<Frequencia>(respstring.ToString());
                return retorno;
            }
            else
            {
                return null;
            }
        }
    }
}
