using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.ComponentModel;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace AppBanco
{
	[XamlCompilation(XamlCompilationOptions.Compile)]
	public partial class teste : ContentPage
	{
        private ObservableCollection<ClasseAlunoChamada> AlunoChamada;
        public teste ()
		{
			InitializeComponent ();




            var listaElementos = new List<ObservableCollection<ClasseAlunoChamada>>();
            var entry = new Entry { Placeholder = "Nome" };


            int i = 1;
            for (i = 1; i <= 30; i++)
            {
                int z = 1;
                //lista.ItemsSource = listaElementos;
                AlunoChamada = new ObservableCollection<ClasseAlunoChamada>()
            {


                new ClasseAlunoChamada(){Numero_Chamada = 1 ,Nome= "" },
               
            };
                listaElementos.Add(AlunoChamada);
                // listaElementos.Add(i);
                z++;
                
            }

            lista.ItemsSource = listaElementos;
        }

        // var listView = new ListView { ItemsSource = listaElementos };
        // lista = new ListView { ItemsSource = listaElementos};

        //lista.ItemsSource = listaElementos;



    }

}
