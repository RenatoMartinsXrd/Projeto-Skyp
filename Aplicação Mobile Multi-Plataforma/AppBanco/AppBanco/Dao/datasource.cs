using AppBanco.Bean;
using AppBanco.dao;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace AppBanco.Dao
{
    public class datasource
    {
       
        HttpClient client = new HttpClient();
        public async Task<RetornoUsuario> GetProdutosAsync(dao.Usuario user)
        {
            string url = "http://localhost:8085/WebServiceDiarioTom";
         
                //string json = JsonConvert.SerializeObject(user);

                //converte a string para um conteúdo a ser enviado
                //StringContent conteudo = new StringContent(
                   // json, Encoding.UTF8, "application/json");
                HttpResponseMessage response = await client.GetAsync(
               url + "/webresources/generic/SelecionarLoginObjeto/" + user.Login+ "," +user.Senha);
                if (response.IsSuccessStatusCode)
                {
                   var respstring = await response.Content.ReadAsStringAsync();

                RetornoUsuario retorno = JsonConvert.DeserializeObject<RetornoUsuario>(respstring.ToString());
                    return retorno;
                }
                else
                {
                    return null;
                }
            }
        public async Task AddChamadaAsync(Usuario ch)
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
                    await client.PostAsync(url + "/webresources/generic/Usuario/inserir", conteudo);
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



    }
    }

