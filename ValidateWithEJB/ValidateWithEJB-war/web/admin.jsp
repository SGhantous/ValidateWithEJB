<%-- 
    Document   : admin
    Created on : Dec 1, 2015, 2:25:36 PM
    Author     : 339250
--%>

<%@page import="adminpagehelper.AdminPageHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Steve Ghantous Assignment 4</title>
    </head>
    <body>
        <h1>Admin Page</h1>
        <a href="index.jsp">Logout</a>
        <h2>User List</h2>
        <%
            String message = request.getParameter("message");
            if(message != null && !message.equals(""))
            {
                out.println(message);
            }
            
            AdminPageHelper helper = new AdminPageHelper();
            out.println(helper.displayTable());
        %>
    </body>
</html>
