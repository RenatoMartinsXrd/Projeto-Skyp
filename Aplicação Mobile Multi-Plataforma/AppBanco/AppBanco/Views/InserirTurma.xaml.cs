 using AppBanco.Bean;
using AppBanco.Dao;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AppBanco.PopUpBonitao;
using Rg.Plugins.Popup.Services;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace Skyp
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class InserirTurma : ContentPage
    {
        public string periodoo { get; set; }
        public InserirTurma()
        {
            InitializeComponent();
            Combobox();
  
        }

        List<string> yurmas = new List<string>
        {
"Manhã","Tarde","Noite"
        };
    
    
        String teste;

        public async void Combobox()
        {

            int i = 0;
        for(int a = 0; a < 3; a++)
            {
                Picker.Items.Add(yurmas[a].ToString());
            }

                



            }

        


        private void Picker_OnSelectedIndexChanged(object sender, EventArgs e)
        {
            var Seriedobaguio = Picker.Items[Picker.SelectedIndex];
        
           periodoo = Seriedobaguio;
           

        }
        public async void btnSalvar(object sender, EventArgs e)
        {
            Turma t = new Turma()
            {
                Serie = serie.Text.Trim(),
                Ano = ano.Text.Trim(),
                Periodo = periodoo.ToString(),
              
            };
            //chama o service para incluir a conta via API
            TurmaDao service = new TurmaDao();


            //mostra mensagem de erro caso não foi possível incluir
            if (service.AddTurmarAsync(t) == null)
            {
                await DisplayAlert("Erro", "Ocorreu um erro ao incluir a Conta", "Ok");
            }
            else
            {
                string mensagem = "Professor cadastrado com sucesso";
                  await PopupNavigation.Instance.PushAsync(new PopPupSucesso());
            }
        }
    }
}