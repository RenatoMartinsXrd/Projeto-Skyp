using AppBanco.Bean;
using AppBanco.Dao;
using Rg.Plugins.Popup.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace AppBanco.PopUpBonitao
{
	[XamlCompilation(XamlCompilationOptions.Compile)]
	public partial class PopupInserirAlunos 
	{
        AlunoDAO servicaoalunao = new AlunoDAO();
        AlunoBean alun = new AlunoBean();
        InserirAlunos i = new InserirAlunos();
        public PopupInserirAlunos ()
		{
			InitializeComponent ();
            
       
        }

        protected override async void OnAppearing()
        {
            alun = i.Pegaralunos();
            BindingContext = alun as AlunoBean;
            base.OnAppearing();
            i.ConsultarAlunosLista();
        }



        private async void Button_ClickedVoltar(object sender, EventArgs e)
        {
            await PopupNavigation.Instance.PopAsync();
        }

        public async void Button_ClickedDeletar(object sender, EventArgs e)
        {
            var actionDeletar = await DisplayAlert("Deletar", "Voce escolheu Deletar seu maldito se tem certeza ", "Ok", "Cancelar");
         

          

           
                InserirAlunos i = new InserirAlunos();
              


            if (actionDeletar == true)
            {
                await servicaoalunao.DeleteAlunoAsync(alun);
                i.DeletarAlunoss();
                i.ConsultarAlunosLista();

               
               

            }
            await PopupNavigation.Instance.PopAsync();
        }
    }
}