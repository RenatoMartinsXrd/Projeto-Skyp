using AppBanco.Bean;
using AppBanco.Dao;
using AppBanco.Views;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace AppBanco
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class TelaLoginProfessor : ContentPage
    {
        public static int Id_Professor { get; set; }
        datasource dataService1;
        public TelaLoginProfessor()
        {
            InitializeComponent();

            dataService1 = new datasource();
            // imagemEmbutida.Source =
            //Nome do projeto e depois o da imagem
            //ImageSource.FromResource("AppBanco.Imagens.Logo2.png", typeof(TelaLogin).GetTypeInfo().Assembly);
        }




        async void btnEntrar(object sender, EventArgs e)
        {

            dao.Usuario user = new dao.Usuario();
         
            user.Login = usuario.Text.Trim();
            user.Senha = Senha.Text.Trim();

            RetornoUsuario u = await dataService1.GetProdutosAsync(user);

            if (u == null)
            {
                await DisplayAlert("Erro", "Erro", "Ok");
            }
            else
            {

                string zuao = $"Id_Usuario ={u.Id_Usuario.ToString()} e Id_Professor = {u.Id_Professor.ToString()}";
                Id_Professor = u.Id_Professor;
                await DisplayAlert("Ok", zuao, "OK");
                await Navigation.PushModalAsync(new MenuProfessor());
            }


        }

        private async void Button_Clicked(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new NovoLogin());
        }
    }
}