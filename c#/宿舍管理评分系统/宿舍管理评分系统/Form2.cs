using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Microsoft.VisualBasic;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace 宿舍管理评分系统
{
    public partial class Form2 : Form
    {
        private string strconn = "server=DESKTOP-F8GIGHJ;database=Dorm;Trusted_Connection=SSPI";
        public Form2()
        {
            InitializeComponent();
        }
        public int ExecuteNonQuery(string cmdText)
        {
            SqlConnection conn = new SqlConnection(strconn);
            conn.Open();
            int res;
            using (SqlCommand cmd = new SqlCommand(cmdText, conn))
            {
                cmd.CommandType = CommandType.Text;
                res = cmd.ExecuteNonQuery();
                if (conn.State == ConnectionState.Open)
                {
                    conn.Close();
                    conn.Dispose();
                }
            }
            return res;
        }

        private void 宿舍管理ToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }
        private void 评分说明ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            MessageBox.Show("评分标准：总分100分，就寝、纪律各占40分，卫生占30分。");
        }

        private void 登记学生会学生ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form4 form4 = new Form4();
            form4.Show();
            this.Hide();
        }

        private void 添加宿舍ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            string str = Interaction.InputBox("输入宿舍号添加宿舍信息（统一4人间）", "宿舍号", "", -1, -1);

            string sql = "insert into [dbo].[dormitorys](dormitory,no1,no2,no3,no4)   values ("+str+",0,0,0,0)";

            int count = ExecuteNonQuery(sql);
            if (count > 0)
            {
                MessageBox.Show("添加成功");
            }
        }

        private void 花名册ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form5 form5 = new Form5();
            form5.Show();
            this.Hide();
        }

        private void 登记学生宿舍记录ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form3 form3 = new Form3();
            form3.Show();
            this.Hide();
        }

        private void 退出系统ToolStripMenuItem_Click(object sender, EventArgs e)
        {

            Application.Exit();
        }

        private void 上传宿舍分数ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form6 form6 = new Form6();
            form6.Show();
            this.Hide();
        }

        private void 查看宿舍成绩ToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Form7 form7 = new Form7();
            form7.Show();
            this.Hide();
        }

        private void Form2_Load(object sender, EventArgs e)
        {

        }
    }
}
