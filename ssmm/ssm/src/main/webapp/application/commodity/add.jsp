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
        <li class="li-nav profit"><a href="javascript:void(0)">利润</a></li>
        <li class="active li-nav costManager"><a href="javascript:void(0)">成本管理</a></li>
    </ul>
    <div class="row" >
        <div class="col-md-6 col-md-offset-3"
             style="padding:5px;">
            <form class="form-horizontal "  id="form1">
                <div class="form-group">
                    <label  class="col-sm-2 control-label">名字</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="name" placeholder="请输入名字">
                    </div>
                    <label  class="col-sm-2 control-label">SKU</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="SKU" placeholder="请输入SKU">
                    </div>
                </div>
                <div class="form-group">
                    <label  class="col-sm-2 control-label">重量</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="weight" placeholder="请输入重量">
                    </div>
                    <label  class="col-sm-2 control-label">长</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="length" placeholder="请输入长">
                    </div>
                    <label class="col-sm-2 control-label">宽</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" name="width" placeholder="请输入宽">
                    </div>
                    <label  class="col-sm-2 control-label">高</label>
                    <div class="col-sm-10">
                        <input type="text" class="control-label" name="height" placeholder="请输入高">
                    </div>
                </div>

            </form>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button  class="btn btn-default" id="save">保存</button>
                    </div>
                </div>

            <form role="form" enctype=”multipart/form-data”id="form2">
                <div class="form-group">
                    <label for="inputfile">文件输入</label>
                    <input type="file" id="inputfile">
                </div>
            </form>
                <button  onclick="App.uploadFiles()" class="btn btn-default">上传</button>
        </div>
    </div>
</div>

</body>
</html>
