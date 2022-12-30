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
    public partial class Form9 : Form
    {
        public Form9()
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
            Form2 form = new Form2();
            form.Show();
            this.Hide();
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void Form9_Load(object sender, EventArgs e)
        {
            listBox1.Items.Add("房号\t客人姓名\t入住日期\t\t退房日期\t\t入住物品\t\t遗留物品\t\t房间情况");
            string sql = "SELECT c.id,c.room,g.name,c.start_date,c.end_date,c.script,c.end_script,c.state FROM [dbo].[check] c " +
                "left join guest g on g.id = c.guest_id";
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
                    columnStr = columnStr + row[6] + "";
                    if (row[7] + "" == "1")
                    {
                        columnStr = columnStr + "已退房";
                    }
                    else
                    {
                        columnStr = columnStr + "使用中";
                    }
                    listBox1.Items.Add(columnStr);
                }
            }
        }
    }
}
