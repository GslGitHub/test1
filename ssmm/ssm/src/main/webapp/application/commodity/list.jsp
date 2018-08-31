<%--
  Created by IntelliJ IDEA.
  User: lzx-t038
  Date: 2018/8/2
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.css" rel="stylesheet">
    <script type="text/javascript" src="${pageContext.request.contextPath}/thirdparty/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/app.js"></script>
</head>
<script>
    jQuery(document).ready(function() {
        var cc = "${pageContext.request.contextPath}";
       App.init(cc);
    });
</script>
<body>

<div class="container">
    <h1>Hello, Wang!</h1>
    <ul class="nav nav-tabs">
        <li class="active li-nav profit"><a href="javascript:void(0)">利润</a></li>
        <li class="li-nav costManager"><a href="javascript:void(0)">成本管理</a></li>
    </ul>
    <div class="row" >
        <div class="col-md-6 col-md-offset-3"
             style="padding:5px;">
            <table class="table table-striped">
                <caption>条纹表格布局</caption>
                <thead>
                <tr>
                    <th>名称</th>
                    <th>城市</th>
                    <th>邮编</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>Tanmay</td>
                    <td>Bangalore</td>
                    <td>560001</td>
                </tr>
                <tr>
                    <td>Sachin</td>
                    <td>Mumbai</td>
                    <td>400003</td>
                </tr>
                <tr>
                    <td>Uma</td>
                    <td>Pune</td>
                    <td>411027</td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>

</body>
</html>
