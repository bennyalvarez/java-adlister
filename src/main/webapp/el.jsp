<%--
  Created by IntelliJ IDEA.
  User: benjaminalvarez
  Date: 6/30/21
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //Setting request attribute (this would be done in a servlet)
    request.setAttribute("userRole", "admin");

    String message;

    switch (request.getAttribute("userRole").toString()) {
        case "admin":
            message = " administrator";
            break;
        case "s_admin":
            message = "super administrator";
            break;
        case "user_1":
            message = "active user";
            break;
        default:
            message = "unknown status";
    }

//    request.setAttribute("userRoleMessage", message);
//
//    User u1 = new User("jaybird13", 27, "jay@codeup.com");
//
//    request.setAttribute("user", u1);
%>

<html>
<head>
    <title>Expression Language</title>
</head>
<body>
    <h1>${userRole}</h1> //it will output the value of the variable above which is "admin"

    <h2>Your name is: ${param.name}</h2>
    <h3>User Status: ${userRoleMessage}</h3>

<%--    We would use the following syntax below to refer to our user instance that we have set in our servlet--%>
<%--    <h2>Username = ${user.username}}</h2>--%>
<%--    <p>User Age = ${user.age}</p>--%>
<%--    <p>User Email = ${user.email}</p>--%>


</body>
</html>
