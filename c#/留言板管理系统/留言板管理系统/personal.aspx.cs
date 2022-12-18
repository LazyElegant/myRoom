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
    public partial class personal : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            Label1.Text = "你好" + Session["username"].ToString();
            Label2.Text = "<a href='Gbook.aspx'>留言</a>";
            Label3.Text = "<a href='loginout.aspx'>注销</a>";
            DBClass db = new DBClass();
            string sql = "SELECT * FROM [dbo].[register] where username = '" + Session["username"].ToString() + "'";
            DataTable dt= db.ExecuteQuery(sql);
            if (dt != null)
            {
                string columnStr = string.Empty;
                //打印每一行的数据
                foreach (DataRow row in dt.Rows)
                {
                    Label4.Text = (string)row[1];
                    Label5.Text = (string)row[3];
                    Label6.Text = (string)row[4];
                    Label7.Text = (string)row[5];
                    Label8.Text = (string)row[6];
                    sql = "SELECT count(*) FROM [dbo].[gbook] where name = '" + Session["username"].ToString() + "'";
                    dt = db.ExecuteQuery(sql);
                    Label9.Text = dt.Rows[0][0].ToString();
                }
            }


        }
    }
}