<%-- 
    Document   : ShowList
    Created on : 02/03/2017, 23:02:39
    Author     : Ismael Nascimento
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="WEB-INF/struts-logic.tld" prefix="logic" %>
        
<!DOCTYPE html>
<html style="background-color: bisque">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Students Information</title>
    </head>
    <body>
        <center>
            <h1>Students Information</h1>
            <table border="1" cellspacing="2" cellpadding="2">
                <tr>
                    <th>Student ID</th>
                    <th>Student Name</th>
                    <th>Student Age</th>
                    <th>Student Email</th>
                    <th>Student Adress</th>
                    <th>Student Phone</th>
                    <th>Student Edit</th>
                    <th>Student Delete</th>
                </tr>
                <logic:iterate id="l" collection="${list}">
                <tr>
                    <td>${l.id}</td>
                    <td>${l.name}</td>
                    <td>${l.age}</td>
                    <td>${l.email}</td>
                    <td>${l.adress}</td>
                    <td>${l.phone}</td>
                    <td>
                        <html:link action="edit?id=${l.id}">Edit</html:link>
                    </td>
                    <td>
                        <html:link action="delete?id=${l.id}" onclick="return confirm('Are you syre ?')">Delete</html:link>
                    </td>
                </tr>
                </logic:iterate>
            </table>
            
            <html:link action="add">Add new students</html:link>
        </center>
    </body>
</html>
