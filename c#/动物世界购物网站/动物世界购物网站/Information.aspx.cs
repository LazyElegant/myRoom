using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Data.SqlClient;
using System.Data;

namespace 动物世界购物网站
{
    public partial class Information : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
        }

        protected void Unnamed1_Click(object sender, EventArgs e)
        {

            string con = "Server=.;Database=Animal;Trusted_Connection=SSPI";
            SqlConnection conn = new SqlConnection(con);
            String sql = "UPDATE Account Set Cname = '" + Cname.Text + "',Country = '" + Country.Text + "',Province = '" + Province.Text + "',City = '" + City.Text + "',Address = '" + Address.Text + "',Zip = '" + Zip.Text + "',Phone = '" + Phone.Text + "',Email = '"+ Email.Text + "' Where Username ='" + Session["username"].ToString() +"'";
            SqlCommand cmd = new SqlCommand(sql, conn);
            try
            {
                conn.Open();
                cmd.ExecuteNonQuery();
                Response.Write("<script type='text/javascript'>alert('更新成功');</script>");
                Server.Transfer("Main.aspx", true);
            }
            catch (Exception ex)
            {
                throw ex;
            }
            finally
            {
                conn.Close();
            }
        }
    }
}