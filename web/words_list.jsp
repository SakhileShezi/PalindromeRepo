<%-- 
    Document   : words_list
    Created on : 12 Apr 2024, 14:56:06
    Author     : Thato Keith Kujwane
--%>

<%@page import="java.util.List"%>
<%@page import="za.ac.tut.entity.word.Word"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Processed Words Page</title>
    </head>
    <body>
        <h1>Palindromes Web Application</h1>
        <h2>Processed Words</h2>
        <%List<Word> wordsList = (List<Word>) session.getAttribute("wordsList");%>
        
        <%if(wordsList.isEmpty()){%>
            <p>
                No words processed yet.
            </p>
        <%}else {%>
            <style>
                table, th, tr, td{
                    border-collapse: collapse; 
                    border: 1px solid black;
                    padding: 15px;
                }
            </style>

            <table>
                <tr>
                    <th>Word</th>
                    <th>Is palindrome</th>
                </tr>
                <%for(Word word : wordsList){%>
                    <tr>
                        <td><%=word.getWord()%></td>
                        <td><%=word.getIsPalindrome()%></td>
                    </tr>
                <%}%>
            </table>
        <%}%>
        Click <a href="index.html">here</a> to navigate home.
    </body>
</html>
