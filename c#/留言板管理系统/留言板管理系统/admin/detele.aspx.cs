using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace 留言板管理系统.admin
{
    public partial class detele : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

            DBClass db = new DBClass();
            string sql = "DELETE FROM [dbo].[gbook] where id = '" + Request.QueryString["id"] + "'";

            int re = db.ExecuteNonQuery(sql);
            if (re > 0)
            {
                Response.Write("<script languge='javascript'>alert('删除成功');" +
                    "window.location.href='Gbook.aspx'</script>");
            }
        }
    }
}