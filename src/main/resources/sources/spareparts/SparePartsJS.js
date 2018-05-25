var apiUrl = 'http://localhost:8080';
var elementsPath = '/sparepart';
var stat;
var aux;




function getElementsList() {
    $('#tableDTOSparePart tbody').empty();
    $.getJSON(apiUrl + elementsPath + '/', null, function (data) {
        $.each(data, function (index, item) {
            var row = '<tr>';
            row = row + '<td class="dataid" >' + item.id + '</td>';
            row = row + '<td class="datapicture"><img class="imgPic" src="data:image/jpeg;base64,' + item.picture + '"></td>';
            row = row + '<td class="dataname" >' + item.name + '</td>';
            row = row + '<td class="dataseries" >' + item.series + '</td>';
            row = row + '<td class="dataprice" >' + item.price + '</td>';
            row = row + '<td class="dataquantity" >' + item.quantity + '</td>';
            row = row + '<td class="dataorigin" >' + item.origin + '</td>';
            row = row + '<td><button class="btn edit-item editMenu_item"><span class="glyphicon active glyphicon-pencil" aria-hidden="true"></span></button></td>';
            row = row + '<td><button class="btn btn-danger remove-item deleteMenu_item"><span class="glyphicon active glyphicon-trash" aria-hidden="true"></span></button></td>';
            row = row + '</tr>';
            $('#tableDTOSparePart tbody:last-child').append(row);
        });
    });

    stat = "";
    //document.getElementById('originId').style.display = 'visible';
}

function getElementsListRomania() {
    $('#tableDTOSparePart tbody').empty();
    $.getJSON(apiUrl + elementsPath + '/getByOrigin/ROMANIA', null, function (data) {
        $.each(data, function (index, item) {
            var row = '<tr>';
            row = row + '<td class="dataid" >' + item.id + '</td>';
            row = row + '<td class="datapicture"><img class="imgPic" src="data:image/jpeg;base64,' + item.picture + '"></td>';
            row = row + '<td class="dataname" >' + item.name + '</td>';
            row = row + '<td class="dataseries" >' + item.series + '</td>';
            row = row + '<td class="dataprice" >' + item.price + '</td>';
            row = row + '<td class="dataquantity" >' + item.quantity + '</td>';
            row = row + '<td class="dataorigin" >' + item.origin + '</td>';
            row = row + '<td><button class="btn edit-item editMenu_item"><span class="glyphicon active glyphicon-pencil" aria-hidden="true"></span></button></td>';
            row = row + '<td><button class="btn btn-danger remove-item deleteMenu_item"><span class="glyphicon active glyphicon-trash" aria-hidden="true"></span></button></td>';
            row = row + '</tr>';
            $('#tableDTOSparePart tbody:last-child').append(row);
        });
    });

    stat = "ROMANIA";
    console.log(stat);

}

function getElementsListGermany() {
    $('#tableDTOSparePart tbody').empty();
    $.getJSON(apiUrl + elementsPath + '/getByOrigin/GERMANY', null, function (data) {
        $.each(data, function (index, item) {
            var row = '<tr>';
            row = row + '<td class="dataid" >' + item.id + '</td>';
            row = row + '<td class="datapicture"><img class="imgPic" src="data:image/jpeg;base64,' + item.picture + '"></td>';
            row = row + '<td class="dataname" >' + item.name + '</td>';
            row = row + '<td class="dataseries" >' + item.series + '</td>';
            row = row + '<td class="dataprice" >' + item.price + '</td>';
            row = row + '<td class="dataquantity" >' + item.quantity + '</td>';
            row = row + '<td class="dataorigin" >' + item.origin + '</td>';
            row = row + '<td><button class="btn edit-item editMenu_item"><span class="glyphicon active glyphicon-pencil" aria-hidden="true"></span></button></td>';
            row = row + '<td><button class="btn btn-danger remove-item deleteMenu_item"><span class="glyphicon active glyphicon-trash" aria-hidden="true"></span></button></td>';
            row = row + '</tr>';
            $('#tableDTOSparePart tbody:last-child').append(row);
        });
    });

    stat = "GERMANY";
    console.log(stat);

}


$(document).ready(
    function ()
    {
        stat = "";
        //listOrigin();
        getElements(stat);

        listOrigin();



        $(document).on('click', '.editMenu_item', function () {
            var iddata = ($(this).parent().parent()).find('.dataid').html();
            $('#editid').val(iddata);
            var picturedata = ($(this).parent().parent()).find('.imgPic').attr('src');
            $('#editpicture').attr('src', picturedata);
            var namedata = ($(this).parent().parent()).find('.dataname').html();
            $('#editname').val(namedata);
            var seriesdata = ($(this).parent().parent()).find('.dataseries').html();
            $('#editseries').val(seriesdata);
            var pricedata = ($(this).parent().parent()).find('.dataprice').html();
            $('#editprice').val(pricedata);
            var quantitydata = ($(this).parent().parent()).find('.dataquantity').html();
            $('#editquantity').val(quantitydata);
            var origindata = ($(this).parent().parent()).find('.dataorigin').html();
            $('#editorigin').val(origindata);
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

        $(document).on('click', '#add_menu_button', function () {


            if(stat === 'ROMANIA' || stat === 'GERMANY')
            {
                //document.getElementById('originId').style.display = 'none';
                document.getElementById('originId').style.display = 'none';
                console.log("Intra?");
            }
            else {
                document.getElementById('originId').style.display = '';
                console.log("Vede?");
            }

        });



        $(document).on('click', '#add_button', function () {
            // var iddata = $('#createid').val();
            var iddata = 1;
            var picturedata = getBase64($('#createpicture').attr('src'));
            var namedata = $('#createname').val();
            var seriesdata = $('#createseries').val();
            var pricedata = $('#createprice').val();
            var quantitydata = $('#createquantity').val();
            var origindata;
            console.log("before");

            if(stat === 'ROMANIA' || stat === 'GERMANY')
            {
                origindata = 'EMPTY';
                //$('.originId').hide();
                document.getElementById('originId').style.display = 'none';
                console.log("Intra?");
            }
            else
                {
                origindata = $('#createorigin').val();
            }

            var jsonCreate = '{"id":"' + iddata + '","picture":"' + picturedata + '","name":"' + namedata + '","series":"' + seriesdata + '","price":"' + pricedata + '","quantity":"' + quantitydata + '","origin":"' + origindata + '"}';
            $.ajax({
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'
                },
                url: apiUrl + elementsPath + '/create' + stat,
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
            var picturedata = getBase64($('#editpicture').attr('src'));
            var namedata = $('#editname').val();
            var seriesdata = $('#editseries').val();
            var pricedata = $('#editprice').val();
            var quantitydata = $('#editquantity').val();
            var origindata = $('#editorigin').val();

            var jsonEdit = '{"id":"' + iddata + '","picture":"' + picturedata + '","name":"' + namedata + '","series":"' + seriesdata + '","price":"' + pricedata + '","quantity":"' + quantitydata + '","origin":"' + origindata + '"}';
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
            $('#tableDTOSparePart tbody').empty();
            getElements(stat);
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

function getElements(stat)
{
    if(stat === "")
    {
        getElementsList();
        console.log(stat);
       // document.getElementById('originId').style.display = 'visible';
    }

    if(stat === "ROMANIA")
    {
        getElementsListRomania();
        console.log(stat);
    }

    if(stat === "GERMANY")
    {
        getElementsListGermany();
        console.log(stat);
    }

}

function getBase64(path)
{
    return path.replace(/^data.*base64,/g, "");
}

function listOrigin()
{
    $('#createorigin').empty();

    // for creating
    $('#createorigin').append("<option value = 0>" + "ROMANIA" + "</option>");
    $('#createorigin').append("<option value = 1>" + "GERMANY" + "</option>");

    //for editing
    $('#editowner_id').append("<option class='active' value = 1>" + "ROMANIA" + "</option>");
    $('#editowner_id').append("<option class='active' value = 0>" + "GERMANY" + "</option>");
}

