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
    <script type="text/javascript" src="${pageContext.request.contextPath}/thirdparty/jquery-1.6.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/app.js"></script>
</head>
<script>
    jQuery(document).ready(function() {
        var cc = "${pageContext.request.contextPath}";
       App.init(cc);
    });
</script>
<body>
        <h2>-----------</h2>
<button id="aaa">测试一下</button>
</body>
</html>
