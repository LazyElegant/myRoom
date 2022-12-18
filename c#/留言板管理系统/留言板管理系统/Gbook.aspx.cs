using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Data;
using System.Web.UI.WebControls;

namespace 留言板管理系统
{
    public partial class Gbook : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            DBClass db = new DBClass();
            string sql = "SELECT id,name,title,time,content,reptitle,admin,reptime" +
                " FROM [dbo].[gbook]";

            DataTable dataTable = db.ExecuteQuery(sql);
            int curpage = 1;
            PagedDataSource pds = new PagedDataSource();
            pds.DataSource = dataTable.DefaultView;
            pds.AllowPaging = true;
            pds.PageSize = 10;
            pds.CurrentPageIndex = curpage - 1;

            DataList1.DataSource = pds;
            DataList1.DataBind();


            if (Session["username"] == null)
            {
                Panel1.Visible = false;
                Label1.Text = "<a href='login.aspx'>登录</a>";
                Label2.Text = "<a href='zc.aspx'>注册</a>";
                Label3.Text = "<a href='../admin/adminlogin.aspx'>管理员登录</a>";
            }
            else {
                Label1.Text = "你好<a href='personal.aspx'>" + Session["username"].ToString()+ "</a>";
                Label2.Text = "<a href='seebook.aspx'>查看留言</a>";
                Label3.Text = "<a href='loginout.aspx'>注销</a>";
            }
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            DBClass db = new DBClass();
            
            string sql = "insert into [dbo].[gbook] (title,name,time,[content]) values('" + 
              TextBox1.Text + "','" + Session["username"].ToString() + "','" +
              DateTime.Now.ToString("yyyy-MM-dd")+ "','" +
              TextBox2.Text+"')";
            int re = db.ExecuteNonQuery(sql);
            if (re > 0)
            {
                Response.Write("<script languge='javascript'>alert('留言成功！');</script>");
                TextBox1.Text = "";
                TextBox2.Text = "";
            }
        }
    }
}