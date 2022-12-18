using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Data.SqlClient;
using System.Windows.Forms;

namespace 宿舍管理评分系统
{
    public partial class Form5 : Form
    {
        private string strconn = "server=DESKTOP-F8GIGHJ;database=Dorm;Trusted_Connection=SSPI";
        public Form5()
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
        private void Form5_Load(object sender, EventArgs e)
        {

            listBox1.Items.Add("宿舍号\t1号床学号\t1号床姓名\t2号床学号\t2号床姓名\t3号床学号\t3号床姓名\t4号床学号\t4号床姓名");
            string sql = "SELECT d.dormitory,d.no1,s1.name,d.no2,s2.name,d.no3,s3.name,d.no4,s4.name FROM [dbo].[dormitorys] d " +
                "left join [dbo].[students] s1 on d.no1 = s1.number " +
                "left join [dbo].[students] s2 on d.no2 = s2.number " +
                "left join [dbo].[students] s3 on d.no3 = s3.number " +
                "left join [dbo].[students] s4 on d.no4 = s4.number ";
            DataTable dataTable = ExecuteQuery(sql);
            if (dataTable != null)
            {
                //打印每一行的数据
                foreach (DataRow row in dataTable.Rows)
                {
                    string columnStr = string.Empty;
                    columnStr = columnStr + row[0] + "";
                    columnStr += "\t";

                    columnStr = columnStr + row[1] + "";
                    columnStr += "\t\t";
                    if (int.Parse(row[1] + "") == 0)
                    {
                        row[2] = "无";
                    }
                    columnStr += (string)row[2];
                    columnStr += "\t";

                    columnStr = columnStr + row[3] + "";
                    columnStr += "\t\t";
                    if (int.Parse(row[3] + "") == 0)
                    {
                        row[4] = "无";
                    }
                    columnStr += (string)row[4];
                    columnStr += "\t";

                    columnStr = columnStr + row[5] + "";
                    columnStr += "\t\t";
                    if (int.Parse(row[5] + "") == 0) {
                        row[6] = "无";
                    }

                    columnStr += (string)row[6];
                    columnStr += "\t\t";

                    columnStr = columnStr + row[7] + "";
                    columnStr += "\t\t";
                    if (int.Parse(row[7] + "") == 0)
                    {
                        row[8] = "无";
                    }
                    columnStr += (string)row[8];
                    listBox1.Items.Add(columnStr);
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Form2 form2 = new Form2();
            form2.Show();
            this.Hide();
        }
    }
}
