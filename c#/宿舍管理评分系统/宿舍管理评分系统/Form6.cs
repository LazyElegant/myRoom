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

namespace 宿舍管理评分系统
{
    public partial class Form6 : Form
    {
        private string strconn = "server=DESKTOP-F8GIGHJ;database=Dorm;Trusted_Connection=SSPI";
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

        private void button2_Click(object sender, EventArgs e)
        {
            Form2 form2 = new Form2();
            form2.Show();
            this.Hide();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int sum = 0;
            float bedScroe = float.Parse(textBox1.Text) /100  * 40;
            float sanitationScroe = float.Parse(textBox2.Text) /100 * 30;
            float disciplineScroe = float.Parse(textBox3.Text) / 100 * 40;
            sum = (int)bedScroe + (int)sanitationScroe + (int)disciplineScroe;

            string sql = "insert into [dbo].[dormScroe] (dorm,bedScroe,sanitationScroe,disciplineScroe,scroe) values(" + comboBox1.Text + "," + textBox1.Text + "," + textBox2.Text + "," + textBox3.Text + "," + sum +")";
            int re = ExecuteNonQuery(sql);
            if (re > 0)
            {
                MessageBox.Show("添加成功");
                textBox1.Text = "";
                textBox2.Text = "";
                textBox3.Text = "";
            }
        }

        private void Form6_Load(object sender, EventArgs e)
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
    }
}
