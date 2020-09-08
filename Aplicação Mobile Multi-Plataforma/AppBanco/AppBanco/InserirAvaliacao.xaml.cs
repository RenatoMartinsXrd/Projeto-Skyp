using AppBanco.Bean;
using AppBanco.Dao;
using AppBanco.PopUpBonitao;
using Rg.Plugins.Popup.Services;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace AppBanco
{
	[XamlCompilation(XamlCompilationOptions.Compile)]
	public partial class InserirAvaliacao : ContentPage
	{
        public static List<Turma> urna { get; set; }
        public int Id_Turma { get; set; }
        public int Id_Professor { get; set; }
        public int Id_Bimestre { get; set; }
        public string Serie { get; set; }
        public string bimestre { get; set; }
        TurmaDao servicao = new TurmaDao();
        public InserirAvaliacao ()
		{
			InitializeComponent ();

            Id_Professor = TelaLoginProfessor.Id_Professor;

        }
       
 



        private void Picker_OnSelectedIndexChanged(object sender, EventArgs e)
        {
            var Bimestre = Picker.Items[Picker.SelectedIndex];

            bimestre = Bimestre;
            switch (bimestre)
            {
                case "1º Bimestre":
                    Id_Bimestre = 1;
                    break;
                case "2º Bimestre":
                    Id_Bimestre = 2;
                    break;
                case "3º Bimestre":
                    Id_Bimestre = 3;
                    break;
                case "4º Bimestre":
                    Id_Bimestre = 4;
                    break;
            }

        }



        protected override async void OnAppearing()
        {
           
          
            urna = await servicao.GetTodasTurmasAsync();
            int contar = urna.Count();
            
            listView.ItemsSource = urna;
            

        }

        void listViewSelected(object s, SelectedItemChangedEventArgs v)
        {
            if (v.SelectedItem != null)
            {

                BindingContext = v.SelectedItem as Turma;

            }
        }

        public async void Salvar(object sender, EventArgs e)
        {
           
           
            List<Turma> listaTurma = new List<Turma>();
     
       
        
            Avaliacao avaliar = null;
            var checkedItems = urna.Where(x => x.IsChecked == true).ToList();
         
            AvaliacaoDAO service = new AvaliacaoDAO();
            Turma t = new Turma();
            int b = checkedItems.Count();
            foreach (var item in checkedItems)
            {
               
                // await DisplayAlert(bixa, "Foi o item Selecionado ", "OK");

                //chama o service para incluir a conta via API

                int c = 0;

                string bixa = item.Serie;
                t.Serie = bixa;
                listaTurma = await servicao.GetId_TurmaAsync(t);

                item.Id_Turma = listaTurma[c].Id_Turma;
                Id_Turma = item.Id_Turma;
                c++;
       
                    avaliar = new Avaliacao();

                    avaliar.Id_Professor = Id_Professor;

                    avaliar.Id_Bimestre = Id_Bimestre;
                    avaliar.Id_Turma = Id_Turma;
                    avaliar.Serie = bixa;
                    avaliar.Bimestre = bimestre;
                    avaliar.Titulo = labelTitulo.Text.Trim();
                    avaliar.Descricao = labelDescricao.Text.Trim();
                    avaliar.Data_Avaliacao = dataAvaliacao.Date;


                    await service.AddAvaliacaoAsync(avaliar);
                
            };






            await PopupNavigation.Instance.PushAsync(new PopPupSucesso());


        }


    }
}