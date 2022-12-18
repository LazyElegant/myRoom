<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="modi.aspx.cs" Inherits="留言板管理系统.modi" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h1>留言板</h1>
            <asp:Label ID="Label1" runat="server" CssClass="topLab" Text="<a href='personal.aspx'>返回</a>"></asp:Label>
            <asp:Label ID="Label2" runat="server" CssClass="topLab" Text="<a href='loginout.aspx'>注销</a>"></asp:Label>
            
        </div>
        <div>
            请修改个人信息：
            <br />
            用户名：<asp:Label ID="Label3" runat="server" CssClass="topLab" Text="<a href='personal.aspx'>返回</a>"></asp:Label>
            <br />
            密码： <asp:TextBox ID="TextBox1" runat="server" Enabled="false"></asp:TextBox>
            <br />
            修改密码： <asp:TextBox TextMode="Password" ID="TextBox2" runat="server"></asp:TextBox>
            <br />
            再输一次： <asp:TextBox TextMode="Password" ID="TextBox3" runat="server"></asp:TextBox>
            <br />
            性别：

            <asp:DropDownList ID="DropDownList1" runat="server">
                <asp:ListItem>男</asp:ListItem>
                <asp:ListItem>女</asp:ListItem>
            </asp:DropDownList>
            <br />
            QQ：<asp:TextBox ID="TextBox4" AutoPostBack="true" runat="server"></asp:TextBox>
            <br />
            个性签名：<asp:TextBox TextMode="MultiLine" ID="TextBox5" runat="server"></asp:TextBox>
            <br />
            备注：<asp:TextBox TextMode="MultiLine" ID="TextBox6" runat="server"></asp:TextBox>
            <br />
            <asp:Button ID="Button1" runat="server" Text="提交修改" OnClick="Button1_Click" />
        </div>
    </form>
</body>
</html>
