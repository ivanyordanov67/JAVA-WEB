<%@ page import="models.serviceModels.CourseServiceModel" %>
<%@ page import="java.util.List" %>
<%@ page import="models.views.CoursesViewModel" %>
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

    <label>
        Price: <input name="price" type="text">
    </label>
    <button>Create</button>
</form>
<% List<CourseServiceModel> courses = ((List<CourseServiceModel>) request.getAttribute("courses"));%>
<ul>
    <% for (CourseServiceModel course : courses) {%>
    <li>
        <%out.println(String.format("%s - Price: %s",course.getName(), course.getPrice()));%>
    </li>
    <%};%>
</ul>

</body>
</html>
