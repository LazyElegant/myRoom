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

namespace 超市管理系统
{
    public partial class Form5 : Form
    {
        private string strconn = "server=DESKTOP-F8GIGHJ;database=Supermarket;Trusted_Connection=SSPI";
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
        private void Form5_Load(object sender, EventArgs e)
        {
            listBox1.Items.Add("商品名\t\t商品数量\t商品介绍\t商品价格");
            
            string sql = "SELECT name,count,content,price FROM [dbo].[Goods]";
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
                    columnStr += "\t";
                    columnStr = columnStr + row[3] + "";
                    listBox1.Items.Add(columnStr);
                }
            }
        }

        private void button1_Click(object sender, EventArgs e)
        {
            int index = listBox1.SelectedIndex;

            if (index < 1) {
                MessageBox.Show("请选择商品！！");
                return;
            }
            String str =(String) listBox1.Items[listBox1.SelectedIndex];

            string[] getAry = str.Split(new char[] { '\t' });

            int count = int.Parse(getAry[1].Trim());
            float price = float.Parse(getAry[4].Trim());

            if (int.Parse(textBox1.Text) > count)
            {
                MessageBox.Show("库存不足！！");
                return;

            }

            float sum = int.Parse(textBox1.Text) * price;
            MessageBoxButtons messButton = MessageBoxButtons.OKCancel;
            //对话框弹出
            DialogResult dr = MessageBox.Show("本次消费"+sum+"，是否立即支付？", "提示", messButton);
            if (dr == DialogResult.OK)//如果点击“确定”按钮
            {

                string sql = "insert into [dbo].[Logs](good,count,[user])   values ('" + getAry[0].Trim() + "'," + textBox1.Text + ",'" + Form1.name + "')";
                int re = ExecuteNonQuery(sql);
                if (re > 0)
                {
                    MessageBox.Show("购买成功");

                    count -= int.Parse(textBox1.Text);
                    sql = "UPDATE [dbo].[Goods] SET count = " + count + " where name = '" + getAry[0].Trim() + "'";
                    ExecuteNonQuery(sql);
                    Form3 form3 = new Form3();
                    form3.Show();
                    this.Hide();
                }
            }
            else
            {
                return;
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            Form3 form3 = new Form3();
            form3.Show();
            this.Hide();
        }
    }
}
