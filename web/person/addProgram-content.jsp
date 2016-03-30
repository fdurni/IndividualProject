<%--
  Created by IntelliJ IDEA.
  User: felic
  Date: 3/29/2016
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>${addProgramMessage}</h3>
<c:set var="addProgramMessage" value="" scope="session" />

<br />
<form action="/java112/program-add-action" method="POST">
    Program Name:
    <br />
    <input type="text" name="programName" /><br />
    <br />
    Program Type:
    <br />
    <input type="text" name="programType" /><br />
    <br />
    Program Description:
    <br />
    <input type="text" name="programDescription" /><br />
    <input type="submit" name="" value="Enter" />
    <br /><br />
</form>
