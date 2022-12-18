using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Data.SqlClient;
using System.Data;
using System.Web.UI.WebControls;

namespace 留言板管理系统
{
    public partial class WebForm1 : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            TextBox2.Attributes["value"] = TextBox2.Text;
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            DBClass db = new DBClass();
            string sql = "SELECT id FROM [dbo].[register] where username = '" + TextBox1.Text + "'";

            DataTable dataTable = db.ExecuteQuery(sql);
            if (dataTable != null && dataTable.Rows.Count==1)
            {
                Response.Write("<script languge='javascript'>alert('注册失败，用户名重复！');</script>");
                return;
            }
            sql = "insert into [dbo].[register] (username,password,sex,QQ,information,others) values('" + TextBox1.Text + "','" + TextBox2.Text + "','" +DropDownList1.Text + "','" + TextBox3.Text + "','" + TextBox4.Text + "','" + TextBox5.Text + "')";
            int re = db.ExecuteNonQuery(sql);
            if (re > 0)
            {
                Response.Write("<script languge='javascript'>alert('注册成功！');" +
                    "window.location.href='login.aspx'</script>");
            }


        }

        protected void TextBox1_TextChanged(object sender, EventArgs e)
        {
            if (TextBox1.Text == "")
            {
                Label3.Text = "用户名不能为空";
            }
            else {
                Label3.Text = "";
            }
        }

        protected void TextBox2_TextChanged(object sender, EventArgs e)
        {
            if (TextBox2.Text.Equals(""))
            {
                Label4.Text = "密码不能为空";
            }
            else
            {
                Label4.Text = "";
            }
        }
    }
}