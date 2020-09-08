using AppBanco.Bean;
using System;
using System.Text;
using Newtonsoft.Json;
using System.Net.Http;
using System.Threading.Tasks;
namespace AppBanco.Dao
{
    public class UsuarioAlunoDAO
    {
        HttpClient client = new HttpClient();
        public async Task AddUsuarioAlunoAsync(UsuarioAluno a)
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
                    await client.PostAsync(url + "/webresources/generic/UsuarioAluno/inserir", conteudo);
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

        public async Task<UsuarioAluno> GetId_UsuarioAlunoAsync(UsuarioAluno user)
        {
            string url = "http://localhost:8085/WebServiceDiarioTom";

            //string json = JsonConvert.SerializeObject(user);

            //converte a string para um conteúdo a ser enviado
            //StringContent conteudo = new StringContent(
            // json, Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.GetAsync(
           url + "/webresources/generic/SelecionarLoginAluno/" + user.Login + "," + user.Senha);
            if (response.IsSuccessStatusCode)
            {
                var respstring = await response.Content.ReadAsStringAsync();

                UsuarioAluno retorno = JsonConvert.DeserializeObject<UsuarioAluno>(respstring.ToString());
                return retorno;
            }
            else
            {
                return null;
            }
        }
    }
}
