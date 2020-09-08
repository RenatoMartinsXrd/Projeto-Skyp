using AppBanco.Bean;
using AppBanco.Dao;
using AppBanco.PopUpBonitao;
using Rg.Plugins.Popup.Services;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AppBanco.PopUpBonitao;
using Rg.Plugins.Popup.Services;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace AppBanco
{
	[XamlCompilation(XamlCompilationOptions.Compile)]
	public partial class InserirAlunos : ContentPage 
	{
        public static List<Turma> urna2 { get; set; }

        public static List<AlunoBean> urna { get; set; }
        public static int Id_TurmaAluno { get; set; }
        public static int Id_AlunoInserir{ get; set; }
        public static string NomeAlunoInserir { get; set; }
        public static string RA { get; set; }
        public static string Turma { get; set; }
        public static DateTime Data_Nascimento{ get; set; }
        static TurmaDao servicao = new TurmaDao();
        static AlunoDAO servicaoalunao = new AlunoDAO();
        
        public InserirAlunos ()
		{
			InitializeComponent ();
          
		}


        protected override async void OnAppearing()
        {
     
            Combobox();
        

        }

        void listViewSelected(object s, SelectedItemChangedEventArgs v)
        {
            if (v.SelectedItem != null)
            {

                BindingContext = v.SelectedItem as AlunoBean;

            }
        }

        public static async void listView_ItemTapped(object sender, ItemTappedEventArgs e)
        {
            var Aluno = e.Item as AlunoBean;
            AlunoBean alun = new AlunoBean();
            alun.Id_Aluno = Aluno.Id_Aluno;
            Id_AlunoInserir = Aluno.Id_Aluno;
            NomeAlunoInserir = Aluno.Nome;
            RA = Aluno.RA;
            Data_Nascimento = Aluno.Data_Nascimento;

            await PopupNavigation.Instance.PushAsync(new PopupInserirAlunos());

           

            /*
            var action = await DisplayActionSheet($"Aluno {Aluno.Nome}", "Deletar", "Voltar para a lista",  $" Informações de {Aluno.Nome} \n \n RA:{Aluno.RA}\n Data de Nascimento: {String.Format(Aluno.Data_Nascimento.ToString("dd/MM/yyyy"))}");
      
            switch (action)
            {
                case "Voltar para a lista":
                    await DisplayAlert("Ok", "Voce escolheu voltar para a lista seu viado", "Ok");
                    break;
                case "Deletar":
                    var actionDeletar = await DisplayAlert("Deletar", "Voce escolheu Deletar seu maldito se tem certeza ", "Ok","Cancelar");
                    AlunoBean alun = new AlunoBean();
                    alun.Id_Aluno = Aluno.Id_Aluno;
                  
                  if(actionDeletar == true)
                    {
                        await servicaoalunao.DeleteAlunoAsync(alun);
                        ConsultarAlunosLista();
                    }
                
                    break;
            }
            */

        }

        public AlunoBean Pegaralunos()
        {
            AlunoBean t = new AlunoBean();
            t.Nome = NomeAlunoInserir;
            t.RA = RA;
            t.Data_Nascimento = Data_Nascimento;
            return t;
        }

        public async void DeletarAlunoss()
        {
            
            AlunoBean alun = new AlunoBean();
            alun.Id_Aluno = Id_AlunoInserir;


           
                await servicaoalunao.DeleteAlunoAsync(alun);
                ConsultarAlunosLista();
            
        
            



        }


        public async void Combobox()
        {
       
           
            urna2 = await servicao.GetTodasTurmasAsync();
            int z = urna2.Count();
            for (int i = 0; i < z; i++)
            {
                string t = urna2[i].Serie.ToString();

                Picker.Items.Add(t);



            }

        }

        public async void ConsultarAlunosLista()
        {
            List<AlunoBean> alun = new List<AlunoBean>();
            AlunoBean alunoo = new AlunoBean()
            {
                Id_Turma = Id_TurmaAluno,

            };

            int a = 0;

            urna = await servicaoalunao.GetTodosAlunosId_TurmaAsync(alunoo);
            if (urna.Count().Equals(0))
            {
                await DisplayAlert($"Turma{Turma} ", "Essa turma não possui nenhum aluno cadastrado!", "OK");
                listView.ItemsSource = null;
            }
            else
            {
                listView.ItemsSource = urna;
            }
          
        }



        private async void Picker_OnSelectedIndexChanged(object sender, EventArgs e)
        {
            var Seriedobaguio = Picker.Items[Picker.SelectedIndex];
           Turma pc = new Turma();
            pc.Serie = Seriedobaguio;
            Turma = Seriedobaguio;
           List<Turma> t = await servicao.GetId_TurmaAsync(pc);
            int i = 0;
            Id_TurmaAluno = t[i].Id_Turma; 

        }



       

        public async void Salvar(object sender, EventArgs e)
        {
         
        
            AlunoDAO service = new AlunoDAO();

            AlunoBean aluno2 = new AlunoBean()

            {
                Id_Turma = Id_TurmaAluno,
                Nome = nomeAluno.Text.Trim(),
                RA = raAluno.Text.Trim(),
                Data_Nascimento = dataAluno.Date,
            };
            //chama o service para incluir a conta via API
         


            //mostra mensagem de erro caso não foi possível incluir
            if (service.AddAlunosrAsync(aluno2) == null)
            {
                await DisplayAlert("Erro", "Ocorreu um erro ao incluir a Conta", "Ok");
            }
            else
            {
                string mensagem = "Aluno cadastrado com sucesso";
                

   await PopupNavigation.Instance.PushAsync(new PopPupSucesso());
                ConsultarAlunosLista();
            }
        }

        public async void Consultar(object sender, EventArgs e)
        {
            ConsultarAlunosLista();
           

        }

      
    }
}