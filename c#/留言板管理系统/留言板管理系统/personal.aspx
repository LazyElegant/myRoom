<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="personal.aspx.cs" Inherits="留言板管理系统.personal" %>

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
            <asp:Label ID="Label1" runat="server" CssClass="topLab" Text="你好"></asp:Label>
            <asp:Label ID="Label2" runat="server" CssClass="topLab" Text="留言"></asp:Label>
            <asp:Label ID="Label3" runat="server" CssClass="topLab" Text="注销"></asp:Label>
            <br />
        </div>
        <div>
            个人信息：<asp:Label ID="Label4" runat="server" CssClass="topLab" Text="你好"></asp:Label>
            <br />
            用户性别：<asp:Label ID="Label5" runat="server" CssClass="topLab" Text="你好"></asp:Label>
            <br />
            QQ：<asp:Label ID="Label6" runat="server" CssClass="topLab" Text="你好"></asp:Label>
            <br />
            个性签名：<asp:Label ID="Label7" runat="server" CssClass="topLab" Text="你好"></asp:Label>
            <br />
            用户备注：<asp:Label ID="Label8" runat="server" CssClass="topLab" Text="你好"></asp:Label>
            <br />
            留言数：<asp:Label ID="Label9" runat="server" CssClass="topLab" Text="你好"></asp:Label>
            <br />
            <a href="modi.aspx">修改资料</a>
        </div>
    </form>
</body>
</html>
