<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content-wrapper">

    <section class="content-header">
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Add Routine</li>
        </ol>
    </section>
    <!-- Main content -->
    <section class="content">

        <!-- Form code begins -->
        <form class="form-horizontal" method="post">

            <fieldset>

                <!-- Form Name -->
                <legend>Add Routine</legend>

                <!-- Select Basic -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="program">Selected Program</label>
                    <div class="col-md-4">
                        <input id="program" name="program" value="${selectedProgram.programId}" class="form-control input-md" readonly="readonly" type="text">
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="routineName">Routine Name</label>
                    <div class="col-md-4">
                        <input id="routineName" name="routineName" placeholder="Routine Name" class="form-control input-md" type="text">
                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="routineDescription">Routine Description</label>
                    <div class="col-md-4">
                        <input id="routineDescription" name="routineDescription" placeholder="Routine Description" class="form-control input-md" type="text">
                    </div>
                </div>

                <!-- Multiple Radios (inline) -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="radios-0">Day of Week</label>
                    <div class="col-md-4">
                        <label class="radio-inline" for="radios-0">
                            <input name="radios" id="radios-0" value="1" checked="checked" type="radio">
                            1
                        </label>
                        <label class="radio-inline" for="radios-1">
                            <input name="radios" id="radios-1" value="2" type="radio">
                            2
                        </label>
                        <label class="radio-inline" for="radios-2">
                            <input name="radios" id="radios-2" value="3" type="radio">
                            3
                        </label>
                        <label class="radio-inline" for="radios-3">
                            <input name="radios" id="radios-3" value="4" type="radio">
                            4
                        </label>
                        <label class="radio-inline" for="radios-4">
                            <input name="radios" id="radios-4" value="5" type="radio">
                            5
                        </label>
                        <label class="radio-inline" for="radios-5">
                            <input name="radios" id="radios-5" value="6" type="radio">
                            6
                        </label>
                        <label class="radio-inline" for="radios-6">
                            <input name="radios" id="radios-6" value="7" type="radio">
                            7
                        </label>
                    </div>
                </div>
                <!-- Multiple Checkboxes (inline) -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="checkboxes-${i}">Occurs on Weeks</label>
                    <div class="col-md-8">
                        <c:forEach var="i" begin="1" end="${selectedProgram.numberOfWeeks}">
                            <label class="checkbox-inline" for="checkboxes-${i}">
                                <input name="checkboxes" id="checkboxes-${i}" value="${i}" type="checkbox">
                                    ${i}
                            </label>
                        </c:forEach>
                    </div>
                </div>

                <!-- Select Basic -->
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
                    <label class="col-sm-2 control-label" for="submit"></label>
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