/**
 * Created by felic on 5/8/2016.
 */
$(document).ready(function() {

    $('#selectProgram').change(function(event) {
        var programId = $("#selectProgram").val();
        $.get('getRoutines', {
            programId : programId
        }, function(response) {

            var select = $('#selectRoutine');
            select.find('option').remove();
            $('<option>').val('').text('Select Routine').appendTo(select);
            $.each(response, function(index, value) {
                $('<option>').val(value).text(value).appendTo(select);
            });
        });
    });

    $('#selectRoutine').change(function(event) {

        var routineName = $("#selectRoutine").val();
        $.get('getWeeks', {
            routineName : routineName
        }, function(response) {

            var select = $('#selectWeek');
            select.find('option').remove();
            $('<option>').val('').text('Select Week').appendTo(select);
            $.each(response, function(index, value) {
                $('<option>').val(value).text(value).appendTo(select);
            });
        });
    });
});