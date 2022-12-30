using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Data.SqlClient;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace 酒店信息管理系统
{
    public partial class Form4 : Form
    {

        public Form4()
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

        private void Form4_Load(object sender, EventArgs e)
        {
            listBox1.Items.Add("客房号\t\t客房价格\t客房电话");
            string sql = "SELECT * FROM [dbo].[room]";
            DataTable dataTable = ExecuteQuery(sql);
            if (dataTable != null)
            {
                foreach (DataRow row in dataTable.Rows)
                {
                    string columnStr = string.Empty;

                    columnStr = columnStr + row[1] + "";
                    columnStr += "\t\t";
                    columnStr = columnStr + row[2] + "";
                    columnStr += "\t\t";
                    columnStr = columnStr + row[3] + "";
                    listBox1.Items.Add(columnStr);
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            String sql = "update [dbo].[room]  Set price="+textBox2.Text+",phone= '"+textBox3.Text+"' where number=" + textBox1.Text ;
            int re = ExecuteNonQuery(sql);
            if (re > 0)
            {
                MessageBox.Show("修改成功");
                textBox1.Text = "";
                textBox2.Text = "";
                textBox3.Text = "";
                listBox1.Items.Clear();
                listBox1.Items.Add("客房号\t\t客房价格\t客房电话");
                sql = "SELECT * FROM [dbo].[room]";
                DataTable dataTable = ExecuteQuery(sql);
                if (dataTable != null)
                {
                    foreach (DataRow row in dataTable.Rows)
                    {
                        string columnStr = string.Empty;

                        columnStr = columnStr + row[1] + "";
                        columnStr += "\t\t";
                        columnStr = columnStr + row[2] + "";
                        columnStr += "\t\t";
                        columnStr = columnStr + row[3] + "";
                        listBox1.Items.Add(columnStr);
                    }
                }
            }
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            string sql = "SELECT * FROM [dbo].[room]";
            DataTable dataTable = ExecuteQuery(sql);
            if (listBox1.SelectedIndex > 0)
            {
                DataRow row = dataTable.Rows[listBox1.SelectedIndex - 1];
                textBox1.Text = row[1] + "";
                textBox2.Text = row[2] + "";
                textBox3.Text = (String)row[3];
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (listBox1.SelectedIndex > 0)
            {

                String sql = "Delete [dbo].[room] where number = " + textBox1.Text;
                int re = ExecuteNonQuery(sql);
                if (re > 0)
                {
                    MessageBox.Show("删除成功");
                    textBox1.Text = "";
                    textBox2.Text = "";
                    textBox3.Text = "";
                    listBox1.Items.Clear();
                    listBox1.Items.Add("客房号\t\t客房价格\t客房电话");
                     sql = "SELECT * FROM [dbo].[room]";
                    DataTable dataTable = ExecuteQuery(sql);
                    if (dataTable != null)
                    {
                        foreach (DataRow row in dataTable.Rows)
                        {
                            string columnStr = string.Empty;

                            columnStr = columnStr + row[1] + "";
                            columnStr += "\t\t";
                            columnStr = columnStr + row[2] + "";
                            columnStr += "\t\t";
                            columnStr = columnStr + row[3] + "";
                            listBox1.Items.Add(columnStr);
                        }
                    }
                }
            }
        }
    }
}
