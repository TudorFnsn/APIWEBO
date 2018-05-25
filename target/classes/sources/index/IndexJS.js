//
//
// $(document).ready(function(){
//     for(var i=0 ; i< m.length ; i++) {
//         $('<div class="item"><img src="'+m[i]+'"><div class="carousel-caption"></div>   </div>').appendTo('.carousel-inner');
//         $('<li data-target="#carousel-example-generic" data-slide-to="'+i+'"></li>').appendTo('.carousel-indicators')
//
//     }
//     $('.item').first().addClass('active');
//     $('.carousel-indicators > li').first().addClass('active');
//     $('#carousel-example-generic').carousel();
// });


function getAllNews()
{
    $('#insertPicturesHere').empty();
    $.getJSON('http://localhost:8080/news/', null, function (data) {
        $.each(data, function (index, item) {
            //console.log(item.sparePartIdList);
            // var row = '<tr>';
            // row = row + '<td class="dataid" >' + item.id + '</td>';
            // // row = row + '<td class="datapicture" >' + item.picture + '</td>';
            // row = row + '<td class="datapicture"><img class="imgPic" src="data:image/jpeg;base64,' + item.picture + '"></td>';
            // //row = row + '<div class="imageBox">'+ '<img src="data:image/jpeg;base64," >' + ' </div>';
            // row = row + '<td class="dataname" >' + item.name + '</td>';
            // row = row + '<td class="dataseries" >' + item.series + '</td>';
            // row = row + '<td class="datastatus" >' + item.status + '</td>';
            // // row = row + '<td class="datasparePartIdList" >' + item.sparePartIdList+ '</td>';
            // row = row + '<td class="datasparePartIdList"><button class="btn spareParts-item sparePartsShow_item"><span class="glyphicon active glyphicon-list-alt" aria-hidden="true"></span></button></td>';
            //
            // //row = row  + '<td class="datastatus" ><button type="button" ></button></td>';
            // row = row + '<td class="dataarrivalDate" >' + item.arrivalDate + '</td>';
            // row = row + '<td class="dataowner_id" >' + item.owner_id + '</td>';
            // row = row + '<td><button class="btn edit-item editMenu_item"><span class="glyphicon active glyphicon-pencil" aria-hidden="true"></span></button></td>';
            // row = row + '<td><button class="btn btn-danger remove-item deleteMenu_item"><span class="glyphicon active glyphicon-trash" aria-hidden="true"></span></button></td>';
            // row = row + '</tr>';

            var row = '<div class="carousel-item active">';
            row = row + '<img class="d-block w-100" src="data:image/jpeg;base64,' + item.picture + '" alt="">';
            row = row + '</div>';

            // $('#tableDTOMachine tbody:last-child').append(row);
            $('#insertPicturesHere').append(row);

        });
    });
}



$(document).ready(
    function () {
        getAllNews();



        // listEmployeeTask();
        // listEmployeeVacation();
        // listMotives();
        // document.getElementById('vacationContent').style.display='none';
        //
        // $(document).on('click', '#add_button_task', function () {
        //     var iddata = $('#createid').val();
        //     var employee_iddata = $('#createemployee_id').val();
        //     var datedata = $('#createdate').val();
        //     var startHourdata = $('#createstartHour').val();
        //     var endHourdata = $('#createendHour').val();
        //     var descriptiondata = $('#createdescription').val();
        //
        //     var jsonCreate = '{"id":"' + iddata + '","employeeId":"' + employee_iddata +'","date":"'+ datedata +'","startHour":"' + startHourdata + '","endHour":"' + endHourdata + '","description":"' + descriptiondata +'","completed":"' + 'NO' + '"}';
        //     $.ajax({
        //         headers: {
        //             'Accept': 'application/json',
        //             'Content-Type': 'application/json'
        //         },
        //         url: apiUrl + elementsPath + '/create',
        //         type: 'POST',
        //         data: jsonCreate,
        //         dataType: 'text',
        //         success: function (result) {
        //             emptyFormTask();
        //             //getElementsList();
        //             alert(result);
        //         }
        //     });
        // });
        //
        // $(document).on('click', '#add_button_vacation', function () {
        //     var iddata = $('#createVacationid').val();
        //     var employee_iddata = $('#createVacationemployee_id').val();
        //     var leavedata = $('#createVacationleave').val();
        //     var arrivaldata = $('#createVacationarrival').val();
        //     var motivedata = $('#createVacationmotive').val();
        //     var descriptiondata = $('#createdescription').val();
        //
        //     var jsonCreate = '{"id":"' + iddata + '","employeeId":"' + employee_iddata +'","leave":"'+ leavedata +'","arrival":"' + arrivaldata + '","motive":"' + motivedata + '","description":"' + descriptiondata + '"}';
        //     $.ajax({
        //         headers: {
        //             'Accept': 'application/json',
        //             'Content-Type': 'application/json'
        //         },
        //         url: apiUrl + vacationPath + '/create',
        //         type: 'POST',
        //         data: jsonCreate,
        //         dataType: 'text',
        //         success: function (result) {
        //             emptyFormVacation();
        //             //getElementsList();
        //             alert(result);
        //         }
        //     });
        // });



    });