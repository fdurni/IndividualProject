<%--
  Created by IntelliJ IDEA.
  User: felic
  Date: 2/9/2016
  Time: 6:03 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="contentType.jsp" />
<html>
<jsp:include page="head.jsp" />
<body class="hold-transition login-page">
<div class="login-box">
    <div class="login-logo">
        <b>Training</b>Tracker
    </div>
    <!-- /.login-logo -->
    <div class="error-page">
        <p>Sign In Error. Try Again.</p>
        <a href="${pageContext.request.contextPath}" class="text-center">Sign In</a>

    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->
<jsp:include page="include.jsp" />
</body>
</html>
