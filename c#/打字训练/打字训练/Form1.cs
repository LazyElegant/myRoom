using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;
using System.Web;

namespace 打字训练
{
    public partial class Form1 : Form
    {
        public int time = 0;
        int wn = 1;
        float  wrong = 0;
        float  right = 0;
        double cont = 0;
        double count = 0;
        public Form1()
        {
           InitializeComponent();
        }
        public Form1(string strTxt)
        {
            InitializeComponent();
            read(strTxt);
        }

        private void read(String file) {
            StreamReader fp ;
            fp = File.OpenText(Application.StartupPath + "/" + file);
            richTextBox1.Text = fp.ReadToEnd();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            time++;
            int miao = time % 60;
            int mlu = time / 60;

            String sum = "";
            if (mlu < 10)
            {

                sum = "0" + mlu + ":";
            }
            else
            {
                sum =  mlu + ":";
            }
            if (miao < 10)
            {
                sum = sum + "0";

                sum = sum + miao;

            }
            else
            {
            
                sum = sum + miao;

            }


            label3.Text = sum;
            double count = right / time * 60;
            count = Math.Round(count, 2);
            label4.Text = "打字速度：" + count + "/minute";
        }
        private void textBox2_TextChanged(object sender, EventArgs e) { 
            
            Char[] A = richTextBox1.Text.ToCharArray();
            Char[] B = textBox2.Text.ToCharArray();
            if (A.Length == B.Length ) {

                MessageBox.Show("打字速度：" + count + "/minute，" + "准确率：" + cont + "%");

                Form2 form2 = new Form2();
                form2.Show();
                this.Hide();

                time = 0;
                richTextBox1.Select(0, 1);
                richTextBox1.SelectionColor = Color.Black ;


            }
            if (B[B.Length - 1]  +'0'==58)
             {
                wn++;
                richTextBox1.Select(B.Length - wn, 1);
                richTextBox1.SelectionColor = Color.Red;
                return;
            }
            
            if (A[B.Length - wn] == B[B.Length - 1])
            {
                right++;
                richTextBox1.Select(B.Length- wn, 1);
                richTextBox1.SelectionColor = Color.Green;
            }
            else
            {
                wrong++;
                richTextBox1.Select(B.Length - wn, 1);
                richTextBox1.SelectionColor = Color.Red ;

            }
            cont = 0;
            if (wrong == 0)
            {
                 cont = 100;
            }
            else {
                 cont = right / (wrong+right) *100;
                cont = Math.Round(cont, 2);
            }


            count = right /time * 60;
            count = Math.Round(count, 2);
            label4.Text = "打字速度：" + count + "/minute";
            label5.Text = "准确率：" + cont + "%";
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (textBox2.Enabled)
            {
                timer1.Enabled = false;
                textBox2.Enabled = false;
            }
            else
            {
                timer1.Enabled = true;
                textBox2.Enabled = true;
            }
        }

        private void richTextBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void label4_Click(object sender, EventArgs e)
        {

        }
    }
}
