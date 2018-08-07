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
            $("#aaa").click(function () {
                getUser();
            });
        }
    }
}();