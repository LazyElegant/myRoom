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
    public partial class Form8 : Form
    {
        public Form8()
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
        private void Form8_Load(object sender, EventArgs e)
        {
            listBox1.Items.Add("房号\t客人姓名\t入住日期\t\t预计退房日期\t\t入住物品");
            string sql = "SELECT c.id,c.room,g.name,c.start_date,c.end_date,c.script FROM [dbo].[check] c " +
                "left join guest g on g.id = c.guest_id where state = 0";
            DataTable dataTable = ExecuteQuery(sql);
            if (dataTable != null)
            {
                foreach (DataRow row in dataTable.Rows)
                {
                    string columnStr = string.Empty;

                    columnStr = columnStr + row[1] + "";
                    columnStr += "\t";
                    columnStr = columnStr + row[2] + "";
                    columnStr += "\t\t";
                    columnStr = columnStr + row[3] + "";
                    columnStr += "\t";
                    columnStr = columnStr + row[4] + "";
                    columnStr += "\t";
                    columnStr = columnStr + row[5] + "";
                    listBox1.Items.Add(columnStr);
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            String sql = "update [dbo].[check]  Set end_script='" + textBox1.Text + "',end_date= '" + DateTime.Now.ToLongDateString().ToString() + "',state=1  where id=" + textBox3.Text;
            int re = ExecuteNonQuery(sql);
            if (re > 0)
            {
                MessageBox.Show("退房成功");
                textBox1.Text = "";
                textBox2.Text = "";
                textBox3.Text = "";
                listBox1.Items.Clear();
                listBox1.Items.Add("房号\t客人姓名\t入住日期\t\t预计退房日期\t\t入住物品");
                 sql = "SELECT c.id,c.room,g.name,c.start_date,c.end_date,c.script FROM [dbo].[check] c " +
                    "left join guest g on g.id = c.guest_id where state = 0";
                DataTable dataTable = ExecuteQuery(sql);
                if (dataTable != null)
                {
                    foreach (DataRow row in dataTable.Rows)
                    {
                        string columnStr = string.Empty;

                        columnStr = columnStr + row[1] + "";
                        columnStr += "\t";
                        columnStr = columnStr + row[2] + "";
                        columnStr += "\t\t";
                        columnStr = columnStr + row[3] + "";
                        columnStr += "\t";
                        columnStr = columnStr + row[4] + "";
                        columnStr += "\t";
                        columnStr = columnStr + row[5] + "";
                        listBox1.Items.Add(columnStr);
                    }
                }
            }
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            string sql = "SELECT c.id,c.room,g.name,c.start_date,c.end_date,c.script FROM [dbo].[check] c " +
                "left join guest g on g.id = c.guest_id where state = 0";
            DataTable dataTable = ExecuteQuery(sql);
            if (listBox1.SelectedIndex > 0)
            {
                DataRow row = dataTable.Rows[listBox1.SelectedIndex - 1];
                textBox2.Text = row[1] + "";
                textBox3.Text = row[0] + "";
            }
        }
    }
}
