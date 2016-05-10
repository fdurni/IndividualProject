/**
 * Created by felic on 5/8/2016.
 */
$(document).ready(function(){
    var maxField = 10; //Input fields increment limitation
    var addButton = $('.add_button'); //Add button selector
    var wrapper = $('.field_wrapper'); //Input field wrapper
    var fieldHTML =
        '<div class="form-group">' +
        '<label class="col-sm-2 control-label" for="exercise">Enter Exercise</label>' +
        '<div class="col-md-2">' +
        '<select id="exercise" name="exercise" class="form-control">' +
        '<option value="">Select Exercise</option>' +
        '<c:forEach var="exercise" items="${exercises}">' +
        '<option value=${exercise.exerciseId}>${exercise.exerciseName}</option>' +
        '</c:forEach>' +
        '</select>' +
        '</div>' +
        '<div class="col-md-2">' +
        '<input id="sets" name="sets" placeholder="Sets" class="form-control input-md" type="text">' +
        '</div>' +
        '<div class="col-md-2">' +
        '<input id="reps" name="reps" placeholder="Reps" class="form-control input-md" type="text">' +
        '</div>' +
        '<div class="col-md-2">' +
        '<input id="weight" name="weight" placeholder="Weight" class="form-control input-md" type="text">' +
        '</div>' +
        '<a href="javascript:void(0);" class="remove_button" title="Remove field"><img height="30px" width="30px" src="../dist/img/remove-button.png"/></a></div>' +
        '</div>';
    var x = 1; //Initial field counter is 1
    $(addButton).click(function(){ //Once add button is clicked
        if(x < maxField){ //Check maximum number of input fields
            x++; //Increment field counter
            $(wrapper).append(fieldHTML); // Add field html
        }
    });
    $(wrapper).on('click', '.remove_button', function(e){ //Once remove button is clicked
        e.preventDefault();
        $(this).parent('div').remove(); //Remove field html
        x--; //Decrement field counter
    });
});