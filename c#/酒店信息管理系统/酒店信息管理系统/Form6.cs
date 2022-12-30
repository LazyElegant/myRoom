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

namespace 酒店信息管理系统
{
    public partial class Form6 : Form
    {
        public Form6()
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
        private void Form6_Load(object sender, EventArgs e)
        {
            listBox1.Items.Add("身份证号\t\t姓名\t\t性别\t电话号码");
            string sql = "SELECT * FROM [dbo].[guest]";
            DataTable dataTable = ExecuteQuery(sql);
            if (dataTable != null)
            {
                foreach (DataRow row in dataTable.Rows)
                {
                    string columnStr = string.Empty;

                    columnStr = columnStr + row[1] + "";
                    columnStr += "\t";
                    columnStr = columnStr + row[2] + "";
                    columnStr += "\t";
                    columnStr = columnStr + row[3] + "";
                    columnStr += "\t";
                    columnStr = columnStr + row[4] + "";
                    listBox1.Items.Add(columnStr);
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            String sql = "update [dbo].[guest]  Set number=" + textBox1.Text + ",name= '" + textBox2.Text + "',sex= '" + comboBox1.Text + "',phone= '" + textBox3.Text + "' where id=" + textBox4.Text;
            int re = ExecuteNonQuery(sql);
            if (re > 0)
            {
                MessageBox.Show("修改成功");
                textBox1.Text = "";
                textBox2.Text = "";
                comboBox1.Text = "";
                textBox3.Text = "";
                listBox1.Items.Clear();
                listBox1.Items.Add("身份证号\t\t姓名\t性别\t电话号码");
                 sql = "SELECT * FROM [dbo].[guest]";
                DataTable dataTable = ExecuteQuery(sql);
                if (dataTable != null)
                {
                    foreach (DataRow row in dataTable.Rows)
                    {
                        string columnStr = string.Empty;

                        columnStr = columnStr + row[1] + "";
                        columnStr += "\t";
                        columnStr = columnStr + row[2] + "";
                        columnStr += "\t";
                        columnStr = columnStr + row[3] + "";
                        columnStr += "\t";
                        columnStr = columnStr + row[4] + "";
                        listBox1.Items.Add(columnStr);
                    }
                }
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (listBox1.SelectedIndex > 0)
            {

                String sql = "Delete [dbo].[guest] where id = " + textBox4.Text;
                int re = ExecuteNonQuery(sql);
                if (re > 0)
                {
                    MessageBox.Show("删除成功");
                    textBox1.Text = "";
                    textBox2.Text = "";
                    textBox3.Text = "";
                    listBox1.Items.Clear();
                    listBox1.Items.Add("身份证号\t\t姓名\t性别\t电话号码");
                    sql = "SELECT * FROM [dbo].[guest]";
                    DataTable dataTable = ExecuteQuery(sql);
                    if (dataTable != null)
                    {
                        foreach (DataRow row in dataTable.Rows)
                        {
                            string columnStr = string.Empty;

                            columnStr = columnStr + row[1] + "";
                            columnStr += "\t";
                            columnStr = columnStr + row[2] + "";
                            columnStr += "\t";
                            columnStr = columnStr + row[3] + "";
                            columnStr += "\t";
                            columnStr = columnStr + row[4] + "";
                            listBox1.Items.Add(columnStr);
                        }
                    }
                }
            }
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            string sql = "SELECT * FROM [dbo].[guest]";
            DataTable dataTable = ExecuteQuery(sql);
            if (listBox1.SelectedIndex > 0)
            {
                DataRow row = dataTable.Rows[listBox1.SelectedIndex - 1];
                textBox1.Text = (String)row[1];
                textBox2.Text = (String)row[2];
                comboBox1.Text = (String)row[3];
                textBox3.Text = (String)row[4];
                textBox4.Text = row[0] + "";
            }
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }
    }
}
