var apiUrl = 'http://localhost:8080';
var elementsPath = '/employee';
var tasksPath = '/task';
var vacationPath = '/vacation';
var stat;

function getElementsListAll()
{
    $('#tableDTOEmployee tbody').empty();
    $.getJSON(apiUrl + elementsPath + '/', null, function (data) {
        $.each(data, function (index, item) {
            var row = '<tr>';
            row = row + '<td class="dataid" >' + item.id + '</td>';
            row = row + '<td class="datapicture"><img class="imgPic" src="data:image/jpeg;base64,' + item.picture + '"></td>';
            row = row + '<td class="dataname" >' + item.name + '</td>';
            row = row + '<td class="datadepartment" >' + item.department + '</td>';
            row = row + '<td class="dataposition" >' + item.position + '</td>';
            row = row + '<td class="datataskIdList"><button class="btn tasks-item tasksShow_item"><span class="glyphicon active glyphicon-th-list" aria-hidden="true"></span></button></td>';
            row = row + '<td class="datataskIdList"><button class="btn vacations-item vacationsShow_item"><span class="glyphicon active glyphicon-plane" aria-hidden="true"></span></button></td>';
            row = row + '<td><button class="btn edit-item editMenu_item"><span class="glyphicon active glyphicon-pencil" aria-hidden="true"></span></button></td>';
            row = row + '<td><button class="btn btn-danger remove-item deleteMenu_item"><span class="glyphicon active glyphicon-trash" aria-hidden="true"></span></button></td>';
            row = row + '</tr>';
            $('#tableDTOEmployee tbody:last-child').append(row);
        });
    });
    
    stat = "";
}

function getElementsListManagement() {
    $('#tableDTOEmployee tbody').empty();
    $.getJSON(apiUrl + elementsPath + '/getByDepartment/MANAGEMENT', null, function (data) {
        $.each(data, function (index, item) {
            var row = '<tr>';
            row = row + '<td class="dataid" >' + item.id + '</td>';
            row = row + '<td class="datapicture"><img class="imgPic" src="data:image/jpeg;base64,' + item.picture + '"></td>';
            row = row + '<td class="dataname" >' + item.name + '</td>';
            row = row + '<td class="datadepartment" >' + item.department + '</td>';
            row = row + '<td class="dataposition" >' + item.position + '</td>';
            row = row + '<td class="datataskIdList"><button class="btn tasks-item tasksShow_item"><span class="glyphicon active glyphicon-th-list" aria-hidden="true"></span></button></td>';
            row = row + '<td class="datataskIdList"><button class="btn vacations-item vacationsShow_item"><span class="glyphicon active glyphicon-plane" aria-hidden="true"></span></button></td>';
            row = row + '<td><button class="btn edit-item editMenu_item"><span class="glyphicon active glyphicon-pencil" aria-hidden="true"></span></button></td>';
            row = row + '<td><button class="btn btn-danger remove-item deleteMenu_item"><span class="glyphicon active glyphicon-trash" aria-hidden="true"></span></button></td>';
            row = row + '</tr>';
            $('#tableDTOEmployee tbody:last-child').append(row);
        });
    });

    stat = "MANAGEMENT";
    console.log(stat);

}

function getElementsListSales() {
    $('#tableDTOEmployee tbody').empty();
    $.getJSON(apiUrl + elementsPath + '/getByDepartment/SALES', null, function (data) {
        $.each(data, function (index, item) {
            var row = '<tr>';
            row = row + '<td class="dataid" >' + item.id + '</td>';
            row = row + '<td class="datapicture"><img class="imgPic" src="data:image/jpeg;base64,' + item.picture + '"></td>';
            row = row + '<td class="dataname" >' + item.name + '</td>';
            row = row + '<td class="datadepartment" >' + item.department + '</td>';
            row = row + '<td class="dataposition" >' + item.position + '</td>';
            row = row + '<td class="datataskIdList"><button class="btn tasks-item tasksShow_item"><span class="glyphicon active glyphicon-th-list" aria-hidden="true"></span></button></td>';
            row = row + '<td class="datataskIdList"><button class="btn vacations-item vacationsShow_item"><span class="glyphicon active glyphicon-plane" aria-hidden="true"></span></button></td>';
            row = row + '<td><button class="btn edit-item editMenu_item"><span class="glyphicon active glyphicon-pencil" aria-hidden="true"></span></button></td>';
            row = row + '<td><button class="btn btn-danger remove-item deleteMenu_item"><span class="glyphicon active glyphicon-trash" aria-hidden="true"></span></button></td>';
            row = row + '</tr>';
            $('#tableDTOEmployee tbody:last-child').append(row);
        });
    });

    stat = "SALES";
    console.log(stat);

}


function getElementsListService() {
    $('#tableDTOEmployee tbody').empty();
    $.getJSON(apiUrl + elementsPath + '/getByDepartment/SERVICE', null, function (data) {
        $.each(data, function (index, item) {
            var row = '<tr>';
            row = row + '<td class="dataid" >' + item.id + '</td>';
            row = row + '<td class="datapicture"><img class="imgPic" src="data:image/jpeg;base64,' + item.picture + '"></td>';
            row = row + '<td class="dataname" >' + item.name + '</td>';
            row = row + '<td class="datadepartment" >' + item.department + '</td>';
            row = row + '<td class="dataposition" >' + item.position + '</td>';
            row = row + '<td class="datataskIdList"><button class="btn tasks-item tasksShow_item"><span class="glyphicon active glyphicon-th-list" aria-hidden="true"></span></button></td>';
            row = row + '<td class="datataskIdList"><button class="btn vacations-item vacationsShow_item"><span class="glyphicon active glyphicon-plane" aria-hidden="true"></span></button></td>';
            row = row + '<td><button class="btn edit-item editMenu_item"><span class="glyphicon active glyphicon-pencil" aria-hidden="true"></span></button></td>';
            row = row + '<td><button class="btn btn-danger remove-item deleteMenu_item"><span class="glyphicon active glyphicon-trash" aria-hidden="true"></span></button></td>';
            row = row + '</tr>';
            $('#tableDTOEmployee tbody:last-child').append(row);
        });
    });

    stat = "SERVICE";
    console.log(stat);

}


function emptyEmployee()
{
    $('#createpicture').attr('src', '');
    $('#createname').val('');
    $('#createposition').val('');




}

$(document).ready(
    function () {


        stat = "";

        getElementsList(stat);

        listDepartment();

        $(document).on('click', '.editMenu_item', function () {
            var iddata = ($(this).parent().parent()).find('.dataid').html();
            $('#editid').val(iddata);
            var picturedata = ($(this).parent().parent()).find('.datapicture').html();
            $('#editpicture').val(picturedata);
            var namedata = ($(this).parent().parent()).find('.dataname').html();
            $('#editname').val(namedata);
            var departmentdata = ($(this).parent().parent()).find('.datadepartment').html();
            $('#editdepartment').val(departmentdata);
            var positiondata = ($(this).parent().parent()).find('.dataposition').html();
            $('#editposition').val(positiondata);
            $('#edit-item').modal('show');
        });

        $(document).on('click', '#refresh_menu_button', function () {
            $('#tableDTOEmployee tbody').empty();
            getElementsList(stat);
        });





        $(document).on('click', '.deleteMenu_item', function () {
            var iddata = ($(this).parent().parent()).find('.dataid').html();
            $.ajax({
                url: apiUrl + elementsPath + '/deleteById/' + iddata,
                type: 'DELETE',
                success: function (result) {
                    getElementsList(stat);
                    alert(result);
                }, error: function (xhr, textStatus, errorThrown) {
                    alert(xhr.responseText);
                }
            });
        });

        $(document).on('click', '.deleteTaskMenu_item', function () {
            var iddata = ($(this).parent().parent()).find('.dataid').html();
            $.ajax({
                url: apiUrl + tasksPath + '/deleteById/' + iddata,
                type: 'DELETE',
                success: function (result) {
                    $('#tasks-item').modal('toggle');
                    alert(result);
                }, error: function (xhr, textStatus, errorThrown) {
                    alert(xhr.responseText);
                }
            });
        });

        $(document).on('click', '.deleteVacationMenu_item', function () {
            var iddata = ($(this).parent().parent()).find('.dataid').html();
            $.ajax({
                url: apiUrl + vacationPath + '/deleteById/' + iddata,
                type: 'DELETE',
                success: function (result) {
                    //getElementsList();
                    $('#vacations-item').modal('toggle');
                    alert(result);
                }, error: function (xhr, textStatus, errorThrown) {
                    alert(xhr.responseText);
                }
            });
        });

        $(document).on('click', '#add_menu_button', function () {

            if(stat === 'MANAGEMENT' || stat === 'SALES' || stat === 'SERVICE')
            {

                document.getElementById('departmentId').style.display = 'none';
                console.log("Intra?");
            }
            else {
                document.getElementById('departmentId').style.visibility = 'visible';
                console.log("Vede?");
            }

        });

        $(document).on('click', '#add_button', function () {
            var iddata = 1;
            var picturedata = getBase64($('#createpicture').attr('src'));
            var namedata = $('#createname').val();
            var departmentdata;
            var positiondata = $('#createposition').val();

            if(stat === 'MANAGEMENT' || stat === 'SALES' || stat === 'SERVICE')
            {
                departmentdata = 'EMPTY';

                document.getElementById('departmentId').style.visibility = 'hidden';
            }
            else
            {
                document.getElementById('departmentId').style.visibility = 'visible';
                departmentdata = $('#createdepartment').val();
            }

            var jsonCreate = '{"id":"' + iddata + '","picture":"' + picturedata + '","name":"' + namedata + '","department":"' + departmentdata + '","position":"' + positiondata + '"}';
            console.log(jsonCreate);
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                url: apiUrl + elementsPath + '/create' + stat,
                type: 'POST',
                data: jsonCreate,
                dataType: 'text',
                success: function (result)
                {
                    getElementsList(stat);
                    emptyEmployee();
                    alert(result);
                }
            });
        });

        $(document).on('click', '#update_button', function () {
            var iddata = $('#editid').val();
            var picturedata = $('#editpicture').val();
            var namedata = $('#editname').val();
            var departmentdata = $('#editdepartment').val();
            var positiondata = $('#editposition').val();

            var jsonEdit = '{"id":"' + iddata + '","picture":"' + picturedata + '","name":"' + namedata + '","department":"' + departmentdata + '","position":"' + positiondata + '"}';
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                url: apiUrl + elementsPath + '/' + iddata,
                type: 'POST',
                data: jsonEdit,
                dataType: 'text',
                success: function (result) {
                    getElementsList(stat);
                    alert(result);
                }
            });
        });

        $(document).on('click', '.confirm_item', function () {
            var iddata = ($(this).parent().parent()).find('.dataid').html();
            var idemployeeId = ($(this).parent().parent()).find('.dataemployeeid').html();
            var datedata = ($(this).parent().parent()).find('.datadate').html();
            var descriptiondata = ($(this).parent().parent()).find('.datadescription').html();
            var starthourdata = ($(this).parent().parent()).find('.datastarthour').html();
            var endhourdata =($(this).parent().parent()).find('.dataendhour').html();
            var completeddata = 'YES';

            var jsonEdit = '{"id":"' + iddata + '","employeeId":"' + idemployeeId + '","date":"' + datedata + '","startHour":"' + starthourdata + '","endhour":"' + endhourdata +'","description":"'+ descriptiondata +'","completed":"'+ completeddata +'"}';
            console.log(jsonEdit);
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                url: apiUrl + tasksPath + '/update/' + iddata,
                type: 'POST',
                data: jsonEdit,
                dataType: 'text',
                success: function (result)
                {

                    $('#tasks-item').modal('toggle');


                    alert(result);
                }
            });
        });


        $(document).on('click', '#refresh_menu_button', function () {
            getElementsList();
        });


        $(document).on('click', '.tasksShow_item', function () {

            var index = ($(this).parent().parent()).find('.dataid').html();
            console.log(index);

            $('#tableTasks tbody').empty();
            $.getJSON(apiUrl + tasksPath + '/getByEmployee/' + index, null, function (data)
            {
                $.each(data, function (index, item)
                {
                    var row = '<tr>';
                    row = row + '<td class="dataid">' + item.id +'</td>';
                    row = row + '<td style="display: none" class="dataemployeeid">' + item.employeeId +'</td>';
                    row = row + '<td class="datadate">' + item.date +'</td>';
                    row = row + '<td class="datadescription">' + item.description +'</td>';
                    row = row + '<td class="datastarthour">' + item.startHour +'</td>';
                    row = row + '<td class="dataendhour">' + item.endHour +'</td>';
                    row = row + '<td class="datacompleted">' + item.completed +'</td>';

                    if(item.completed === 'NO')
                    {
                        row = row + '<td><button class="btn btn-primary confirm_item"><span class="glyphicon active glyphicon-ok-circle" aria-hidden="true"></span></button></td>';
                        console.log("Asta este on ready: " + item.completed);
                    }
                    else
                    {
                        console.log("ESTE?");
                        row = row + '<td><button class="btn btn-primary confirm_item" disabled><span class="glyphicon active glyphicon-ok-circle" aria-hidden="true"></span></button></td>';
                    }

                    row = row + '<td><button class="btn btn-danger remove-item deleteTaskMenu_item"><span class="glyphicon active glyphicon-trash" aria-hidden="true"></span></button></td>';
                    row = row + '</tr>';
                    $('#tableTasks tbody:last-child').append(row);

                })

            });

            $('#tasks-item').modal('show');
        });



        $(document).on('click', '.vacationsShow_item', function () {

            var index = ($(this).parent().parent()).find('.dataid').html();

            $('#tableVacations tbody').empty();
            $.getJSON(apiUrl + vacationPath + '/getByEmployee/' + index, null, function (data)
            {
                $.each(data, function (index, item)
                {
                    var row = '<tr>';
                    row = row + '<td class="dataid">' + item.id +'</td>';
                    row = row + '<td class="datadescription">' + item.description +'</td>';
                    row = row + '<td class="datamotive">' + item.motive +'</td>';
                    row = row + '<td class="dataleave">' + item.leave +'</td>';
                    row = row + '<td class="dataarrival">' + item.arrival +'</td>';
                    row = row + '<td><button class="btn btn-danger remove-item deleteVacationMenu_item"><span class="glyphicon active glyphicon-trash" aria-hidden="true"></span></button></td>';
                    row = row + '</tr>';
                    $('#tableVacations tbody:last-child').append(row);

                })

            });

            $('#vacations-item').modal('show');
        });

        $(document).on('dragover dragenter', ".thumbnail", function (e) {
            e.preventDefault();
            e.stopPropagation();

        });

        $(document).on('drop', ".thumbnail", function (e) {
            var dataTransfer = e.originalEvent.dataTransfer;
            if (dataTransfer && dataTransfer.files.length) {
                e.preventDefault();
                e.stopPropagation();
                $.each(dataTransfer.files, function (i, file) {
                    var reader = new FileReader();
                    reader.onload = $.proxy(function (file, $holder, event) {
                        var imgPath;

                        if (file.type.match("image/jpeg") || file.type.match("image/png"))
                        {
                            imgPath = event.target.result + "";
                        }

                        $(e.target).attr('src', imgPath);
                    }, this, file, e.target);

                    reader.readAsDataURL(file);
                });
            }
        });


        $(document).on('click', '.datapicture', function () {




            $("#ideal").attr("src",$(this).find("img").attr("src"));
            $('#showPicture-item').modal('show');



        });



    });

function getElementsList(stat)
{
    if(stat === "")
    {
        getElementsListAll();
        console.log(stat);
    }

    if(stat === "MANAGEMENT")
    {
        getElementsListManagement();
        console.log(stat);
    }

    if(stat === "SALES")
    {
        getElementsListSales();
        console.log(stat);
    }

    if(stat === "SERVICE")
    {
        getElementsListService();
        console.log(stat);
    }

}

function getBase64(path)
{
    return path.replace(/^data.*base64,/g, "");
}

function listDepartment()
{
    $('#createdepartment').empty();

    // for creating
    $('#createdepartment').append("<option value = 0>" + "MANAGEMENT" + "</option>");
    $('#createdepartment').append("<option value = 1>" + "SALES" + "</option>");
    $('#createdepartment').append("<option value = 2>" + "SERVICE" + "</option>");

    //for editing
    $('#editowner_id').append("<option class='active' value = 1>" + "ROMANIA" + "</option>");
    $('#editowner_id').append("<option class='active' value = 0>" + "GERMANY" + "</option>");
}
