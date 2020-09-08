using AppBanco.Bean;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace AppBanco.Dao
{
    class SecretariaDAO
    {
        HttpClient client = new HttpClient();
        public async Task<bool> GetSecretariaAsync(Bean.Secretaria user, Bean.Secretaria Senha)
        {
            string url = "http://localhost:8085/WebServiceDiarioTom";

            //string json = JsonConvert.SerializeObject(user);

            //converte a string para um conteúdo a ser enviado
            //StringContent conteudo = new StringContent(
            // json, Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.GetAsync(
           url + "/webresources/generic/SelecionarSecretaria/" + user.Login + "," + Senha.Senha);
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
