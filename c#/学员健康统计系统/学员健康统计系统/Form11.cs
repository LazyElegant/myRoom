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
    public partial class Form11 : Form
    {
        private string strconn = "server=DESKTOP-F8GIGHJ;database=health;Trusted_Connection=SSPI";

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
        public Form11()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (listBox1.SelectedIndex > 0)
            {
                String sql = "update [dbo].[health] set temperature =" + textBox1.Text + ", postscript='" + textBox2.Text + "' where id = " + textBox4.Text;
                int re = ExecuteNonQuery(sql);
                if (re > 0)
                {
                    MessageBox.Show("修改成功");
                    textBox1.Text = "";
                    textBox2.Text = "";
                    textBox4.Text = "";
                    listBox1.Items.Clear();
                    listBox1.Items.Add("学员名\t\t学员身份证号码\t\t温度\t\t来源地\t\t日期\t\t备注");

                    sql = "SELECT s.name,s.number,h.temperature,s.source,h.date,h.postscript FROM [dbo].[health] h " +
                        "left join student s on s.number = h.student_number";
                    DataTable dataTable = ExecuteQuery(sql);
                    if (dataTable != null)
                    {
                        //打印每一行的数据
                        foreach (DataRow row in dataTable.Rows)
                        {
                            String dq = (string)row[3];
                            listBox1.Items.Add((string)row[0] + "\t" + (string)row[1] + "\t" + row[2] + "\t\t" + dq.Trim() + "\t" + (string)row[4] + "\t" + (string)row[5]);

                        }
                    }

                }
            }
        }

        private void Form11_Load(object sender, EventArgs e)
        {

            listBox1.Items.Add("学员名\t\t学员身份证号码\t\t温度\t\t来源地\t\t日期\t\t备注");

            string sql = "SELECT s.name,s.number,h.temperature,s.source,h.date,h.postscript FROM [dbo].[health] h " +
                "left join student s on s.number = h.student_number";
            DataTable dataTable = ExecuteQuery(sql);
            if (dataTable != null)
            {
                //打印每一行的数据
                foreach (DataRow row in dataTable.Rows)
                {
                    String dq = "";
                    if (row[3] != null) {

                        dq = (string)row[3];
                    }

                    listBox1.Items.Add((string)row[0] + "\t" + (string)row[1] + "\t" + row[2] + "\t\t" + dq.Trim() + "\t" + (string)row[4] + "\t" + (string)row[5]);
                    
                }
            }
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            string sql = "SELECT h.id,h.temperature,h.postscript FROM [dbo].[health] h";
            DataTable dataTable = ExecuteQuery(sql);
            if (listBox1.SelectedIndex > 0)
            {
                DataRow row = dataTable.Rows[listBox1.SelectedIndex - 1];
                textBox4.Text = row[0] + "";
                textBox1.Text = row[1] + "";
                textBox2.Text = (string)row[2];
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (listBox1.SelectedIndex > 0)
            {

                String sql = "Delete [dbo].[health] where id = " + textBox4.Text;
                int re = ExecuteNonQuery(sql);
                if (re > 0)
                {
                    MessageBox.Show("删除成功");
                    textBox1.Text = "";
                    textBox2.Text = "";
                    textBox4.Text = "";
                    listBox1.Items.Clear();
                    listBox1.Items.Add("学员名\t\t学员身份证号码\t\t温度\t\t来源地\t\t日期\t\t备注");

                    sql = "SELECT s.name,s.number,h.temperature,s.source,h.date,h.postscript FROM [dbo].[health] h " +
                        "left join student s on s.number = h.student_number";
                    DataTable dataTable = ExecuteQuery(sql);
                    if (dataTable != null)
                    {
                        //打印每一行的数据
                        foreach (DataRow row in dataTable.Rows)
                        {
                            String dq = (string)row[3];
                            listBox1.Items.Add((string)row[0] + "\t" + (string)row[1] + "\t" + row[2] + "\t\t" + dq.Trim() + "\t" + (string)row[4] + "\t" + (string)row[5]);

                        }
                    }
                }
            }
        }
    }
}
