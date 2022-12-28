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
    public partial class Form9 : Form
    {
        private string strconn = "server=DESKTOP-F8GIGHJ;database=SupermarketMember;Trusted_Connection=SSPI";
        public Form9()
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
        private void Form9_Load(object sender, EventArgs e)
        {

            string sql = "SELECT number FROM [dbo].[card]";
            DataTable dataTable = ExecuteQuery(sql);
            if (dataTable != null)
            {
                //打印每一行的数据
                foreach (DataRow row in dataTable.Rows)
                {
                    comboBox1.Items.Add(row[0]);
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string sql = "SELECT points FROM [dbo].[card] where number ='" + comboBox1.Text + "'";
            DataTable dataTable = ExecuteQuery(sql);
            DataRow row = dataTable.Rows[0];
            int points = (int)row[0];
            if (Int32.Parse(textBox1.Text) > points)
            {

                MessageBox.Show("余额不足");
                return;
            }
            else
            {
                sql = "update [dbo].[card] set points = points - " + textBox1.Text + " where number ='" + comboBox1.Text + "'";
                int re = ExecuteNonQuery(sql);
                if (re > 0)
                {
                    MessageBox.Show("扣除成功");
                    return;
                }
            }
        }

    }
}
