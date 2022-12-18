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
    public partial class Form3 : Form
    {
        private string strconn = "server=DESKTOP-F8GIGHJ;database=Dorm;Trusted_Connection=SSPI";
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
        private void Form3_Load(object sender, EventArgs e)
        {

            string sql = "SELECT dormitory FROM [dbo].[dormitorys]";
            DataTable dataTable = ExecuteQuery(sql);
            if (dataTable != null)
            {
                //打印每一行的数据
                foreach (DataRow row in dataTable.Rows)
                {
                    string columnStr = string.Empty;
                    columnStr = row[0] + "";
                    comboBox1.Items.Add(columnStr);
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {

            string sql = "SELECT no1,no2,no3,no4 FROM [dbo].[dormitorys] where dormitory = " + comboBox1.Text;
            DataTable dataTable = ExecuteQuery(sql);
            if (dataTable != null)
            {
                //打印每一行的数据
                foreach (DataRow row in dataTable.Rows)
                {
                    string columnStr = string.Empty;
                    columnStr = row[int.Parse(textBox3.Text)-1] + "";
                    if (int.Parse(columnStr) != 0)
                    {
                        MessageBox.Show("该床位已有人！！");
                    }
                    else {
                        sql = "insert into [dbo].[students] (number,name,dorm,bedNumber)   values(" + textBox1.Text + ",'" + textBox2.Text + "'," + comboBox1.Text +"," + textBox3.Text+ ")";
                        ExecuteNonQuery(sql);

                        sql = "UPDATE [dbo].[dormitorys] SET no" +textBox3.Text+ " = " + textBox1.Text + " where dormitory =" + comboBox1.Text ;

                        int re = ExecuteNonQuery(sql);
                        if (re > 0)
                        {
                            MessageBox.Show("登记成功");
                            textBox1.Text = "";
                            textBox2.Text = "";
                            textBox3.Text = "";
                        }
                    }
                }
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Form2 form2 = new Form2();
            form2.Show();
            this.Hide();
        }
    }
}
