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
    public partial class Form7 : Form
    {
        public Form7()
        {
            InitializeComponent();
        }

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

        private void Form7_Load(object sender, EventArgs e)
        {

            comboBox1.Items.Add("男");
            comboBox1.Items.Add("女");
            string sql = "SELECT name FROM [dbo].[class]";
            DataTable dataTable = ExecuteQuery(sql);
            if (dataTable != null)
            {
                //打印每一行的数据
                foreach (DataRow row in dataTable.Rows)
                {
                    comboBox2.Items.Add((string)row[0]);
                }
            }

            listBox1.Items.Add("身份证号\t\t姓名\t\t性别\t\t班级\t\t来源地");

            sql = "SELECT s.number,s.name,s.sex,c.name,s.source,s.password FROM [dbo].[student] s " +
                "left join  [dbo].[class] c on s.class_id = c.id";
            dataTable = ExecuteQuery(sql);
            if (dataTable != null)
            {
                //打印每一行的数据
                foreach (DataRow row in dataTable.Rows)
                {
                    listBox1.Items.Add((string)row[0] + "\t" + (string)row[1] + "\t" + (string)row[2] + "\t" + (string)row[3] + "\t" + (string)row[4] );
                }
            }
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            string sql = "SELECT s.id,s.number,s.name,s.source FROM [dbo].[student] s ";
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

        private void button1_Click(object sender, EventArgs e)
        {

            string sql = "SELECT id FROM [dbo].[class] where name = '" + comboBox2.Text + "'";
            DataTable dataTable = ExecuteQuery(sql);
            DataRow row2 = dataTable.Rows[0];
            int id = (int)row2[0];

            if (listBox1.SelectedIndex > 0)
            {

                sql = "update [dbo].[student] set number ='" + textBox1.Text + "', name='" + textBox2.Text + "', source='" + textBox3.Text + "', sex='"+comboBox1.Text+"', class_id="+id+"  where id = " + textBox4.Text;
                int re = ExecuteNonQuery(sql);
                if (re > 0)
                {
                    MessageBox.Show("修改成功");
                    textBox1.Text = "";
                    textBox2.Text = "";
                    textBox3.Text = "";
                    textBox4.Text = "";
                }
            }
            listBox1.Items.Clear();
            listBox1.Items.Add("身份证号\t\t姓名\t\t性别\t\t班级\t\t来源地");

            sql = "SELECT s.number,s.name,s.sex,c.name,s.source,s.password FROM [dbo].[student] s " +
                "left join  [dbo].[class] c on s.class_id = c.id";
            dataTable = ExecuteQuery(sql);
            if (dataTable != null)
            {
                //打印每一行的数据
                foreach (DataRow row in dataTable.Rows)
                {
                    listBox1.Items.Add((string)row[0] + "\t" + (string)row[1] + "\t" + (string)row[2] + "\t" + (string)row[3] + "\t" + (string)row[4]);
                }
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            if (listBox1.SelectedIndex > 0)
            {

                String sql = "Delete [dbo].[student] where id = " + textBox4.Text;
                int re = ExecuteNonQuery(sql);
                if (re > 0)
                {
                    MessageBox.Show("删除成功");
                    textBox1.Text = "";
                    textBox2.Text = "";
                    textBox3.Text = "";
                    textBox4.Text = "";
                    listBox1.Items.Clear();
                    listBox1.Items.Add("身份证号\t\t姓名\t\t性别\t\t班级\t\t来源地");

                    sql = "SELECT s.number,s.name,s.sex,c.name,s.source,s.password FROM [dbo].[student] s " +
                        "left join  [dbo].[class] c on s.class_id = c.id";
                    DataTable dataTable = ExecuteQuery(sql);
                    if (dataTable != null)
                    {
                        //打印每一行的数据
                        foreach (DataRow row in dataTable.Rows)
                        {
                            listBox1.Items.Add((string)row[0] + "\t" + (string)row[1] + "\t" + (string)row[2] + "\t" + (string)row[3] + "\t" + (string)row[4]);
                        }
                    }
                }
            }
        }
    }
}
