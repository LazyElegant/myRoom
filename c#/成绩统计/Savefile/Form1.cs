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

        private void button1_Click_1(object sender, EventArgs e)
        {
            StreamReader sr = new StreamReader(Application.StartupPath + "\\ScoreIn22.txt");
            string x = sr.ReadLine();
            string[] s = new string[2];
            while (x != null)
            {
                s = x.Split(',');
                listBox1.Items.Add(s[0]);
                listBox2.Items.Add(s[1]);
                x = sr.ReadLine();

            }
            sr.Close();
            sr.Dispose();
        }

        private void button2_Click(object sender, EventArgs e)
        {
            for (int i = 1; i < listBox2.Items.Count; i++) {
                for (int j = 0; j < i; j++) {
                    if (Convert.ToInt64(listBox2.Items[j]) < Convert.ToInt64(listBox2.Items[i])){
                        int tem = Convert.ToInt32(listBox2.Items[j]);
                        listBox2.Items[j] = listBox2.Items[i];
                        listBox2.Items[i] = tem;
                        String str = Convert.ToString (listBox1.Items[j]);
                        listBox1.Items[j] = listBox1.Items[i];
                        listBox1.Items[i] = str;
                    }
                }
            }

            for (int i = 1; i <= listBox2.Items.Count; i++)
            {
                listBox3.Items.Add(i);
            }
        }

        private void button3_Click(object sender, EventArgs e)
        {
            StreamWriter sw = new StreamWriter(Application.StartupPath + "\\ScoreIn22.txt");
            for (int i = 0; i < listBox1.Items.Count; i++)
                sw.WriteLine(listBox1.Items[i].ToString() + "," + listBox2.Items[i].ToString() + "," + listBox3.Items[i].ToString());
            sw.Close();
        }

        private void button4_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < listBox1.Items.Count; i++)
            {
                if (listBox1.Items[i].Equals(textBox1.Text)) {
                    textBox2.Text = listBox1.Items[i].ToString() + "," + listBox2.Items[i].ToString();
                    break;
                }
            }
        }

        private void button5_Click(object sender, EventArgs e)
        {
            for (int i = 0; i < 10; i++)
            {
                textBox3.Text += Environment.NewLine + listBox1.Items[i].ToString() + "," + listBox2.Items[i].ToString() + "," + listBox3.Items[i].ToString();
            }
        }

        private void button6_Click(object sender, EventArgs e)
        {
            textBox3.Text ="";
            for (int i = 0; i < listBox1.Items.Count; i++)
            {
                if (Convert.ToInt32(listBox2.Items[i]) < 60)
                {
                    textBox3.Text += Environment.NewLine + listBox1.Items[i].ToString() + "," + listBox2.Items[i].ToString();
                }
            }
        }
    }
}