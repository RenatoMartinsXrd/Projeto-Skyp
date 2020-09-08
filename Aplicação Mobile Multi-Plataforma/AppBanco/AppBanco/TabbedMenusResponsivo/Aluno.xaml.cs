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
    public partial class Aluno : TabbedPage
    {
        public Aluno ()
        {
            InitializeComponent();

            InserirAlunos navhome3 = new InserirAlunos();
            navhome3.Title = "Inserir Alunos";
            Children.Add(navhome3);


            teste navhome2 = new teste();
            navhome2.Title = "teste";
            Children.Add(navhome2);
        }
    }
}