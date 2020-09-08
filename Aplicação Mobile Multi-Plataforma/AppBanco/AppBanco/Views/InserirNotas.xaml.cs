using AppBanco.Bean;
using AppBanco.Dao;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;
using AppBanco.PopUpBonitao;
using Rg.Plugins.Popup.Services;
namespace AppBanco.Views
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class InserirNotas : ContentPage
    {
        public static List<AlunoBean> urna2 { get; set; }

        public static List<Chamada> urna { get; set; }
        public static int Id_TurmaAluno { get; set; }
        public static int Id_AlunoInserir { get; set; }
        public static string NomeAlunoInserir { get; set; }
        public static string RA { get; set; }
        public static string Turma { get; set; }
        public static double Nota { get; set; }
        public static DateTime Data_Nascimento { get; set; }
        static ChamadaDAO servicao = new ChamadaDAO();
        static TurmaDao servicaoTurma = new TurmaDao();
        static AlunoDAO servicaoalunao = new AlunoDAO();

        public static Chamada cac { get; set; }
        public static List<ClasseAlunoChamada> alunochamda { get; set; }



        public InserirNotas()
        {
            InitializeComponent();
            ConsultarAlunosLista();
            Id_TurmaAluno = ListarAvaliacoes.Id_TurmaNotas;
        }
        protected override async void OnAppearing()
        {

            ConsultarAlunosLista();

        }

        /*
        void listViewSelected(object s, SelectedItemChangedEventArgs v)
        {
            if (v.SelectedItem != null)
            {

                BindingContext = v.SelectedItem as ClasseAlunoChamada;

            }
        }
        */
        public async void Buscar(object sender, EventArgs e)
        {
            ConsultarAlunosLista();


        }


        void listViewSelected(object s, SelectedItemChangedEventArgs v)
        {
            if (v.SelectedItem != null)
            {

                BindingContext = v.SelectedItem as Nota;

            }
        }



        public async void ConsultarAlunosLista()
        {


            int a = 0;
            Chamada x = new Chamada();
            x.Id_Turma = ListarAvaliacoes.Id_TurmaNotas;
            urna = await servicao.GetChamada_TurmaAsync(x);
            int i = 1;

            int contar = urna.Count();

            if (urna.Count().Equals(0))
            {
                await DisplayAlert($"Turma{Turma} ", "Essa turma não possui nenhum aluno cadastrado!", "OK");
                listView.ItemsSource = null;
            }

            else
            {
                var listaElementos = new List<Chamada>();

                for (int z = 0; z < contar; z++)
                {


                    cac = new Chamada()
                    {

                        Numero_Chamada = urna[z].Numero_Chamada,
                        Nome = urna[z].Nome,
                    };



                    listaElementos.Add(cac);
                }


                listView.ItemsSource = listaElementos;











            }
        }

        public async void Button_Clicked(object sender, EventArgs e)
        {
            List<AlunoBean> alun = new List<AlunoBean>();
            Chamada alunoo = new Chamada()
            {
                Id_Turma = Id_TurmaAluno,

            };

            int a = 0;

            urna = await servicao.GetChamada_TurmaAsync(alunoo);
            int i = 1;

            int contar = urna.Count();

            Turma t = new Turma();
            NotaDAO tpd = new NotaDAO();
            ProfessorTurma prturma = null;
            List<Turma> listaTurma = new List<Turma>();



            // await DisplayAlert(bixa, "Foi o item Selecionado ", "OK");

            //chama o service para incluir a conta via API
            TurmaDao service = new TurmaDao();
            int c = 0;

            // string bixa = iten[c].Serie;
            //t.Serie = bixa;
            //listaTurma = await servicao.GetId_TurmaAsync(t);

            //item.Id_Turma = listaTurma[c].Id_Turma;
            // Id_Turma = item.Id_Turma;
            c++;

            AlunoBean ch1 = new AlunoBean();

            foreach (var item in urna)
            {
                ch1.Nome = item.Nome;
                ch1.Id_Turma = Id_TurmaAluno;
            }
            if (await servicaoalunao.GetAutenticarId_Açuno(ch1) != null)
            {
                urna2 = await servicaoalunao.GetAutenticarId_Açuno(ch1);
                int contar2 = urna2.Count();
                int yy = 1;
                foreach (var item in urna)
                {

                    Nota ch = new Nota();

                    ch.Id_Turma = Id_TurmaAluno;
                        ch.Id_Aluno = urna2[yy].Id_Aluno;
                        ch.Id_Professor = TelaLoginProfessor.Id_Professor;
                        ch.Id_Bimestre = ListarAvaliacoes.Id_BimestreNotas;
                        ch.nota = 5;

             

                    yy++;
                    await tpd.AddNotasAsync(ch);

                }
				  await PopupNavigation.Instance.PushAsync(new PopPupSucesso());
            }





            await DisplayAlert("Sucerro", "Salvo", "Ok");
        }

        async void updateItem(object sender, EventArgs e)
        {
            var item = (Nota)((Entry)sender).BindingContext;
            List<Nota> sla = new List<Nota>();
            sla.Add(item);

        }
    }
}
