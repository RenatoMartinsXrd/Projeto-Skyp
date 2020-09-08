using AppBanco.dao;
using AppBanco.Dao;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;
using AppBanco.PopUpBonitao;
using Rg.Plugins.Popup.Services;
using AppBanco.TabbedMenusResponsivo;
using AppBanco.Bean;

namespace AppBanco.Views
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class NovoLoginAluno : ContentPage
    {
        public NovoLoginAluno()
        {
            InitializeComponent();
        }

        private async void salvarCadastroProfessor_Clicked(object sender, EventArgs e)
        {
            UsuarioAlunoDAO service = new UsuarioAlunoDAO();
            AlunoDAO service2 = new AlunoDAO();


            UsuarioAluno t = new UsuarioAluno();

          
            AlunoBean p = new AlunoBean();
            p.RA = RaAlunor.Text.Trim();
            AlunoBean ab = await service2.GetRAalunosAsync(p);
            int Id_Aluno = ab.Id_Aluno;
            if (Id_Aluno!=0) { 

                //chama o service para incluir a conta via API
                datasource services = new datasource();


                //mostra mensagem de erro caso não foi possível incluir
                t.Id_Aluno = Id_Aluno;
                t.Login = loginAlunor.Text.Trim();
                t.Senha = senhaAluno.Text.Trim();

                await service.AddUsuarioAlunoAsync(t);
                await PopupNavigation.Instance.PushAsync(new PopPupSucesso());
            
            }
            else
            {
                await DisplayAlert("Não cadstrado", "Não castrado pela escola", "ok");
            }
    }
    }
}