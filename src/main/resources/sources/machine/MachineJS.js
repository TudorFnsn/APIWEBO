
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
var elementsPath = '/machine';

function getElementsList() {
    $('#tableDTOMachine tbody').empty();
    $.getJSON(apiUrl + elementsPath + '/', null, function (data) {
        $.each(data, function (index, item) {
            var row = '<tr>';
            row = row + '<td class="dataid" >' + item.id + '</td>';
            row = row + '<td class="datapicture" >' + item.picture + '</td>';
            row = row + '<td class="dataname" >' + item.name + '</td>';
            row = row + '<td class="dataseries" >' + item.series + '</td>';
            row = row + '<td class="datastatus" >' + item.status + '</td>';
            row = row + '<td class="datasparePartIdList" >' + item.sparePartIdList + '</td>';
            row = row + '<td class="dataarrivalDate" >' + item.arrivalDate + '</td>';
            row = row + '<td class="dataowner_id" >' + item.owner_id + '</td>';
            row = row + '<td><button class="btn btn-light edit-item editMenu_item"><span class="glyphicon active glyphicon-pencil" aria-hidden="true"></span></button></td>';
            row = row + '<td><button class="btn btn-outline-danger remove-item deleteMenu_item"><span class="glyphicon active glyphicon-remove" aria-hidden="true"></span></button></td>';
            row = row + '</tr>';
            $('#tableDTOMachine tbody:last-child').append(row);
        });
    });
}




//************
$(document).ready(
    function () {
        getElementsList();
        $(document).on('click', '.editMenu_item', function () {
            var iddata = ($(this).parent().parent()).find('.dataid').html();
            $('#editid').val(iddata);
            var picturedata = ($(this).parent().parent()).find('.datapicture').html();
            $('#editpicture').val(picturedata);
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
                    getElementsList();
                    alert(result);
                }, error: function (xhr, textStatus, errorThrown) {
                    alert(xhr.responseText);
                }
            });
        });

        $(document).on('click', '#add_button', function () {
            var iddata = $('#createid').val();
            var picturedata = $('#createpicture').val();
            var namedata = $('#createname').val();
            var seriesdata = $('#createseries').val();
            var statusdata = $('#createstatus').val();
            var sparePartIdListdata = $('#createsparePartIdList').val();
            var arrivalDatedata = $('#createarrivalDate').val();
            var owner_iddata = $('#createowner_id').val();

            var jsonCreate = '{"id":"' + iddata + '","picture":"' + picturedata + '","name":"' + namedata + '","series":"' + seriesdata + '","status":"' + statusdata + '","sparePartIdList":[' + sparePartIdListdata + '],"arrivalDate":"' + arrivalDatedata + '","owner_id":"' + owner_iddata + '"}';
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
                    getElementsList();
                    alert(result);
                }
            });
        });
        $(document).on('click', '#update_button', function () {
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
                url: apiUrl + elementsPath + '/update/' + iddata,
                type: 'POST',
                data: jsonEdit,
                dataType: 'text',
                success: function (result) {
                    getElementsList();
                    alert(result);
                }
            });
        });
        $(document).on('click', '#refresh_menu_button', function () {
            getElementsList();
        });
    });

