
// Start Date-Time shower
var monthName = new Array('January', 'Febuary', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December');
var hourap = new Array(12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
function showTime(){
    var dateObj = new Date();
    var day = dateObj.getDate(), month = dateObj.getMonth(), year = dateObj.getFullYear(), hour = dateObj.getHours(), minutes = (dateObj.getMinutes()<=9?'0'+dateObj.getMinutes():dateObj.getMinutes());
    var string  = monthName[month]+
        ' '+day+
        ', '+year+
        '<br />'+hourap[hour]+
        ':'+minutes+
        ' '+(hour<=11?'am':'pm');
    var timeDiv = document.getElementById('time');
    if(timeDiv !== null) {
        timeDiv.innerHTML = string;
        timeDiv.setAttribute('datetime',year+'-'+(month+1<=9?'0'+(month+1):month+1)+'-'+day+' '+hour+':'+minutes);

    };
};
setInterval(showTime,1000);
// End Date-Time shower

//***********

var apiUrl = 'http://localhost:8080';
var ownerPath = '/owner';
var elementsPath = '/machine';
var sparePartsPath='/sparepart';
var navbar;
var sticky;
var stat;



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
            row = row + '<td><button class="btn btn-danger remove-item deleteMenu_item"><span class="glyphicon active glyphicon-remove" aria-hidden="true"></span></button></td>';
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
            row = row + '<td><button class="btn btn-danger remove-item deleteMenu_item"><span class="glyphicon active glyphicon-remove" aria-hidden="true"></span></button></td>';
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
            row = row + '<td><button class="btn btn-danger remove-item deleteMenu_item"><span class="glyphicon active glyphicon-remove" aria-hidden="true"></span></button></td>';
            row = row + '</tr>';
            $('#tableDTOMachine tbody:last-child').append(row);
        });
    });

    stat = "FINALIZED";
    console.log(stat);
    //addFinished();
}

// nope

function addIP()
{

    //('.mdb-select').chosen({width: "95%"});
    $(document).on('click', '#add_button', function () {
        //listSpareParts();
        //('.mdb-select').chosen({width: "95%"});
        var iddata = $('#createid').val();
        var picturedata = $('#createpicture').val();
        var namedata = $('#createname').val();
        var seriesdata = $('#createseries').val();
        //var statusdata = $('#createstatus').val();
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
            url: apiUrl + '/machine/createIP',
            type: 'POST',
            data: jsonCreate,
            dataType: 'text',
            success: function (result) {
                //listSpareParts();
                getElementsListIP();
                alert(result);
                //console.log(result+"*************");
            }
        });
    });
}

// nope

function addWaiting()
{
    $(document).on('click', '#add_button', function () {
        var iddata = $('#createid').val();
        var picturedata = $('#createpicture').val();
        var namedata = $('#createname').val();
        var seriesdata = $('#createseries').val();
        //var statusdata = $('#createstatus').val();
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
            url: apiUrl + '/machine/createWait',
            type: 'POST',
            data: jsonCreate,
            dataType: 'text',
            success: function (result) {
                getElementsListWaiting();
                alert(result);
                //console.log(result+"*************");
            }
        });
    });
}

//nope

function addFinished()
{
    $(document).on('click', '#add_button', function () {
        var iddata = $('#createid').val();
        var picturedata = $('#createpicture').val();
        var namedata = $('#createname').val();
        var seriesdata = $('#createseries').val();
        //var statusdata = $('#createstatus').val();
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
            url: apiUrl + '/machine/createFinish',
            type: 'POST',
            data: jsonCreate,
            dataType: 'text',
            success: function (result) {
                getElementsListFinished();
                alert(result);
                //console.log(result+"*************");
            }
        });
    });

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
            var iddata = $('#createid').val();
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
                    alert(result);
                    //console.log(result+"*************");
                }
            });
        });



        $(document).on('click', '.sparePartsShow_item', function () {

            var index = ($(this).parent().parent()).find('.dataid').html();

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
                    row = row + '<td class="dataquantity" >' + item.quantity + '</td>';
                    row = row + '</tr>';
                    $('#tableSpareParts tbody:last-child').append(row);

                })

            });
            $('#spareParts-item').modal('show');
        });



        // ***

          $(document).on('click', '.sparePartsShowAdd-item', function () {
            //listToAddSpareParts();

            //var index = ($(this).parent().parent()).find('.dataid').html();
            console.log("IIIIIIII");

            $('#tableSparePartsAdd tbody').empty();
            $.getJSON(apiUrl + sparePartsPath + '/', null, function (data)
            {
                $.each(data, function (index, item)
                {
                    var row = '<tr>';
                    row = row + '<td class="dataid">' + item.id +'</td>';
                    row = row + '<td class="datapicture"><img class="imgPic" src="data:image/jpeg;base64,' + item.picture + '"></td>';
                    row = row + '<td class="dataname">' + item.name +'</td>';
                    row = row + '<td class="dataseries">' + item.series +'</td>';
                    row = row + '<td class="dataquantity" >' + item.quantity + '</td>';
                    row = row + '<td class="dataquantity" ><div class="col-md-2>"><div class="input-group"><span class="input-group-btn"><button type="button" class="quantity-left-minus btn btn-danger btn-number"  data-type="minus" data-field=""><span class="glyphicon glyphicon-minus"></span></button></span><input type="text" id="quantity" name="quantity" class="form-control input-number" value="0" min="1" max=' + item.quantity + '><span class="input-group-btn"><button type="button" class="quantity-right-plus btn btn-success btn-number" data-type="plus" data-field=""><span class="glyphicon glyphicon-plus"></span></button></span></div></div></td>';
                    row = row + '</tr>';
                    $('#tableSparePartsAdd tbody:last-child').append(row);

                })

            });
            $('#sparePartsAdd-item').modal('show');


            return false;
        });



        $(document).on('click', '.editMenu_item', function () {
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
            var iddata = $('#editid').val();
            var picturedata = $('#editpicture').val();
            var namedata = $('#editname').val();
            var seriesdata = $('#editseries').val();
            var statusdata = $('#editstatus').val();
            var sparePartIdListdata = $('#editsparePartIdList').val();
            var arrivalDatedata = $('#editarrivalDate').val();
            var owner_iddata = $('#editowner_id').val();

            var jsonEdit = '{"id":"' + iddata + '","picture":"' + picturedata + '","name":"' + namedata + '","series":"' + seriesdata + '","status":"' + statusdata + '","sparePartIdList":[' + sparePartIdListdata + '],"arrivalDate":"' + arrivalDatedata + '","owner_id":"' + owner_iddata + '"}';
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                url: apiUrl + elementsPath + '/move'+ stat +'/'+ iddata,
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

        // add button
        $(document).on('click','.quantity-right-plus', function(e){

            // Stop acting like a button
            e.preventDefault();
            // Get the field name
            var quantity = parseInt($('#quantity').val());

            // If is not undefined

            $('#quantity').val(quantity + 1);


            // Increment

        });

        // minus button

        $(document).on('click','.quantity-left-minus', function(e){
            // Stop acting like a button
            e.preventDefault();
            // Get the field name
            var quantity = parseInt($('#quantity').val());

            // If is not undefined

            // Increment
            if(quantity>0){
                $('#quantity').val(quantity - 1);
            }
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

function listToAddSpareParts()
{

    $('#tableSparePartsAdd tbody').empty();

    $.getJSON(apiUrl + sparePartsPath + '/', null, function (data)
    {
        $.each(data, function (index, item)
        {
            var row = '<tr>';
            row = row + '<td class="dataid">' + item.id +'</td>';
            row = row + '<td class="datapicture"><img class="imgPic" src="data:image/jpeg;base64,' + item.picture + '"></td>';
            row = row + '<td class="dataname">' + item.name +'</td>';
            row = row + '<td class="dataseries">' + item.series +'</td>';
            row = row + '<td class="dataquantity" >' + item.quantity + '</td>';
            row = row + '<td class="dataquantity" ><div class="col-md-2>"><div class="input-group"><span class="input-group-btn"><button type="button" class="quantity-left-minus btn btn-danger btn-number"  data-type="minus" data-field=""><span class="glyphicon glyphicon-minus"></span></button></span><input type="text" id="quantity" name="quantity" class="form-control input-number" value="0" min="1" max=' + item.quantity + '><span class="input-group-btn"><button type="button" class="quantity-right-plus btn btn-success btn-number" data-type="plus" data-field=""><span class="glyphicon glyphicon-plus"></span></button></span></div></div></td>';
            row = row + '</tr>';
            $('#tableSparePartsAdd tbody:last-child').append(row);

        })

    });

    $('#sparePartsAdd-item').modal('show');

    return false;

}

// function () {
//
// }

function refreshIP()
{
    $(document).on('click', '#refresh_menu_button', function () {
        $('#tableDTOMachine tbody').empty();
        getElementsListIP();


    });
}

function refreshWaiting()
{

    $(document).on('click', '#refresh_menu_button', function () {
        $('#tableDTOMachine tbody').empty();
        getElementsListWaiting();
        stat = "WAITING";


    });

}

function refreshFinished()
{

    $(document).on('click', '#refresh_menu_button', function () {
        $('#tableDTOMachine tbody').empty();
        getElementsListFinished();


    });

}

function deleteIP()
{
    $(document).on('click', '.deleteMenu_item', function () {
        var iddata = ($(this).parent().parent()).find('.dataid').html();
        $.ajax({
            url: apiUrl + elementsPath + '/deleteById/' + iddata,
            type: 'DELETE',
            success: function (result) {
                getElementsListIP();
                refreshIP();
                alert(result);
            }, error: function (xhr, textStatus, errorThrown) {
                alert(xhr.responseText);
            }
        });
    });

}

function deleteWaiting()
{
    $(document).on('click', '.deleteMenu_item', function () {
        var iddata = ($(this).parent().parent()).find('.dataid').html();
        $.ajax({
            url: apiUrl + elementsPath + '/deleteById/' + iddata,
            type: 'DELETE',
            success: function (result) {
                //getElementsListWaiting();
                refreshWaiting();
                alert(result);
            }, error: function (xhr, textStatus, errorThrown) {
                alert(xhr.responseText);
            }
        });
    });

}

function deleteFinished()
{
    $(document).on('click', '.deleteMenu_item', function () {
        var iddata = ($(this).parent().parent()).find('.dataid').html();
        $.ajax({
            url: apiUrl + elementsPath + '/deleteById/' + iddata,
            type: 'DELETE',
            success: function (result) {
                getElementsListFinished();
                alert(result);
            }, error: function (xhr, textStatus, errorThrown) {
                alert(xhr.responseText);
            }
        });
    });

}



// populate the select in edit with the spare parts of the machine!!!
function editListSparePartsList()
{
    $('#editsparePartIdList').empty();
    $.getJSON(apiUrl + sparePartsPath + '/', null, function (data)
    {
        $.each(data, function (index, item)
        {
            $('#editsparePartIdList').append("<option class='active' value = '" + item.id + "'>" + item.name + "</option>")
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
    }



}

function getBase64(path)
{
    return path.replace(/^data.*base64,/g, "");
}

function adjustCount(diff)
{
    var sel = document.getElementById('listboxstock');

    if (sel.selectedIndex < 0)
        return; // nothing selected
    var opt = sel.options[sel.selectedIndex];
    opt.textContent = opt.textContent.replace(/\d+/, function (m) {
        return Math.max(0, +m + diff); // adjust, but not below 0
    });
}


// function modalPicture()
// {
//     var modal = document.getElementById('modal-picture');
//
//
//     var idRow = ($(this).parent().parent()).find('.dataid').html();
//     //var pictureIdOfRow = ($(this).parent().parent()).find('.datapicture').html();
//     var indexPicture = ($(this).parent().parent()).find('.datapicture').html();
//
//     var image = document.getElementById(indexPicture);
//
//     var indexModalPicture = indexPicture + idRow;
//
//     var modalPictureElem = document.getElementById("generic");
//     modalPictureElem.id = indexModalPicture;
//     //var enhancedImage = '<img class="modal-content" id="image.indexOf() + indexPicture ">';
//     //var enhancedImage = '<img class="modal-content" id="'image.indexOf()'+'indexPicture'">';
//     //$('#modal-picture').append(enhancedImage);
//     // src="data:image/jpeg;base64,' + item.picture + '">
//
//
//
//     // image.onclick = function(){
//     //     modal.style.display = "block";
//     //     modalPictureElem.src = this.src;
//     //     //captionText.innerHTML = this.alt;
//     //  };
//
//     modal.style.display = "block";
//     modalPictureElem.src = this.src;
//
//
//
//
// // Get the <span> element that closes the modal
//     var span = document.getElementsByClassName("close")[0];
//
// // When the user clicks on <span> (x), close the modal
//     span.onclick = function() {
//         modal.style.display = "none";
//     }
//
//
//
//
//
// }

