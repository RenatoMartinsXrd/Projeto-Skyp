using AppBanco.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace AppBanco.Views
{
	[XamlCompilation(XamlCompilationOptions.Compile)]
	public partial class ListPage : ContentPage
	{
		public ListPage ()
		{
			InitializeComponent ();
		}
        protected override async void OnAppearing()
        {
            listView.ItemsSource = await App.Bancos().Tarefas.Listar();
        }
        async void btNovo(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new pageView
            {
                BindingContext = new TarefaModel()
            });
        }
            async void listViewSelected(object s, SelectedItemChangedEventArgs v)
            {
                if (v.SelectedItem != null)
                {
                    await Navigation.PushAsync(new pageView
                    {
                        BindingContext = v.SelectedItem as TarefaModel
                    });
                }
            }
        }
    }

