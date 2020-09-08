using System;
using System.Collections.Generic;


using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Xamarin.Forms;

namespace AppBanco
{

    public class MenuProfessorMenuItem
    {
        public MenuProfessorMenuItem()
        {
            TargetType = typeof(MenuProfessorDetail);
        }
        public int Id { get; set; }
        public string Title { get; set; }

        public Type TargetType { get; set; }
        public Color cor { get; set; }
    }
}