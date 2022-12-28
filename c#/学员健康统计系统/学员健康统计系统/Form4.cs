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
    public partial class Form4 : Form
    {

        private string strconn = "server=DESKTOP-F8GIGHJ;database=health;Trusted_Connection=SSPI";
        public Form4()
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
        private void Form4_Load(object sender, EventArgs e)
        {

            listBox1.Items.Add("班级名称\t\t类别\t\t专业");

            string sql = "SELECT * FROM [dbo].[class]";
            DataTable dataTable = ExecuteQuery(sql);
            if (dataTable != null)
            {
                //打印每一行的数据
                foreach (DataRow row in dataTable.Rows)
                {
                    listBox1.Items.Add((string)row[1] + "\t\t" + (string)row[2] + "\t" + (string)row[3]);
                }
            }

        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

            string sql = "SELECT * FROM [dbo].[class]";
            DataTable dataTable = ExecuteQuery(sql);
            if (listBox1.SelectedIndex > 0)
            {
                DataRow row = dataTable.Rows[listBox1.SelectedIndex - 1];
                textBox4.Text = row[0] + "";
                textBox1.Text = (string)row[1];
                textBox2.Text = (string)row[2];
                textBox3.Text = (string)row[3];
            }
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
            if (listBox1.SelectedIndex > 0)
            {

                String sql = "update [dbo].[class] set name ='" + textBox1.Text + "', classify='" + textBox2.Text + "', majoy='" + textBox3.Text + "' where id = " + textBox4.Text;
                int re = ExecuteNonQuery(sql);
                if (re > 0)
                {
                    MessageBox.Show("修改成功");
                    textBox1.Text = "";
                    textBox2.Text = "";
                    textBox3.Text = "";
                    textBox4.Text = "";
                    listBox1.Items.Clear();
                    listBox1.Items.Add("班级名称\t\t类别\t\t专业");

                    sql = "SELECT * FROM [dbo].[class]";
                    DataTable dataTable = ExecuteQuery(sql);
                    if (dataTable != null)
                    {
                        //打印每一行的数据
                        foreach (DataRow row in dataTable.Rows)
                        {
                            listBox1.Items.Add((string)row[1] + "\t\t" + (string)row[2] + "\t" + (string)row[3]);
                        }
                    }
                }
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (listBox1.SelectedIndex > 0)
            {

                String sql = "Delete [dbo].[class] where id = " + textBox4.Text;
                int re = ExecuteNonQuery(sql);
                if (re > 0)
                {
                    MessageBox.Show("删除成功");
                    textBox1.Text = "";
                    textBox2.Text = "";
                    textBox3.Text = "";
                    textBox4.Text = "";
                    listBox1.Items.Clear();
                    listBox1.Items.Add("班级名称\t\t类别\t\t专业");

                    sql = "SELECT * FROM [dbo].[class]";
                    DataTable dataTable = ExecuteQuery(sql);
                    if (dataTable != null)
                    {
                        //打印每一行的数据
                        foreach (DataRow row in dataTable.Rows)
                        {
                            listBox1.Items.Add((string)row[1] + "\t\t" + (string)row[2] + "\t" + (string)row[3]);
                        }
                    }
                }
            }
        }
    }
}
