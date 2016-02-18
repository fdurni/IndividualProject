<%--
  Created by IntelliJ IDEA.
  User: felic
  Date: 2/14/2016
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<!-- Content Wrapper. Contains page content -->
<div class="content-wrapper">

    <section class="content-header">
        <h1>
            Dashboard
            <small>Control panel</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Dashboard</li>
        </ol>
    </section>
    <!-- Main content -->
    <section class="content">
        <!-- Small boxes (Stat box) -->
        <div class="row">
            <div class="col-lg-3 col-xs-6">
                <!-- small box -->
                <div class="small-box bg-aqua">
                    <div class="inner">
                        <h3>25<sup style="font-size: 20px">%</sup></h3>

                        <p>through program</p>
                    </div>
                    <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                </div>
            </div>
            <!-- ./col -->
            <div class="col-lg-3 col-xs-6">
                <!-- small box -->
                <div class="small-box bg-green">
                    <div class="inner">
                        <h3>3</h3>

                        <p>sessions remaining this week</p>
                    </div>
                    <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                </div>
            </div>
            <!-- ./col -->
            <div class="col-lg-3 col-xs-6">
                <!-- small box -->
                <div class="small-box bg-yellow">
                    <div class="inner">
                        <h3>2</h3>

                        <p>weeks until deload</p>
                    </div>
                    <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                </div>
            </div>
            <!-- ./col -->
            <div class="col-lg-3 col-xs-6">
                <!-- small box -->
                <div class="small-box bg-red">
                    <div class="inner">
                        <h3>2</h3>

                        <p>weeks until check-in</p>
                    </div>
                    <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
                </div>
            </div>
            <!-- ./col -->
        </div>
        <!-- /.row -->
        <div class="box box-primary">
            <div class="box-header with-border">
                <h3 class="box-title">Line Chart</h3>
            </div>
            <div class="box-body">
                <div id="mainChart" style="width:100%; height:400px;"></div>
            </div>
            <!-- /.box-body -->
        </div>
        <!-- /.box -->

        <div class="row">
            <div class="col-md-6">

                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">Goal Progress</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body no-padding">
                        <table class="table table-striped">
                            <tr>
                                <th>Exercise</th>
                                <th>Progress</th>
                                <th style="width: 40px"></th>
                            </tr>
                            <tr>
                                <td>Squat</td>
                                <td>
                                    <div class="progress progress-xs progress-striped active">
                                        <div class="progress-bar progress-bar-success" style="width: 55%"></div>
                                    </div>
                                </td>
                                <td><span class="badge bg-green">275/300</span></td>
                            </tr>
                            <tr>
                                <td>Deadlift</td>
                                <td>
                                    <div class="progress progress-xs progress-striped active">
                                        <div class="progress-bar progress-bar-yellow" style="width: 70%"></div>
                                    </div>
                                </td>
                                <td><span class="badge bg-yellow">300/315</span></td>
                            </tr>
                            <tr>
                                <td>Bench</td>
                                <td>
                                    <div class="progress progress-xs progress-striped active">
                                        <div class="progress-bar progress-bar-primary" style="width: 30%"></div>
                                    </div>
                                </td>
                                <td><span class="badge bg-light-blue">145/160</span></td>
                            </tr>
                        </table>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
            <!-- /.col -->
            <div class="col-md-6">
                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">Training Routine</h3>
                    </div>
                    <!-- /.box-header -->
                    <div class="box-body">
                        <table id="example2" class="table table-bordered table-hover">
                            <thead>
                            <tr>
                                <th>Exercise</th>
                                <th>Sets</th>
                                <th>Reps</th>
                                <th>Weight</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>Deadlift</td>
                                <td>1</td>
                                <td>1</td>
                                <td>270</td>
                            </tr>
                            <tr>
                                <td>Deadlift</td>
                                <td>3</td>
                                <td>3</td>
                                <td>250</td>
                            </tr>
                            <tr>
                                <td>Deficit Deadlift</td>
                                <td>3</td>
                                <td>3</td>
                                <td>185</td>
                            </tr>
                            <tr>
                                <td>Linear Leg Press</td>
                                <td>4</td>
                                <td>10</td>
                                <td>Heavy</td>
                            </tr>
                            <tr>
                                <td>Lying Leg Curl</td>
                                <td>4</td>
                                <td>10</td>
                                <td>50</td>
                            </tr>
                            <tr>
                                <td>Adductor</td>
                                <td>3</td>
                                <td>20</td>
                                <td>50</td>
                            </tr>
                            <tr>
                                <td>Abductor</td>
                                <td>3</td>
                                <td>20</td>
                                <td>50</td>
                            </tr>
                            <tr>
                                <td>Rolling Plank</td>
                                <td>3</td>
                                <td>5</td>
                                <td>5 Sec hold</td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                    <!-- /.box-body -->
                </div>
                <!-- /.box -->
            </div>
            <!-- /.col -->
        </div>
        <!-- /.row -->

    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->