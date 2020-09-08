using System;
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace AppBanco
{

    public class MenuMenuItem
    {
        public MenuMenuItem()
        {
            TargetType = typeof(MenuDetail);
        }
        public int Id { get; set; }
        public string Title { get; set; }

        public Type TargetType { get; set; }

        public Color cor { get; set; }
    }
}