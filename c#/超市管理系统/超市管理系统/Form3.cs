using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 超市管理系统
{
    public partial class Form3 : Form
    {
        public Form3()
        {
            InitializeComponent();
        }

        private void timer1_Tick(object sender, EventArgs e)
        {
            label3.Text = "当前时间：" + DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss");

        }

        private void Form3_Load(object sender, EventArgs e)
        {
            label2.Text = "欢迎您用户("+ Form1.name + ")";
            label3.Text = "当前时间：" + DateTime.Now.ToString("yyyy-MM-dd HH:mm:ss");

        }

        private void 退出登录ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form1.name = "";
            Form1 form1 = new Form1();
            form1.Show();
            this.Hide();

        }

        private void 退出系统ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Application.Exit();
        }

        private void 添加商品ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form4 form4 = new Form4();
            form4.Show();
            this.Hide();
        }


        private void 购买商品ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form5 form5 = new Form5();
            form5.Show();
            this.Hide();
        }

        private void 购买记录ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form6 form6 = new Form6();
            form6.Show();
            this.Hide();
        }

        private void 商品补货ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form7 form7 = new Form7();
            form7.Show();
            this.Hide();
        }
    }
}
