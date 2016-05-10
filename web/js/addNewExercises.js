/**
 * Created by felic on 5/8/2016.
 */
$(document).ready(function(){
    var maxField = 10; //Input fields increment limitation
    var addButton = $('.add_button'); //Add button selector
    var wrapper = $('.field_wrapper'); //Input field wrapper
    var fieldHTML =
        '<div class="form-group">' +
        <!-- Text input-->
            '<label class="col-sm-2 control-label" for="exerciseName">Enter Exercise</label>' +
            '<div class="col-md-2">' +
            '<input id="exerciseName" name="exerciseName" placeholder="Exercise Name" class="form-control input-md" type="text">' +
        '</div>' +
        '<div class="col-md-2">' +
            '<select id="exerciseType" name="exerciseType" class="form-control">' +
                '<option value="">Select Type</option>' +
                '<option value="T1">T1 (Primary)</option>' +
                '<option value="T2">T2 (Main Accessory)</option>' +
                '<option value="T3">T3 (Accessory)</option>' +
            '</select>' +
        '</div>' +
        '<div class="col-md-4">' +
            '<input id="exerciseDescription" name="exerciseDescription" placeholder="Exercise Description" class="form-control input-md" type="text">' +
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