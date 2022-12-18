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
    public partial class modi : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            TextBox2.Attributes["value"] = TextBox2.Text;
            DBClass db = new DBClass();
            string sql = "SELECT * FROM [dbo].[register] where username = '" + Session["username"].ToString() + "'";
            DataTable dt = db.ExecuteQuery(sql);
            if (dt != null)
            {
                string columnStr = string.Empty;
                //打印每一行的数据
                foreach (DataRow row in dt.Rows)
                {
                    if (TextBox5.Text == "")
                    {
                        Label3.Text = (string)row[1];
                        TextBox1.Text = (string)row[2];
                        DropDownList1.SelectedValue = (string)row[3];
                        TextBox4.Text = (string)row[4];
                        TextBox5.Text = (string)row[5];
                        TextBox6.Text = (string)row[6];
                    }
                }
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            if (!TextBox2.Text.Equals(TextBox3.Text)) {
                Response.Write("<script languge='javascript'>alert('修改密码与再输一次不一致');</script>");
                return;
            }
            if (TextBox2.Text.Trim()=="")
            {
                TextBox2.Text =  TextBox1.Text;
            }
            DBClass db = new DBClass();
            string sql = "UPDATE [dbo].[register] SET password = '" + TextBox2.Text.Trim() + "',sex ='" +  DropDownList1.Text.Trim() + "', QQ ='" + TextBox4.Text.Trim() + "',information ='" + TextBox5.Text.Trim() + "',others = '" + TextBox6.Text.Trim() + "'  WHERE  username ='" + Session["username"] + "'";
            int re = db.ExecuteNonQuery(sql);
            if (re > 0) {
                Response.Write("<script languge='javascript'>alert('修改成功');" +
                    "window.location.href='personal.aspx'</script>");
            }
        }
    }
}