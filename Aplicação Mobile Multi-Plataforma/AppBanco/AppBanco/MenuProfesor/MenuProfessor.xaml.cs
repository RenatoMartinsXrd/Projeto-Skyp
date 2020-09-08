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
    public partial class MenuProfessor : MasterDetailPage
    {
        public MenuProfessor()
        {
            InitializeComponent();
            MasterPage.ListView.ItemSelected += ListView_ItemSelected;
        }

        private void ListView_ItemSelected(object sender, SelectedItemChangedEventArgs e)
        {
            var item = e.SelectedItem as MenuProfessorMenuItem;
            if (item == null)
                return;

            var page = (Page)Activator.CreateInstance(item.TargetType);
            page.Title = item.Title;

            Detail = new NavigationPage(page) { BarBackgroundColor = item.cor }; ;
            IsPresented = false;

            MasterPage.ListView.SelectedItem = null;
        }
    }
}