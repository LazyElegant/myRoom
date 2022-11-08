<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="login.aspx.cs" Inherits="动物世界购物网站.login" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <style type="text/css">
        a {
            color:black;
            text-decoration:none;
        }
        span{
            color:red;
        }
        .auto-style2 {
            width: 348px;
        }
        .auto-style3 {
            width: 278px;
        }
        .auto-style4 {
            width: 210px;
        }
        .auto-style5 {
            width: 210px;
            height: 25px;
        }
        .auto-style6 {
            width: 210px;
            height: 32px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h3 style="text-align:center">用户登录</h3>
        </div>
            <table style="width:650px;margin :0 auto;">
                <tr>
                    <td class="auto-style4"><label>用户名:</label></td>
                    <td class="auto-style3"><asp:TextBox ID="username" runat="server" Width="239px" Height="19px" ></asp:TextBox>*</td>
                    <td class="auto-style2"><asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="username" ErrorMessage="用户名不能为空" SetFocusOnError="True" Display="Dynamic"></asp:RequiredFieldValidator></td>
                </tr>
                <tr>
                    <td class="auto-style4"><label>密码:</label></td>
                    <td class="auto-style3"><asp:TextBox ID="password1" runat="server" Width="239px" Height="19px"  TextMode="Password" ></asp:TextBox>*</td>
                    <td class="auto-style2"><asp:RequiredFieldValidator ID="RequiredFieldValidator2" runat="server" ControlToValidate="password1" ErrorMessage="密码不能为空" SetFocusOnError="True" Display="Dynamic"></asp:RequiredFieldValidator></td>
                </tr>
                <tr>
                    <td></td>
                    <td  style="text-align:center"><asp:Button style="background-color:gold; height: 27px;" ID="Button1" runat="server" Text="登录" Width="98px" OnClick="Button1_Click" /></td>
                </tr>
                <tr>
                    <td class="auto-style5"> <asp:CheckBox runat="server" ID="remember" Text="记住我" /> </td>
                    <td colspan="2" rowspan="2" style="text-align:center"><asp:Label ID="Msg" runat="server" Text=""></asp:Label></td>
                </tr>
                <tr>
                    <td class="auto-style6">  <a href="reg.aspx" style="font-size:16px">还没有注册用户？</a></td>
                </tr>

                </table>
    </form>
</body>
</html>
