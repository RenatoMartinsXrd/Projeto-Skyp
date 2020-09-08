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
    public partial class NovoLogin : ContentPage
    {
        public NovoLogin()
        {
            InitializeComponent();
        }

        private async void salvarCadastroProfessor_Clicked(object sender, EventArgs e)
        {
            ProfessorDAO service = new ProfessorDAO();



            Usuario t = new Usuario();

            t.Login = loginProfessor.Text.Trim();
            t.Senha = senhaProfessor.Text.Trim();
            ProfessorCadastro p = new ProfessorCadastro();
            p.CPF = cpfProfessor.Text.Trim();
            Professor pp = new Professor();
            if (await service.GetAutenticarCpfAsync(p)) { 

                //chama o service para incluir a conta via API
                datasource services = new datasource();


            //mostra mensagem de erro caso não foi possível incluir
            
                    RetornoUsuario oo = new RetornoUsuario();
                    int i = 0;
                    List<ProfessorCadastro> pc = new List<ProfessorCadastro>();
                  RetornoUsuario pc1 = new RetornoUsuario();
                    ProfessorCadastro odk = new ProfessorCadastro();
                    odk.CPF = cpfProfessor.Text.Trim();
                    pc = await service.GetCpfCadstro(odk);
                    await services.AddChamadaAsync(t);
                    oo.Id_Professor = pc[i].Id_Professor;
                 
                    Usuario user = new Usuario();
                    user.Login = t.Login;
                  
                    user.Senha = t.Senha;
                   pc1 = await services.GetProdutosAsync(user);
                    oo.Id_Usuario = pc1.Id_Usuario;
                  await service.AddProfessorUsuarioAsync(oo);
                await PopupNavigation.Instance.PushAsync(new PopPupSucesso());
            
            }
            else
            {
                await DisplayAlert("Não cadstrado", "Não castrado pela escola", "ok");
            }
    }
    }
}