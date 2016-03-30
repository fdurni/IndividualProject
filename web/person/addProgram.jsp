<%--
  Created by IntelliJ IDEA.
  User: felic
  Date: 2/7/2016
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<!-- Content Type -->
<jsp:include page="../contentType.jsp"/>
<html>
<jsp:include page="head.jsp"/>
<body class="hold-transition skin-blue sidebar-mini">

<!-- wrapper -->
<div class="wrapper">

    <!-- Main Header -->
    <jsp:include page="header.jsp"/>

    <!-- Left side column. contains the logo and sidebar -->
    <jsp:include page="sidebar.jsp"/>

    <!-- Page content -->
    <jsp:include page="addProgram-content.jsp"/>

    <!-- Main Footer -->
    <jsp:include page="footer.jsp"/>

</div>

<!-- REQUIRED JS SCRIPTS -->
<jsp:include page="include.jsp"/>

</body>
</html>
