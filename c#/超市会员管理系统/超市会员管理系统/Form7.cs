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
    public partial class Form7 : Form
    {
        private string strconn = "server=DESKTOP-F8GIGHJ;database=SupermarketMember;Trusted_Connection=SSPI";

        public Form7()
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

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
           
            string sql = "insert into [dbo].[card](name,number,points,date,phone,address) values ('" + textBox1.Text + "','" + textBox2.Text + "'," + textBox3.Text + ",'" + DateTime.Now.ToLongDateString().ToString() 
                + "','" + textBox4.Text + "','" + textBox5.Text + "')";
            int count = ExecuteNonQuery(sql);
            if (count > 0)
            {
                MessageBox.Show("添加成功");
                textBox1.Text = "";
                textBox2.Text = "";
                textBox3.Text = "";
                textBox4.Text = "";
                textBox5.Text = "";
            }
        }

        private void Form7_Load(object sender, EventArgs e)
        {

        }
    }
}
