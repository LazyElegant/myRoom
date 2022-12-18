using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace 留言板管理系统
{
    public partial class loginout : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Session["username"] = "";
            Session["userId"] = "";
            Session["admin"] = "";
            Response.Write("<script languge='javascript'>window.location.href='login.aspx'</script>");
        }
    }
}