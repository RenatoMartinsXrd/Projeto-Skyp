using AppBanco.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace AppBanco.Views
{
    [XamlCompilation(XamlCompilationOptions.Compile)]
    public partial class pageView : ContentPage
    {
        public pageView()
        {
            InitializeComponent();
        }
        async void btSalvar(object sender, EventArgs e)
        {
            //busca a tarefa na tela
            TarefaModel tarefa = (TarefaModel)BindingContext;

            //salva no banco
            await App.Bancos().Tarefas.Salvar(tarefa);

            //volta para a tela anterior

            await Navigation.PopAsync();
        }

        async void btExcluir(object sender, EventArgs e)
        {
            //busca a tarefa na tela
            TarefaModel tarefa = (TarefaModel)BindingContext;

            //salva no banco
            await App.Bancos().Tarefas.Excluir(tarefa);

            //volta para a tela anterior

            await Navigation.PopAsync();
        }

        async void btCancelar(object sender, EventArgs e)
        {

            await Navigation.PopAsync();
        }
    }
}
