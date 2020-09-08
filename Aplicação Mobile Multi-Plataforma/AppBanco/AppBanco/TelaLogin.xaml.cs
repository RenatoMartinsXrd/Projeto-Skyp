using AppBanco.Bean;
using AppBanco.dao;
using AppBanco.Dao;
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
  
    public partial class TelaLogin : ContentPage
    {
        SecretariaDAO dataService1;
       
      
        public TelaLogin()
        {
            InitializeComponent();
            dataService1 = new SecretariaDAO();
            //imagemEmbutida.Source =
            //Nome do projeto e depois o da imagem
            // ImageSource.FromResource("AppBanco.Imagens.Logo2.png", typeof(TelaLogin).GetTypeInfo().Assembly);
        }


        async void btnEntrar(object sender, EventArgs e)
        {
            
            Bean.Secretaria user = new Bean.Secretaria();
            Bean.Secretaria user2 = new Bean.Secretaria();
            user.Login = usuario.Text.Trim();
            user2.Senha = Senha.Text.Trim();
            
   

            if (await dataService1.GetSecretariaAsync(user, user2) == false)
            {
                await DisplayAlert("Erro", "Erro", "Ok");
            }
            else
            {
          
                await Navigation.PushModalAsync((new Menu()));
              
            }
            
             
          
           
        }


   



      
    }
}
