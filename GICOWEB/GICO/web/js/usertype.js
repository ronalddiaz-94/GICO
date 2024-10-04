/*------------------------------DATA TABLE product----------------------------------------*/
/* global resultEmail */

const path_services = "/GICO-AD/webresources";
const path = "/usertype";
let prueba="jorge sapee";
$(document).ready(function () {
//-----------------------MODAL.-------------------------------
    var formularioAdd = document.form_add_usertype,
            elementosAdd = formularioAdd.elements,
            formularioUpdate = document.form_update_usertype,
            elementosUpdate = formularioUpdate.elements;
            
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
        if (elementosAdd[i].type === "text" || elementosAdd[i].type === "number"|| elementosAdd[i].type === "email"|| elementosAdd[i].type === "password") {
            elementosAdd[i].addEventListener("focus", focusInput);
            elementosAdd[i].addEventListener("blur", blurInput);
        }
    }
     for (var i = 0; i < elementosUpdate.length; i++) {
        if (elementosUpdate[i].type === "text" || elementosUpdate[i].type === "number"|| elementosUpdate[i].type === "email"|| elementosUpdate[i].type === "password") {
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
            {className: "dt-center", targets: [1, 2, 3]},
            {targets: 3, bSortable: false},
            {targets: 2, bSortable: false, tooltip: "modificar"},
            {targets: 1, bSortable: false}
        ],
        "scrollX": true,
        "scrollY": true,
        responsive: true,
        "language": {"url": "dataTables/languaje.json"},
        ajax: {
            url: `${path_services}${path}/listUserType`, //Traemos informacion del servicio restful
            type: 'GET',
            dataType: 'json',
            dataSrc: ''
        },
        columns: [//carga la informacion en cada columna del datatable
            {data: 'userTypeId'},
            {data: 'userTypeDescription'},
//            {data: iconArea},
            {data: iconUpdate},
            {data: iconDelete}
        ]

    });
    /*------------------------------ICONOS DATATABLES----------------------------------------*/
    function iconArea(data) {
        let datas = '<a id="providerarea" title="Asignar Area" href="#" identityCard-data="' + data.usertypeIdentif + '"\n\
     class="icon-table">\n\
         <i class="fa fa-check-square" aria-hidden="true"></i></a>';
        return datas;
    }
    function iconUpdate(data) { // boton actualizar (obtener datos de listado restfull)
        let datas = '<a id="update" title="Modificar" href="#" userTypeId-data="' + data.userTypeId +'" \n\
         userTypeDescription-data="' + data.userTypeDescription + '" class="icon-table">\n\
         <i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>';
        return datas;
    }
    function iconDelete(data) {
        let datas = '<a id="delete" title="Eliminar" href="#" userTypeId-data="' + data.userTypeId +'" \n\
         userTypeDescription-data="' + data.userTypeDescription + '" class="icon-table">\n\
         <i class="fa fa-trash" aria-hidden="true" ></i></a></td>';
        return datas;
    }

    /*------------------------------FUNCIONES DE CLIENTE----------------------------------------*/

    function deleteusertype() {
        let userTypeMType = "3";

        let userTypeId = $('#usertypeId-deleteModal').text();
        let userTypeDescription = $('#usertypeDescription-deleteModal').text();

        let formData = new FormData();
        formData.append('userTypeMType', userTypeMType);
        formData.append('userTypeId', userTypeId);
        formData.append('userTypeDescription', userTypeDescription);

        $.ajax({
//            url: "/GICO-AD/webresources/product/addproduct",
            url: `${path_services}${path}/managementUserType`, //Traemos informacion del servicio restful
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
                console.log(status + "User Type: " + errorMsg);
            }});
        $('#windows-delete-usertype').toggleClass('hide-modal');
    }

    function updateusertype() {
        let userTypeMType = "2"; //erecivimos los datos desde la ventan modal

        let userTypeId = $('input[name="usertypeId-updateModal"]').val();
        let userTypeDescription= $('input[name="usertypeDescription-updateModal"]').val();

        if ((userTypeDescription === '')) {
            alert('Por Favor llene todos los campos');
        } else {
            let formData = new FormData();
            formData.append('userTypeMType', userTypeMType);
            formData.append('userTypeId', userTypeId);
            formData.append('userTypeDescription', userTypeDescription);         
    
            $.ajax({
//                    url: "/GICO-AD/webresources/product/addproduct",
                url: `${path_services}${path}/managementUserType`, //Traemos informacion del servicio restful
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
                    console.log(status + "User Type: " + errorMsg);
                }});
            $('#windows-update-usertype').toggleClass('hide-modal');
        }
    }

    function addusertype() {
        let userTypeMType = "1";
        let userTypeId = "0";
        let userTypeDescription = $('input[name="usertypeDescription-addModal"]').val();

        if ((userTypeDescription === '')) {
            alert('Por Favor llene todos los campos');
        } else {
            let formData = new FormData();
            formData.append('userTypeMType', userTypeMType);
            formData.append('userTypeId', userTypeId);
            formData.append('userTypeDescription', userTypeDescription);  
            
            $.ajax({
//                    url: "/GICO-AD/webresources/product/managementProduct",
                url: `${path_services}${path}/managementUserType`, //Traemos informacion del servicio restful
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
            $('#windows-add-usertype').toggleClass('hide-modal');
        }
    }

    /*------------------------------ACCIONES EVENTO CLIC    BOTONES----------------------------------------*/
    $(document).on('click', 'a#delete', function (e) { //Mostrar la ventana modal de eliminar proveedor
        e.preventDefault();
        let usertypeId = $(this).attr("usertypeId-data");
        let usertypeDescription = $(this).attr("usertypeDescription-data");


        $('#windows-delete-usertype').removeClass('hide-modal'); //Desoculta la ventana modal

        $('#usertypeId-deleteModal').text(usertypeId);
        $('#usertypeDescription-deleteModal').text(usertypeDescription);

    });

    $(document).on('click', '#closeIcon-delete', function () {// Cerrar la Ventana Modal de eliminar producto
        $('#windows-delete-usertype').toggleClass('hide-modal');
    });
    $(document).on('click', '#delete-usertype', function (e) {//Boton ACEPTAR eliminar producto
        e.preventDefault();
        deleteusertype();
    });
    $(document).on('click', '#delete-usertype-cancel', function () { //Boton CANCELAR eliminar producto    
        $('#windows-delete-usertype').toggleClass('hide-modal');
    });
    /*------------------------------UPDATE CLIENT----------------------------------------*/

    $(document).on('click', 'a#update', function (e) {//Mostrar la ventana modal de actualizar producto
        e.preventDefault();
        let usertypeId = $(this).attr("usertypeId-data");
        let usertypeDescription = $(this).attr("usertypeDescription-data");


        $('#windows-update-usertype').removeClass('hide-modal'); //Muestra la ventan modal

        $('input[name="usertypeId-updateModal"]').val(usertypeId); //carga los datos en innput de ventana modal
        $('input[name="usertypeDescription-updateModal"]').val(usertypeDescription);

    });
    $(document).on('click', '#closeIcon-update', function () {// Cerrar la Ventana Modal desde el icono
        $('#windows-update-usertype').toggleClass('hide-modal');
        $("#form-update-usertype")[0].reset();
    });
    $(document).on('click', '#update-usertype-cancel', function () {//Boton CANCELAR modificar producto 
        $('#windows-update-usertype').toggleClass('hide-modal');
        $("#form-update-usertype")[0].reset();
    });
    $(document).on('click', '#update-usertype', function () {//Boton ACEPTAR modificar producto 
        updateusertype();
    });


    $(document).on('click', '#id-add-usertype', function () {// Mostrar ventana modal ingresar producto    
        $("#form-add-usertype")[0].reset();
        $('#windows-add-usertype').removeClass('hide-modal');
    });
    $(document).on('click', '#closeIcon-add', function () {// Cerrar la Ventana Modal desde el icono
        $('#windows-add-usertype').toggleClass('hide-modal');
    });
    $(document).on('click', '#add-usertype', function () {// Boton ACEPTAR ingresar producto
        addusertype();
    });
    $(document).on('click', '#add-usertype-cancel', function () {// Boton CANCELAR ingresar producto    
        $('#windows-add-usertype').toggleClass('hide-modal');     
    });

});