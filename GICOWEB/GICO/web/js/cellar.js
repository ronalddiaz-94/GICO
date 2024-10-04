/*------------------------------DATA TABLE product----------------------------------------*/
/* global resultEmail */

const path_services = "/GICO-AD/webresources";
const path = "/cellar";
let prueba="jorge no sapee";
$(document).ready(function () {

    let table = $('#gblTable').DataTable({
        dom: 'Blfrtip',
        lengthMenu: [5, 10, 25, 50],
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ],
        columnDefs: [
            {className: "dt-center", targets: [1, 2, 3, 4]},
            {targets: 3, bSortable: false},
            {targets: 2, bSortable: false, tooltip: "modificar"},
            {targets: 1, bSortable: false}
        ],
        "scrollX": true,
        "scrollY": true,
        responsive: true,
        "language": {"url": "dataTables/languaje.json"},
        ajax: {
            url: `${path_services}${path}/listCellar`, //Traemos informacion del servicio restful
            type: 'GET',
            dataType: 'json',
            dataSrc: ''
        },
        columns: [//carga la informacion en cada columna del datatable
            {data: 'cellarId'},
            {data: 'cellarName'},
            {data: 'cellarManager'},
//            {data: iconArea},
            {data: iconUpdate},
            {data: iconDelete}
        ]

    });
    /*------------------------------ICONOS DATATABLES----------------------------------------*/
    function iconArea(data) {
        let datas = '<a id="providerarea" title="Asignar Area" href="#" identityCard-data="' + data.providerIdentif + '"\n\
     class="icon-table">\n\
         <i class="fa fa-check-square" aria-hidden="true"></i></a>';
        return datas;
    }
    function iconUpdate(data) { // boton actualizar (obtener datos de listado restfull)
        let datas = '<a id="update" title="Modificar" href="#" cellarId-data="'+data.cellarId+'" cellarName-data="'+data.cellarName+'" \n\
         cellarManager-data="'+data.cellarManager+'" class="icon-table">\n\
         <i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>';
        return datas;
    }
    function iconDelete(data) {
        let datas = '<a id="delete" title="Eliminar" href="#" cellarId-data="' + data.cellarId + '" cellarName-data="' + data.cellarName + '" \n\
         cellarManager-data="' + data.cellarManager + '" class="icon-table">\n\
         <i class="fa fa-trash" aria-hidden="true" ></i></a></td>';
        return datas;
    }

    /*------------------------------FUNCIONES DE producto----------------------------------------*/

    function deletecellar() {
        let cellarMType = "3";

        let cellarId = $('#cellarId-deleteModal').text();
        let cellarName = $('#cellarName-deleteModal').text();
        let cellarManager = $('#cellarManager-deleteModal').text();
        
        let formData = new FormData();
        formData.append('cellarMType', cellarMType);
        formData.append('cellarId', cellarId);
        formData.append('cellarName', cellarName);
        formData.append('cellarManager', cellarManager);

        $.ajax({
//            url: "/GICO-AD/webresources/product/addproduct",
            url: `${path_services}${path}/managementCellar`, //Traemos informacion del servicio restful
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
                console.log(status + "Cellar: " + errorMsg);
            }});
        $('#windows-delete-cellar').toggleClass('hide-modal');
    }

    function updatecellar() {
        let cellarMType = "2"; //erecivimos los datos desde la ventan modal

        let cellarId = $('input[name="cellarId-updateModal"]').val();
        let cellarName = $('input[name="cellarName-updateModal"]').val();
        let cellarManager = $('input[name="cellarManager-updateModal"]').val();

        if ((cellarName === '') || (cellarManager === '')) {
            alert('Por Favor llene todos los campos');
        } else {
            let formData = new FormData();
            formData.append('cellarMType', cellarMType);
            formData.append('cellarId', cellarId);
            formData.append('cellarName', cellarName);
            formData.append('cellarManager', cellarManager);            
    
            $.ajax({
//                    url: "/GICO-AD/webresources/product/addproduct",
                url: `${path_services}${path}/managementCellar`, //Traemos informacion del servicio restful
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
                    console.log(status + "cellar: " + errorMsg);
                }});
            $('#windows-update-cellar').toggleClass('hide-modal');
        }
    }

    function addcellar() {
        let cellarMType = "1";
        let cellarId = "1";
        let cellarName = $('input[name="cellarName-addModal"]').val();
        let cellarManager = $('input[name="cellarManager-addModal"]').val();

        if ((cellarName === '') || (cellarManager === '')) {
            alert('Por Favor llene todos los campos');
        } else {
            let formData = new FormData();
            formData.append('cellarMType', cellarMType);
            formData.append('cellarId', cellarId);
            formData.append('cellarName', cellarName);
            formData.append('cellarManager', cellarManager);
            
            $.ajax({
//                    url: "/GICO-AD/webresources/product/managementProduct",
                url: `${path_services}${path}/managementCellar`, //Traemos informacion del servicio restful
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
                    console.log(status + "Cellar: " + errorMsg);
                }});
            $('#windows-add-cellar').toggleClass('hide-modal');
        }
    }

    /*------------------------------ACCIONES EVENTO CLIC    BOTONES----------------------------------------*/
    $(document).on('click', 'a#delete', function (e) { //Mostrar la ventana modal de eliminar bodega
        e.preventDefault();
        let cellarId = $(this).attr("cellarId-data");
        let cellarName = $(this).attr("cellarName-data");
        let cellarManager = $(this).attr("cellarManager-data");


        $('#windows-delete-cellar').removeClass('hide-modal'); //Desoculta la ventana modal

        $('#cellarId-deleteModal').text(cellarId);
        $('#cellarName-deleteModal').text(cellarName);
        $('#cellarManager-deleteModal').text(cellarManager);

    });

    $(document).on('click', '#closeIcon-delete', function () {// Cerrar la Ventana Modal de eliminar bodega
        $('#windows-delete-cellar').toggleClass('hide-modal');
    });
    $(document).on('click', '#delete-cellar', function (e) {//Boton ACEPTAR eliminar bodega
        e.preventDefault();
        deletecellar();
    });
    $(document).on('click', '#delete-cellar-cancel', function () { //Boton CANCELAR eliminar bodega    
        $('#windows-delete-cellar').toggleClass('hide-modal');
    });
    /*------------------------------UPDATE CELLAR----------------------------------------*/

    $(document).on('click', 'a#update', function (e) {//Mostrar la ventana modal de actualizar bodega
        e.preventDefault();
        let cellarId = $(this).attr("cellarId-data");
        let cellarName = $(this).attr("cellarName-data");
        let cellarManager = $(this).attr("cellarManager-data");

        $('#windows-update-cellar').removeClass('hide-modal'); //Muestra la ventan modal


        $('input[name="cellarId-updateModal"]').val(cellarId); //carga los datos en innput de ventana modal
        $('input[name="cellarName-updateModal"]').val(cellarName);
        $('input[name="cellarManager-updateModal"]').val(cellarManager);

    });
    $(document).on('click', '#closeIcon-update', function () {// Cerrar la Ventana Modal desde el icono
        $('#windows-update-cellar').toggleClass('hide-modal');
        $("#form-update-cellar")[0].reset();
    });
    $(document).on('click', '#update-cellar-cancel', function () {//Boton CANCELAR modificar producto 
        $('#windows-update-cellar').toggleClass('hide-modal');
        $("#form-update-cellar")[0].reset();
    });
    $(document).on('click', '#update-cellar', function () {//Boton ACEPTAR modificar producto 
        updatecellar();
    });


    $(document).on('click', '#id-add-cellar', function () {// Mostrar ventana modal ingresar producto    
        $("#form-add-cellar")[0].reset();
        $('#windows-add-cellar').removeClass('hide-modal');
    });
    $(document).on('click', '#closeIcon-add', function () {// Cerrar la Ventana Modal desde el icono
        $('#windows-add-cellar').toggleClass('hide-modal');
    });
    $(document).on('click', '#add-cellar', function () {// Boton ACEPTAR ingresar producto
        addcellar();
    });
    $(document).on('click', '#add-cellar-cancel', function () {// Boton CANCELAR ingresar producto    
        $('#windows-add-cellar').toggleClass('hide-modal'); 
    });

//-------------------------UPDATE VENTANA MODAL----------------------------------------  
    var formulario = document.form_add_cellar,
            elementosAdd = formulario.elements;
            
    var formulario = document.form_update_cellar,
            elementosUpdate = formulario.elements;
            
    // Funcion que se ejecuta cuando el evento click es activado
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
    for (var i = 0; i < elementosAdd.length; i++) {
        if (elementosUpdate[i].type === "text" || elementosUpdate[i].type === "number") {
            elementosUpdate[i].addEventListener("focus", focusInput);
            elementosUpdate[i].addEventListener("blur", blurInput);
        }
    }
    //-------------------------FIN VENTANA MODAL----------------------------------------


});