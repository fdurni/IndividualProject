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
            View Program Details
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">View Program Details</li>
        </ol>
    </section>
    <!-- Main content -->
    <section class="content">

        <!-- Form code begins -->
        <form class="form-horizontal" method="post">

            <fieldset>

                <!-- Select Basic -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="selectProgram">Select Program</label>
                    <div class="col-md-4">
                        <select id="selectProgram" name="selectProgram" class="form-control">
                            <option value="">Select Program</option>
                            <c:forEach var="program" items="${personPrograms}">
                                <option value=${program.programId}>${program.programName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <!-- Select Basic -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="selectRoutine">Select Routine</label>
                    <div class="col-md-4">
                        <select id="selectRoutine" name="selectRoutine" class="form-control">
                            <option value="">Select Routine</option>
                        </select>
                    </div>
                </div>

                <!-- Select Basic -->
                <div class="form-group">
                    <label class="col-sm-2 control-label" for="selectWeek">Select Week</label>
                    <div class="col-md-4">
                        <select id="selectWeek" name="selectWeek" class="form-control">
                            <option value="">Select Week</option>
                        </select>
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
