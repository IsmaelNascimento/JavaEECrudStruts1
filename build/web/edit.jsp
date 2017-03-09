<%-- 
    Document   : edit
    Created on : 05/03/2017, 11:17:50
    Author     : Ismael Nascimento
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update student</title>
    </head>
    <body>
        <center>
        <h1>Update student information !</h1>
        <html:form action="update.do" method="POST">
            <table border="1" cellspacing="2" cellpadding="2">
                <logic:iterate id="l" collection="${listEdit}">
                    <tr>
                        <td>Student ID</td>
                        <td>
                            <html:text property="id" name="l" readonly="true" />
                        </td>
                    </tr>
                    <tr>
                        <td>Student Name</td>
                        <td>
                            <html:text property="name" name="l" />
                        </td>
                    </tr>
                    <tr>
                        <td>Student Age</td>
                        <td>
                            <html:text property="age" name="l" />
                        </td>
                    </tr>
                    <tr>
                        <td>Student Email</td>
                        <td>
                            <html:text property="email" name="l" />
                        </td>
                    </tr>
                    <tr>
                        <td>Student Adress</td>
                        <td>
                            <html:text property="adress" name="l" />
                        </td>
                    </tr>
                    <tr>
                        <td>Student Phone</td>
                        <td>
                            <html:text property="phone" name="l" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <html:submit value="Update Student"/>
                        </td>
                        <td>
                            <html:link action="list">Back</html:link>
                        </td>
                        
                    </tr>
                    </logic:iterate>
            </table>
        </html:form>
    </center>
    </body>
</html>
