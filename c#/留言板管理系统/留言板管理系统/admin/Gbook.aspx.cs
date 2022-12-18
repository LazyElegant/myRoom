using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data;

namespace 留言板管理系统.admin
{
    public partial class Gbook : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Label1.Text = "<a href='personal.aspx'>用户管理</a>";
            Label2.Text = "<a href='loginout.aspx'>注销</a>";
            DBClass db = new DBClass();
            string sql = "SELECT id,name,title,time,content,reptitle FROM [dbo].[gbook]";

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