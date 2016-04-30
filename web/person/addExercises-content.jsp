<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content-wrapper">

    <section class="content-header">
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Add Exercises</li>
        </ol>
    </section>
    <!-- Main content -->
    <section class="content">

        <!-- Form code begins -->
        <form class="form-horizontal" method="post" action="javascript:alert(grecaptcha.getResponse(widgetId1));">

            <fieldset>

                <!-- Form Name -->
                <legend>Add Exercises</legend>

                <div class="form-group">
                    <label class="col-sm-2 control-label" for="exercise">Select Routine</label>
                    <div class="col-md-4">
                        <select id="routine" name="routine" class="form-control">
                            <option value="">Select Routine</option>
                            <c:forEach var="routine" items="${routines}">
                                <option value=${routine.routineId}>${routine.routineName} - Week ${routine.week}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="field_wrapper">
                    <div class="form-group">
                        <label class="col-sm-2 control-label" for="exercise">Enter Exercise</label>
                        <div class="col-md-2">
                            <select id="exercise" name="exercise" class="form-control">
                                <option value="">Select Exercise</option>
                                <c:forEach var="exercise" items="${exercises}">
                                    <option value=${exercise.exerciseId}>${exercise.exerciseName}</option>
                                    </c:forEach>
                                </select>
                        </div>
                        <div class="col-md-2">
                            <input id="sets" name="sets" placeholder="Sets" class="form-control input-md" type="text">
                        </div>
                        <div class="col-md-2">
                            <input id="reps" name="reps" placeholder="Reps" class="form-control input-md" type="text">
                        </div>
                        <div class="col-md-2">
                            <input id="weight" name="weight" placeholder="Weight" class="form-control input-md" type="text">
                        </div>
                        <a href="javascript:void(0);" class="add_button" title="Add Exercise"><img height="30px" width="30px" src="../dist/img/button_plus_red.png"/></a>
                    </div>
                </div>
                <!-- Submit Button -->
                <div class="form-group">
                    <div class="col-sm-2"></div>
                    <div class="col-md-4">
                        <button class="btn btn-primary " name="submit" id="submit" type="submit">Submit</button>
                    </div>
                </div>

            </fieldset>
        </form>
        <!-- Form code ends -->

    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->