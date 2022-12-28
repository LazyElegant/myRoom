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
    public partial class Form6 : Form
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
        public Form6()
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


        private void button1_Click(object sender, EventArgs e)
        {
            string sql = "SELECT id FROM [dbo].[class] where name = '" + comboBox2.Text +"'";
            DataTable dataTable = ExecuteQuery(sql);
            DataRow row =  dataTable.Rows[0];
            int id = (int)row[0];

            sql = "insert into [dbo].[student](number,name,sex,class_id,source,password) values ('" + textBox1.Text.Trim() + "','" + textBox2.Text.Trim() + "','" + comboBox1.Text + "',"+id+",'" + textBox3.Text.Trim() + "','" + textBox4.Text.Trim() + "')";
            int count = ExecuteNonQuery(sql);
            if (count > 0)
            {
                MessageBox.Show("添加成功");
                textBox1.Text = "";
                textBox2.Text = "";
                textBox3.Text = "";
                textBox4.Text = "";
            }
        }

        private void Form6_Load(object sender, EventArgs e)
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


        }
    }
}
