using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Runtime.CompilerServices;
using System.Text;

namespace AppBanco.Bean
{
    public class Turma
    {
        public int Id_Turma{ get; set; }
        public string Serie { get; set; }
        public string Periodo{ get; set; }
        public string Ano { get; set; }
        public bool visivel { get; set; }
        private string _title;
        private bool _isChecked;

        public String Title
        {
            get { return _title; }
            set
            {
                _title = value;
                OnPropertyChanged();
            }
        }
        public Boolean IsChecked
        {
            get { return _isChecked; }
            set
            {
                _isChecked = value;
                OnPropertyChanged();
            }
        }

        public Turma()
        {
            Title = String.Empty;
            IsChecked = false;
        }

        public Turma(string title)
            : this()
        {
            Title = title;
        }

        public Turma(string title, bool isChecked)
            : this(title)
        {
            IsChecked = isChecked;
        }

        public event PropertyChangedEventHandler PropertyChanged;

        protected void OnPropertyChanged([CallerMemberName]string propertyName = "")
        {
            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(propertyName));
        }
    }
}
    

