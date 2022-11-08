<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="reg.aspx.cs" Inherits="动物世界购物网站.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <style>
        span{
            color:red;
        }
        .auto-style1 {
            width: 93px;
        }
        .auto-style2 {
            width: 252px;
        }
        .auto-style3 {
            width: 259px;
        }
    </style>
    <script>
        

    </script>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h3 style="text-align:center">注册新用户</h3>
            <table style="width:650px;margin :0 auto;">
                <tr>
                    <td class="auto-style1"><label>用户名:</label></td>
                    <td class="auto-style3"><asp:TextBox ID="username" runat="server" Width="239px" Height="19px" ></asp:TextBox>*</td>
                    <td class="auto-style2"><asp:RequiredFieldValidator ID="RequiredFieldValidator1" runat="server" ControlToValidate="username" ErrorMessage="用户名不能为空" SetFocusOnError="True" Display="Dynamic"></asp:RequiredFieldValidator></td>
                </tr>
                <tr>
                    <td class="auto-style1"><label>密码:</label></td>
                    <td class="auto-style3"><asp:TextBox ID="password1" runat="server" Width="239px" Height="19px"  TextMode="Password" ></asp:TextBox>*</td>
                    <td class="auto-style2"></td>
                </tr>
                <tr>
                    <td class="auto-style1"><label>确认密码:</label></td>
                    <td class="auto-style3"><asp:TextBox ID="password2" runat="server" Width="239px" Height="19px"  TextMode="Password" ></asp:TextBox>*</td>
                    <td class="auto-style2"><asp:CompareValidator ID="CompareValidator1" runat="server" ControlToCompare="password1" ControlToValidate="password2" ErrorMessage="确定密码与密码不一致" SetFocusOnError="True" Display="Dynamic"></asp:CompareValidator></td>
                </tr>
                <tr>
                    <td></td>
                    <td style="text-align:center"><asp:Button style="background-color:gold" ID="Button1" runat="server" Text="注册" Width="98px" OnClick="Button1_Click" /></td>
                </tr>
                <tr>
                    <td colspan="3" style="text-align:center"><asp:Label ID="Msg" runat="server" Text=""></asp:Label></td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
