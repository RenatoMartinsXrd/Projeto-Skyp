

using AppBanco.Views;
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
    public partial class Turma : TabbedPage
    {
        public Turma ()
        {
            InitializeComponent();

           InserirTurma navhome = new InserirTurma();
            navhome.Title = "Inserir Turmas";
            Children.Add(navhome);

            ConsultaTurma navhome10 = new ConsultaTurma();
            navhome10.Title = "Consultar Turmas";
            Children.Add(navhome10);
        }
    }
}