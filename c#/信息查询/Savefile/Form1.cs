using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.IO;
using System.Windows.Forms;
using System.Data.OleDb;

namespace Savefile
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        private void button1_Click_1(object sender, EventArgs e)
        {
            String constr = Properties.Settings.Default.stu_db1ConnectionString;
            OleDbConnection conn = new OleDbConnection("Provider=Microsoft.Jet.OLEDB.4.0;Data Source=stu_db1.mdb");
            OleDbCommand comm = conn.CreateCommand();
            conn.Open();

            comm.CommandText = "Select * from student22";
            OleDbDataReader read = comm.ExecuteReader();

            while (read.Read())
            {
                if (textBox1.Text.Equals(read[1].ToString())) {
                    textBox2.Text = read[2].ToString();
                    textBox3.Text = read[3].ToString();
                }
            }
        }

        private void button2_Click(object sender, EventArgs e)
        {
            String constr = Properties.Settings.Default.stu_db1ConnectionString;
            OleDbConnection conn = new OleDbConnection("Provider=Microsoft.Jet.OLEDB.4.0;Data Source=stu_db1.mdb");
            OleDbCommand comm = conn.CreateCommand();
            conn.Open();

            comm.CommandText = "Select * from student22";
            OleDbDataReader read = comm.ExecuteReader();
            listBox1.Items.Clear();
            while (read.Read())
            {
                if (textBox4.Text.Equals(read[3].ToString()))
                {
                    listBox1.Items.Add(read[2].ToString());
                }
            }
        }

    }
}