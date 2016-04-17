<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="content-wrapper">

    <section class="content-header">
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">Add Program</li>
        </ol>
    </section>
    <!-- Main content -->
    <section class="content">

        <!-- Form code begins -->
        <form class="form-horizontal" method="post">

            <fieldset>

                <!-- Form Name -->
                <legend>Add Program</legend>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="programName">Program Name</label>
                    <div class="col-md-4">
                        <input id="programName" name="programName" placeholder="Program Name" class="form-control input-md" type="text">

                    </div>
                </div>

                <!-- Text input-->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="programType">Program Type</label>
                    <div class="col-md-4">
                        <input id="programType" name="programType" placeholder="Program Type" class="form-control input-md" type="text">

                    </div>
                </div>

                <!-- Date input -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="date">Begin Date</label>
                    <div class="col-md-4">
                        <input class="form-control" id="date" name="date" placeholder="MM/DD/YYYY" type="text"/>
                    </div>
                </div>

                <!-- Spinbox -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="spinner">Number of Weeks</label>
                    <div class="spinner col-md-4">
                        <input type="text" id="spinner" class="form-control" value="1">
                        <div class="input-group-btn-vertical">
                            <button class="btn btn-default" type="button"><i class="fa fa-caret-up"></i></button>
                            <button class="btn btn-default" type="button"><i class="fa fa-caret-down"></i></button>
                        </div>
                    </div>
                </div>

                <!-- Textarea -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="programDescription">Program Description</label>
                    <div class="col-md-4">
                        <textarea class="form-control" id="programDescription" name="programDescription"></textarea>
                    </div>
                </div>

                <!-- Submit Button -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="submit"></label>
                    <div class="col-md-4">
                        <button class="btn btn-primary " name="submit" id="submit" type="submit">Go to Step 2</button>
                    </div>
                </div>

            </fieldset>
        </form>
        <!-- Form code ends -->

        <!-- Display programs -->
        <div class="table-responsive">
            <table class="table table-striped">
                <thead>
                <tr>
                    <th>Program Name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="program" items="${programInfo}">
                    <tr>
                        <td>${program.programName}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>

    </section>
    <!-- /.content -->
</div>
<!-- /.content-wrapper -->