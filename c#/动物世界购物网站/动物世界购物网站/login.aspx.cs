using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Data;
using System.Collections.Specialized;


namespace 动物世界购物网站
{
    public partial class login : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
        }

        protected void Button1_Click(object sender, EventArgs e)
        {
            string con = "Server=.;Database=Animal;Trusted_Connection=SSPI";
            string sql = "Select * from Account";
            SqlConnection conn = new SqlConnection(con);
            conn.Open();
            SqlDataAdapter SDA = new SqlDataAdapter(sql, con);
            DataSet DS = new DataSet();
            SDA.Fill(DS, "Account");
            conn.Close();
            for (int i = 0; i < DS.Tables[0].Rows.Count; i++)
            {
                object[] row = DS.Tables[0].Rows[i].ItemArray;
                if (row[0].Equals(username.Text))
                {
                    if (row[1].Equals(password1.Text))
                    {
                        Session["username"] = username.Text;
                        if (remember.Checked)
                        {

                            HttpCookie cookie = new HttpCookie("username")
                            {
                                Value = username.Text,
                                Expires = DateTime.MaxValue
                            };
                            HttpContext.Current.Response.Cookies.Add(cookie);
                            cookie = new HttpCookie("password")
                            {
                                Value = password1.Text,
                                Expires = DateTime.MaxValue
                            };
                            HttpContext.Current.Response.Cookies.Add(cookie);
                        }
                        Response.Write("<script type='text/javascript'>alert('登录成功');</script>");
                        Server.Transfer("Main.aspx", true);
                    }
                    break;
                }
            }

            Msg.Text = "用户名和密码不匹配";
        }
    }
}