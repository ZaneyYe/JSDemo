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
    <title>success</title>
  </head>
  <body>
    <form id="pointForm" action="/sendPoint.do" method="post" enctype="multipart/form-data">
      消息：<input type="text" placeholder="请输入" width="200" height="300" name="queueMsg"/>
      <input type="submit" value="点对点发送" />
    </form>

    <hr/>
    <form id="topicForm" action="/sendTopic.do" method="post" enctype="multipart/form-data">
      消息：<input type="text" placeholder="请输入" width="400" height="500" name="topicMsg"/>
      <input type="submit" value="主题发送" />
    </form>
  </body>
</html>
