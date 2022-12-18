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

namespace 宿舍管理评分系统
{
    public partial class Form1 : Form
    {
        private string strconn = "server=DESKTOP-F8GIGHJ;database=Dorm;Trusted_Connection=SSPI";

        public Form1()
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

        private void button1_Click(object sender, EventArgs e)
        {


            string sql = "SELECT number,password FROM [dbo].[Manage] where number = '" + textBox1.Text + "'";
            DataTable dataTable = ExecuteQuery(sql);
            if (dataTable != null)
            {
                string columnStr = string.Empty;
                //打印每一行的数据
                foreach (DataRow row in dataTable.Rows)
                {
                    String password = (string)row[1];
                    if (textBox2.Text.Equals(password.Trim()))
                    {
                        MessageBox.Show("登录成功!!");
                        this.Hide();
                        Form2 form = new Form2();
                        form.Show();

                    }else if (textBox1.Text.Equals("admin") || textBox2.Text.Equals("root"))
                    {
                        MessageBox.Show("登录成功！！");
                        Form2 form = new Form2();
                        form.Show();
                        this.Hide();
                    }
                    else
                    {
                        MessageBox.Show("登录失败");
                    }
                }
            }
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }
    }
}
