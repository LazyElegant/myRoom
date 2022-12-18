using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Data;
using System.Web.UI.WebControls;

namespace 留言板管理系统
{
    public partial class seebook : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

            Label1.Text = "你好<a href='personal.aspx'>" + Session["username"].ToString() + "</a>";
            Label2.Text = "<a href='Gbook.aspx'>留言</a>";
            Label3.Text = "<a href='loginout.aspx'>注销</a>";
            DBClass db = new DBClass();
            string sql = "SELECT id,title,time,content,reptitle,admin,reptime" +
                " FROM [dbo].[gbook] where name = '" + Session["username"].ToString()+"'";

            DataTable dataTable = db.ExecuteQuery(sql);
            int curpage = 1;
            PagedDataSource pds = new PagedDataSource();
            pds.DataSource = dataTable.DefaultView;
            pds.AllowPaging = true;
            pds.PageSize = 10;
            pds.CurrentPageIndex = curpage - 1;

            DataList1.DataSource = pds;
            DataList1.DataBind();
            


        }
    }
}