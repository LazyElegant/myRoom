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
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void 产生数ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Random r = new Random();
            int sum = 0;
            for (int i = 0; i < 20; i++) { 
                int number = r.Next(10, 100);
                listBox1.Items.Add(number);
                sum += number;
                if (isPrim(number)) {
                    listBox2.Items.Add(number);
                }
            }
            label1.Text = "total = " + sum;
        }
        
        static bool isPrim(int num)
        {
            for(int i=2;i<num-1;i++)
            {
                if (num % i == 0)
                {                    
                    return false;
                }
            }
            Console.WriteLine(num.ToString() + "是素数");
            return true;
        }

        private void button1_Click(object sender, EventArgs e)
        {
            StreamWriter sw = new StreamWriter(Application.StartupPath + "\\random.txt");
            for (int i = 0; i < listBox1.Items.Count ; i++)
                sw.WriteLine(listBox1.Items[i].ToString());
            sw.Close();
        }

        private void 退出ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        private void 动画演示ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form2 form2 = new Form2();
            form2.Show();
            this.Hide();
        }
    }
}