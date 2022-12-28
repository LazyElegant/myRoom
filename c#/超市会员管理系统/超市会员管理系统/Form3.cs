using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 超市会员管理系统
{
    public partial class Form3 : Form
    {
        public Form3()
        {
            InitializeComponent();
        }

        private void Form3_Load(object sender, EventArgs e)
        {

        }

        private void 扣除积分ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form9 form = new Form9();
            form.Show();
        }

        private void 添加积分ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form10 form = new Form10();
            form.Show();
        }

        private void 退出系统ToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            Application.Exit();

        }

        private void 返回首页ToolStripMenuItem_Click(object sender, EventArgs e)
        {

            Form1 form = new Form1();
            form.Show();
            this.Hide();
        }
    }
}
