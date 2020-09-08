using AppBanco.Bean;
using AppBanco.Dao;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace AppBanco
{
	[XamlCompilation(XamlCompilationOptions.Compile)]
	public partial class testchamada : ContentPage
	{
        public static List<Turma> urna2 { get; set; }

        public static List<AlunoBean> urna { get; set; }
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
        public ObservableCollection<List<ClasseAlunoChamada>> td;
        public  static List<ClasseAlunoChamada> alunochamda { get; set; }
        public testchamada ()
		{
			InitializeComponent ();
            Combobox();
        }

        protected override async void OnAppearing()
        {

            Combobox();

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
                      
                            Numero_Chamada = z,
                            Nome = urna[z].Nome,
                        } ;



                    listaElementos.Add(cac);
                }
             

                listView.ItemsSource = listaElementos;











                }
               
               
           

                  
                  
                






            }

            // listaElementos.Add(i);

        }
    }

