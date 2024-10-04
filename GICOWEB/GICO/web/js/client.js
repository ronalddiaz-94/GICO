/*------------------------------DATA TABLE product----------------------------------------*/
/* global resultEmail */

const path_services = "/GICO-AD/webresources";
const path = "/client";
$(document).ready(function () {
//-----------------------MODAL.-------------------------------
    var formulario = document.form_add_client,
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

    let table = $('#gblTable').DataTable({
        dom: 'Blfrtip',
        lengthMenu: [5, 10, 25, 50],
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ],
        columnDefs: [
            {className: "dt-center", targets: [1, 2, 3, 4, 5, 6, 7, 8]},
            {targets: 3, bSortable: false},
            {targets: 2, bSortable: false, tooltip: "modificar"},
            {targets: 1, bSortable: false}
        ],
        "scrollX": true,
        "scrollY": true,
        responsive: true,
        "language": {"url": "dataTables/languaje.json"},
        ajax: {
            url: `${path_services}${path}/listClient`, //Traemos informacion del servicio restful
            type: 'GET',
            dataType: 'json',
            dataSrc: ''
        },
        columns: [//carga la informacion en cada columna del datatable
            {data: 'clientId'},
            {data: 'clientCi'},
            {data: 'clientName'},
            {data: 'clientPhone'},
            {data: 'clientCell'},
            {data: 'clientMail'},
            {data: 'clientCredit'},
            {data: 'clientAddress'},
            {data: iconUpdate},
            {data: iconDelete}
        ]

    });
    /*------------------------------ICONOS DATATABLES----------------------------------------*/
    function iconArea(data) {
        let datas = '<a id="providerarea" title="Asignar Area" href="#" identityCard-data="' + data.clientIdentif + '"\n\
     class="icon-table">\n\
         <i class="fa fa-check-square" aria-hidden="true"></i></a>';
        return datas;
    }
    function iconUpdate(data) { // boton actualizar (obtener datos de listado restfull)
        let datas = '<a id="update" title="Modificar" href="#" clientId-data="' + data.clientId + '"clientCi-data="' + data.clientCi + '" \n\
         clientName-data="' + data.clientName + '" \n\
         clientPhone-data="' + data.clientPhone + '" \n\
         clientCell-data="' + data.clientCell + '"clientMail-data="' + data.clientMail + '"\n\
         clientAddress-data="' + data.clientAddress + '"\n\
         clientCredit-data="' + data.clientCredit + '" class="icon-table">\n\
         <i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>';
        return datas;
    }
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

    function updateclient() {
        let clientMType = "2"; //erecivimos los datos desde la ventan modal

        let clientId = $('input[name="clientId-updateModal"]').val();
        let clientCi = $('input[name="clientCi-updateModal"]').val();
        let clientName = $('input[name="clientName-updateModal"]').val();
        let clientPhone = $('input[name="clientPhone-updateModal"]').val();
        let clientCell = $('input[name="clientCell-updateModal"]').val();
        let clientMail = $('input[name="clientMail-updateModal"]').val();
        let clientCredit = $('input[name="clientCredit-updateModal"]').val();
        let clientAddress = $('input[name="clientAddress-updateModal"]').val();

        if ((clientName === '') || (clientCi === '') || (clientPhone === '') || (clientCell === '') || (clientMail === '') || (clientCredit === '') || (clientAddress === '')) {
            alert('Por Favor llene todos los campos');
        } else {
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
//                    url: "/GICO-AD/webresources/product/addproduct",
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
            $('#windows-update-client').toggleClass('hide-modal');
        }
    }

    function addclient() {
        let clientMType = "1";
        let clientId = "0";
        let clientCi = $('input[name="clientCi-addModal"]').val();
        let clientName = $('input[name="clientName-addModal"]').val();
        let clientPhone = $('input[name="clientPhone-addModal"]').val();
        let clientCell = $('input[name="clientCell-addModal"]').val();
        let clientMail = $('input[name="clientMail-addModal"]').val();
        let clientCredit = $('input[name="clientCredit-addModal"]').val();
        let clientAddress = $('input[name="clientAddress-addModal"]').val();

        if ((clientName === '') || (clientCi === '') || (clientPhone === '') || (clientCell === '') || (clientMail === '') || (clientCredit === '') || (clientAddress === '')) {
            alert('Por Favor llene todos los campos');
        } else {
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
//                    url: "/GICO-AD/webresources/product/managementProduct",
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
            $('#windows-add-client').toggleClass('hide-modal');
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
    /*------------------------------UPDATE CLIENT----------------------------------------*/

    $(document).on('click', 'a#update', function (e) {//Mostrar la ventana modal de actualizar producto
        e.preventDefault();
        let clientId = $(this).attr("clientId-data");
        let clientCi = $(this).attr("clientCi-data");
        let clientName = $(this).attr("clientName-data");
        let clientPhone = $(this).attr("clientPhone-data");
        let clientCell = $(this).attr("clientCell-data");
        let clientMail = $(this).attr("clientMail-data");
        let clientCredit = $(this).attr("clientCredit-data");
        let clientAddress = $(this).attr("clientAddress-data");

        $('#windows-update-client').removeClass('hide-modal'); //Muestra la ventan modal


        $('input[name="clientId-updateModal"]').val(clientId); //carga los datos en innput de ventana modal
        $('input[name="clientCi-updateModal"]').val(clientCi);
        $('input[name="clientName-updateModal"]').val(clientName);
        $('input[name="clientPhone-updateModal"]').val(clientPhone);
        $('input[name="clientCell-updateModal"]').val(clientCell);
        $('input[name="clientMail-updateModal"]').val(clientMail);
        $('input[name="clientCredit-updateModal"]').val(clientCredit);
        $('input[name="clientAddress-updateModal"]').val(clientAddress);
    });
    $(document).on('click', '#closeIcon-update', function () {// Cerrar la Ventana Modal desde el icono
        $('#windows-update-client').toggleClass('hide-modal');
        $("#form-update-client")[0].reset();
    });
    $(document).on('click', '#update-client-cancel', function () {//Boton CANCELAR modificar producto 
        $('#windows-update-client').toggleClass('hide-modal');
        $("#form-update-client")[0].reset();
    });
    $(document).on('click', '#update-client', function () {//Boton ACEPTAR modificar producto 
        updateclient();
    });


    $(document).on('click', '#id-add-client', function () {// Mostrar ventana modal ingresar producto    
        $("#form-add-client")[0].reset();
        $('#windows-add-client').removeClass('hide-modal');
    });
    $(document).on('click', '#closeIcon-add', function () {// Cerrar la Ventana Modal desde el icono
        $('#windows-add-client').toggleClass('hide-modal');
    });
    $(document).on('click', '#add-client', function () {// Boton ACEPTAR ingresar producto
        addclient();
    });
    $(document).on('click', '#add-client-cancel', function () {// Boton CANCELAR ingresar producto    
        $('#windows-add-client').toggleClass('hide-modal');
    });


});