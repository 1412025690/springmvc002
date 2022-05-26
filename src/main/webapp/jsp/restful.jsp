<%--
  Created by IntelliJ IDEA.
  User: 米
  Date: 2022/5/25
  Time: 22:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>REST ful</title>
    <Script src="/js/jquery-3.6.0.js"></Script>
</head>
    <body>
         <form id="myForm" action="" method="post">
             球队ID:<input type="text" name="teamId" id="teamId"/><br/>
             球队名称:<input type="text" name="teamName" /><br/>
             球队位置:<input type="text" name="location" /><br/>
             <button type="button" id="btnGetAll"> 查询所有GET </button>
             <button type="button" id="btnGetOne"> 查询单个GET </button>
             <button type="button" id="btnPost">   添加POST   </button>
             <button type="button" id="btnPut">    更新PUT    </button>
             <button type="button" id="btnDel">    删除DELETE </button>
         </form>
        <p id="showResult" class="showResult"></p>
    </body>
</html>
<script>
    //页面加载完毕之后给按钮绑定事件
    $(function () {


        //给 删除DELETE 绑定单击事件
        $("#btnDel").click(function () {
            alert($("#myForm").serialize());
            //发起异步ajax请求
            $.ajax({
                type:"POST",
                URL:"/team/"+$("#teamId").val(), //REST ful风格的API去定义
                data: "&_method=DELETE", //表单的所有数据以 ? & 形式追加在url后面 /team?teamId=1006 & teamName = kuaichuan & location = las
                dataType:"json",
                success:function (msg) {
                    // alert("Data Saved: " + msg);
                    $("#showResult").html(msg);
                }
            });
        });


        //给 更新PUT 绑定单击事件
        $("#btnPut").click(function () {
            alert($("#myForm").serialize());
            //发起异步ajax请求
            $.ajax({
                type:"POST",
                URL:"/team/"+$("#teamId").val(), //REST ful风格的API去定义
                data: $("#myForm").serialize()+"&_method=PUT", //表单的所有数据以 ? & 形式追加在url后面 /team?teamId=1006 & teamName = kuaichuan & location = las
                dataType:"json",
                success:function (msg) {
                    // alert("Data Saved: " + msg);
                    $("#showResult").html(msg);
                }
            });
        });




        //给 添加POST 绑定单击事件
        $("#btnPost").click(function () {
            alert($("#myForm").serialize());
            //发起异步ajax请求
            $.ajax({
                type:"POST",
                URL:"/team", //REST ful风格的API去定义
                data: $("#myForm").serialize(), //表单的所有数据以 ? & 形式追加在url后面 /team?teamId=1006 & teamName = kuaichuan & location = las
                dataType:"json",
                success:function (msg) {
                    // alert("Data Saved: " + msg);
                    $("#showResult").html(msg);
                }
            });
        });

        //给 查询所有GET 绑定单击事件
        $("#btnGetAll").click(function () {
            //发起异步ajax请求
            $.ajax({
                type:"GET",
                URL:"teams", //REST ful风格的API去定义
                data:"",
                dataType:"json",
                success:function (vo) {
                    if(vo.code == 200){
                        var list = vo.list;
                        var str = "";
                        for(var i=0;i<list.length;i++){
                         var obj = list[i];
                         str += obj.teamId + "---" + obj.teamName + "----" + obj.location + "<br/>";
                        }
                        $(#showResult).html(str);
                    }else {
                        $(#showResult).html(vo.msg);
                    }
                }
            });
        });

        //给 查询单个GET 绑定单击事件
        $("#btnGetOne").click(function () {
            //发起异步ajax请求
            $.ajax({
                type:"GET",
                URL:"team/"+$("#teamId").val(), //REST ful风格的API去定义
                data:"",
                dataType:"json",
                success:function (obj) {
                    alert("Data Saved: " + obj);
                    if(obj == ""){
                        $("#showResult").html("没有查询到数据");
                    }else {
                        $("#showResult").html(obj.teamId + "," + obj.teamName + "," + obj.location + "<br/>");
                    }
                }
            });
        });
    });
</script>
