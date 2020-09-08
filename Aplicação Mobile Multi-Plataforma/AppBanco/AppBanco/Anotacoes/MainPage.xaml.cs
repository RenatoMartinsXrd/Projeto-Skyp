using AppBanco.Views;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace AppBanco
{
	public partial class MainPage : ContentPage
	{
		public MainPage()
		{
			InitializeComponent();

		}
        async void btTarefas(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new ListPage());
        }

      async void btteste(object sender, EventArgs a)
        {
          await Navigation.PushAsync(new teste());
        }
	}
}
