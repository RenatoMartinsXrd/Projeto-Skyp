using AppBanco.TabbedMenusResponsivo;
using AppBanco.Views;
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
    public partial class MenuMaster : ContentPage
    {
        public ListView ListView;

        public MenuMaster()
        {
            InitializeComponent();

            BindingContext = new MenuMasterViewModel();
            ListView = MenuItemsListView;
        }

        class MenuMasterViewModel : INotifyPropertyChanged
        {
            public ObservableCollection<MenuMenuItem> MenuItems { get; set; }
            
            public MenuMasterViewModel()
            {
                MenuItems = new ObservableCollection<MenuMenuItem>(new[]
                {
                    new MenuMenuItem { Id = 0, Title = "Alunos" , TargetType= typeof(Aluno) },
                    new MenuMenuItem { Id = 1, Title = "Chamada" , TargetType = typeof(InserirChamada), cor = Color.GreenYellow},
                    new MenuMenuItem { Id = 2, Title = "Professores" , TargetType = typeof(TabbedMenusResponsivo.Professor), cor = Color.Red},
                    new MenuMenuItem { Id = 3, Title = "Turmas" , TargetType = typeof(TabbedMenusResponsivo.Turma), cor = Color.DarkBlue },
                 
                });
            }
            
            #region INotifyPropertyChanged Implementation
            public event PropertyChangedEventHandler PropertyChanged;
            void OnPropertyChanged([CallerMemberName] string propertyName = "")
            {
                if (PropertyChanged == null)
                    return;

                PropertyChanged.Invoke(this, new PropertyChangedEventArgs(propertyName));
            }
            #endregion
        }
    }
}