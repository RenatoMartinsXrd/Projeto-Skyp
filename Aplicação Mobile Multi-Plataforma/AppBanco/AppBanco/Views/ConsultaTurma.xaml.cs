using AppBanco.Bean;
using AppBanco.Dao;
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
	public partial class ConsultaTurma : ContentPage
	{
        public static List<Turma> urna { get; set; }
        TurmaDao servicao = new TurmaDao();

        public ConsultaTurma ()
		{
			InitializeComponent ();
          
        }

   

        protected override async void OnAppearing()
        {
            urna = await servicao.GetTodasTurmasAsync();
            listView.ItemsSource = urna;

        }

        void listViewSelected(object s, SelectedItemChangedEventArgs v)
        {
            if (v.SelectedItem != null)
            {

                BindingContext = v.SelectedItem as Turma;

            }
        }
    }
}