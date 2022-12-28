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

namespace 学员健康统计系统
{
    public partial class Form3 : Form
    {

        private string strconn = "server=DESKTOP-F8GIGHJ;database=health;Trusted_Connection=SSPI";

        public Form3()
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
            string sql = "insert into [dbo].[class](name,classify,majoy) values ('" + textBox1.Text.Trim() + "','" + textBox2.Text.Trim() + "','" + textBox3.Text.Trim() + "')";
            int count = ExecuteNonQuery(sql);
            if (count > 0)
            {
                MessageBox.Show("添加成功");
                textBox1.Text = "";
                textBox2.Text = "";
                textBox3.Text = "";
            }
        }

        private void Form3_Load(object sender, EventArgs e)
        {

        }
    }
}
