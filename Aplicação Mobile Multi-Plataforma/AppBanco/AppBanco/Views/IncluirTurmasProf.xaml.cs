using AppBanco.Bean;
using AppBanco.Dao;
using Skyp;
using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;
using AppBanco.PopUpBonitao;
using Rg.Plugins.Popup.Services;

namespace AppBanco
{
    public partial class IncluirTurmasProf : ContentPage
    {
        ProfessorDAO dataService;
     
        public static List<Turma> urna { get; set; }
        public int Id_Turma { get; set; }
        public int Id_Professor { get; set; }
        public string Serie { get; set; }
        TurmaDao servicao = new TurmaDao();
        public IncluirTurmasProf()
        {
            
           
            InitializeComponent();
        





        }

      



        public async void Combobox()
        {
            dataService = new ProfessorDAO();
            List<ProfessorCadastro> u = new List<ProfessorCadastro>();
            List<ProfessorCadastro> professor = new List<ProfessorCadastro>();
            ProfessorCadastro p = new ProfessorCadastro();
            u = await dataService.GetProfessoresAsync();
            int z = u.Count();
            for (int i = 0; i < z; i++)
            {
                string t = u[i].Nome.ToString();

                Picker.Items.Add(t);



            }

        }



        private async void Picker_OnSelectedIndexChanged(object sender, EventArgs e)
        {
            var Professorprofis = Picker.Items[Picker.SelectedIndex];
            ProfessorCadastro pc = new ProfessorCadastro();
            pc.Nome = Professorprofis;

            ProfessorCadastro t = await dataService.GetId_ProfessorAsync(pc);
            await DisplayAlert(Professorprofis, $"Foi o item Selecionado e o Id foi{t.Id_Professor} ", "OK");
            Id_Professor = t.Id_Professor;
          
        }



        protected override async void OnAppearing()
        {
            urna = await servicao.GetTodasTurmasAsync();
            listView.ItemsSource = urna;
            Combobox();

        }

        void listViewSelected(object s, SelectedItemChangedEventArgs v)
        {
            if (v.SelectedItem != null)
            {

                BindingContext = v.SelectedItem as Turma;

            }
        }

        protected async void Salvar(object sender, EventArgs e)
        {
            dataService = new ProfessorDAO();
            List<ProfessorCadastro> u = new List<ProfessorCadastro>();
            List<ProfessorCadastro> professor = new List<ProfessorCadastro>();
            List<Turma> listaTurma = new List<Turma>();
            ProfessorCadastro p = new ProfessorCadastro();
            u = await dataService.GetProfessoresAsync();
            int z = u.Count();
            Turma t = new Turma();
            TurmaProfessorDao tpd = new TurmaProfessorDao();
            ProfessorTurma prturma = null;
            var checkedItems = urna.Where(x => x.IsChecked == true).ToList();

            foreach (var item in checkedItems)
            {
                int k = checkedItems.Count();
               // await DisplayAlert(bixa, "Foi o item Selecionado ", "OK");

                //chama o service para incluir a conta via API
                TurmaDao service = new TurmaDao();
                int c = 0;
                   
                    string bixa = item.Serie;
                    t.Serie = bixa;
                    listaTurma = await servicao.GetId_TurmaAsync(t);

                item.Id_Turma = listaTurma[c].Id_Turma;
                Id_Turma = item.Id_Turma;
                c++;
                    prturma = new ProfessorTurma();
                    prturma.Id_Professor = Id_Professor;
                    prturma.Id_Turma = Id_Turma;
                    prturma.Serie = bixa;
                   
                    await tpd.AddTurmaProfessorAsync(prturma);
                item.IsChecked = false;
                };
         
          
           

           
   await PopupNavigation.Instance.PushAsync(new PopPupSucesso());

            Combobox();
        }
          

        }




        /*
          private async void tst(object sender, EventArgs e)
          {

              dataService = new ProfessorDAO();
              List<ProfessorCadastro> u = new List<ProfessorCadastro>();
              List<ProfessorCadastro> professor = new List<ProfessorCadastro>();
              ProfessorCadastro p = new ProfessorCadastro();
              u = await dataService.GetProfessoresAsync();
              int z = u.Count();
              List<Turma> urna = new List<Turma>();
              for (int i = 0; i < z; i++)
              {
                  if (true)
                  {


                      TurmaProfessorDao tpd = new TurmaProfessorDao();

                      TurmaDao td = new TurmaDao();
                      urna = await td.GetTodasTurmasAsync();
                      await DisplayAlert(urna[i].Serie, "Foi o item Selecionado ", "OK");
                  }
              }
              }
          }
          */
    }

    



