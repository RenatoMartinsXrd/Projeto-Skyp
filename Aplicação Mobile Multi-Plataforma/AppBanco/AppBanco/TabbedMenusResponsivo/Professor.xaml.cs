using Skyp;
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
    public partial class Professor : TabbedPage
    {
        public Professor ()
        {
            InitializeComponent();
           CadastroProfessorPage navhome = new CadastroProfessorPage();
            navhome.Title = "Inserir Professor";
            Children.Add(navhome);

           IncluirTurmasProf navhome3 = new IncluirTurmasProf();
            navhome3.Title = " Incluir Turmas";
            Children.Add(navhome3);
        }
    }
   
}