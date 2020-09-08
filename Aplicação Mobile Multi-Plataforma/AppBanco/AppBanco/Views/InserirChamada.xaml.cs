using AppBanco.Bean;
using AppBanco.Dao;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using AppBanco.PopUpBonitao;
using Rg.Plugins.Popup.Services;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace AppBanco.Views
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class InserirChamada : ContentPage
    {
        public static List<Turma> urna2 { get; set; }
        public int Id_Turma { get; set; }
        public static List<AlunoBean> urna { get; set; }
        public static List<Turma> iten { get; set; }
        public static int Id_TurmaAluno { get; set; }
        public static int Id_AlunoInserir { get; set; }
        public static string NomeAlunoInserir { get; set; }
        public static string RA { get; set; }
        public static string Turma { get; set; }
        public static DateTime Data_Nascimento { get; set; }
        static TurmaDao servicao = new TurmaDao();
        static AlunoDAO servicaoalunao = new AlunoDAO();
        public static ClasseAlunoChamada cac { get; set; }
        public ObservableCollection<ClasseAlunoChamada> AlunoChamada;
        Chamada ch = new Chamada();
        public ClasseAlunoChamada alunochamda = new ClasseAlunoChamada();

        public InserirChamada()
        {
            InitializeComponent();
        
            
          
          
        }
        
        protected override async void OnAppearing()
        {

            Combobox();

        }

    
        void listViewSelected(object s, SelectedItemChangedEventArgs v)
        {
            if (v.SelectedItem != null)
            {

                BindingContext = v.SelectedItem as ClasseAlunoChamada;

            }
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
            Id_TurmaAluno = t[i].Id_Turma;

        }

        public async void Buscar(object sender, EventArgs e)
        {
            ConsultarAlunosLista();

            
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
            int i = 1;

            int contar = urna.Count();

            if (urna.Count().Equals(0))
            {
                await DisplayAlert($"Turma{Turma} ", "Essa turma não possui nenhum aluno cadastrado!", "OK");
                listView.ItemsSource = null;
            }

            else
            {
                var listaElementos = new List<ClasseAlunoChamada>();

                for (int z = 0; z < contar; z++)
                {
                    

                    cac = new ClasseAlunoChamada()
                    {

                        Numero_Chamada = i,
                        Nome = urna[z].Nome,
                    };
                    i++;


                    listaElementos.Add(cac);
                }


                listView.ItemsSource = listaElementos;











            }

            // listaElementos.Add(i);

        }

        private async void Button_Clicked(object sender, EventArgs e)
        {
            List<AlunoBean> alun = new List<AlunoBean>();
            AlunoBean alunoo = new AlunoBean()
            {
                Id_Turma = Id_TurmaAluno,

            };

            int a = 0;

            urna = await servicaoalunao.GetTodosAlunosId_TurmaAsync(alunoo);
            int i = 1;

            int contar = urna.Count();
          
            Turma t = new Turma();
            ChamadaDAO tpd = new ChamadaDAO();
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
                ch = new Chamada();
               Chamada ch1 = new Chamada();

            foreach (var item in urna)
            {
                ch1.Nome = item.Nome;

                ch1.Numero_Chamada = cac.Numero_Chamada;
                ch1.Id_Turma = Id_TurmaAluno;
            }
            if (await tpd.GetAutenticarChamadaAsync(ch1))
            {
                await tpd.DeleteAlunoAsync(ch1);
                int yy = 1;
                foreach (var item in urna)
                {
             
                 
                    ch.Id_Turma = Id_TurmaAluno;
                    ch.Id_Aluno = item.Id_Aluno;
                    ch.Numero_Chamada = yy;
                    ch.Nome = item.Nome;
                    yy++;
                    await tpd.AddChamadaAsync(ch);
               
                }
            }
            else
            {
                int yy = 1;
                foreach (var item in urna)
                {
                    
                    ch.Id_Turma = Id_TurmaAluno;
                    ch.Id_Aluno = item.Id_Aluno;
                    ch.Numero_Chamada = cac.Numero_Chamada;
                    ch.Nome = item.Nome;
                    yy++;
                    await tpd.AddChamadaAsync(ch);
                }
            }
 




       await PopupNavigation.Instance.PushAsync(new PopPupSucesso());

            Combobox();
        }

    }
}
            

        

        


    
