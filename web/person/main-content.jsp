<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                        <p><strong>Current Program</strong></p>
                        <c:choose>
                            <c:when test="${not empty currentProgram.programName}">
                                <h4>${currentProgram.programName}</h4>
                            </c:when>
                            <c:otherwise>
                                <h4>Nothing to Display</h4>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
            <!-- ./col -->
            <div class="col-lg-3 col-xs-6">
                <!-- small box -->
                <div class="small-box bg-red">
                    <div class="inner">
                        <c:choose>
                            <c:when test="${not empty numberOfRoutines}">
                                <h4>${numberOfRoutines}</h4>
                            </c:when>
                            <c:otherwise>
                                <h4>Nothing to Display</h4>
                            </c:otherwise>
                        </c:choose>
                        <p><strong>Routines This Week</strong></p>
                    </div>
                </div>
            </div>
            <!-- ./col -->
            <div class="col-lg-3 col-xs-6">
                <!-- small box -->
                <div class="small-box bg-green">
                    <div class="inner">
                        <p><strong>Current Week</strong></p>
                        <c:choose>
                            <c:when test="${not empty currentWeek}">
                                <h4>${currentWeek}</h4>
                            </c:when>
                            <c:otherwise>
                                <h4>Nothing to Display</h4>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
            <!-- ./col -->
            <div class="col-lg-3 col-xs-6">
                <!-- small box -->
                <div class="small-box bg-yellow">
                    <div class="inner">
                        <c:choose>
                            <c:when test="${not empty remainingWeeks}">
                                <h4>${remainingWeeks}</h4>
                            </c:when>
                            <c:otherwise>
                                <h4>Nothing to Display</h4>
                            </c:otherwise>
                        </c:choose>
                        <p><strong>Weeks Remaining</strong></p>
                    </div>
                </div>
            </div>
            <!-- ./col -->
        </div>

        <div class="row">
            <c:forEach var="routine" items="${weekRoutines}">
                <div class="col-md-6">
                    <!-- Routine -->
                    <div class="box box-danger">
                        <div class="box-header with-border">
                            <h3 class="box-title">${routine.routineName} Routine <small>Day ${routine.day}</small></h3>

                            <div class="box-tools pull-right">
                                <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                </button>
                                <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i>
                                </button>
                            </div>
                        </div>
                        <!-- /.box-header -->
                        <div class="box-body no-padding">
                            <table class="table table-striped">
                                <thead>
                                <tr>
                                    <th>Exercise</th>
                                    <th>Sets</th>
                                    <th>Reps</th>
                                    <th>Weight</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach var="exercise" items="${routine.routineExercises}">
                                    <tr>
                                        <td>${exercise.exercise.exerciseName}</td>
                                        <td>${exercise.expectedSets}</td>
                                        <td>${exercise.expectedReps}</td>
                                        <td>${exercise.expectedWeight}</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                        <div class="box-footer"></div>
                        <!-- /.box-footer -->
                    </div>
                    <!--/.box -->
                </div>
                <!-- /.col -->
            </c:forEach>
        </div>
        <!-- /.row -->

    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
