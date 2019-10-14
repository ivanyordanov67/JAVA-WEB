<%@ page import="models.serviceModels.CourseServiceModel" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Courses</title>
</head>
<body>
<form method="post" action="/courses">
    <label>
        Name: <input name="name" type="text">
    </label>
    <button>Create</button>
</form>
<% List<CourseServiceModel> courses = ((List<CourseServiceModel>) request.getAttribute("courses"));%>
<ul>

    <% for (CourseServiceModel cours : courses) {%>
    <li>
        <%out.println(cours.getName());%>
    </li>
    <%};%>

</ul>

</body>
</html>
