var apiUrl = 'http://localhost:8080';
var elementsPath = '/news';



function getElementsList() {
    $('#tableDTONews tbody').empty();
    $.getJSON(apiUrl + elementsPath + '/', null, function (data) {
        $.each(data, function (index, item) {
            //console.log(item.sparePartIdList);
            var row = '<tr>';
            row = row + '<td class="dataid" >' + item.id + '</td>';
            row = row + '<td class="datatitle" >' + item.title + '</td>';
            row = row + '<td class="datapicture"><img class="imgPic" src="data:image/jpeg;base64,' + item.picture + '"></td>';
            row = row + '<td class="datastartDate" >' + item.startDate + '</td>';
            row = row + '<td class="dataendDate" >' + item.endDate + '</td>';
            row = row + '<td><button class="btn edit-item editMenu_item"><span class="glyphicon active glyphicon-pencil" aria-hidden="true"></span></button></td>';
            row = row + '<td><button class="btn btn-danger remove-item deleteMenu_item"><span class="glyphicon active glyphicon-trash" aria-hidden="true"></span></button></td>';
            row = row + '</tr>';
            $('#tableDTONews tbody:last-child').append(row);
        });
    });

}

$(document).ready(
    function ()
    {
        getElementsList();


        $(document).on('click', '#add_button', function () {
            //var iddata = $('#createid').val();
            var iddata = 1;
            var titledata = $('#createtitle').val();
            var picturedata = getBase64($('#createpicture').attr('src'));
            var startDatedata = $('#createstartDate').val();
            var endDatedata = $('#createendDate').val();

            var jsonCreate = '{"id":"' + iddata + '","title":"' + titledata + '","picture":"' + picturedata + '","startDate":"' + startDatedata + '","endDate":"' + endDatedata + '"}';
            //console.log(jsonCreate);
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                url: apiUrl + elementsPath +'/create',
                type: 'POST',
                data: jsonCreate,
                dataType: 'text',
                success: function (result) {
                    //listSpareParts();
                    getElementsList();

                    alert(result);
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
            var iddata = ($(this).parent().parent()).find('.dataid').html();
            $('#editid').val(iddata);
            var titledata = ($(this).parent().parent()).find('.datatitle').html();
            $('#edittitle').val(titledata);
            var picturedata = ($(this).parent().parent()).find('.imgPic').attr('src');
            $('#editpicture').attr('src', picturedata);
            var startDatedata = ($(this).parent().parent()).find('.datastartDate').html();
            $('#editstartDate').val(startDatedata);
            var endDatedata = ($(this).parent().parent()).find('.dataendDate').html();
            $('#editendDate').val(endDatedata);


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
                    //modalPicture();
                }, error: function (xhr, textStatus, errorThrown) {
                    alert(xhr.responseText);
                }
            });
        });


        $(document).on('click', '#update_button', function () {

            //console.log($("#move_button"));
            var iddata = $('#editid').val();
            var titledata = $('#edittitle').val();
            var picturedata = getBase64($('#editpicture').attr('src'));
            var startDatedata = $('#editstartDate').val();
            var endDatedata = $('#editendDate').val();

            var jsonEdit = '{"id":"' + iddata + '","title":"' + titledata + '","picture":"' + picturedata + '","startDate":"' + startDatedata + '","endDate":"' + endDatedata + '"}';
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
                    getElementsList();
                    alert(result);
                    //console.log(document.status.toString());
                }
            });

        });

        $(document).on('click', '#refresh_menu_button', function () {
            $('#tableDTONews tbody').empty();
            getElementsList();
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

    });

function getBase64(path)
{
    return path.replace(/^data.*base64,/g, "");
}