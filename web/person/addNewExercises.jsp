<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: felic
  Date: 2/7/2016
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<!-- Content Type -->
<c:import url="/contentType.jsp"/>
<html>
<c:import url="head.jsp"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/dist/css/addRoutine.css">
<body class="hold-transition skin-blue sidebar-mini">

<!-- wrapper -->
<div class="wrapper">

    <!-- Main Header -->
    <c:import url="header.jsp"/>

    <!-- Left side column. contains the logo and sidebar -->
    <c:import url="sidebar.jsp"/>

    <!-- Page content -->
    <c:import url="addNewExercises-content.jsp"/>

    <!-- Main Footer -->
    <c:import url="footer.jsp"/>

</div>

<!-- REQUIRED JS SCRIPTS -->
<c:import url="include.jsp"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/addNewExercises.js"></script>
</body>
</html>