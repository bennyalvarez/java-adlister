
<%--
  Created by IntelliJ IDEA.
  User: benjaminalvarez
  Date: 6/30/21
  Time: 11:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setAttribute("lactoseIntolerant", false);

    List<String> dairyProducts = new ArrayList<>();
    dairyProducts.add("milk");
    dairyProducts.add("cheese");
    dairyProducts.add("yogurt");
    dairyProducts.add("ice cream");
    dairyProducts.add("cottage cheese");
    dairyProducts.add("butter");

    request.setAttribute("dairyProducts", dairyProducts);

    boolean textIsBlue = true;

    request.setAttribute("blue", textIsBlue);

%>
<html>
<head>
    <title>JSPs: JSTL</title>
</head>
<body>
<c:choose>
    <c:when test="${lactoseIntolerant}">
        <h1>You are lactose intolerant! Please don't buy any dairy products.</h1>
    </c:when>
    <c:when test="${blue}">
        <p>Yay! Blue text!</p>
    </c:when>
        <c:otherwise>
            <h3>Dairy Products List</h3>
            <c:forEach items="${dairyProducts}" var="dairyProduct">
                <div>
                    <p>${dairyProduct}</p>
                </div>
            </c:forEach>
        </c:otherwise>
</c:choose>
<c:if test="${blue}">
    <p style="color: blue">Yay it's blue!</p>
</c:if>
</body>
</html>
