<%--
  Created by IntelliJ IDEA.
  User: Sanzen
  Date: 29.03.2019
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<%
    Integer counter = (Integer) request.getAttribute("counter");
    out.print("Текущее состояние счетчика: " + counter);
%>
<body>
</body>
</html>
