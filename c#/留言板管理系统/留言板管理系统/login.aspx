<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="login.aspx.cs" Inherits="留言板管理系统.login" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h1>登录</h1>
            <asp:Label CssClass="label" ID="Label1" runat="server" Text="用户名"></asp:Label>
            <asp:TextBox ID="TextBox1" runat="server" AutoPostBack="true" OnTextChanged="TextBox1_TextChanged"></asp:TextBox>
            <asp:Label ID="Label3" runat="server" Text="" ForeColor="Red"></asp:Label>
            <br />
            <asp:Label CssClass="label" ID="Label2" runat="server" Text="密码"></asp:Label>
         
            <asp:TextBox TextMode="Password" ID="TextBox2" runat="server" CssClass="auto-style1" AutoPostBack="true" OnTextChanged="TextBox2_TextChanged" ></asp:TextBox>
            <asp:Label ID="Label4" runat="server" Text="" ForeColor="Red"></asp:Label>
            <br />
            <asp:Button ID="Button1" runat="server" Text="登录" OnClick="Button1_Click" />

            
        </div>
    </form>
</body>
</html>
