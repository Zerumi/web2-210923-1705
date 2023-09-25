<%--
  Created by IntelliJ IDEA.
  User: zerumi
  Date: 25.09.2023
  Time: 03:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>404</title>
</head>
  <body>
    <%
      String redirectURL = "http://http.cat/404";
      response.sendRedirect(redirectURL);
    %>
  </body>
</html>
