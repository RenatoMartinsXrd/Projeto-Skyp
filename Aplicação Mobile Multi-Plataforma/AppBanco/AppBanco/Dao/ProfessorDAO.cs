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
    public class ProfessorDAO
    {
        public async  Task AddProfessorAsync(ProfessorCadastro profcadastro)
        {
            string url = "http://localhost:8085/WebServiceDiarioTom";
            //converte o objeto para uma string no formato json
            string json = JsonConvert.SerializeObject(profcadastro);
            //converte a string para um conteúdo a ser enviado
            StringContent conteudo = new StringContent(
                json, Encoding.UTF8, "application/json");
            try
            {
                HttpClient client = new HttpClient();
                //envia o conteúdo para a url informada
                HttpResponseMessage response =
                    await client.PostAsync(url + "/webresources/generic/ProfessorCadastro/inserir", conteudo);
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


        public async Task AddProfessorUsuarioAsync(RetornoUsuario profcadastro)
        {
            string url = "http://localhost:8085/WebServiceDiarioTom";
            //converte o objeto para uma string no formato json
            string json = JsonConvert.SerializeObject(profcadastro);
            //converte a string para um conteúdo a ser enviado
            StringContent conteudo = new StringContent(
                json, Encoding.UTF8, "application/json");
            try
            {
                HttpClient client = new HttpClient();
                //envia o conteúdo para a url informada
                HttpResponseMessage response =
                    await client.PostAsync(url + "/webresources/generic/ProfessorUsuario/inserir", conteudo);
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
        public async Task<List<ProfessorCadastro>> GetProfessoresAsync()
        {
            string url = "http://localhost:8085/WebServiceDiarioTom";

            //string json = JsonConvert.SerializeObject(user);

            //converte a string para um conteúdo a ser enviado
            //StringContent conteudo = new StringContent(
            // json, Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.GetAsync(
           url + "/webresources/generic/listarTododProfessores");
            if (response.IsSuccessStatusCode)
            {
                var respstring = await response.Content.ReadAsStringAsync();
                ProfessorCadastro teste1 = new ProfessorCadastro();
             
                List<ProfessorCadastro> retorno = JsonConvert.DeserializeObject<List<ProfessorCadastro>>(respstring.ToString());
                return retorno;
            }
            else
            {
                return null;
            }
        }


    
        public async Task<ProfessorCadastro> GetId_ProfessorAsync(ProfessorCadastro user)
        {
            string url = "http://localhost:8085/WebServiceDiarioTom";

            //string json = JsonConvert.SerializeObject(user);

            //converte a string para um conteúdo a ser enviado
            //StringContent conteudo = new StringContent(
            // json, Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.GetAsync(
           url + "/webresources/generic/listarId_Professor/" + user.Nome);
            if (response.IsSuccessStatusCode)
            {
                var respstring = await response.Content.ReadAsStringAsync();

                ProfessorCadastro retorno = JsonConvert.DeserializeObject<ProfessorCadastro>(respstring.ToString());
                return retorno;
            }
            else
            {
                return null;
            }
        }


        public async Task<List<ProfessorCadastro>> GetCpfCadstro(ProfessorCadastro user)
        {
            string url = "http://localhost:8085/WebServiceDiarioTom";

            //string json = JsonConvert.SerializeObject(user);

            //converte a string para um conteúdo a ser enviado
            //StringContent conteudo = new StringContent(
            // json, Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.GetAsync(
           url + "/webresources/generic/listarCpfCadastro/" + user.CPF);
            if (response.IsSuccessStatusCode)
            {
                var respstring = await response.Content.ReadAsStringAsync();

                List<ProfessorCadastro> retorno = JsonConvert.DeserializeObject<List<ProfessorCadastro>>(respstring.ToString());
                return retorno;
            }
            else
            {
                return null;
            }
        }


        public async Task<bool> GetAutenticarCpfAsync(ProfessorCadastro user)
        {
            string url = "http://localhost:8085/WebServiceDiarioTom";

            //string json = JsonConvert.SerializeObject(user);

            //converte a string para um conteúdo a ser enviado
            //StringContent conteudo = new StringContent(
            // json, Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.GetAsync(
           url + "/webresources/generic/SelecionarCpfs/" + user.CPF);
            if (response.IsSuccessStatusCode)
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        public async Task<ProfessorCadastro> GetDisciplinaAsync(ProfessorCadastro user)
        {
            string url = "http://localhost:8085/WebServiceDiarioTom";

            //string json = JsonConvert.SerializeObject(user);

            //converte a string para um conteúdo a ser enviado
            //StringContent conteudo = new StringContent(
            // json, Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.GetAsync(
           url + "/webresources/generic/listarDisciplina/" + user.Id_Professor);
            if (response.IsSuccessStatusCode)
            {
                var respstring = await response.Content.ReadAsStringAsync();

                ProfessorCadastro retorno = JsonConvert.DeserializeObject<ProfessorCadastro>(respstring.ToString());
                return retorno;
            }
            else
            {
                return null;
            }
        }
    }
}


