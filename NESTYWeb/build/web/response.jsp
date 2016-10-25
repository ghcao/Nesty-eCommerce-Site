<%-- 
    Document   : response
    Created on : Oct 23, 2016, 10:52:11 PM
    Author     : mattaugsburger
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body background="./PaintSquares_1920x1234.jpg">
        <img src="de2cf927-cffb-4743-a8e5-15ce8154e950.png" width="200" height="200" alt="de2cf927-cffb-4743-a8e5-15ce8154e950"/>
        <jsp:useBean id="mybean" scope="session" class="org.mypackage.hello.Login" />
        <jsp:setProperty name="mybean" property="username" />
        <h1>Welcome to NESTY, <jsp:getProperty name="mybean" property="username" />!</h1>
    </body>
</html>
