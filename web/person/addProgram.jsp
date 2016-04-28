<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: felic
  Date: 2/7/2016
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<!-- Content Type -->
<c:import url="../contentType.jsp"/>
<html>
<c:import url="head.jsp"/>
<body class="hold-transition skin-blue sidebar-mini">

<!-- wrapper -->
<div class="wrapper">

    <!-- Main Header -->
    <c:import url="header.jsp"/>

    <!-- Left side column. contains the logo and sidebar -->
    <c:import url="sidebar.jsp"/>

    <!-- Page content -->
    <c:import url="addProgram-content.jsp"/>

    <!-- Main Footer -->
    <c:import url="footer.jsp"/>

</div>

<!-- REQUIRED JS SCRIPTS -->
<c:import url="include.jsp"/>
<script>
    var date_input=$('input[name="beginDate"]');
    var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
    var options={
        format: 'yyyy-mm-dd',
        container: container,
        todayHighlight: true,
        autoclose: true,
    };
    date_input.datepicker(options);

    (function ($) {
        $('.spinner .btn:first-of-type').on('click', function() {
            $('.spinner input').val( parseInt($('.spinner input').val(), 10) + 1);
        });
        $('.spinner .btn:last-of-type').on('click', function() {
            $('.spinner input').val( parseInt($('.spinner input').val(), 10) - 1);
        });
    })(jQuery);
</script>
</body>
</html>
