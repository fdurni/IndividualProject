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
    <div class="login-box-body">
        <p class="login-box-msg">Sign in</p>

        <form action="j_security_check" method="post">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="User Name" name="j_username">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" placeholder="Password" name="j_password">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox"> Remember Me
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <a href="/signUpUser" class="text-center">Register</a>

    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->
<jsp:include page="include.jsp" />
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
</script>
</body>
</html>
