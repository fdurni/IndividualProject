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
            View Routine Details
            <a href="updateRoutine" class="update_button" title="Update Routine"><img height="15px" src="../dist/img/update.jpg"/></a>
            <a href="javascript:void(0);" class="delete_button" title="Delete Routine"><img height="15px" src="../dist/img/delete.jpg"/></a>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">View Routine Details</li>
        </ol>
    </section>
    <!-- Main content -->
    <section class="content">

        <div>
            <input id="routine" name="routine" value="${selectedRoutine.routineId}" hidden="true" readonly="readonly" type="text">
        </div>
        <div>
            <h4><b>Name: </b>${selectedRoutine.routineName}</h4>
            <h4><b>Description: </b>${selectedRoutine.routineDescription}</h4>
            <h4><b>Week: </b>${selectedRoutine.week}</h4>
            <h4><b>Day: </b>${selectedRoutine.day}</h4>
        </div>
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
            <c:forEach var="exercise" items="${selectedRoutine.routineExercises}">
                <tr>
                    <td>${exercise.exercise.exerciseName}</td>
                    <td>${exercise.expectedSets}</td>
                    <td>${exercise.expectedReps}</td>
                    <td>${exercise.expectedWeight}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
