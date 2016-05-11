<%--
  Created by IntelliJ IDEA.
  User: felic
  Date: 2/9/2016
  Time: 6:04 PM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="contentType.jsp" />
<html>
<jsp:include page="head.jsp" />
<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">
        <a href="person/home"><b>Training</b>Tracker</a>
    </div>

    <div class="register-box-body">
        <p class="login-box-msg">Registration</p>

        <form id="signUpForm" role="form" action="signUpUser" method="post">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" id="firstName"
                       name="firstName" placeholder="First Name">
                <span class="glyphicon glyphicon-person form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="text" class="form-control" id="lastName"
                       name="lastName" placeholder="Last Name">
                <span class="glyphicon glyphicon-person form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="text" class="form-control" id="userName"
                       name="userName" placeholder="User Name">
                <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" id="password"
                       name="password" placeholder="Password">
                <span class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" id="confirmPassword"
                       name="confirmPassword" placeholder="Retype password">
                <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
            </div>
            <div class="row">
                <!-- /.col -->
                <div class="col-xs-4">
                    <div id="re-captcha"></div>
                    <br />
                </div>
                <!-- /.col -->
            </div>
            <div class="row">
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">Register</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <a href="signIn.jsp" class="text-center">I already have an account</a>
    </div>
    <!-- /.form-box -->
</div>
<!-- /.register-box -->
<jsp:include page="include.jsp" />
<script>
    $(function () {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });

    $( '#signUpForm' ).submit(function() {
        if($('#password').val()!=$('#confirmPassword').val()){
            alert('Passwords do not match');
            return false;
        }
        return true;
    });

    var onloadCallback = function() {

        grecaptcha.render('re-captcha', {
            'sitekey' : '6Lfgvx4TAAAAAKfJcRGVe0O6qqSFPi3YjKxUr-CZ',
            'theme' : 'light'
        });
    };
</script>
</body>
</html>
