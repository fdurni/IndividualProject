<%--
  Created by IntelliJ IDEA.
  User: felic
  Date: 2/14/2016
  Time: 4:55 PM
  To change this template use File | Settings | File Templates.
--%>
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="../dist/img/user.png" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>Alexander Pierce</p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- Sidebar Menu -->
        <ul class="sidebar-menu">
            <li class="header">Main Navigation</li>
            <!-- Optionally, you can add icons to the links -->
            <li class="treeview">
                <a href="#"><span>My Programs</span> <i class="fa fa-angle-left pull-right"></i></a>
                <ul class="treeview-menu">
                    <li><a href="/person/viewProgram">View Program</a></li>
                    <li><a href="/person/addProgram">Add Program</a></li>
                    <li><a href="/person/selectProgram">Add Routine</a></li>
                </ul>
            </li>
            <li class="treeview">
                <a href="/person/progress"><span>My Progress</span></a>
            </li>
            <li class="treeview">
                <a href="/person/personalRecords"><span>My Personal Records</span></a>
            </li>
        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>
