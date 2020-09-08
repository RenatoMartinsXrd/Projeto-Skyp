using AppBanco.Models;
using AppBanco.Views;
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
	public partial class PopPupLembretes 
	{
		public PopPupLembretes ()
		{
			InitializeComponent();
		}

        private async void Button_Clicked(object sender, EventArgs e)
        {
           
            await Navigation.PushAsync(new pageView
            {
                BindingContext = new TarefaModel()
            });
             await PopupNavigation.Instance.PopAsync();
        }

        private async void Button_Clicked_1(object sender, EventArgs e)
        {
            //busca a tarefa na tela
           
            TarefaModel tarefa = (TarefaModel)BindingContext;

            //salva no banco

           
            await App.Bancos().Tarefas.Excluir(tarefa);
          
          
         

            ListPage p = new ListPage();
            await PopupNavigation.Instance.PopAsync();

            new NavigationPage(new pageView());





        }
    }
}