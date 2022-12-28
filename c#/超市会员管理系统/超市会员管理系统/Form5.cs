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

namespace 超市会员管理系统
{
    public partial class Form5 : Form
    {
        private string strconn = "server=DESKTOP-F8GIGHJ;database=SupermarketMember;Trusted_Connection=SSPI";

        public Form5()
        {
            InitializeComponent();
        }

        public DataTable ExecuteQuery(string cmdText)
        {
            SqlConnection conn = new SqlConnection(strconn);
            conn.Open();
            DataTable dt = new DataTable();
            using (SqlCommand cmd = new SqlCommand(cmdText, conn))
            {
                using (SqlDataReader sdr = cmd.ExecuteReader())
                {
                    dt.Load(sdr);
                    sdr.Close();
                    sdr.Dispose();
                    if (conn.State == ConnectionState.Open)
                    {
                        conn.Close();
                        conn.Dispose();
                    }
                }
            }
            return dt;
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
            if (!textBox1.Text.Equals(textBox2.Text))
            {
                MessageBox.Show("密码与确认密码不一致");
                return;
            }

            String sql = "UPDATE [dbo].[counter] SET password = " + textBox2.Text + " where name = '" + comboBox1.Text + "'";
            int re = ExecuteNonQuery(sql);
            if (re > 0)
            {
                MessageBox.Show("修改成功");
                textBox1.Text = "";
                textBox2.Text = "";
            }
        }

        private void Form5_Load(object sender, EventArgs e)
        {
            string sql = "SELECT name FROM [dbo].[counter]";
            DataTable dataTable = ExecuteQuery(sql);
            if (dataTable != null)
            {
                //打印每一行的数据
                foreach (DataRow row in dataTable.Rows)
                {
                    comboBox1.Items.Add((string)row[0]);
                }
            }
        }
    }
}
