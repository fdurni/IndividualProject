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
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">View Routine Details</li>
        </ol>
    </section>
    <!-- Main content -->
    <section class="content">

        <!-- Form code begins -->
        <form method="post">

            <fieldset>

                <div>
                    <input id="routineId" name="routineId" value="${selectedRoutine.routineId}" hidden="true" readonly="readonly" type="text">
                    <input id="programId" name="programId" value="${selectedRoutine.program.programId}" hidden="true" readonly="readonly" type="text">
                </div>
                <div>
                    <h4><b>Name: </b><input id="routineName" name="routineName" value="${selectedRoutine.routineName}" type="text" size="30"></h4>
                    <h4><b>Description: </b><input id="routineDescription" name="routineDescription" value="${selectedRoutine.routineDescription}" type="text" size="50"></h4>
                    <h4><b>Week: </b><input id="week" name="week" value="${selectedRoutine.week}" type="text" size="5"></h4>
                    <h4><b>Day: </b><input id="day" name="day" value="${selectedRoutine.day}" type="text" size="5"></h4>
                </div>
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th style="display:none;">Routine Exercise Id</th>
                        <th style="display:none;">Exercise Id</th>
                        <th style="display:none;">Routine Id</th>
                        <th>Exercise</th>
                        <th>Sets</th>
                        <th>Reps</th>
                        <th>Weight</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="exercise" items="${selectedRoutine.routineExercises}">
                        <tr>
                            <td style="display:none;"><input id="routineexerciseId" name="routineexerciseId" value="${exercise.routineexerciseId}" hidden="true" readonly="readonly" type="text"></td>
                            <td style="display:none;"><input id="routineexerciseexerciseId" name="routineexerciseexerciseId" value="${exercise.exercise.exerciseId}" hidden="true" readonly="readonly" type="text"></td>
                            <td style="display:none;"><input id="routineexerciseroutineId" name="routineexerciseroutineId" value="${exercise.routine.routineId}" hidden="true" readonly="readonly" type="text"></td>
                            <td>${exercise.exercise.exerciseName}</td>
                            <td><input id="expectedSets" name="expectedSets" value="${exercise.expectedSets}" type="text" size="5"></td>
                            <td><input id="expectedReps" name="expectedReps" value="${exercise.expectedReps}" type="text" size="5"></td>
                            <td><input id="expectedWeight" name="expectedWeight" value="${exercise.expectedWeight}" type="text" size="5"></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

                <!-- Submit Button -->
                <div class="form-group">
                    <div class="col-md-4">
                        <button class="btn btn-primary " name="submit" id="submit" type="submit">Submit</button>
                        <button class="btn btn-primary " name="cancel" id="cancel" type="submit">Cancel</button>
                    </div>
                </div>

            </fieldset>
        </form>
    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->
