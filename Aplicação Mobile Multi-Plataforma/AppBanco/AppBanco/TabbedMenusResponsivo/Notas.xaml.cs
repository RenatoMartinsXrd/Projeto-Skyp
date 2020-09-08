using AppBanco.Views;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace AppBanco.TabbedMenusResponsivo
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class Notas : TabbedPage
    {
        public Notas ()
        {
            InitializeComponent();

            ListarAvaliacoes navhome2 = new ListarAvaliacoes();
            navhome2.Title = "Inserir Notas";
            Children.Add(navhome2);
        }
    }
}