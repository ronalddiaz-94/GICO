/*------------------------------DATA TABLE product----------------------------------------*/
/* global resultEmail */

const path_services = "/GICO-AD/webresources";
const path = "/provider";
let prueba="jorge sapee";
$(document).ready(function () {

//-----------------------MODAL.-------------------------------
    var formularioAdd = document.form_add_provider,
            elementosAdd = formularioAdd.elements,
            formularioUpdate = document.form_update_provider,
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
        if (elementosAdd[i].type === "text" || elementosAdd[i].type === "number"|| elementosAdd[i].type === "email") {
            elementosAdd[i].addEventListener("focus", focusInput);
            elementosAdd[i].addEventListener("blur", blurInput);
        }
    }
     for (var i = 0; i < elementosUpdate.length; i++) {
        if (elementosUpdate[i].type === "text" || elementosUpdate[i].type === "number"|| elementosUpdate[i].type === "email") {
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
            url: `${path_services}${path}/listProvider`, //Traemos informacion del servicio restful
            type: 'GET',
            dataType: 'json',
            dataSrc: ''
        },
        columns: [//carga la informacion en cada columna del datatable
            {data: 'providerId'},
            {data: 'providerName'},
            {data: 'providerAddress'},
            {data: 'providerMail'},
            {data: 'providerPhone'},
            {data: 'providerCell1'},
            {data: 'providerCell2'},
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
        let datas = '<a id="update" title="Modificar" href="#" providerId-data="' + data.providerId + '"providerName-data="' + data.providerName + '" \n\
         providerAddress-data="' + data.providerAddress + '" \n\
         providerMail-data="' + data.providerMail + '" \n\
         providerPhone-data="' + data.providerPhone + '"providerCell1-data="' + data.providerCell1 + '"\n\
         providerCell2-data="' + data.providerCell2 + '" class="icon-table">\n\
         <i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>';
        return datas;
    }
    function iconDelete(data) {
        let datas = '<a id="delete" title="Eliminar" href="#" providerId-data="' + data.providerId + '"providerName-data="' + data.providerName + '" \n\
         providerAddress-data="' + data.providerAddress + '" \n\
         providerMail-data="' + data.providerMail + '" \n\
         providerPhone-data="' + data.providerPhone + '"providerCell1-data="' + data.providerCell1 + '"\n\
         providerCell2-data="' + data.providerCell2 + '" class="icon-table">\n\
         <i class="fa fa-trash" aria-hidden="true" ></i></a></td>';
        return datas;
    }

    /*------------------------------FUNCIONES DE producto----------------------------------------*/

    function deleteprovider() {
        let providerMType = "3";

        let providerId = $('#providerId-deleteModal').text();
        let providerName = $('#providerName-deleteModal').text();
        let providerAddress = $('#providerAddress-deleteModal').text();
        let providerMail = $('#providerMail-deleteModal').text();
        let providerPhone = $('#providerPhone-deleteModal').text();
        let providerCell1 = $('#providerCell1-deleteModal').text();
        let providerCell2 = $('#providerCell2-deleteModal').text();

        let formData = new FormData();
        formData.append('providerMType', providerMType);
        formData.append('providerId', providerId);
        formData.append('providerName', providerName);
        formData.append('providerAddress', providerAddress);
        formData.append('providerMail', providerMail);
        formData.append('providerPhone', providerPhone);
        formData.append('providerCell1', providerCell1);
        formData.append('providerCell2', providerCell2);

        $.ajax({
//            url: "/GICO-AD/webresources/product/addproduct",
            url: `${path_services}${path}/managementProvider`, //Traemos informacion del servicio restful
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
                console.log(status + "Provider: " + errorMsg);
            }});
        $('#windows-delete-provider').toggleClass('hide-modal');
    }

    function updateprovider() {
        let providerMType = "2"; //erecivimos los datos desde la ventan modal

        let providerId = $('input[name="providerId-updateModal"]').val();
        let providerName = $('input[name="providerName-updateModal"]').val();
        let providerAddress = $('input[name="providerAddress-updateModal"]').val();
        let providerMail = $('input[name="providerMail-updateModal"]').val();
        let providerPhone = $('input[name="providerPhone-updateModal"]').val();
        let providerCell1 = $('input[name="providerCell1-updateModal"]').val();
        let providerCell2 = $('input[name="providerCell2-updateModal"]').val();

        if ((providerName === '') || (providerAddress === '') || (providerMail === '') || (providerPhone === '') || (providerCell1 === '')) {
            alert('Por Favor llene todos los campos');
        } else {
            let formData = new FormData();
            formData.append('providerMType', providerMType);
            formData.append('providerId', providerId);
            formData.append('providerName', providerName);
            formData.append('providerAddress', providerAddress);
            formData.append('providerMail', providerMail);
            formData.append('providerPhone', providerPhone);
            formData.append('providerCell1', providerCell1);
            formData.append('providerCell2', providerCell2);
            
    
            $.ajax({
//                    url: "/GICO-AD/webresources/product/addproduct",
                url: `${path_services}${path}/managementProvider`, //Traemos informacion del servicio restful
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
                    console.log(status + "provider: " + errorMsg);
                }});
            $('#windows-update-provider').toggleClass('hide-modal');
        }
    }

    function addprovider() {
        let providerMType = "1";
        let providerId = "0";
        let providerName = $('input[name="providerName-addModal"]').val();
        let providerAddress = $('input[name="providerAddress-addModal"]').val();
        let providerMail = $('input[name="providerMail-addModal"]').val();
        let providerPhone = $('input[name="providerPhone-addModal"]').val();
        let providerCell1 = $('input[name="providerCell1-addModal"]').val();
        let providerCell2 = $('input[name="providerCell2-addModal"]').val();

        if ((providerName === '') || (providerAddress === '') || (providerMail === '') || (providerPhone === '') || (providerCell1 === '')) {
            alert('Por Favor llene todos los campos');
        } else {
            let formData = new FormData();
            formData.append('providerMType', providerMType);
            formData.append('providerId', providerId);
            formData.append('providerName', providerName);
            formData.append('providerAddress', providerAddress);
            formData.append('providerMail', providerMail);
            formData.append('providerPhone', providerPhone);
            formData.append('providerCell1', providerCell1);
            formData.append('providerCell2', providerCell2);
            
            $.ajax({
//                    url: "/GICO-AD/webresources/product/managementProduct",
                url: `${path_services}${path}/managementProvider`, //Traemos informacion del servicio restful
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
                    console.log(status + "Proveedor: " + errorMsg);
                }});
            $('#windows-add-provider').toggleClass('hide-modal');
        }
    }

    /*------------------------------ACCIONES EVENTO CLIC    BOTONES----------------------------------------*/
    $(document).on('click', 'a#delete', function (e) { //Mostrar la ventana modal de eliminar proveedor
        e.preventDefault();
        let providerId = $(this).attr("providerId-data");
        let providerName = $(this).attr("providerName-data");
        let providerAddress = $(this).attr("providerAddress-data");
        let providerMail = $(this).attr("providerMail-data");
        let providerPhone = $(this).attr("providerPhone-data");
        let providerCell1 = $(this).attr("providerCell1-data");
        let providerCell2 = $(this).attr("providerCell2-data");

        $('#windows-delete-provider').removeClass('hide-modal'); //Desoculta la ventana modal

        $('#providerId-deleteModal').text(providerId);
        $('#providerName-deleteModal').text(providerName);
        $('#providerAddress-deleteModal').text(providerAddress);
        $('#providerMail-deleteModal').text(providerMail);
        $('#providerPhone-deleteModal').text(providerPhone);
        $('#providerCell1-deleteModal').text(providerCell1);
        $('#providerCell2-deleteModal').text(providerCell2);
    });

    $(document).on('click', '#closeIcon-delete', function () {// Cerrar la Ventana Modal de eliminar producto
        $('#windows-delete-provider').toggleClass('hide-modal');
    });
    $(document).on('click', '#delete-provider', function (e) {//Boton ACEPTAR eliminar producto
        e.preventDefault();
        deleteprovider();
    });
    $(document).on('click', '#delete-provider-cancel', function () { //Boton CANCELAR eliminar producto    
        $('#windows-delete-provider').toggleClass('hide-modal');
    });
    /*------------------------------UPDATE PROVIDER----------------------------------------*/

    $(document).on('click', 'a#update', function (e) {//Mostrar la ventana modal de actualizar producto
        e.preventDefault();
        let providerId = $(this).attr("providerId-data");
        let providerName = $(this).attr("providerName-data");
        let providerAddress = $(this).attr("providerAddress-data");
        let providerMail = $(this).attr("providerMail-data");
        let providerPhone = $(this).attr("providerPhone-data");
        let providerCell1 = $(this).attr("providerCell1-data");
        let providerCell2 = $(this).attr("providerCell2-data");

        $('#windows-update-provider').removeClass('hide-modal'); //Muestra la ventan modal


        $('input[name="providerId-updateModal"]').val(providerId); //carga los datos en innput de ventana modal
        $('input[name="providerName-updateModal"]').val(providerName);
        $('input[name="providerAddress-updateModal"]').val(providerAddress);
        $('input[name="providerMail-updateModal"]').val(providerMail);
        $('input[name="providerPhone-updateModal"]').val(providerPhone);
        $('input[name="providerCell1-updateModal"]').val(providerCell1);
        $('input[name="providerCell2-updateModal"]').val(providerCell2);
    });
    $(document).on('click', '#closeIcon-update', function () {// Cerrar la Ventana Modal desde el icono
        $('#windows-update-provider').toggleClass('hide-modal');
        $("#form-update-provider")[0].reset();
    });
    $(document).on('click', '#update-provider-cancel', function () {//Boton CANCELAR modificar producto 
        $('#windows-update-provider').toggleClass('hide-modal');
        $("#form-update-provider")[0].reset();
    });
    $(document).on('click', '#update-provider', function () {//Boton ACEPTAR modificar producto 
        updateprovider();
    });


    $(document).on('click', '#id-add-provider', function () {// Mostrar ventana modal ingresar producto    
        $("#form-add-provider")[0].reset();
        $('#windows-add-provider').removeClass('hide-modal');
    });
    $(document).on('click', '#closeIcon-add', function () {// Cerrar la Ventana Modal desde el icono
        $('#windows-add-provider').toggleClass('hide-modal');
    });
    $(document).on('click', '#add-provider', function () {// Boton ACEPTAR ingresar producto
        addprovider();
    });
    $(document).on('click', '#add-provider-cancel', function () {// Boton CANCELAR ingresar producto    
        $('#windows-add-provider').toggleClass('hide-modal'); 
    });
//   
//  
//   /*-----------------------------DATATABLE2---------------------------*/
//
//    let table2 = $('#gblTable_area').DataTable({
//        dom: 'frtip',
//        lengthMenu: [5],
//        responsive: false,
//        //"destroy": true,
//        "language": {"url": "dataTables/languaje.json"},
//        ajax: {
//            url: "productControl?accion=listproductArea&strproductid=" + "1804449690", //LIST product FOR DATATABLE 
//            type: 'POST',
//            dataType: 'json',
//            dataSrc: ''
//        },
//        columnDefs: [
//            {className: "dt-center", targets: [2, 0]}
//        ],
//        columns: [
//           // {data: 'ag_id'},
//           {data: 'productAreaId'},
//            {data: 'productAreaName'},
//            {data: iconDeletearea}
//        ]
//                
//    });
////     table2.on( 'order.dt search.dt', function () {
////        table2.column(0, {search:'applied', order:'applied'}).nodes().each( function (cell, i) {
////            cell.innerHTML = i+1;
////        } );
////    } ).draw();
//    /*------------------------------ICONOS DATATABLES----------------------------------------*/
//    function iconDeletearea(data) {
//        let datas = '<a id="delete-area" title="Eliminar" href="#" identityCard-data="' + data.productIdentify + '" productAreaName-data="' + data.productAreaName + '" \n\
//         idproductArea-data="' + data.productAreaId + '" class="icon-table">\n\
//         <i class="fa fa-trash" aria-hidden="true" ></i></a></td>';
//        return datas;
//    }
//    /*------------------------------OPTIENE DATOS----------------------------------------*/
//    function addproductArea(ci) {
//        //let identityCard =  ;
//        let identityCard = ci;
//        let productAreaId = $('#delectArea').val();
//        alert("ci:" + identityCard + "area: " + productAreaId);
//        let formData = new FormData();
//        formData.append('identityCard', identityCard);
//        formData.append('productAreaId', productAreaId);
//        $.ajax({
//            url: "productControl?accion=areaManagementproduct&strgestion=1&stridentityCard=" + identityCard + "&strproductAreaId=" + productAreaId,
//            type: 'POST',
//            data: formData,
//            cache: false,
//            contentType: false,
//            processData: false,
//            success: function (data) {
//                // alert(data.message);
//                table2.ajax.reload();
//            },
//            error: function (jqxhr, status, errorMsg) {
//                console.log(status + "producto: " + errorMsg);
//            }
//        });
//    }
//    /*------------------------------EVENTO CLIC DE areas----------------------------------------*/
//
//    $(document).on('click', 'a#productarea', function (e) {//desoculta la ventana modal para asignar areas
//        $('#windows-productarea-product').removeClass('hide-modal');
//    });
//    $(document).on('click', '#id-add-product', function () {// Mostrar ventana modal ingresar AREA producto    
//        $("#form-add-product")[0].reset();
//        $('#windows-add-product').removeClass('hide-modal');
//    });
//    $(document).on('click', '#closeIcon-productarea', function () {// Cerrar la Ventana Modal desde el icono
//        $('#windows-productarea-product').toggleClass('hide-modal');
//        $("#form-productarea-product")[0].reset();
//    });
//    $(document).on('click', '#id-add-product-area', function () {//Boton ACEPTAR modificar producto 
//        addproductArea(cedula);
//    });
//    /*------------------------------DELET product AREA----------------------------------------*/
//    function deleteproductArea(ci, id) {
//        //let identityCard =  ;
//        let identityCard = ci;
//        let productAreaId = id;
//        // alert("ci:" + identityCard + "area: " + productAreaId);
//        let formData = new FormData();
//        formData.append('identityCard', identityCard);
//        formData.append('productAreaId', productAreaId);
//        $.ajax({
//            url: "productControl?accion=areaManagementproduct&strgestion=2&stridentityCard=" + identityCard + "&strproductAreaId=" + productAreaId,
//            type: 'POST',
//            data: formData,
//            cache: false,
//            contentType: false,
//            processData: false,
//            success: function (data) {
//                // alert(data.message);
//                table2.ajax.reload();
//            },
//            error: function (jqxhr, status, errorMsg) {
//                console.log(status + "producto: " + errorMsg);
//            }
//        });
//        $('#windows-delete-product-area').toggleClass('hide-modal');
//    }
//    $(document).on('click', 'a#delete-area', function (e) { //Mostrar la ventana modal de eliminar producto AREA
//        e.preventDefault();
//        let identityCard = $(this).attr("identityCard-data");
//        let idproductArea = $(this).attr("idproductArea-data");
//        productIdAreaDT = idproductArea;
//        alert(idproductArea+"jorge");
//        $('#windows-delete-product-area').removeClass('hide-modal');
//        $('#identityCard-product-delete').text(identityCard);
//        $('#name-product-delete').text(name);
//    });
//    $(document).on('click', '#closeIcon-delete-area', function () {// Cerrar la Ventana Modal de eliminar producto AREA
//        $('#windows-delete-product-area').toggleClass('hide-modal');
//    });
//    $(document).on('click', '#delete-product-area', function (e) {//Boton ACEPTAR eliminar producto
//        deleteproductArea(cedula, productIdAreaDT);
//    });
//    $(document).on('click', '#delete-product-cancel-area', function () {//Boton CANCELAR eliminar producto    
//        $('#windows-delete-product-area').toggleClass('hide-modal');
//    });
//    var temp = 0;
//    $(document).on('click', 'a#productarea', function (e) { //Actualizar tabla 2 y toma datos de select
//        e.preventDefault();
//        let idproductArea = $(this).attr("identityCard-data"); // obtiene la cedula del producto
//        cedula = idproductArea;
//        $.ajax({
//            url: "productControl?accion=listproductAreaAll", //LIST product FOR DATATABLE 
//            type: 'POST',
//            dataType: 'json',
//            dataSrc: '',
//            success: function (datas) {
//                console.log(datas);
//                table2.ajax.url('productControl?accion=listproductArea&strproductid=' + idproductArea).load();
//                console.log(datas.length);
//                console.log(datas[0].areaNombre);
//                //alert(datas[1].areaid);
//                if (temp === 0) {
//                    temp++;
//                    for (var i = 0; i < datas.length; i++) {
//                        $("#delectArea").append(
//                                '<option value="' + datas[i].areaid + '">' + datas[i].areaNombre + '</option>'
//                                );
//                    }
//                }
//            }
//        });
//    });
//    /*-------------------------------MENU-DINAMICO-----------------------------------------*/
//    $.ajax({
//
//        url: "productControl?accion=listproductAreaMenu", //LIST product FOR DATATABLE 
//        type: 'POST',
//        dataType: 'json',
//        dataSrc: '',
//        success: function (dataMenu) {
//            console.log(dataMenu);
//            console.log(dataMenu.length);
//            console.log(dataMenu[0].areaman_maid);
//            for (var i = 0; i < dataMenu.length; i++) {
//                var ul = '<ul class="main-menu" id="main-menu">';
//                
//                if (dataMenu[i].areaman_maid === 1) {
//                    ul += '<li class="main-menu__row"><a class="main-menu__link "  href="FrmCPAdminReq.jsp">' + dataMenu[i].areaNombre + '</a>';
//                }
//                alert(dataMenu[i].areaid);
//                for (var j = 0; j < dataMenu.length; j++) {
//                    if (dataMenu[i].areaid === dataMenu[j].areaman_maid) {
//                        ul += '<ul  id="ulprueba"><li class=""><a class="main-menu__link_1" href="#">' + dataMenu[j].areaNombre + '</a></li></ul> ';
//                    }
//                }
//                ul += '</li>';
//                ul += '</ul>';
//                document.getElementById("dinamicMenu").innerHTML += ul;
//            }
//        }
//
//    });


});