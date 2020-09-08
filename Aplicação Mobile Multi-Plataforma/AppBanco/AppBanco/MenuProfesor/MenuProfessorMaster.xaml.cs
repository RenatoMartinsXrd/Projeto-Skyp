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
    public partial class MenuProfessorMaster : ContentPage
    {
        public ListView ListView;

        public MenuProfessorMaster()
        {
            InitializeComponent();

            BindingContext = new MenuProfessorMasterViewModel();
            ListView = MenuItemsListView;
        }

        class MenuProfessorMasterViewModel : INotifyPropertyChanged
        {
            public ObservableCollection<MenuProfessorMenuItem> MenuItems { get; set; }
            
            public MenuProfessorMasterViewModel()
            {
                MenuItems = new ObservableCollection<MenuProfessorMenuItem>(new[]
                {
                     new MenuProfessorMenuItem { Id = 0, Title = "Anotações", TargetType = typeof(ListPage), cor = Color.Red},
                    new MenuProfessorMenuItem { Id = 1, Title = "Avaliações", TargetType = typeof(TabbedMenusResponsivo.Avaliação), cor = Color.DarkOrange },
                    new MenuProfessorMenuItem { Id = 2, Title = "Chamada" },
                    new MenuProfessorMenuItem { Id = 3, Title = "Notas" , TargetType = typeof(TabbedMenusResponsivo.Notas),cor = Color.AliceBlue },
                     new MenuProfessorMenuItem { Id = 4, Title = "Turmas" },
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