using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using System.Windows.Forms;

namespace 超市会员管理系统
{
    public partial class Form4 : Form
    {
        private string strconn = "server=DESKTOP-F8GIGHJ;database=SupermarketMember;Trusted_Connection=SSPI";

        public Form4()
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
            if (!textBox2.Text.Equals(textBox3.Text))
            {
                MessageBox.Show("密码与确认密码不一致");
                return;
            }

            string sql = "insert into [dbo].[counter](name,password) values ('" + textBox1.Text + "','" + textBox2.Text + "')";
            int count = ExecuteNonQuery(sql);
            if (count > 0)
            {
                MessageBox.Show("注册成功");
                textBox1.Text = "";
                textBox2.Text = "";
                textBox3.Text = "";
            }
        }

        private void Form4_Load(object sender, EventArgs e)
        {

        }
    }
}
