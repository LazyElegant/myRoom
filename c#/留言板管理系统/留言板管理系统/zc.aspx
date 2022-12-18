<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="zc.aspx.cs" Inherits="留言板管理系统.WebForm1" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>注册</title>
    <style type="text/css">
        .auto-style1 {
            margin-bottom: 0px;
        }
    </style>
    <link href="index.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <form id="form1" runat="server">
        <h1>欢迎注册留言板</h1>
        <div>
            <asp:Label CssClass="label" ID="Label1" runat="server" Text="用户名"></asp:Label>
            <asp:TextBox ID="TextBox1" runat="server" AutoPostBack="true" OnTextChanged="TextBox1_TextChanged"></asp:TextBox>
            <asp:Label ID="Label3" runat="server" Text="" ForeColor="Red"></asp:Label>
            <br />
            <asp:Label CssClass="label" ID="Label2" runat="server" Text="密码"></asp:Label>
         
            <asp:TextBox TextMode="Password" ID="TextBox2" runat="server" CssClass="auto-style1" AutoPostBack="true" OnTextChanged="TextBox2_TextChanged" ></asp:TextBox>
            <asp:Label ID="Label4" runat="server" Text="" ForeColor="Red"></asp:Label>
            <br />
            <asp:Label CssClass="label" ID="Label5" runat="server" Text="性别"></asp:Label>

            <asp:DropDownList ID="DropDownList1" runat="server">
                <asp:ListItem>男</asp:ListItem>
                <asp:ListItem>女</asp:ListItem>
            </asp:DropDownList>
            <br />
            <asp:Label CssClass="label" ID="Label6" runat="server" Text="QQ"></asp:Label>
            <asp:TextBox ID="TextBox3" runat="server" CssClass="auto-style1" ></asp:TextBox>
            <br />
            <asp:Label CssClass="label" ID="Label7" runat="server" Text="个性签名"></asp:Label>
            <asp:TextBox ID="TextBox4" runat="server" CssClass="auto-style1" TextMode="MultiLine" ></asp:TextBox>
            <br />
            <asp:Label CssClass="label" ID="Label8" runat="server" Text="备注"></asp:Label>
            <asp:TextBox ID="TextBox5" runat="server" CssClass="auto-style1" TextMode="MultiLine" ></asp:TextBox>
            <br />
            <asp:Button ID="Button1" runat="server" Text="立即注册" OnClick="Button1_Click" />




        </div>
    </form>
</body>
</html>
