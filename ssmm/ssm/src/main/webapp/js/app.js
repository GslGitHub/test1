var App = function(){
var CONTENTPATH;
        function getUser(){
            $.post(CONTENTPATH+"/test.do",{userId:"aaaa"},function (data) {
                alert(data);
            })
        }
        
    return{
        init:function (data) {
            CONTENTPATH = data;
            App.saveForm();
            $(".li-nav").unbind("click").bind("click",function () {
                if($(this).hasClass("active")){
                    return;
                }
                $(this).removeClass("active");
                $(this).addClass("active");

                if($(this).hasClass("profit")){
                    window.location.href = data+"/application/commodity/list.jsp";
                }
                if($(this).hasClass("costManager")){
                    window.location.href = data+"/application/commodity/add.jsp";
                }
            });
        },
        saveForm : function () {
            $("#save").unbind("click").bind("click",function(){
                var URL = CONTENTPATH+"/savecommodity.do";
                console.log(URL);
                $.ajax({
                    type:'post',
                    url:CONTENTPATH+"/savecommodity.do",
                    data:$("#form1").serialize(),
                    cache:false,
                    dataType:'json',
                    success:function(){
                        $("#form1").clearForm();
                    }
                });
            });
        }
        uploadFiles : function () {
            document.form2.action = CONTENTPATH + "/upload.do";
            document.form2.submit();
        }
    }
}();