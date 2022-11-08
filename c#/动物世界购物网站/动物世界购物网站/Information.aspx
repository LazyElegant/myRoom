<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Information.aspx.cs" Inherits="动物世界购物网站.Information" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <style>
        .title {
            background-color:navy;
            color:white;
            height:30px;
            line-height:30px;
            font-weight:900;
        }
        table tr {
            height:35px;
        }
        .auto-style1 {
            width: 500px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <div class="title"> <b style="margin-left:20px;">个人资料</b></div>

            <table style="margin:20px auto;" class="auto-style1">
                <tr>
                    <td colspan="2" style="font-weight:700;">个人信息</td>
                </tr>
                <tr>
                    <td colspan="2">
                        用户名: <%=Session["username"].ToString()%>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">姓名</td>
                </tr>
                <tr>
                    <td colspan="2"><asp:TextBox runat="server" ID="Cname"></asp:TextBox></td>
                </tr>
                <tr>
                    <td>国家</td><td>省</td>
                </tr>
                <tr>
                    <td><asp:TextBox runat="server" ID="Country"></asp:TextBox></td>
                    <td><asp:TextBox runat="server" ID="Province"></asp:TextBox></td>
                </tr>
                <tr>
                    <td>城市</td><td>邮编</td>
                </tr>
                <tr>
                    <td><asp:TextBox runat="server" ID="City"></asp:TextBox></td>
                    <td><asp:TextBox Width="80px" runat="server" ID="Zip"></asp:TextBox></td>
                </tr>
                <tr>
                    <td colspan="2">地址</td>
                </tr>
                <tr>
                    <td colspan="2"><asp:TextBox Width="425px" runat="server" ID="Address"></asp:TextBox></td>
                </tr>
                <tr>
                    <td colspan="2">电话号码</td>
                </tr>
                <tr>
                    <td colspan="2"><asp:TextBox runat="server" ID="Phone"></asp:TextBox></td>
                </tr>
                <tr>
                    <td colspan="2">Email</td>
                </tr>
                <tr>
                    <td colspan="2"><asp:TextBox Width="425px" runat="server" ID="Email"></asp:TextBox></td>
                </tr>
                
                <tr>
                    <td colspan="2" style="text-align:right"><asp:Button runat="server" style="margin-right:67px" Text="更新" BackColor="#ff9900" OnClick="Unnamed1_Click" /></td>
                </tr>

            </table>
        </div>
    </form>
</body>
</html>
