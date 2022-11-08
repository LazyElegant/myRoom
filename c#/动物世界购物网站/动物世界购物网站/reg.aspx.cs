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
    public partial class WebForm1 : System.Web.UI.Page
    {

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
            Boolean flag = true;
            for (int i = 0; i < DS.Tables[0].Rows.Count; i++) {
                object[] row = DS.Tables[0].Rows[i].ItemArray;
                if (row[0].Equals(username.Text)) {
                    flag = false;
                    Msg.Text = "用户名重复请重新输入";
                    break;
                }
            }
            if (flag)
            {
                conn = new SqlConnection(con);
                sql = "insert into Account  (UserName,Password)  values ('" + username.Text + "','" + password1.Text + "') ";
                SqlCommand cmd = new SqlCommand(sql, conn);
                try
                {
                    conn.Open();
                    cmd.ExecuteNonQuery();
                    Response.Write("<script type='text/javascript'>alert('注册成功');</script>");
                    Server.Transfer("login.aspx", true);
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
}