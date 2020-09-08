using AppBanco.Bean;
using AppBanco.TabbedMenusResponsivo;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace AppBanco.Dao
{
    public class AlunoDAO
    {
        public async Task AddAlunosrAsync(AlunoBean a)
        {
            string url = "";
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
                    await client.PostAsync(url + "/webresources/generic/Aluno/inserir", conteudo);
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



        public async Task<List<AlunoBean>> GetTodosAlunosId_TurmaAsync(AlunoBean user)
        {
            HttpClient client = new HttpClient();
            string url = "http://localhost:8085/WebServiceDiarioTom";

            //string json = JsonConvert.SerializeObject(user);

            //converte a string para um conteúdo a ser enviado
            //StringContent conteudo = new StringContent(
            // json, Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.GetAsync(
           url + "/webresources/generic/listarAlunos/" + user.Id_Turma);
            if (response.IsSuccessStatusCode)
            {
                var respstring = await response.Content.ReadAsStringAsync();

                List<AlunoBean> retorno = JsonConvert.DeserializeObject<List<AlunoBean>>(respstring.ToString());
                return retorno;
            }
            else
            {
                return null;
            }
        }


        public async Task<bool> DeleteAlunoAsync(AlunoBean user)
        {
            HttpClient client = new HttpClient();
            string url = "http://localhost:8085/WebServiceDiarioTom";

            //string json = JsonConvert.SerializeObject(user);

            //converte a string para um conteúdo a ser enviado
            //StringContent conteudo = new StringContent(
            // json, Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.GetAsync(
           url + "/webresources/generic/DeletarAluno/" + user.Id_Aluno);
            if (response.IsSuccessStatusCode)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public async Task<List<AlunoBean>> GetAutenticarId_Açuno(AlunoBean user)
        {
            HttpClient client = new HttpClient();
            string url = "http://localhost:8085/WebServiceDiarioTom";

            //string json = JsonConvert.SerializeObject(user);

            //converte a string para um conteúdo a ser enviado
            //StringContent conteudo = new StringContent(
            // json, Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.GetAsync(
           url + "/webresources/generic/SelecionarId_Alunos/" + user.Id_Turma + "," + user.Nome);
            if (response.IsSuccessStatusCode)
            {
                var respstring = await response.Content.ReadAsStringAsync();

                List<AlunoBean> retorno = JsonConvert.DeserializeObject<List<AlunoBean>>(respstring.ToString());
                return retorno;
            }
            else
            {
                return null;
            }
        }

        public async Task<AlunoBean> GetRAalunosAsync(AlunoBean user)
        {
            HttpClient client = new HttpClient();
            string url = "http://localhost:8085/WebServiceDiarioTom";

            //string json = JsonConvert.SerializeObject(user);

            //converte a string para um conteúdo a ser enviado
            //StringContent conteudo = new StringContent(
            // json, Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.GetAsync(
           url + "/webresources/generic/SelecionarAlunoRa/" + user.RA);
            if (response.IsSuccessStatusCode)
            {
                var respstring = await response.Content.ReadAsStringAsync();

                AlunoBean retorno = JsonConvert.DeserializeObject<AlunoBean>(respstring.ToString());
                return retorno;
            }
            else
            {
                return null;
            }
        }
    }
}
