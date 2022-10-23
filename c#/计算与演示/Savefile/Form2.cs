using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.IO;
using System.Windows.Forms;

namespace Savefile
{
    public partial class Form2 : Form
    {
        Boolean off = false;
        public Form2()
        {
            InitializeComponent();
        }

        private void button1_Click_1(object sender, EventArgs e)
        {
            timer1.Enabled = true;
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            if (label1.Top > 0 && off)
            {
                label1.Top -= 10;
            }
            else if (label1.Top < 0)
            {
                off = false;
            }
            if (label1.Top < this.Height-20 && off == false)
            {
                label1.Top += 10;
            }
            else if (label1.Top > this.Height - 20)
            {
                off = true;
            }
            
        }

        private void button2_Click(object sender, EventArgs e)
        {
            timer1.Enabled = false;
        }

        private void button3_Click(object sender, EventArgs e)
        {
            Form1 frm1 = new Form1();
            frm1.Show();
            this.Hide();
        }
    }
}