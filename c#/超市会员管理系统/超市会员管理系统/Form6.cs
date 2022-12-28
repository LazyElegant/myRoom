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

namespace 超市会员管理系统
{
    public partial class Form6 : Form
    {
        private string strconn = "server=DESKTOP-F8GIGHJ;database=SupermarketMember;Trusted_Connection=SSPI";
        public Form6()
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
        private void Form6_Load(object sender, EventArgs e)
        {
            listBox1.Items.Add("\t用户名\t\t密码");
            string sql = "SELECT name,password FROM [dbo].[counter]";
            DataTable dataTable = ExecuteQuery(sql);
            if (dataTable != null)
            {
                //打印每一行的数据
                foreach (DataRow row in dataTable.Rows)
                {
                    listBox1.Items.Add("\t"+(string)row[0] +"\t" + (string)row[1]);
                }
            }

        }
    }
}
