<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="reply.aspx.cs" Inherits="留言板管理系统.admin.reply" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            回复留言：
            <br />
            <asp:TextBox TextMode="MultiLine" ID="TextBox1" runat="server" Height="129px" Width="928px"></asp:TextBox>
            <br />

            <asp:Button ID="Button1" runat="server" Text="回复留言" OnClick="Button1_Click" />
        </div>
    </form>
</body>
</html>
