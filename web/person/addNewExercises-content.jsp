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
        <form class="form-horizontal" method="post">

            <fieldset>
                <!-- Form Name -->
                <legend>Add Exercises to Existing Routine</legend>

                <div class="field_wrapper">
                    <div class="form-group">
                        <!-- Text input-->
                        <label class="col-sm-2 control-label" for="exerciseName">Enter Exercise</label>
                        <div class="col-md-2">
                            <input id="exerciseName" name="exerciseName" placeholder="Exercise Name" class="form-control input-md" type="text">
                        </div>
                        <div class="col-md-2">
                            <select id="exerciseType" name="exerciseType" class="form-control">
                                <option value="">Select Type</option>
                                <option value="T1">T1 (Primary)</option>
                                <option value="T2">T2 (Main Accessory)</option>
                                <option value="T3">T3 (Accessory)</option>
                            </select>
                        </div>
                        <div class="col-md-4">
                            <input id="exerciseDescription" name="exerciseDescription" placeholder="Exercise Description" class="form-control input-md" type="text">
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