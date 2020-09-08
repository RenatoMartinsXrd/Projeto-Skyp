using AppBanco;
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
	public partial class CadastroProfessorPage : ContentPage
	{
        public static List<ProfessorCadastro> AtualizarProfessores{ get; set; }
        IncluirTurmasProf incluirTurmasProf = new IncluirTurmasProf();
        public CadastroProfessorPage ()
		{
          
			InitializeComponent ();
         
            
        }

        public static async void Atualizar()
        {
            ProfessorDAO pd = new ProfessorDAO();
            List<ProfessorCadastro> b = new List<ProfessorCadastro>();
          AtualizarProfessores = await pd.GetProfessoresAsync();
            
        }

        async void Salvar(object sender, EventArgs e)
        {


            //recupera o objeto conta da tela
            ProfessorCadastro prof = new ProfessorCadastro()
            {
                Nome = nomeProfessor.Text.Trim(),
                Disciplina = disciplina.Text.Trim(),
                CPF = cpfProfessor.Text.Trim(),
            };
                //chama o service para incluir a conta via API                                      
                ProfessorDAO service = new ProfessorDAO();
           

                //mostra mensagem de erro caso não foi possível incluir
                if (service.AddProfessorAsync(prof) == null)
                {
                    await DisplayAlert("Erro", "Ocorreu um erro ao incluir a Conta", "Ok");
                }
                else
                {
                string mensagem = "Professor cadastrado com sucesso";
                await PopupNavigation.Instance.PushAsync(new PopPupSucesso());
                Atualizar();
            }
            
        }
         

         
        }
    }
