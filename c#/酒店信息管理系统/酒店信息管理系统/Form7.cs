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
    public partial class Form7 : Form
    {
        public Form7()
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
        private void button1_Click(object sender, EventArgs e)
        {

            string sql = "SELECT id FROM [dbo].[check] where room = " + comboBox1.Text + " and state = 1";
            DataTable dataTable = ExecuteQuery(sql);
            if (dataTable.Rows.Count > 0)
            {
                MessageBox.Show("该房间还在使用中");
                return;
            }
            sql = "SELECT id FROM [dbo].[guest] where name = '" + comboBox2.Text + "'";
            dataTable = ExecuteQuery(sql);

            int id = (int)dataTable.Rows[0][0];
            sql = "insert into [dbo].[check] (room,guest_id,start_date,end_date,script,end_script,state) values(" + comboBox1.Text + "," + id + ",'" + DateTime.Now.ToLongDateString().ToString() + "','"+dateTimePicker1.Text+"','"+textBox1.Text+"','',0)";
            int re = ExecuteNonQuery(sql);
            if (re > 0)
            {
                MessageBox.Show("添加成功");
                textBox1.Text = "";
                comboBox1.Text = "";
                comboBox2.Text = "";
            }
        }

        private void Form7_Load(object sender, EventArgs e)
        {
            string sql = "SELECT number FROM [dbo].[room]";
            DataTable dataTable = ExecuteQuery(sql);
            if (dataTable != null)
            {
                //打印每一行的数据
                foreach (DataRow row in dataTable.Rows)
                {
                    comboBox1.Items.Add(row[0] + "");
                }
            }
            sql = "SELECT name FROM [dbo].[guest]";
            dataTable = ExecuteQuery(sql);
            if (dataTable != null)
            {
                //打印每一行的数据
                foreach (DataRow row in dataTable.Rows)
                {
                    comboBox2.Items.Add((string)row[0]);
                }
            }
        }
    }
}
