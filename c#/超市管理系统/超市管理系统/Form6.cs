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

namespace 超市管理系统
{
    public partial class Form6 : Form
    {
        private string strconn = "server=DESKTOP-F8GIGHJ;database=Supermarket;Trusted_Connection=SSPI";
        public Form6()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            Form3 form3 = new Form3();
            form3.Show();
            this.Hide();
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
        private void Form6_Load(object sender, EventArgs e)
        {
            listBox1.Items.Add("商品名\t\t购买数量\t购买人");

            string sql = "SELECT good,count,[user] FROM [dbo].[Logs]";
            DataTable dataTable = ExecuteQuery(sql);
            if (dataTable != null)
            {
                //打印每一行的数据
                foreach (DataRow row in dataTable.Rows)
                {
                    string columnStr = string.Empty;
                    columnStr += (string)row[0];
                    columnStr += "\t";

                    columnStr = columnStr + row[1] + "";
                    columnStr += "\t\t";
                    columnStr += (string)row[2];
                    listBox1.Items.Add(columnStr);
                }
            }
        }
    }
}
