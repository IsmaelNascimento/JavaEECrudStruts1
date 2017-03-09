<%-- 
    Document   : Add
    Created on : 03/03/2017, 18:43:12
    Author     : Ismael Nascimento
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<!DOCTYPE html>
<html style="background-color: bisque">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add student</title>
    </head>
    <body>
    <center>
        <h1>Add student information !</h1>
        <html:form action="save.do" method="POST">
            <table border="1" cellspacing="2" cellpadding="2">
                    <tr>
                        <td>Student Name</td>
                        <td>
                            <html:text property="name" />
                        </td>
                    </tr>
                    <tr>
                        <td>Student Age</td>
                        <td>
                            <html:text property="age" />
                        </td>
                    </tr>
                    <tr>
                        <td>Student Email</td>
                        <td>
                            <html:text property="email" />
                        </td>
                    </tr>
                    <tr>
                        <td>Student Adress</td>
                        <td>
                            <html:text property="adress" />
                        </td>
                    </tr>
                    <tr>
                        <td>Student Phone</td>
                        <td>
                            <html:text property="phone" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <html:submit value="Save Student"/>
                        </td>
                        <td>
                            <html:link action="list">Back</html:link>
                        </td>
                    </tr>
            </table>
        </html:form>
    </center>
    </body>
</html>
