using AppBanco.Bean;
using AppBanco.Dao;
using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace AppBanco.Views
{
	[XamlCompilation(XamlCompilationOptions.Compile)]
	public partial class ConsultarAvaliacaoes : ContentPage
	{
        public static List<Avaliacao> urna { get; set; }
        public int Id_Turma { get; set; }
        public int Id_Professor { get; set; }
        public int Id_Bimestre { get; set; }
    
        public ConsultarAvaliacaoes ()
		{

            Id_Professor = 112;
            Id_Bimestre = 1;
            Id_Turma = 9;
            InitializeComponent ();
         
           
           
         


        }

        protected override async void OnAppearing()
        {
            AvaliacaoDAO servicao = new AvaliacaoDAO();
            Avaliacao a = new Avaliacao();
            a.Id_Professor = Id_Professor;
            a.Id_Bimestre = Id_Bimestre;
            a.Id_Turma = Id_Turma;
            urna = await servicao.GetAvaliacoes(a);
            listView.ItemsSource = urna;

        }

        public async Task<List<Avaliacao>> Atualizar()
        {
            AvaliacaoDAO servicao = new AvaliacaoDAO();
            Avaliacao a = new Avaliacao();
            a.Id_Professor = Id_Professor;
            a.Id_Bimestre = Id_Bimestre;
            a.Id_Turma = Id_Turma;
             urna = await servicao.GetAvaliacoes(a);
            listView.ItemsSource = urna;
            return urna;
        }

        void listViewSelected(object s, SelectedItemChangedEventArgs v)
        {
            if (v.SelectedItem != null)
            {

                BindingContext = v.SelectedItem as Avaliacao;

            }
        }
    }
}