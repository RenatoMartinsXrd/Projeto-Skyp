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

namespace AppBanco.Views
{
	[XamlCompilation(XamlCompilationOptions.Compile)]
	public partial class ListarMedia : ContentPage
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
        static MediaDAO servicao2 = new MediaDAO();
        static AlunoDAO servicaoalunao = new AlunoDAO();
        public int Id_Turma { get; set; }
        public int Id_Professor { get; set; }
        public int Id_Bimestre { get; set; }
      
        public ListarMedia ()
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


        protected override  void OnAppearing()
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

        private void Picker2_OnSelectedIndexChanged(object sender, EventArgs e)
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

        public async void ConsultarMediaLista()
        {
            List<Media> alun = new List<Media>();
            Media avaliar = new Media()
            {
                Id_Aluno = TelaLoginAluno.Id_AlunoUsuarioAluno,
                Id_Bimestre = Id_BimestreNotas,
                Id_Turma = Id_TurmaNotas,
            };

          



            int a = 0;
            int finality = 0;

            alun = await servicao2.GetMediaBimestre(avaliar);
            int contar = alun.Count();
            if (alun.Count().Equals(0))
            {
                await DisplayAlert($"Turma{Turma} ", "Voce não possui nenhuma média cadastrada", "OK");
                listView.ItemsSource = null;
            }
            else
            {
                int cont = 0;
                string DisciplinaMonstruosa = "";
                List<RetornoUsuarioAluno> retornar = new List<RetornoUsuarioAluno>();
                RetornoUsuarioAluno ru ;
                ProfessorDAO pd = new ProfessorDAO();
                ProfessorCadastro pc = new ProfessorCadastro();
                ProfessorCadastro pc2 = new ProfessorCadastro();
                Frequencia f ;
                Frequencia fre = new Frequencia();
                FrequenciaDAO fd = new FrequenciaDAO();
                RetornoUsuarioAluno [] teste = new RetornoUsuarioAluno[contar];
                double media = 0;
                for (int i = 0; i<contar; i++)
                {
                   
                    finality = alun[i].Id_Professor;
                    pc.Id_Professor = finality;
                   pc2 = await pd.GetDisciplinaAsync(pc);
                    media = alun[i].media;
                 
                    DisciplinaMonstruosa = pc2.Disciplina;
                    f = new Frequencia()
                    {
                        falta = "F",
                        Id_Aluno = TelaLoginAluno.Id_AlunoUsuarioAluno,
                        Id_Bimestre = Id_BimestreNotas,
                        Id_Turma = Id_TurmaNotas,
                        Id_Professor = finality
                    };
                    fre = await fd.GetFrequenciaBimestreAsync(f);
                    int TotalFalta = 0;
                    if (fre.Total_Falta == 0)
                    {
                        TotalFalta = 0;
                    }
                    else
                    {
                        TotalFalta = fre.Total_Falta;
                    }

                    ru = new RetornoUsuarioAluno()
                    {
                        Disciplina = DisciplinaMonstruosa,
                    Media = media,
                    Falta = TotalFalta
                    };

                    retornar.Add(ru);
                }
               
                listView.ItemsSource = retornar;
            }

        }

        public async void Listar(object sender, EventArgs e)
        {

            ConsultarMediaLista();

        }

        private void Button_Clicked(object sender, EventArgs e)
        {
            Navigation.PushAsync(new InserirNotas());
        }
        private async void Button_ClickedVoltar(object sender, EventArgs e)
        {
            await PopupNavigation.Instance.PopAsync();
        }
    }
}