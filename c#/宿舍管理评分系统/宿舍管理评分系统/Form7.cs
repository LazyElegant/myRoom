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
    public partial class Form7 : Form
    {
        private string strconn = "server=DESKTOP-F8GIGHJ;database=Dorm;Trusted_Connection=SSPI";
        public Form7()
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
        private void Form7_Load(object sender, EventArgs e)
        {

            listBox1.Items.Add("宿舍号\t就寝分数\t卫生分数\t纪律分数\t总分数");
            string sql = "SELECT dorm,bedScroe,sanitationScroe,disciplineScroe,scroe FROM [dbo].[dormScroe]";
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
                    columnStr = columnStr + row[2] + "";
                    columnStr += "\t\t";

                    columnStr = columnStr + row[3] + "";
                    columnStr += "\t\t";
                    columnStr = columnStr + row[4] + "";
                    columnStr += "\t";
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
