<%--
  Created by IntelliJ IDEA.
  User: felic
  Date: 2/14/2016
  Time: 4:58 PM
  To change this template use File | Settings | File Templates.
--%>
<!-- Main Header -->
<header class="main-header">

    <!-- Logo -->
    <a href="${pageContext.request.contextPath}" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>T</b> T</span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>Training</b>Tracker</span>
    </a>

    <!-- Header Navbar -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>
        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- User Account Menu -->
                <li class="dropdown user user-menu">
                    <!-- Menu Toggle Button -->
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <!-- The user image in the navbar-->
                        <img src="${pageContext.request.contextPath}/dist/img/user.png" class="user-image" alt="User Image">
                        <!-- hidden-xs hides the username on small devices so only the image appears. -->
                        <span class="hidden-xs">${name}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- The user image in the menu -->
                        <li class="user-header">
                            <img src="${pageContext.request.contextPath}/dist/img/user.png" class="img-circle" alt="User Image">

                            <p>
                                ${name}
                            </p>
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-right">
                                <a href="${pageContext.request.contextPath}/person/signOut" class="btn btn-default btn-flat">Sign out</a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </nav>
</header>