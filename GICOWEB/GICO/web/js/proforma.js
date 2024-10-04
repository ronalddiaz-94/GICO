/*------------------------------DATA TABLE product----------------------------------------*/
/* global resultEmail, moment */

const path_services = "/GICO-AD/webresources";
const path = "/proforma";
$(document).ready(function () {
//-----------------------MODAL.-------------------------------
    var formulario = document.form_select_client,
            elementosAdd = formulario.elements;
    var formulario = document.form_update_client,
            elementosUpdate = formulario.elements;

//     Funcion que se ejecuta cuando el evento click es activado
    var focusInput = function () {
        this.parentElement.children[1].className = "label active";
        this.parentElement.children[0].className = this.parentElement.children[0].className.replace("error", "");
    };
    var blurInput = function () {
        if (this.value <= 0) {
            this.parentElement.children[1].className = "label";
            this.parentElement.children[0].className = this.parentElement.children[0].className + " error";
        }
    };
    // --- Eventos ---
    for (var i = 0; i < elementosAdd.length; i++) {
        if (elementosAdd[i].type === "text" || elementosAdd[i].type === "number") {
            elementosAdd[i].addEventListener("focus", focusInput);
            elementosAdd[i].addEventListener("blur", blurInput);
        }
    }
    for (var i = 0; i < elementosUpdate.length; i++) {
        if (elementosUpdate[i].type === "text" || elementosUpdate[i].type === "number") {
            elementosUpdate[i].addEventListener("focus", focusInput);
            elementosUpdate[i].addEventListener("blur", blurInput);
        }
    }
    //-------------------------FIN VENTANA MODAL----------------------------------------
    var temp = 0;
    $.ajax({
        url: "/GICO-AD/webresources/client/listClient",
        type: 'GET',
        dataType: 'json',
        dataSrc: '',
        success: function (datas) {
            console.log(datas);
            console.log(datas.length);
            console.log(datas[0].userTypeDescription);
            $(document).ready(function () {
                $("#selectClient-addModal").select2();
            });
            if (temp === 0) {
                temp++;
                for (var i = 0; i < datas.length; i++) {
                    $("#selectClient-addModal").append(
                            '<option value="' + datas[i].clientId + '">' + datas[i].clientName + '</option>'
                            );
                }
            }
        }
    });

    let table = $('#gblTable').DataTable({
        dom: 'Blfrtip',
        lengthMenu: [5, 10, 25, 50],
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ],
        order: [ 0, "desc" ],
        columnDefs: [
            {className: "dt-center", targets: [0, 1, 2, 3, 4]},
            {targets: 3, bSortable: false},
            {targets: 2, bSortable: false, tooltip: "modificar"},
            {targets: 1, bSortable: false},
            {targets: 4, render: $.fn.dataTable.render.number(',', '.', 2)}
        ],
        "scrollX": true,
        "scrollY": true,
        responsive: true,
        "language": {"url": "dataTables/languaje.json"},
        ajax: {
            url: `${path_services}${path}/listProforma`, //Traemos informacion del servicio restful
            type: 'GET',
            dataType: 'json',
            dataSrc: ''
        },
        columns: [//carga la informacion en cada columna del datatable
            {data: 'proformaId'},
            {data: 'oClient.clientName'},
            {data: 'proformaDate'},
            {data: 'proformaTime'},
            {data: 'proformaTotal'},
            {data: iconDelete}
        ]

    });
    /*------------------------------ICONOS DATATABLES----------------------------------------*/

    function iconDelete(data) {
        let datas = '<a id="delete" title="Eliminar" href="#" clientId-data="' + data.clientId + '"clientCi-data="' + data.clientCi + '" \n\
         clientName-data="' + data.clientName + '" \n\
         clientPhone-data="' + data.clientPhone + '" \n\
         clientCell-data="' + data.clientCell + '"clientMail-data="' + data.clientMail + '"\n\
         clientAddress-data="' + data.clientAddress + '"\n\
         clientCredit-data="' + data.clientCredit + '" class="icon-table">\n\
         <i class="fa fa-trash" aria-hidden="true" ></i></a></td>';
        return datas;
    }

    /*------------------------------FUNCIONES DE CLIENTE----------------------------------------*/

    function deleteclient() {
        let clientMType = "3";

        let clientId = $('#clientId-deleteModal').text();
        let clientCi = $('#clientCi-deleteModal').text();
        let clientName = $('#clientName-deleteModal').text();
        let clientPhone = $('#clientPhone-deleteModal').text();
        let clientCell = $('#clientCell-deleteModal').text();
        let clientMail = $('#clientMail-deleteModal').text();
        let clientCredit = $('#clientCredit-deleteModal').text();
        let clientAddress = $('#clientAddress-deleteModal').text();

        let formData = new FormData();

        formData.append('clientMType', clientMType);
        formData.append('clientId', clientId);
        formData.append('clientCi', clientCi);
        formData.append('clientName', clientName);
        formData.append('clientPhone', clientPhone);
        formData.append('clientCell', clientCell);
        formData.append('clientMail', clientMail);
        formData.append('clientCredit', clientCredit);
        formData.append('clientAddress', clientAddress);

        $.ajax({
//            url: "/GICO-AD/webresources/product/addproduct",
            url: `${path_services}${path}/managementClient`, //Traemos informacion del servicio restful
            type: 'POST',
            data: formData,
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {
                alert(data.message);
                table.ajax.reload();

            },
            error: function (jqxhr, status, errorMsg) {
                console.log(status + "Client: " + errorMsg);
            }});
        $('#windows-delete-client').toggleClass('hide-modal');
    }

    function addProforma() {
        // Display the month, day, and year. getMonth() returns a 0-based number.
        var dt = new Date();
        var month = dt.getMonth() + 1;
        var day = dt.getDate();
        var year = dt.getFullYear();

        let proformaMType = "1";
        let proformaId = "1";
        let clientId = $('#selectClient-addModal').val();
        let proformaTotal = "0";
        let proformaTime = $('#daysProforma-addModal').val();
        let proformaState = "1";
        let proformaDate = year + '-' + month + '-' + day;

        if ((proformaTime === '') || (clientId === '') ) {
            alert('Por Favor llene todos los campos');
        } else {
            let formData = new FormData();
            formData.append('proformaMType', proformaMType);
            formData.append('proformaId', proformaId);
            formData.append('clientId', clientId);
            formData.append('proformaTotal', proformaTotal);
            formData.append('proformaTime', proformaTime);
            formData.append('proformaState', proformaState);
            formData.append('proformaDate', proformaDate);

            $.ajax({
                url: `${path_services}${path}/managementProforma`, //Traemos informacion del servicio restful
                type: 'POST',
                data: formData,
                cache: false,
                contentType: false,
                processData: false,
                success: function (data) {
                    //alert(data.message);
                    table.ajax.reload();
                    var pagina = "adminCreateProforma.jsp";
                    location.href = pagina;
                },
                error: function (jqxhr, status, errorMsg) {
                    console.log(status + "Client: " + errorMsg);
                }});
//        $('#windows-select-client').toggleClass('hide-modal');
        }
    }

    /*------------------------------ACCIONES EVENTO CLIC    BOTONES----------------------------------------*/
    $(document).on('click', 'a#delete', function (e) { //Mostrar la ventana modal de eliminar proveedor
        e.preventDefault();
        let clientId = $(this).attr("clientId-data");
        let clientCi = $(this).attr("clientCi-data");
        let clientName = $(this).attr("clientName-data");
        let clientPhone = $(this).attr("clientPhone-data");
        let clientCell = $(this).attr("clientCell-data");
        let clientMail = $(this).attr("clientMail-data");
        let clientCredit = $(this).attr("clientCredit-data");
        let clientAddress = $(this).attr("clientAddress-data");

        $('#windows-delete-client').removeClass('hide-modal'); //Desoculta la ventana modal

        $('#clientId-deleteModal').text(clientId);
        $('#clientCi-deleteModal').text(clientCi);
        $('#clientName-deleteModal').text(clientName);
        $('#clientPhone-deleteModal').text(clientPhone);
        $('#clientCell-deleteModal').text(clientCell);
        $('#clientMail-deleteModal').text(clientMail);
        $('#clientCredit-deleteModal').text(clientCredit);
        $('#clientAddress-deleteModal').text(clientAddress);
    });

    $(document).on('click', '#closeIcon-delete', function () {// Cerrar la Ventana Modal de eliminar producto
        $('#windows-delete-client').toggleClass('hide-modal');
    });
    $(document).on('click', '#delete-client', function (e) {//Boton ACEPTAR eliminar producto
        e.preventDefault();
        deleteclient();
    });
    $(document).on('click', '#delete-client-cancel', function () { //Boton CANCELAR eliminar producto    
        $('#windows-delete-client').toggleClass('hide-modal');
    });
  
    $(document).on('click', '#id-add-proforma', function () {// Mostrar ventana modal crear proforma   

        $("#form-select-client")[0].reset();
        $('#windows-select-client').removeClass('hide-modal');
    });
    $(document).on('click', '#closeIcon-add', function () {// Cerrar la Ventana Modal desde el icono
        $('#windows-select-client').toggleClass('hide-modal');
    });
    $(document).on('click', '#add-client', function () {// Boton ACEPTAR ingresar producto
        addProforma();

    });
    $(document).on('click', '#add-client-cancel', function () {// Boton CANCELAR ingresar producto    
        $('#windows-select-client').toggleClass('hide-modal');
    });


});