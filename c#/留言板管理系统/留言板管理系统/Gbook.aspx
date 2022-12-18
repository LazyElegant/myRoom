<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Gbook.aspx.cs" Inherits="留言板管理系统.Gbook" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="index.css" rel="stylesheet" type="text/css" />
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h1>留言板</h1>
            <asp:Label ID="Label1" runat="server" CssClass="topLab" Text="登录"></asp:Label>
            <asp:Label ID="Label2" runat="server" CssClass="topLab" Text="注册"></asp:Label>
            <asp:Label ID="Label3" runat="server" CssClass="topLab" Text="管理员登录"></asp:Label>
            <br />
        </div>
        <asp:DataList ID="DataList1" runat="server" Width="1198px">
                <ItemTemplate>
                    
                    <div class="Gbook">
                        <p class="thead"><%#  DataBinder.Eval(Container.DataItem, "name") %>于<%#  DataBinder.Eval(Container.DataItem, "time") %>进行留言</p>
                        <p><%#  DataBinder.Eval(Container.DataItem, "content") %></p>
                        <p style="color:red"><%#  DataBinder.Eval(Container.DataItem, "reptitle") %></p>
                    </div>
                </ItemTemplate>
            </asp:DataList>
            
            <asp:SqlDataSource ID="SqlDataSource1" runat="server"></asp:SqlDataSource>
        <asp:Panel ID="Panel1" runat="server">
            给我们留言:<br />
            <asp:TextBox ID="TextBox1" runat="server"></asp:TextBox>
            <br />
            主题内容：
            <br />
            <asp:TextBox ID="TextBox2" runat="server" TextMode="MultiLine" Height="155px" Width="720px"></asp:TextBox>
            <br />
            <asp:Button ID="Button1" runat="server" Text="留言" OnClick="Button1_Click" style="height: 27px" />
        </asp:Panel>
    </form>
</body>
</html>
