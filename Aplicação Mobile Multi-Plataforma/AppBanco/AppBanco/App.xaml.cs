using AppBanco.PopUpBonitao;
using AppBanco.TabbedMenusResponsivo;
using AppBanco.Views;
using Rg.Plugins.Popup.Services;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;

using Xamarin.Forms;

namespace AppBanco
{
	public partial class App : Application
	{

 private static banco banco;

       public static banco Bancos()
        {
            //Instancia única do banco de dados
            if(banco == null)
            {
                //Diretório local da aplicação, o mesmo não é compartilhado
                string diretorio = Environment.GetFolderPath(Environment.SpecialFolder.LocalApplicationData);

                //Nome do banco de dados que sera salvo no celular
                string nome = "BancoTarefa.db3";

                //Instancia o banco de dados
                banco = new banco(Path.Combine(diretorio, nome));
            }
            return banco;
        }
		public App ()
		{
			InitializeComponent();

            // MainPage = new NavigationPage(new InserirChamada());
            //MainPage = new NavigationPage(new SelecionarPerfil());
            //MainPage = new NavigationPage(new PopPupSucesso());
            //MainPage = new NavigationPage(new InserirAlunos());
            // MainPage = new NavigationPage(new InserirAvaliacao());
          MainPage = new NavigationPage(new  SelecionarPerfil());
        }

        protected override void OnStart ()
		{
			// Handle when your app starts
		}

		protected override void OnSleep ()
		{
			// Handle when your app sleeps
		}

		protected override void OnResume ()
		{
			// Handle when your app resumes
		}
	}
}
