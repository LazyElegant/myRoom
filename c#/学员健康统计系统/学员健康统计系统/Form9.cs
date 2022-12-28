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

namespace 学员健康统计系统
{
    public partial class Form9 : Form
    {

        private string strconn = "server=DESKTOP-F8GIGHJ;database=health;Trusted_Connection=SSPI";
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
        public Form9()
        {
            InitializeComponent();
        }

        private void Form9_Load(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            string sql = "insert into [dbo].[health](temperature,student_number,date,postscript) values (" + textBox1.Text.Trim() + ","+Form1.name+",'" + DateTime.Now.ToLongDateString().ToString() + "','" + textBox2.Text.Trim() + "')";
            int count = ExecuteNonQuery(sql);
            if (count > 0)
            {
                MessageBox.Show("添加成功");
                textBox1.Text = "";
                textBox2.Text = "";
            }
        }
    }
}
