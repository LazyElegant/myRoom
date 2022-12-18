using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Data;

namespace 留言板管理系统
{
    public partial class login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            TextBox2.Attributes["value"] = TextBox2.Text;

        }

        protected void TextBox1_TextChanged(object sender, EventArgs e)
        {
            if (TextBox1.Text == "")
            {
                Label3.Text = "用户名不能为空";
            }
            else
            {
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

        protected void Button1_Click(object sender, EventArgs e)
        {
            DBClass db = new DBClass();
            string sql = "SELECT id,username,password FROM [dbo].[register] where username = '" + TextBox1.Text + "'";

            DataTable dataTable = db.ExecuteQuery(sql);
            if (dataTable != null)
            {
                string columnStr = string.Empty;
                //打印每一行的数据
                foreach (DataRow row in dataTable.Rows)
                {
                    String password = (string)row[2];
                    if (TextBox2.Text.Equals(password.Trim()))
                    {
                        Session["username"] = TextBox1.Text;
                        Session["userId"] = (int)row[0];

                        Response.Write("<script languge='javascript'>alert('登录成功！');" +
                            "window.location.href='Gbook.aspx'</script>");
                    }
                    else
                    {

                        Response.Write("<script languge='javascript'>alert('登录失败！');" +
                            "window.location.href='login.aspx'</script>");

                    }
                }
            }

        }
    }
}