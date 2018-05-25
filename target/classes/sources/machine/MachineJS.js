

//***********

var apiUrl = 'http://localhost:8080';
var ownerPath = '/owner';
var elementsPath = '/machine';
var sparePartsPath='/sparepart';
var navbar;
var sticky;
var stat;

function emptyMachine()
{
    $('#createpicture').attr('src', '');
    $('#createname').val('');
    $('#createseries').val('');
    $('#createsparePartIdList').val('');
    $('#createarrivalDate').val('');
    $('#createowner_id').val('');

}

function getElementsListIP() {
    $('#tableDTOMachine tbody').empty();
    $.getJSON(apiUrl + elementsPath + '/getByStatus/IN_PROGRESS', null, function (data) {
        $.each(data, function (index, item) {
            //console.log(item.sparePartIdList);
            var row = '<tr>';
            row = row + '<td class="dataid" >' + item.id + '</td>';
            // row = row + '<td class="datapicture" >' + item.picture + '</td>';
            row = row + '<td class="datapicture"><img class="imgPic" src="data:image/jpeg;base64,' + item.picture + '"></td>';
            //row = row + '<div class="imageBox">'+ '<img src="data:image/jpeg;base64," >' + ' </div>';
            row = row + '<td class="dataname" >' + item.name + '</td>';
            row = row + '<td class="dataseries" >' + item.series + '</td>';
            row = row + '<td class="datastatus" >' + item.status + '</td>';
            // row = row + '<td class="datasparePartIdList" >' + item.sparePartIdList+ '</td>';
            row = row + '<td class="datasparePartIdList"><button class="btn spareParts-item sparePartsShow_item"><span class="glyphicon active glyphicon-list-alt" aria-hidden="true"></span></button></td>';

            //row = row  + '<td class="datastatus" ><button type="button" ></button></td>';
            row = row + '<td class="dataarrivalDate" >' + item.arrivalDate + '</td>';
            row = row + '<td class="dataowner_id" >' + item.owner_id + '</td>';
            row = row + '<td><button class="btn edit-item editMenu_item"><span class="glyphicon active glyphicon-pencil" aria-hidden="true"></span></button></td>';
            row = row + '<td><button class="btn btn-danger remove-item deleteMenu_item"><span class="glyphicon active glyphicon-trash" aria-hidden="true"></span></button></td>';
            row = row + '</tr>';
            $('#tableDTOMachine tbody:last-child').append(row);
        });
    });

    stat = "IN_PROGRESS";
    console.log(stat);



}


function getElementsListWaiting() {
    $('#tableDTOMachine tbody').empty();
    $.getJSON(apiUrl + elementsPath + '/getByStatus/WAITING', null, function (data) {
        $.each(data, function (index, item) {
            var row = '<tr>';
            row = row + '<td class="dataid" >' + item.id + '</td>';
            row = row + '<td class="datapicture"><img class="imgPic" src="data:image/jpeg;base64,' + item.picture + '"></td>';
            row = row + '<td class="dataname" >' + item.name + '</td>';
            row = row + '<td class="dataseries" >' + item.series + '</td>';
            row = row + '<td class="datastatus" >' + item.status + '</td>';
            // row = row + '<td class="datasparePartIdList" >' + item.sparePartIdList + '</td>';
            row = row + '<td class="datasparePartIdList"><button class="btn spareParts-item sparePartsShow_item"><span class="glyphicon active glyphicon-list-alt" aria-hidden="true"></span></button></td>';
            row = row + '<td class="dataarrivalDate" >' + item.arrivalDate + '</td>';
            row = row + '<td class="dataowner_id" >' + item.owner_id + '</td>';
            row = row + '<td><button class="btn edit-item editMenu_item"><span class="glyphicon active glyphicon-pencil" aria-hidden="true"></span></button></td>';
            row = row + '<td><button class="btn btn-danger remove-item deleteMenu_item"><span class="glyphicon active glyphicon-trash" aria-hidden="true"></span></button></td>';
            row = row + '</tr>';
            $('#tableDTOMachine tbody:last-child').append(row);
        });
    });

    stat = "WAITING";
    console.log(stat);
    //addWaiting();
}

function getElementsListFinished() {
    $('#tableDTOMachine tbody').empty();
    $.getJSON(apiUrl + elementsPath + '/getByStatus/FINALIZED', null, function (data) {
        $.each(data, function (index, item) {
            var row = '<tr>';
            row = row + '<td class="dataid" >' + item.id + '</td>';
            row = row + '<td class="datapicture"><img class="imgPic" src="data:image/jpeg;base64,' + item.picture + '"></td>';
            row = row + '<td class="dataname" >' + item.name + '</td>';
            row = row + '<td class="dataseries" >' + item.series + '</td>';
            row = row + '<td class="datastatus" >' + item.status + '</td>';
            // row = row + '<td class="datasparePartIdList" >' + item.sparePartIdList + '</td>';
            row = row + '<td class="datasparePartIdList"><button class="btn spareParts-item sparePartsShow_item"><span class="glyphicon active glyphicon-list-alt" aria-hidden="true"></span></button></td>';
            row = row + '<td class="dataarrivalDate" >' + item.arrivalDate + '</td>';
            row = row + '<td class="dataowner_id" >' + item.owner_id + '</td>';
            row = row + '<td><button class="btn edit-item editMenu_item"><span class="glyphicon active glyphicon-pencil" aria-hidden="true"></span></button></td>';
            row = row + '<td><button class="btn btn-danger remove-item deleteMenu_item"><span class="glyphicon active glyphicon-trash" aria-hidden="true"></span></button></td>';
            row = row + '</tr>';
            $('#tableDTOMachine tbody:last-child').append(row);
        });
    });

    stat = "FINALIZED";
    console.log(stat);
    //addFinished();
}



//************
$(document).ready(
    function ()
    {
        var quantitiy=0;
        stat = "IN_PROGRESS";
        console.log("BY DEFAULT:" + stat);
        // load the select options to choose owner and spare parts
        listOwner();
        listSpareParts();
        getElements(stat);
        //modalPicture();

        $(document).on('click', '#add_button', function () {
            //var iddata = $('#createid').val();
            var iddata = 1;
            var picturedata = getBase64($('#createpicture').attr('src'));
            var namedata = $('#createname').val();
            var seriesdata = $('#createseries').val();
            var statusdata = 'EMPTY';
            var sparePartIdListdata = $('#createsparePartIdList').val();
            var arrivalDatedata = $('#createarrivalDate').val();
            var owner_iddata = $('#createowner_id').val();

            var jsonCreate = '{"id":"' + iddata + '","picture":"' + picturedata + '","name":"' + namedata + '","series":"' + seriesdata + '","status":"' + statusdata + '","sparePartIdList":[' + sparePartIdListdata + '],"arrivalDate":"' + arrivalDatedata + '","owner_id":"' + owner_iddata + '"}';
            //console.log(jsonCreate);
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                url: apiUrl + '/machine/create'+ stat,
                type: 'POST',
                data: jsonCreate,
                dataType: 'text',
                success: function (result) {
                    //listSpareParts();
                    getElements(stat);
                    emptyMachine();
                    console.log(jsonCreate.toString());
                    alert(result);
                    //console.log(result+"*************");
                }
            });
        });



        $(document).on('click', '.sparePartsShow_item', function () {

            var index = ($(this).parent().parent()).find('.dataid').html();
            //console.log(index);

            $('#tableSpareParts tbody').empty();
            $.getJSON(apiUrl + elementsPath + '/sparePartsOf/' + index, null, function (data)
            {
                $.each(data, function (index, item)
                {
                    var row = '<tr>';
                    row = row + '<td class="dataid">' + item.id +'</td>';
                    row = row + '<td class="datapicture"><img class="imgPic" src="data:image/jpeg;base64,' + item.picture + '"></td>';
                    row = row + '<td class="dataname">' + item.name +'</td>';
                    row = row + '<td class="dataseries">' + item.series +'</td>';
                    row = row + '</tr>';
                    $('#tableSpareParts tbody:last-child').append(row);

                })

            });
            $('#spareParts-item').modal('show');
        });





        $(document).on('click', '.editMenu_item', function () {

            if(stat === "FINALIZED")
            {
                document.getElementById("move_button").style.display = 'none';
            }
            else {
                document.getElementById("move_button").style.display = '';
            }
            var iddata = ($(this).parent().parent()).find('.dataid').html();
            $('#editid').val(iddata);
            var picturedata = ($(this).parent().parent()).find('.imgPic').attr('src');
            $('#editpicture').attr('src', picturedata);
            var namedata = ($(this).parent().parent()).find('.dataname').html();
            $('#editname').val(namedata);
            var seriesdata = ($(this).parent().parent()).find('.dataseries').html();
            $('#editseries').val(seriesdata);
            var statusdata = ($(this).parent().parent()).find('.datastatus').html();
            $('#editstatus').val(statusdata);

            var sparePartIdListdata = ($(this).parent().parent()).find('.datasparePartIdList').html();
            $('#editsparePartIdList').val(sparePartIdListdata);
            var arrivalDatedata = ($(this).parent().parent()).find('.dataarrivalDate').html();
            $('#editarrivalDate').val(arrivalDatedata);
            var owner_iddata = ($(this).parent().parent()).find('.dataowner_id').html();
            $('#editowner_id').val(owner_iddata);
            $('#edit-item').modal('show');
        });

        $(document).on('click', '.deleteMenu_item', function () {
            var iddata = ($(this).parent().parent()).find('.dataid').html();
            $.ajax({
                url: apiUrl + elementsPath + '/deleteById/' + iddata,
                type: 'DELETE',
                success: function (result) {
                    getElements(stat);
                    alert(result);
                    //modalPicture();
                }, error: function (xhr, textStatus, errorThrown) {
                    alert(xhr.responseText);
                }
            });
        });


        $(document).on('click', '#update_button', function () {

            //console.log($("#move_button"));
                var iddata = $('#editid').val();
                var picturedata = getBase64($('#editpicture').attr('src'));
                var namedata = $('#editname').val();
                var seriesdata = $('#editseries').val();
                var statusdata = $('#editstatus').val();
                var sparePartIdListdata = $('#editsparePartIdList').val();
                var arrivalDatedata = $('#editarrivalDate').val();
                var owner_iddata = $('#editowner_id').val();

                var jsonEdit = '{"id":"' + iddata + '","picture":"' + picturedata + '","name":"' + namedata + '","series":"' + seriesdata + '","status":"' + statusdata + '","sparePartIdList":[' + sparePartIdListdata + '],"arrivalDate":"' + arrivalDatedata + '","owner_id":"' + owner_iddata + '"}';
                console.log(jsonEdit);
                $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url: apiUrl + elementsPath + '/update/' + iddata,
                    type: 'POST',
                    data: jsonEdit,
                    dataType: 'text',
                    success: function (result) {
                        getElements(stat);
                        alert(result);
                        //console.log(document.status.toString());
                    }
                });

        });

        $(document).on('click', '#refresh_menu_button', function () {
            $('#tableDTOMachine tbody').empty();
            getElements(stat);
        });

        // drag and drop

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


        $(document).on('click', '#move_button', function () {
            // var moveButton = document.getElementById('move_button');
            //


                var iddata = $('#editid').val();
                var picturedata = $('#editpicture').val();
                var namedata = $('#editname').val();
                var seriesdata = $('#editseries').val();
                var statusdata = $('#editstatus').val();
                var sparePartIdListdata = $('#editsparePartIdList').val();
                var arrivalDatedata = $('#editarrivalDate').val();
                var owner_iddata = $('#editowner_id').val();

                var jsonEdit = '{"id":"' + iddata + '","picture":"' + picturedata + '","name":"' + namedata + '","series":"' + seriesdata + '","status":"' + statusdata + '","sparePartIdList":[' + sparePartIdListdata + '],"arrivalDate":"' + arrivalDatedata + '","owner_id":"' + owner_iddata + '"}';
                console.log(jsonEdit);


                $.ajax({
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    url: apiUrl + elementsPath + '/move' + stat + '/' + iddata,
                    type: 'POST',
                    data: jsonEdit,
                    dataType: 'text',
                    success: function (result) {
                        getElements(stat);
                        // console.log(jsonEdit);
                        alert(result);
                        //console.log(document.status.toString());
                    }
                });

        });


    });

function listOwner()
{
    $('#createowner_id').empty();
    $.getJSON(apiUrl + ownerPath + '/', null, function (data)
    {
        $.each(data, function (index, item)
        {
            $('#createowner_id').append("<option value = '" + item.id + "'>" + item.name + "</option>");
            $('#editowner_id').append("<option class='active' value = '" + item.id + "'>" + item.name + "</option>");
        });
    });
}

function listSpareParts()
{


    $.getJSON(apiUrl + sparePartsPath + '/', null, function (data)
    {
        $.each(data, function (index, item)
        {
            //$('#createsparePartIdList').append("<option class='active' value = '" + item.id + "'>" + item.name + "</option>");
            $('#createsparePartIdList').append("<option class='active' value = '" + item.id + "'><div><span>" + item.name + "</span>" + " <span>100</span></div></option>");
            //$('#createsparePartIdList').append("<div class='input-group'>");

            $('#editsparePartIdList').append("<option class='active' value = '" + item.id + "'>" + item.name + "</option>");
        });
    });


}





function getElements(stat)
{
    if(stat ==="IN_PROGRESS")
    {
        getElementsListIP();
        console.log(stat);
    }

    if(stat === "WAITING")
    {
        getElementsListWaiting();
        console.log(stat);
    }

    if(stat === "FINALIZED")
    {
        getElementsListFinished();
        console.log(stat);
        //hideMoveButton();
    }



}

function getBase64(path)
{
    return path.replace(/^data.*base64,/g, "");
}
