using System;
using System.Collections.Generic;
using System.Linq;
using System.Reflection;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;
using Xamarin.Forms.Xaml;
using Skyp;

namespace AppBanco
{
	[XamlCompilation(XamlCompilationOptions.Compile)]
	public partial class SelecionarPerfil : ContentPage
	{
		public SelecionarPerfil()
		{
			InitializeComponent ();

            imagemPerfilProfessor.Source =
                //Nome do projeto e depois o da imagem
                ImageSource.FromResource("AppBanco.Imagens.professor.png", typeof(SelecionarPerfil).GetTypeInfo().Assembly);

            imagemPerfilSecretaria.Source =
                //Nome do projeto e depois o da imagem
                ImageSource.FromResource("AppBanco.Imagens.secretaria.png", typeof(SelecionarPerfil).GetTypeInfo().Assembly);

            imagemPerfilAluno.Source =
             //Nome do projeto e depois o da imagem
             ImageSource.FromResource("AppBanco.Imagens.aluno.png", typeof(SelecionarPerfil).GetTypeInfo().Assembly);
        

    }



        async void professorTapped(object sender, EventArgs args)
        {
          await Navigation.PushAsync(new TelaLoginProfessor());
        }

        async void secretariaTapped(object sender, EventArgs args)
        {
            await Navigation.PushAsync(new TelaLogin());
        }

        async void alunoTapped(object sender, EventArgs args)
        {
            await Navigation.PushAsync(new TelaLoginAluno());
        }
    }
}