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

namespace 酒店信息管理系统
{
    public partial class Form3 : Form
    {
        public Form3()
        {
            InitializeComponent();
        }
        private string strconn = "server=DESKTOP-F8GIGHJ;database=hotel;Trusted_Connection=SSPI";

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
        private void button1_Click(object sender, EventArgs e)
        {

            string sql = "SELECT id FROM [dbo].[room] where number = " + textBox1.Text;
            DataTable dataTable = ExecuteQuery(sql);
            if (dataTable.Rows.Count >0)
            {
                MessageBox.Show("已有该房间");
                return;
            }
            sql = "insert into [dbo].[room] (number,price,phone) values(" + textBox1.Text + ",'" + textBox2.Text + "'," + textBox3.Text +")";
            int re = ExecuteNonQuery(sql);
            if (re > 0)
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
