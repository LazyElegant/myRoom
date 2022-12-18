<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Gbook.aspx.cs" Inherits="留言板管理系统.admin.Gbook" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link href="../index.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h1>后台留言板</h1>
            <asp:Label ID="Label1" runat="server" CssClass="topLab" Text="登录"></asp:Label>
            <asp:Label ID="Label2" runat="server" CssClass="topLab" Text="注销"></asp:Label>
            <br />
        </div>
        <asp:DataList ID="DataList1" runat="server" Width="1198px">
                <ItemTemplate>
                    
                    <div class="Gbook">
                        <p class="thead"><%#  DataBinder.Eval(Container.DataItem, "name") %>于<%#  DataBinder.Eval(Container.DataItem, "time") %>进行留言:<a href="reply.aspx?id=<%#  DataBinder.Eval(Container.DataItem, "id") %>">回复</a><a href="detele.aspx?id=<%#  DataBinder.Eval(Container.DataItem, "id") %>">删除</a></a></p>
                        <p><%#  DataBinder.Eval(Container.DataItem, "content") %></p>
                        <p style="color:red"><%#  DataBinder.Eval(Container.DataItem, "reptitle") %></p>
                    </div>
                </ItemTemplate>
            </asp:DataList>
            
            <asp:SqlDataSource ID="SqlDataSource1" runat="server"></asp:SqlDataSource>
    </form>
</body>
</html>
