﻿using System;
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
    public partial class Form1 : Form
    {
        private string strconn = "server=DESKTOP-F8GIGHJ;database=Supermarket;Trusted_Connection=SSPI";

        public static string name = "";
        public Form1()
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
        private void button1_Click(object sender, EventArgs e)
        {
            string sql = "SELECT name,password FROM [dbo].[Users] where name = '" + textBox1.Text + "'";
            DataTable dataTable = ExecuteQuery(sql);
            if (dataTable != null)
            {
                string columnStr = string.Empty;
                //打印每一行的数据
                foreach (DataRow row in dataTable.Rows)
                {
                    String password  = (string)row[1];
                    if (textBox2.Text.Equals(password.Trim()))
                    {
                        MessageBox.Show("登录成功");
                        name = textBox1.Text;
                        this.Hide();
                        Form3 form3 = new Form3();
                        form3.Show();

                    }
                    else
                    {
                        MessageBox.Show("登录失败");
                    }
                }
            }

        }

        private void button2_Click(object sender, EventArgs e)
        {
            this.Hide();
            Form2 form2 = new Form2();
            form2.Show();
        }
    }
}
