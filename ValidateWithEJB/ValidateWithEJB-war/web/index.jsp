<%-- 
    Document   : index
    Created on : Dec 1, 2015, 11:17:03 AM
    Author     : 339250
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Steve Ghantous Assignment 4</title>
    </head>
    <body>
        <h1>Validate with EJB</h1>
        <form action="ValidateServlet" method="POST">
            Username: <input type="text" name="username">
            <br>
            Password: <input type="password" name="password">
            <br>
            <input type="submit" value="Login">
        </form>
        <%
            String message = request.getParameter("message");
            if(message != null && !message.equals(""))
            {
                out.println(message);
            }
        %>
    </body>
</html>
