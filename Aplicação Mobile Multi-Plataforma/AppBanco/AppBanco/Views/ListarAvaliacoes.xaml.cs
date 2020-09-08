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
	public partial class ListarAvaliacoes : ContentPage
	{
        public static List<Turma> urna2 { get; set; }

        public static List<Avaliacao> urna { get; set; }
        public static int Id_TurmaNotas { get; set; }
        public static int Id_AlunoInserir { get; set; }
        public static string NomeAlunoInserir { get; set; }
        public static string RA { get; set; }
        public static string Turma { get; set; }
        public static int Id_BimestreNotas { get; set; }
        public string Serie { get; set; }
        public string bimestre { get; set; }
        public static DateTime Data_Nascimento { get; set; }
        static TurmaDao servicao = new TurmaDao();
        static AvaliacaoDAO servicao2 = new AvaliacaoDAO();
        static AlunoDAO servicaoalunao = new AlunoDAO();
        public int Id_Turma { get; set; }
        public int Id_Professor { get; set; }
        public int Id_Bimestre { get; set; }
      
        public ListarAvaliacoes ()
		{
			InitializeComponent ();
        
        }

        void listViewSelected(object s, SelectedItemChangedEventArgs v)
        {
            if (v.SelectedItem != null)
            {

                BindingContext = v.SelectedItem as Avaliacao;

            }
        }


        protected override async void OnAppearing()
        {

            Combobox();


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

       



        private async void Picker_OnSelectedIndexChanged(object sender, EventArgs e)
        {
            var Seriedobaguio = Picker.Items[Picker.SelectedIndex];
            Turma pc = new Turma();
            pc.Serie = Seriedobaguio;
            Turma = Seriedobaguio;
            List<Turma> t = await servicao.GetId_TurmaAsync(pc);
            int i = 0;
            Id_TurmaNotas = t[i].Id_Turma;
            

        }

        private async void Picker2_OnSelectedIndexChanged(object sender, EventArgs e)
        {
            var Bimestre = Picker2.Items[Picker2.SelectedIndex];
            bimestre = Bimestre;
            switch (bimestre)
            {
                case "1º Bimestre":
                    Id_BimestreNotas = 1;
                    break;
                case "2º Bimestre":
                    Id_BimestreNotas = 2;
                    break;
                case "3º Bimestre":
                    Id_BimestreNotas = 3;
                    break;
                case "4º Bimestre":
                    Id_BimestreNotas = 4;
                    break;
            }

        }

        public async void ConsultarAlunosLista()
        {
            List<Avaliacao> alun = new List<Avaliacao>();
            Avaliacao avaliar = new Avaliacao()
            {
                Id_Professor = TelaLoginProfessor.Id_Professor,
                Id_Bimestre = Id_BimestreNotas,
                Id_Turma = Id_TurmaNotas,
            };

        

            int a = 0;

            urna = await servicao2.GetAvaliacoes(avaliar);
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

        public async void Listar(object sender, EventArgs e)
        {

            ConsultarAlunosLista();

        }

        private void Button_Clicked(object sender, EventArgs e)
        {
            Navigation.PushAsync(new InserirNotas());
        }
    }
}