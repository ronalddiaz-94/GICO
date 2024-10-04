/*------------------------------DATA TABLE product----------------------------------------*/
/* global resultEmail */

const path_services = "/GICO-AD/webresources";
const path = "/expenses";
let prueba = "jorge sapee";
$(document).ready(function () {
//-----------------------MODAL.-------------------------------
    var formularioAdd = document.form_add_expenses,
            elementosAdd = formularioAdd.elements;
    var formularioUpdate = document.form_update_expenses,
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
            {className: "dt-center", targets: [1, 2, 3, 4, 5]},
            {targets: 3, bSortable: false},
            {targets: 2, bSortable: false, tooltip: "modificar"},
            {targets: 1, bSortable: false}
        ],
        "scrollX": true,
        "scrollY": true,
        responsive: true,
        "language": {"url": "dataTables/languaje.json"},
        ajax: {
            url: `${path_services}${path}/listExpenses`, //Traemos informacion del servicio restful
            type: 'GET',
            dataType: 'json',
            dataSrc: ''
        },
        columns: [//carga la informacion en cada columna del datatable
            {data: 'expensesId'},
            {data: 'expensesDescription'},
            {data: 'expensesCost'},
            {data: 'businessId'},
            {data: iconUpdate},
            {data: iconDelete}
        ]

    });
    /*------------------------------ICONOS DATATABLES----------------------------------------*/

    function iconUpdate(data) { // boton actualizar (obtener datos de listado restfull)
        let datas = '<a id="update" title="Modificar" href="#" expensesId-data="' + data.expensesId + '"expensesDescription-data="' + data.expensesDescription + '" \n\
         expensesCost-data="' + data.expensesCost + '" \n\
         businessId-data="' + data.businessId + '" class="icon-table">\n\
         <i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>';
        return datas;
    }
    function iconDelete(data) {
        let datas = '<a id="delete" title="Eliminar" href="#" expensesId-data="' + data.expensesId + '"expensesDescription-data="' + data.expensesDescription + '" \n\
         expensesCost-data="' + data.expensesCost + '" \n\
         businessId-data="' + data.businessId + '" class="icon-table">\n\
         <i class="fa fa-trash" aria-hidden="true" ></i></a></td>';
        return datas;
    }

    /*------------------------------FUNCIONES DE CLIENTE----------------------------------------*/

    function deleteexpense() {
        let expensesMType = "3";

        let expensesId = $('#expensesId-deleteModal').text();
        let expensesDescription = $('#expensesDescription-deleteModal').text();
        let expensesCost = $('#expensesCost-deleteModal').text();
        let businessId = $('#businessId-deleteModal').text();

        let formData = new FormData();
        formData.append('expensesMType', expensesMType);
        formData.append('expensesId', expensesId);
        formData.append('expensesDescription', expensesDescription);
        formData.append('expensesCost', expensesCost);
        formData.append('businessId', businessId);


        $.ajax({
//            url: "/GICO-AD/webresources/product/addproduct",
            url: `${path_services}${path}/managementExpenses`, //Traemos informacion del servicio restful
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
                console.log(status + "Expenses: " + errorMsg);
            }});
        $('#windows-delete-expenses').toggleClass('hide-modal');
    }

    function updateexpenses() {
        let expensesMType = "2"; //erecivimos los datos desde la ventan modal

        let expensesId = $('input[name="expensesId-updateModal"]').val();
        let expensesDescription = $('input[name="expensesDescription-updateModal"]').val();
        let expensesCost = $('input[name="expensesCost-updateModal"]').val();
        let businessId = $('input[name="businessId-updateModal"]').val();

        if ((expensesDescription === '') || (expensesCost === '')) {
            alert('Por Favor llene todos los campos');
        } else {
            let formData = new FormData();
            formData.append('expensesMType', expensesMType);
            formData.append('expensesId', expensesId);
            formData.append('expensesDescription', expensesDescription);
            formData.append('expensesCost', expensesCost);
            formData.append('businessId', businessId);

            $.ajax({
//                    url: "/GICO-AD/webresources/product/addproduct",
                url: `${path_services}${path}/managementExpenses`, //Traemos informacion del servicio restful
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
                    console.log(status + "Expenses: " + errorMsg);
                }});
            $('#windows-update-expenses').toggleClass('hide-modal');
        }
    }

    function addexpenses() {
        let expensesMType = "1";
        let expensesId = "0";
        let expensesDescription = $('input[name="expensesDescription-addModal"]').val();
        let expensesCost = $('input[name="expensesCost-addModal"]').val();
        let businessId = $('input[name="businessId-addModal"]').val();

        if ((expensesDescription === '') || (expensesCost === '')) {
            alert('Por Favor llene todos los campos');
        } else {
            let formData = new FormData();
            formData.append('expensesMType', expensesMType);
            formData.append('expensesId', expensesId);
            formData.append('expensesDescription', expensesDescription);
            formData.append('expensesCost', expensesCost);
            formData.append('businessId', businessId);
            alert(businessId);
            $.ajax({
//                    url: "/GICO-AD/webresources/product/managementProduct",
                url: `${path_services}${path}/managementExpenses`, //Traemos informacion del servicio restful
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
                    console.log(status + "Expenses: " + errorMsg);
                }});
            $('#windows-add-expenses').toggleClass('hide-modal');
        }
    }

    /*------------------------------ACCIONES EVENTO CLIC    BOTONES----------------------------------------*/
    $(document).on('click', 'a#delete', function (e) { //Mostrar la ventana modal de eliminar proveedor
        e.preventDefault();
        let expensesId = $(this).attr("expensesId-data");
        let expensesDescription = $(this).attr("expensesDescription-data");
        let expensesCost = $(this).attr("expensesCost-data");
        let businessId = $(this).attr("businessId-data");

        $('#windows-delete-expenses').removeClass('hide-modal'); //Desoculta la ventana modal

        $('#expensesId-deleteModal').text(expensesId);
        $('#expensesDescription-deleteModal').text(expensesDescription);
        $('#expensesCost-deleteModal').text(expensesCost);
        $('#businessId-deleteModal').text(businessId);

    });

    $(document).on('click', '#closeIcon-delete', function () {// Cerrar la Ventana Modal de eliminar producto
        $('#windows-delete-expenses').toggleClass('hide-modal');
    });
    $(document).on('click', '#delete-expenses', function (e) {//Boton ACEPTAR eliminar producto
        e.preventDefault();
        deleteexpense();
    });
    $(document).on('click', '#delete-expenses-cancel', function () { //Boton CANCELAR eliminar producto    
        $('#windows-delete-expenses').toggleClass('hide-modal');
    });
    /*------------------------------UPDATE EXPENSES----------------------------------------*/

    $(document).on('click', 'a#update', function (e) {//Mostrar la ventana modal de actualizar producto
        e.preventDefault();
        let expensesId = $(this).attr("expensesId-data");
        let expensesDescription = $(this).attr("expensesDescription-data");
        let expensesCost = $(this).attr("expensesCost-data");
        let businessId = $(this).attr("businessId-data");

        $('#windows-update-expenses').removeClass('hide-modal'); //Muestra la ventan modal


        $('input[name="expensesId-updateModal"]').val(expensesId); //carga los datos en innput de ventana modal
        $('input[name="expensesDescription-updateModal"]').val(expensesDescription);
        $('input[name="expensesCost-updateModal"]').val(expensesCost);
        $('input[name="businessId-updateModal"]').val(businessId);
    });
    $(document).on('click', '#closeIcon-update', function () {// Cerrar la Ventana Modal desde el icono
        $('#windows-update-expenses').toggleClass('hide-modal');
        $("#form-update-expenses")[0].reset();
    });
    $(document).on('click', '#update-expenses-cancel', function () {//Boton CANCELAR modificar producto 
        $('#windows-update-expenses').toggleClass('hide-modal');
        $("#form-update-expenses")[0].reset();
    });
    $(document).on('click', '#update-expenses', function () {//Boton ACEPTAR modificar producto 
        updateexpenses();
    });


    $(document).on('click', '#id-add-expenses', function () {// Mostrar ventana modal ingresar producto    
        $("#form-add-expenses")[0].reset();
        $('#windows-add-expenses').removeClass('hide-modal');
    });
    $(document).on('click', '#closeIcon-add', function () {// Cerrar la Ventana Modal desde el icono
        $('#windows-add-expenses').toggleClass('hide-modal');
    });
    $(document).on('click', '#add-expenses', function () {// Boton ACEPTAR ingresar producto
        addexpenses();
    });
    $(document).on('click', '#add-expenses-cancel', function () {// Boton CANCELAR ingresar producto    
        $('#windows-add-expenses').toggleClass('hide-modal');
    });
//--------------inicio de ventana modal------------------

    var formulario = document.form_add_expenses,
            elementosAdd = formulario.elements;
    var formulario = document.form_update_expenses,
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

});