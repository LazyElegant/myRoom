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
    public partial class Form8 : Form
    {

        private string strconn = "server=DESKTOP-F8GIGHJ;database=SupermarketMember;Trusted_Connection=SSPI";

        public Form8()
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

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            string sql = "SELECT * FROM [dbo].[card]";
            DataTable dataTable = ExecuteQuery(sql);
            if (listBox1.SelectedIndex > 0) {
                DataRow row = dataTable.Rows[listBox1.SelectedIndex - 1];
                textBox6.Text = row[0] + "";
                textBox1.Text = (string)row[1];
                textBox2.Text = (string)row[2];
                textBox3.Text = row[3] + "";
                textBox4.Text = (string)row[5];
                textBox5.Text = (string)row[6];
            }

        }

        private void Form8_Load(object sender, EventArgs e)
        {
            listBox1.Items.Add("用户名\t\t卡号\t\t积分余额\t\t日期\t\t电话号码\t\t地址");

            string sql = "SELECT * FROM [dbo].[card]";
            DataTable dataTable = ExecuteQuery(sql);
            if (dataTable != null)
            {
                //打印每一行的数据
                foreach (DataRow row in dataTable.Rows)
                {
                    listBox1.Items.Add( (string)row[1] + "\t" + (string)row[2] + "\t" + row[3] + "\t\t" + (string)row[4] + "\t" + (string)row[5] + "\t" + (string)row[6]);
                }
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
        private void button2_Click(object sender, EventArgs e)
        {

            if (listBox1.SelectedIndex > 0)
            {

                String sql = "Delete [dbo].[card] where id = " + textBox6.Text;
                int re = ExecuteNonQuery(sql);
                if (re > 0)
                {
                    MessageBox.Show("删除成功");
                    textBox1.Text = "";
                    textBox2.Text = "";
                    textBox3.Text = "";
                    textBox4.Text = "";
                    textBox5.Text = "";
                    textBox6.Text = "";
                    listBox1.Items.Clear();
                    listBox1.Items.Add("用户名\t\t卡号\t\t积分余额\t\t日期\t\t电话号码\t\t地址");

                    sql = "SELECT * FROM [dbo].[card]";
                    DataTable dataTable = ExecuteQuery(sql);
                    if (dataTable != null)
                    {
                        //打印每一行的数据
                        foreach (DataRow row in dataTable.Rows)
                        {
                            listBox1.Items.Add((string)row[1] + "\t" + (string)row[2] + "\t" + row[3] + "\t\t" + (string)row[4] + "\t" + (string)row[5] + "\t" + (string)row[6]);
                        }
                    }
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if (listBox1.SelectedIndex > 0)
            {

                String sql = "update [dbo].[card] set name ='"+textBox1.Text+ "', number='" + textBox2.Text + "', points='" + textBox3.Text + "', phone='" + textBox4.Text + "', address='" + textBox5.Text + "' where id = " + textBox6.Text;
                int re = ExecuteNonQuery(sql);
                if (re > 0)
                {
                    MessageBox.Show("修改成功");
                    textBox1.Text = "";
                    textBox2.Text = "";
                    textBox3.Text = "";
                    textBox4.Text = "";
                    textBox5.Text = "";
                    textBox6.Text = "";
                    listBox1.Items.Clear();
                    listBox1.Items.Add("用户名\t\t卡号\t\t积分余额\t\t日期\t\t电话号码\t\t地址");

                    sql = "SELECT * FROM [dbo].[card]";
                    DataTable dataTable = ExecuteQuery(sql);
                    if (dataTable != null)
                    {
                        //打印每一行的数据
                        foreach (DataRow row in dataTable.Rows)
                        {
                            listBox1.Items.Add((string)row[1] + "\t" + (string)row[2] + "\t" + row[3] + "\t\t" + (string)row[4] + "\t" + (string)row[5] + "\t" + (string)row[6]);
                        }
                    }
                }
            }
        }
    }
}
