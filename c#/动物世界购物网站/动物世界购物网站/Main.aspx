<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Main.aspx.cs" Inherits="动物世界购物网站.Main" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <style>
        .top {
            background-color:antiquewhite;
            text-align:right;
        }
        a {
            color:black;
            text-decoration:none;
        }
        .title {
            background-color:navy;
            color:white;
            height:30px;
            line-height:30px;
            font-weight:900;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <div class="top" >欢迎：<%=Session["username"].ToString()%> ,<a href="Information.aspx">我的资料</a>,<a style="margin-right:20px" href="login.aspx">注销</a> </div>
            <div class="title"> <b style="margin-left:20px;">昆虫</b></div>

            <table style="width:100%">
                <tr >
                    <td>
                        <table style="margin: 30px auto;width:360px">
                            <tr>
                                <td rowspan="5"><asp:Image runat="server" ImageUrl="img/1.JPG" /></td>
                                <td style="font-size:18px;font-weight:700;">蚂蚁</td>

                            </tr>
                            <tr>
                                <td style="font-size:16px;">搬运工</td>
                            </tr>
                            <tr>
                                <td style="font-size:16px;">价格：￥2.00</td>
                            </tr>
                            <tr>
                                <td style="font-size:16px;font-weight:700;"><asp:Image runat="server" ImageUrl="img/购物车.png"/> 添加到购物车</td>
                            </tr>
                            <tr>
                                <td style="font-size:16px;font-weight:700;"><asp:Image runat="server" ImageUrl="img/BBD收藏1.png"/> 收藏</td>
                            </tr>

                        </table>
                    </td>
                    <td>
                        <table style="margin: 30px auto;width:360px">
                            <tr>
                                <td rowspan="5"><asp:Image runat="server" ImageUrl="img/2.JPG" /></td>
                                <td style="font-size:18px;font-weight:700;">蜗牛</td>

                            </tr>
                            <tr>
                                <td style="font-size:16px;">你的柔软伙伴</td>
                            </tr>
                            <tr>
                                <td style="font-size:16px;">价格：￥7.00</td>
                            </tr>
                            <tr>
                                <td style="font-size:16px;font-weight:700;"><asp:Image runat="server" ImageUrl="img/购物车.png"/> 添加到购物车</td>
                            </tr>
                            <tr>
                                <td style="font-size:16px;font-weight:700;"><asp:Image runat="server" ImageUrl="img/BBD收藏1.png"/> 收藏</td>
                            </tr>

                        </table>
                    </td>
                </tr>
                <tr >
                    <td>
                        <table style="margin: 30px auto;width:360px">
                            <tr>
                                <td rowspan="5"><asp:Image runat="server" ImageUrl="img/3.JPG" /></td>
                                <td style="font-size:18px;font-weight:700;">蝴蝶</td>

                            </tr>
                            <tr>
                                <td style="font-size:16px;">越大越美</td>
                            </tr>
                            <tr>
                                <td style="font-size:16px;">价格：￥8.00</td>
                            </tr>
                            <tr>
                                <td style="font-size:16px;font-weight:700;"><asp:Image runat="server" ImageUrl="img/购物车.png"/> 添加到购物车</td>
                            </tr>
                            <tr>
                                <td style="font-size:16px;font-weight:700;"><asp:Image runat="server" ImageUrl="img/BBD收藏1.png"/> 收藏</td>
                            </tr>

                        </table>
                    </td>
                    <td>
                        <table style="margin: 30px auto;width:360px">
                            <tr>
                                <td rowspan="5"><asp:Image runat="server" ImageUrl="img/4.JPG" /></td>
                                <td style="font-size:18px;font-weight:700;">青蛙</td>

                            </tr>
                            <tr>
                                <td style="font-size:16px;">想灭蚊吗</td>
                            </tr>
                            <tr>
                                <td style="font-size:16px;">价格：￥12.00</td>
                            </tr>
                            <tr>
                                <td style="font-size:16px;font-weight:700;"><asp:Image runat="server" ImageUrl="img/购物车.png"/> 添加到购物车</td>
                            </tr>
                            <tr>
                                <td style="font-size:16px;font-weight:700;"><asp:Image runat="server" ImageUrl="img/BBD收藏1.png"/> 收藏</td>
                            </tr>

                        </table>
                    </td>
                </tr>
                <tr >
                    <td>
                        <table style="margin: 30px auto;width:360px">
                            <tr>
                                <td rowspan="5"><asp:Image runat="server" ImageUrl="img/5.JPG" /></td>
                                <td style="font-size:18px;font-weight:700;">蜘蛛</td>

                            </tr>
                            <tr>
                                <td style="font-size:16px;">冷酷美</td>
                            </tr>
                            <tr>
                                <td style="font-size:16px;">价格：￥5.00</td>
                            </tr>
                            <tr>
                                <td style="font-size:16px;font-weight:700;"><asp:Image runat="server" ImageUrl="img/购物车.png"/> 添加到购物车</td>
                            </tr>
                            <tr>
                                <td style="font-size:16px;font-weight:700;"><asp:Image runat="server" ImageUrl="img/BBD收藏1.png"/> 收藏</td>
                            </tr>

                        </table>
                    </td>
                    <td>
                        <table style="margin: 30px auto;width:360px">
                            <tr>
                                <td rowspan="5"><asp:Image runat="server" ImageUrl="img/6.JPG" /></td>
                                <td style="font-size:18px;font-weight:700;">蜻蜓</td>

                            </tr>
                            <tr>
                                <td style="font-size:16px;">精致的宠物</td>
                            </tr>
                            <tr>
                                <td style="font-size:16px;">价格：￥3.20</td>
                            </tr>
                            <tr>
                                <td style="font-size:16px;font-weight:700;"><asp:Image runat="server" ImageUrl="img/购物车.png"/> 添加到购物车</td>
                            </tr>
                            <tr>
                                <td style="font-size:16px;font-weight:700;"><asp:Image runat="server" ImageUrl="img/BBD收藏1.png"/> 收藏</td>
                            </tr>

                        </table>
                    </td>
                </tr>
            </table>
        </div>
    </form>
</body>
</html>
