<%-- 
    Document   : outcoume
    Created on : 12 Apr 2024, 14:48:27
    Author     : Thato Keith Kujwane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Outcome Page</title>
    </head>
    <body>
        <h1>Palindromes Web Application</h1>
        <h2>Processing Outcome</h2>
        <%
            String userWord = request.getAttribute("word").toString();
            Boolean isPalindrome = (Boolean) request.getAttribute("outcome");
            String outcome = "is not";
            
            if (isPalindrome){
                outcome = "is";
            }
        %>
        
        <p>
            The word <%=userWord%> <%=outcome%> a palindrome. <br>
            Click <a href="index.html">here</a> to navigate home
        </p>
        
    </body>
</html>
