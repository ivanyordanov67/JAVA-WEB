<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.io.Writer" %>
<%@ page import="models.views.HomeViewModel" %><%--
  Created by IntelliJ IDEA.
  User: ivan
  Date: 14.10.2019 г.
  Time: 11:42 ч.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<strong>
<%= ((HomeViewModel)request.getAttribute("viewModel")).getName()%>
    <br/>
<%= ((HomeViewModel)request.getAttribute("viewModel")).getCreatedOn()%>
</strong>
</body>
</html>
