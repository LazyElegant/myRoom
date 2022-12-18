using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace 超市管理系统
{
    public partial class Form2 : Form
    {
        private string strconn = "server=DESKTOP-F8GIGHJ;database=Supermarket;Trusted_Connection=SSPI";
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

        private void button1_Click(object sender, EventArgs e)
        {
            if (!textBox2.Text.Equals(textBox3.Text)) {
                MessageBox.Show("密码与确认密码不一致");
                return;
            }

            string sql = "insert into [dbo].[Users](name,password)   values ('"+textBox1.Text +"','"+textBox2.Text+"')";
            int count =  ExecuteNonQuery(sql);
            if (count > 0) {
                MessageBox.Show("注册成功");
                textBox1.Text = "";
                textBox2.Text = "";
                textBox3.Text = "";
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Hide();
            Form1 form1 = new Form1();
            form1.Show();
        }
    }
}
