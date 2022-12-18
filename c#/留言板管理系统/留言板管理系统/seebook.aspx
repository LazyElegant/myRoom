<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="seebook.aspx.cs" Inherits="留言板管理系统.seebook" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link href="index.css" rel="stylesheet" type="text/css" />
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
        <div><asp:DataList ID="DataList1" runat="server" Width="1198px">
                <ItemTemplate>
                    
                    <div class="Gbook">
                        <p class="thead">你于<%#  DataBinder.Eval(Container.DataItem, "time") %>进行留言</p>
                        <p><%#  DataBinder.Eval(Container.DataItem, "title") %></p>
                        <p><%#  DataBinder.Eval(Container.DataItem, "content") %></p>
                    </div>
                </ItemTemplate>
            </asp:DataList>
            
            <asp:SqlDataSource ID="SqlDataSource1" runat="server"></asp:SqlDataSource>
        </div>
    </form>
</body>
</html>
