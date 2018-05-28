var apiUrl = 'http://localhost:8080';
var employeePath = '/employee';
var elementsPath = '/task';
var vacationPath = '/vacation';

function listEmployeeTask()
{
    $('#createemployee_id').empty();
    $.getJSON(apiUrl + employeePath + '/', null, function (data)
    {
        $.each(data, function (index, item)
        {
            $('#createemployee_id').append("<option value = '" + item.id + "'>" + item.name + "</option>");

        });
    });
}



function listEmployeeVacation()
{
    $('#createVacationemployee_id').empty();
    $.getJSON(apiUrl + employeePath + '/', null, function (data)
    {
        $.each(data, function (index, item)
        {
            $('#createVacationemployee_id').append("<option value = '" + item.id + "'>" + item.name + "</option>");

        });
    });
}

function listMotives() {
    $('#createVacationmotive').empty();

    // for creating
    $('#createVacationmotive').append("<option value = 0>" + "PLEASURE" + "</option>");
    $('#createVacationmotive').append("<option value = 1>" + "PERSONAL" + "</option>");
    $('#createVacationmotive').append("<option value = 2>" + "SICK" + "</option>");
}



function emptyFormTask()
{
    $('#createid').val('');
    $('#createdate').val('');
    $('#createendHour').val('');
    $('#createstartHour').val('');
    $('#createdescription').val('');

}

function emptyFormVacation()
{
    $('#createVacationid').val('');
    $('#createVacationleave').val('');
    $('#createVacationarrival').val('');
    $('#createVacationdescription').val('');

}

function visualizeTask()
{
    document.getElementById('taskContent').style.display='';
    document.getElementById('vacationContent').style.display='none';
}

function visualizeVacation()
{
    document.getElementById('taskContent').style.display='none';
    document.getElementById('vacationContent').style.display='';
}


function validateDateTask()
{
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1;
    var yyyy = today.getFullYear();
    if(dd<10){
        dd='0'+dd
    }
    if(mm<10){
        mm='0'+mm
    }

    today = yyyy+'-'+mm+'-'+dd;

    $('#createdate').attr('min', today);
}

function validateDateVacation()
{
    var today = new Date();
    var dd = today.getDate();
    var mm = today.getMonth()+1;
    var yyyy = today.getFullYear();
    if(dd<10){
        dd='0'+dd
    }
    if(mm<10){
        mm='0'+mm
    }

    today = yyyy+'-'+mm+'-'+dd;

    $('#createVacationleave').attr('min', today);

}


function validateSecondaryDateVacation()
{
    var minimum = $('#createVacationleave');
    $('#createVacationarrival').attr('min', minimum.val());
}


$(document).ready(
    function () {


        listEmployeeTask();
        listEmployeeVacation();
        listMotives();
        document.getElementById('vacationContent').style.display='none';

        $(document).on('click', '#add_button_task', function () {
            var iddata = $('#createid').val();
            var employee_iddata = $('#createemployee_id').val();
            var datedata = $('#createdate').val();
            var startHourdata = $('#createstartHour').val();
            var endHourdata = $('#createendHour').val();
            var descriptiondata = $('#createdescription').val();

            var jsonCreate = '{"id":"' + iddata + '","employeeId":"' + employee_iddata +'","date":"'+ datedata +'","startHour":"' + startHourdata + '","endHour":"' + endHourdata + '","description":"' + descriptiondata +'","completed":"' + 'NO' + '"}';
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                url: apiUrl + elementsPath + '/create',
                type: 'POST',
                data: jsonCreate,
                dataType: 'text',
                success: function (result) {
                    emptyFormTask();
                    //getElementsList();
                    alert(result);
                }
            });
        });

        $(document).on('click', '#add_button_vacation', function () {
            var iddata = $('#createVacationid').val();
            var employee_iddata = $('#createVacationemployee_id').val();
            var leavedata = $('#createVacationleave').val();
            var arrivaldata = $('#createVacationarrival').val();
            var motivedata = $('#createVacationmotive').val();
            var descriptiondata = $('#createdescription').val();

            var jsonCreate = '{"id":"' + iddata + '","employeeId":"' + employee_iddata +'","leave":"'+ leavedata +'","arrival":"' + arrivaldata + '","motive":"' + motivedata + '","description":"' + descriptiondata + '"}';
            console.log("::::::::: "+jsonCreate);
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                url: apiUrl + vacationPath + '/create',
                type: 'POST',
                data: jsonCreate,
                dataType: 'text',
                success: function (result) {
                    emptyFormVacation();
                    //getElementsList();
                    alert(result);
                }
            });
        });



    });