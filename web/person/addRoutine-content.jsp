<%--
  Created by IntelliJ IDEA.
  User: felic
  Date: 3/29/2016
  Time: 2:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>${addRoutineMessage}</h3>
<c:set var="addRoutineMessage" value="" scope="session" />

<br />
<form action="/java112/routine-add-action" method="POST">
    Routine Name:
    <br />
    <input type="text" name="routineName" /><br />
    <br />
    Routine Type:
    <br />
    <input type="text" name="routineType" /><br />
    <br />
    Routine Description:
    <br />
    <input type="text" name="routineDescription" /><br />
    <br />
    Week(s):
    <br />
    <input type="checkbox" name="week1" value="1">1
    <input type="checkbox" name="week2" value="2">2
    <input type="checkbox" name="week3" value="1">3
    <input type="checkbox" name="week4" value="2">4
    <input type="checkbox" name="week5" value="1">5
    <input type="checkbox" name="week6" value="2">6
    <input type="checkbox" name="week7" value="1">7
    <input type="checkbox" name="week8" value="2">8
    <input type="checkbox" name="week9" value="1">9
    <input type="checkbox" name="week10" value="2">10
    <input type="checkbox" name="week11" value="1">11
    <input type="checkbox" name="week12" value="2">12
    <br />
    <br />
    Day:
    <br />
    <input type="radio" name="day" value="1">1
    <input type="radio" name="day" value="2">2
    <input type="radio" name="day" value="3">3
    <input type="radio" name="day" value="4">4
    <input type="radio" name="day" value="5">5
    <input type="radio" name="day" value="6">6
    <input type="radio" name="day" value="7">7
    <br />
    <input type="submit" name="" value="Enter" />
    <br /><br />
</form>
