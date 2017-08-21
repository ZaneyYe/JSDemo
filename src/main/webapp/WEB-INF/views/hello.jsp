<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/8/11 0011
  Time: 上午 10:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>Hello</title>
  </head>
  <body>
     <div id="demo1">
        <form action="/uploadFile1.do" enctype="multipart/form-data" method="post" />
           名称:<input type="text" id="name" name="name"/><br/>
           文件:<input type="file" id="upFile" name="upFile" /><br />
           <br />
           <input type="submit" value="提交" />
        </form>
     </div>

  <hr />
     <iframe name="demoFrame" style="display: none" onload="getOk()"></iframe>
     <div id="demo2">
         <form action="/uploadFile2.do" onsubmit="checkValid(this)" enctype="multipart/form-data" method="post" target="demoFrame" />
         名称:<input type="text" name="name2"/><br/>
         文件:<input type="file" name="upFile2" /><br />
         <br />
         <input type="submit" value="提交" />
         </form>
     </div>

    <hr />
     <div id="demo3">
         <form id="demo3Form">
         名称:<input type="text" name="name3"/><br/>
         文件:<input type="file" name="upFile3" /><br />
         <br />
         </form>
         <button id="subBtn">提交</button>
     </div>

    <hr />
    <div id="demo4">
        <form id="demo4Form">
            名字：<input type="text" name="name4" /><br />
            学号：<input type="text" name="stuNo" /><br />
        </form>
        <button id="stuSub">提交</button>
    </div>
  </body>
</html>

<script type="text/javascript" src="/js/jquery.min.js"></script>
<script type="text/javascript">
    function getOk() {
        alert("success");
    }

    function checkValid(form){
        if(form.name2.value == ""){
            alert("名称不能为空..");
            return false;
        }
    }

    //异步
    $("#subBtn").click(function(){
        var data = new FormData($("#demo3Form")[0]);
        $.ajax({
            url : "/uploadFile3.do",
            type : "POST",
            data : data,
            dataType : 'JSON',
            contentType: false, //这两个参数不能少，少的话会js报错报Illegal invocation（非法调用）
            processData: false,
            success : function (data) {
                console.log(data);
                if(data.key = 'result'){
                    alert(data.value);
                }
            },
            error : function (data) {
                console.log(data);
                if(data.key = 'result'){
                    alert(data.value);
                }
            }
        })
    })


    $("#stuSub").click(function () {
        var stuName = $(":input[name='name4']").val();
        var stuNo = $(":input[name='stuNo']").val();
        var data = {
            stuName : stuName,
            stuNo : stuNo
        }
        $.ajax({
            url : "/subStuInfo.do",
            type : "POST",
            data: data
//            success : function (data) {
//                console.log(data);
//            }
        })
    })

</script>