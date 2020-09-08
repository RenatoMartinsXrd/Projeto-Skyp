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
    public partial class TelaLoginAluno : ContentPage
    {
        public static int Id_AlunoUsuarioAluno { get; set; }
        UsuarioAlunoDAO dataService1;
        public TelaLoginAluno()
        {
            InitializeComponent();

            dataService1 = new UsuarioAlunoDAO();
            // imagemEmbutida.Source =
            //Nome do projeto e depois o da imagem
            //ImageSource.FromResource("AppBanco.Imagens.Logo2.png", typeof(TelaLogin).GetTypeInfo().Assembly);
        }




        async void btnEntrar(object sender, EventArgs e)
        {

            UsuarioAluno user = new UsuarioAluno();
         
            user.Login = usuario.Text.Trim();
            user.Senha = Senha.Text.Trim();

            UsuarioAluno u = await dataService1.GetId_UsuarioAlunoAsync(user);

            if (u == null)
            {
                await DisplayAlert("Erro", "Erro", "Ok");
            }
            else
            {


                Id_AlunoUsuarioAluno = u.Id_Aluno;
              
                await Navigation.PushModalAsync(new ListarMedia());
            }


        }

        async void Button_Clicked(object sender, EventArgs e)
        {
            await Navigation.PushAsync(new NovoLoginAluno());
        }
    }
}