
/*------------------------------DATA TABLE product----------------------------------------*/
/* global resultEmail, elementos, add, product */



const path_services = "/GICO-AD/webresources";
const path = "/product";
$(document).ready(function () {

//-------------------------VENTANA MODAL----------------------------------------  
    var formularioAdd = document.form_add_product,
            elementosAdd = formularioAdd.elements,
            formularioUpdate = document.form_update_product,
            elementosUpdate = formularioUpdate.elements,
            formularioPuechase = document.id_form_purchase_product,
            elementosPurchase = formularioPuechase.elements,
            formularioReturnPurchase = document.id_form_returnpurchase_product,
            elementosReturnPurchase = formularioReturnPurchase.elements,
            formularioReturnSale = document.id_form_returnsale_product,
            elementosReturnSale = formularioReturnSale.elements;


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
    for (var i = 0; i < elementosUpdate.length; i++) {
        if (elementosUpdate[i].type === "text" || elementosUpdate[i].type === "number") {
            elementosUpdate[i].addEventListener("focus", focusInput);
            elementosUpdate[i].addEventListener("blur", blurInput);
        }
    }
    for (var i = 0; i < elementosPurchase.length; i++) {
        if (elementosPurchase[i].type === "text" || elementosPurchase[i].type === "number") {
            elementosPurchase[i].addEventListener("focus", focusInput);
            elementosPurchase[i].addEventListener("blur", blurInput);
        }
    }
    for (var i = 0; i < elementosReturnPurchase.length; i++) {
        if (elementosReturnPurchase[i].type === "text" || elementosReturnPurchase[i].type === "number") {
            elementosReturnPurchase[i].addEventListener("focus", focusInput);
            elementosReturnPurchase[i].addEventListener("blur", blurInput);
        }
    }
    for (var i = 0; i < elementosReturnSale.length; i++) {
        if (elementosReturnSale[i].type === "text" || elementosReturnSale[i].type === "number") {
            elementosReturnSale[i].addEventListener("focus", focusInput);
            elementosReturnSale[i].addEventListener("blur", blurInput);
        }
    }
//-------------------------FIN VENTANA MODAL----------------------------------------


//    
//-------------------------------------------------------------------
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
            {targets: 1, bSortable: false},
            {targets: 4, render: $.fn.dataTable.render.number(',', '.', 2)},
            {targets: 5, render: $.fn.dataTable.render.number(',', '.', 2)},
            {targets: 2, render: $.fn.dataTable.render.number(',', '.', 2)}
        ],
        "scrollX": true,
        "scrollY": true,
        responsive: true,
        "language": {"url": "dataTables/languaje.json"},
        ajax: {

            url: `${path_services}${path}/listProduct`, //Traemos informacion del servicio restful
            type: 'GET',
            dataType: 'json',
            dataSrc: ''
        },
        columns: [//carga la informacion en cada columna del datatable
            {data: 'productName'},
            {data: 'productCount'},
            {data: 'productAveragePrice'},
            {data: 'productUtility'},
            {data: 'productPrice'},
            {data: 'productTotalValue'},
            {data: iconVisualize},
            {data: iconUpdate},
            {data: iconReturnPurchases},
            {data: iconReturnSales},
            {data: iconPurchase},
            {data: iconDelete}
        ]

    });
    /*------------------------------ICONOS DATATABLES----------------------------------------*/
    function iconVisualize(data) {
        let datas = '<a id="productvisualize" title="Visualizar" href="#" productId-data="' + data.productId + '"productName-data="' + data.productName + '" \n\
         productDescription-data="' + data.productDescription + '" \n\
         productCount-data="' + data.productCount + '" \n\
         productPrice-data="' + data.productPrice + '"productIva-data="' + data.productIva + '"\n\
         productTotalValue-data="' + data.productTotalValue + '" \n\
         productUtility-data="' + data.productUtility + '"productAveragePrice-data="' + data.productAveragePrice + '"\n\
         productDateExpiration-data="' + data.productDateExpiration + '" class="icon-table">\n\
         <i class="fa fa-eye" aria-hidden="true"></i></a>';
        return datas;
    }
    function iconUpdate(data) { // boton actualizar (obtener datos de listado restfull)
        let datas = '<a id="update" title="Modificar" href="#" productId-data="' + data.productId + '"productName-data="' + data.productName + '" \n\
         productDescription-data="' + data.productDescription + '" \n\
         productCount-data="' + data.productCount + '" \n\
         productPrice-data="' + data.productPrice + '"productIva-data="' + data.productIva + '"\n\
         productTotalValue-data="' + data.productTotalValue + '" \n\
         productUtility-data="' + data.productUtility + '"productAveragePrice-data="' + data.productAveragePrice + '"\n\
         productDateExpiration-data="' + data.productDateExpiration + '" class="icon-table">\n\
         <i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>';
        return datas;
    }
    function iconReturnPurchases(data) {
        let datas = '<a id="returnpurchase" title="Devolucion en Compras" href="#" productId-data="' + data.productId + '"productName-data="' + data.productName + '" \n\
         productDescription-data="' + data.productDescription + '" \n\
         productCount-data="' + data.productCount + '" \n\
         productPrice-data="' + data.productPrice + '"productIva-data="' + data.productIva + '"\n\
         productTotalValue-data="' + data.productTotalValue + '" \n\
         productUtility-data="' + data.productUtility + '"productAveragePrice-data="' + data.productAveragePrice + '"\n\
         productDateExpiration-data="' + data.productDateExpiration + '" class="icon-table">\n\
         <i class="fa fa-reply" aria-hidden="true"></i></a>';
        return datas;
    }
    function iconReturnSales(data) {
        let datas = '<a id="returnsale" title="Devolucion en Ventas" href="#" productId-data="' + data.productId + '"productName-data="' + data.productName + '" \n\
         productDescription-data="' + data.productDescription + '" \n\
         productCount-data="' + data.productCount + '" \n\
         productPrice-data="' + data.productPrice + '"productIva-data="' + data.productIva + '"\n\
         productTotalValue-data="' + data.productTotalValue + '" \n\
         productUtility-data="' + data.productUtility + '"productAveragePrice-data="' + data.productAveragePrice + '"\n\
         productDateExpiration-data="' + data.productDateExpiration + '" class="icon-table">\n\
         <i class="fa fa-share" aria-hidden="true"></i></a>';
        return datas;
    }

    function iconPurchase(data) {
        let datas = '<a id="purchase" title="Agregar stock" href="#" productId-data="' + data.productId + '"productName-data="' + data.productName + '" \n\
         productDescription-data="' + data.productDescription + '" \n\
         productCount-data="' + data.productCount + '" \n\
         productPrice-data="' + data.productPrice + '"productIva-data="' + data.productIva + '"\n\
         productTotalValue-data="' + data.productTotalValue + '" \n\
         productUtility-data="' + data.productUtility + '"productAveragePrice-data="' + data.productAveragePrice + '"\n\
         productDateExpiration-data="' + data.productDateExpiration + '" class="icon-table">\n\
        <i class="fa fa-plus-square" aria-hidden="true"></i></a>';
        return datas;
    }

    function iconDelete(data) {
        let datas = '<a id="delete" title="Eliminar" href="#" productId-data="' + data.productId + '"productName-data="' + data.productName + '" \n\
         productDescription-data="' + data.productDescription + '" \n\
         productCount-data="' + data.productCount + '" \n\
         productPrice-data="' + data.productPrice + '"productIva-data="' + data.productIva + '"\n\
         productTotalValue-data="' + data.productTotalValue + '" \n\
         productProviderId-data="' + data.oProvider.providerId + '" \n\
         productUtility-data="' + data.productUtility + '"productAveragePrice-data="' + data.productAveragePrice + '"\n\
         productDateExpiration-data="' + data.productDateExpiration + '" class="icon-table">\n\
         <i class="fa fa-trash" aria-hidden="true" ></i></a></td>';
        return datas;
    }

    /*------------------------------FUNCIONES DE producto----------------------------------------*/

    function deleteproduct() {
        let productMType = "4";
        let productId = $('#productId-deleteModal').text();
        let productName = $('#productName-deleteModal').text();
        let productDescription = $('#productDescription-deleteModal').text();
        let productPrice = $('#productPrice-deleteModal').text();
        let productIva = $('#productIva-deleteModal').text();
        let productDateExpiration = $('#productDateExpiration-deleteModal').text();
        let productCount = $('#productCount-deleteModal').text();
        let productTotalValue = $('#productTotalValue-deleteModal').text();
        let productUtility = $('#productUtility-deleteModal').text();
        let productAveragePrice = $('#productAveragePrice-deleteModal').text();

        let productDetail = "";
        let productValue = 0;
        let productcountprocess = 0;
        let productProviderId = $('#productProviderId-deleteModal').text();

        let formData = new FormData();
        formData.append('productMType', productMType);
        formData.append('productId', productId);
        formData.append('productName', productName);
        formData.append('productDescription', productDescription);
        formData.append('productPrice', productPrice);
        formData.append('productIva', productIva);
        formData.append('productDateExpiration', productDateExpiration);
        formData.append('productCount', productCount);
        formData.append('productTotalValue', productTotalValue);
        formData.append('productUtility', productUtility);
        formData.append('productAveragePrice', productAveragePrice);
        formData.append('productProviderId', productProviderId);
        formData.append('productDetail', productDetail);
        formData.append('productValue', productValue);
        formData.append('productcountprocess', productcountprocess);
        formData.append('providerId', productProviderId);
        alert(productProviderId);
        $.ajax({
            url: `${path_services}${path}/managementProduct`, //Traemos informacion del servicio restful
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
                console.log(status + "Producto: " + errorMsg);
            }});
        $('#windows-delete-product').toggleClass('hide-modal');
    }

    function updateproduct() {
        let productMType = "3"; //erecivimos los datos desde la ventan modal

        let productId = $('input[name="productId-updateModal"]').val();
        let productName = $('input[name="productName-updateModal"]').val();
        let productDescription = $('input[name="productDescription-updateModal"]').val();
        let productPrice = $('input[name="productPrice-updateModal"]').val();
        let productIva = $('input[name="productIva-updateModal"]').val();
        let productDateExpiration = $('input[name="productDateExpiration-updateModal"]').val();
        let productCount = $('input[name="productCount-updateModal"]').val();
        let productTotalValue = $('input[name="productTotalValue-updateModal"]').val();
        let productUtility = $('input[name="productUtility-updateModal"]').val();
        let productAveragePrice = $('input[name="productAveragePrice-updateModal"]').val();
        let productDetail = "";
        let productValue = 0;
        let productcountprocess = 0;
        let providerId = 0;
        if ((productName === '') || (productDescription === '') || (productIva === '') || (productDateExpiration === '') || (productUtility === '')) {
            alert('Por Favor llene todos los campos');
        } else {
            let formData = new FormData();
            formData.append('productMType', productMType);
            formData.append('productId', productId);
            formData.append('productName', productName);
            formData.append('productDescription', productDescription);
            formData.append('productPrice', productPrice);
            formData.append('productIva', productIva);
            formData.append('productDateExpiration', productDateExpiration);
            formData.append('productCount', productCount);
            formData.append('productTotalValue', productTotalValue);
            formData.append('productUtility', productUtility);
            formData.append('productAveragePrice', productAveragePrice);
            formData.append('productDetail', productDetail);
            formData.append('productValue', productValue);
            formData.append('productcountprocess', productcountprocess);
            formData.append('providerId', providerId);
            $.ajax({
                url: `${path_services}${path}/managementProduct`, //Traemos informacion del servicio restful
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
                    console.log(status + "producto: " + errorMsg);
                }});
            $('#windows-update-product').toggleClass('hide-modal');
        }
    }

    function addproduct() {
        let productMType = "1";
        let productId = "1";
        let productName = $('input[name="productName-addModal"]').val();
        let productDescription = $('input[name="productDescription-addModal"]').val();
        let productAveragePrice = $('input[name="productPrice-addModal"]').val();
        let productIva = $('input[name="productIva-addModal"]').val();
        let productDateExpiration = $('input[name="productDateExpiration-addModal"]').val();
        let productCount = $('input[name="productCount-addModal"]').val();
        let productUtility = $('input[name="productUtility-addModal"]').val();
        let productPrice = $('input[name="productPVP-addModal"]').val();
        let productTotalValue = parseFloat(productAveragePrice) * parseFloat(productCount);
        let productDetail = "Se ingreso un nuevo producto";
        let productValue = productTotalValue;
        let productcountprocess = productCount;
        let providerId = $('#providerId-addModal').val();
        if ((productName === '') || (productDescription === '') || (productAveragePrice === '') || (productIva === '') || (productDateExpiration === '') || (productCount === '') || (productUtility === '') || (productPrice === '') || (productTotalValue === '')) {
            alert('Por Favor llene todos los campos');
        } else {
            let formData = new FormData();
            formData.append('productMType', productMType);
            formData.append('productId', productId);
            formData.append('productName', productName);
            formData.append('productDescription', productDescription);
            formData.append('productAveragePrice', productAveragePrice);
            formData.append('productIva', productIva);
            formData.append('productDateExpiration', productDateExpiration);
            formData.append('productCount', productCount);
            formData.append('productUtility', productUtility);
            formData.append('productPrice', productPrice);
            formData.append('productTotalValue', productTotalValue);
            formData.append('productDetail', productDetail);
            formData.append('productValue', productValue);
            formData.append('productcountprocess', productcountprocess);
            formData.append('providerId', providerId);

            $.ajax({
//                    url: "/GICO-AD/webresources/product/managementProduct",
                url: `${path_services}${path}/managementProduct`, //Traemos informacion del servicio restful
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
                    console.log(status + "Producto: " + errorMsg);
                }});
            $('#windows-add-product').toggleClass('hide-modal');
        }
    }

    /*------------------------------ACCIONES EVENTO CLIC    BOTONES----------------------------------------*/
    $(document).on('click', 'a#delete', function (e) { //Mostrar la ventana modal de eliminar producto
        e.preventDefault();
        let productId = $(this).attr("productId-data");
        let productName = $(this).attr("productName-data");
        let productDescription = $(this).attr("productDescription-data");
        let productPrice = $(this).attr("productPrice-data");
        let productIva = $(this).attr("productIva-data");
        let productDateExpiration = $(this).attr("productDateExpiration-data");
        let productCount = $(this).attr("productCount-data");
        let productTotalValue = $(this).attr("productTotalValue-data");
        let productUtility = $(this).attr("productUtility-data");
        let productAveragePrice = $(this).attr("productAveragePrice-data");
        let productProviderId = $(this).attr("productProviderId-data");

        $('#windows-delete-product').removeClass('hide-modal'); //Desoculta la ventana modal

        $('#productId-deleteModal').text(productId);
        $('#productName-deleteModal').text(productName);
        $('#productDescription-deleteModal').text(productDescription);
        $('#productPrice-deleteModal').text(productPrice);
        $('#productIva-deleteModal').text(productIva);
        $('#productDateExpiration-deleteModal').text(productDateExpiration);
        $('#productCount-deleteModal').text(productCount);
        $('#productTotalValue-deleteModal').text(productTotalValue);
        $('#productUtility-deleteModal').text(productUtility);
        $('#productAveragePrice-deleteModal').text(productAveragePrice);
        $('#productProviderId-deleteModal').text(productProviderId);
    });

    $(document).on('click', '#closeIcon-delete', function () {// Cerrar la Ventana Modal de eliminar producto
        $('#windows-delete-product').toggleClass('hide-modal');
    });
    $(document).on('click', '#delete-product', function (e) {//Boton ACEPTAR eliminar producto
        e.preventDefault();
        deleteproduct();
    });
    $(document).on('click', '#delete-product-cancel', function () { //Boton CANCELAR eliminar producto    
        $('#windows-delete-product').toggleClass('hide-modal');
    });
    /*------------------------------UPDATE product----------------------------------------*/

    $(document).on('click', 'a#update', function (e) {//Mostrar la ventana modal de actualizar producto
        e.preventDefault();
        let productId = $(this).attr("productId-data");
        let productName = $(this).attr("productName-data");
        let productDescription = $(this).attr("productDescription-data");
        let productPrice = $(this).attr("productPrice-data");
        let productIva = $(this).attr("productIva-data");
        let productDateExpiration = $(this).attr("productDateExpiration-data");
        let productCount = $(this).attr("productCount-data");
        let productTotalValue = $(this).attr("productTotalValue-data");
        let productUtility = $(this).attr("productUtility-data");
        let productAveragePrice = $(this).attr("productAveragePrice-data");

        $('#windows-update-product').removeClass('hide-modal'); //Muestra la ventan modal


        $('input[name="productId-updateModal"]').val(productId); //carga los datos en innput de ventana modal
        $('input[name="productName-updateModal"]').val(productName);
        $('input[name="productDescription-updateModal"]').val(productDescription);
        $('input[name="productPrice-updateModal"]').val(productPrice);
        $('input[name="productIva-updateModal"]').val(productIva);
        $('input[name="productDateExpiration-updateModal"]').val(productDateExpiration);
        $('input[name="productCount-updateModal"]').val(productCount);
        $('input[name="productTotalValue-updateModal"]').val(productTotalValue);
        $('input[name="productUtility-updateModal"]').val(productUtility);
        $('input[name="productAveragePrice-updateModal"]').val(productAveragePrice);
    });
    $(document).on('click', '#closeIcon-update', function () {// Cerrar la Ventana Modal desde el icono
        $('#windows-update-product').toggleClass('hide-modal');
        $("#form-update-product")[0].reset();
    });
    $(document).on('click', '#update-product-cancel', function () {//Boton CANCELAR modificar producto 
        $('#windows-update-product').toggleClass('hide-modal');
        $("#form-update-product")[0].reset();
    });
    $(document).on('click', '#update-product', function () {//Boton ACEPTAR modificar producto 
        updateproduct();
    });



    $(document).on('click', '#id-add-product', function () {// Mostrar ventana modal ingresar producto    
        $("#form-add-product")[0].reset();
        $('#windows-add-product').removeClass('hide-modal');

    });
    $(document).on('click', '#closeIcon-add', function () {// Cerrar la Ventana Modal desde el icono
        $('#windows-add-product').toggleClass('hide-modal');
    });
    $(document).on('click', '#add-product', function () {// Boton ACEPTAR ingresar producto

        addproduct();
    });
    $(document).on('click', '#add-product-cancel', function () {// Boton CANCELAR ingresar producto    
        $('#windows-add-product').toggleClass('hide-modal');
    });

    $(document).on('click', '#calcPVP-product', function () {// Boton ACEPTAR ingresar producto
        let productUtility = $('input[name="productUtility-addModal"]').val();
        let productAveragePrice = $('input[name="productPrice-addModal"]').val();
        if ((productUtility === '')) {
            alert('Por Favor llene el campo de utilidad');
            $('input[name="productUtility-addModal"]').focus();
        } else if ((productAveragePrice === '')) {
            alert('Por Favor llene el campo de precio al que se adquiere el producto');
            $('input[name="productPrice-addModal"]').focus();
        } else {
            $('#lblpvp').addClass('active');
            let utilitypercent = parseFloat(productUtility) / 100;
            let utility = parseFloat(productAveragePrice) * parseFloat(utilitypercent);
            let price = parseFloat(utility) + parseFloat(productAveragePrice);
            $("#productPVP-addModal").val(price);
        }
    });
    $(document).on('click', '#calcUtility-product', function () {// Boton CANCELAR ingresar producto    
        let PVP = $('input[name="productPVP-addModal"]').val();
        let productAveragePrice = $('input[name="productPrice-addModal"]').val();
        if ((PVP === '')) {
            alert('Por Favor llene el campo de PVP');
            $('input[name="productPVP-addModal"]').focus();
        } else if ((productAveragePrice === '')) {
            alert('Por Favor llene el campo de precio al que se adquiere el producto');
            $('input[name="productPrice-addModal"]').focus();
        } else {
            $('#lblutility').addClass('active');
            let utilityValue = parseFloat(PVP) * 100;
            let priceIni = parseFloat(utilityValue) / parseFloat(productAveragePrice);
            let utility = parseFloat(priceIni) - 100;
            $("#productUtility-addModal").val(utility);
        }
    });

    /*------------------------------PURCHASE product----------------------------------------*/

    function purchaseproduct() {
        let productMType = "2";

        let productId = $('#productId-purchaseModal').text();
        let productName = $('#productName-purchaseModal').text();
        let productDescription = $('#productDescription-purchaseModal').text();
        let productPrice = $('#productPrice-purchaseModal').text();
        let productIva = $('#productIva-purchaseModal').text();
        let productDateExpiration = $('#productDateExpiration-purchaseModal').text();
        let productCount = $('#productCount-purchaseModal').text();
        let productTotalValue = $('#productTotalValue-purchaseModal').text();
        let productUtility = $('#productUtility-purchaseModal').text();
        let productAveragePrice = $('#productAveragePrice-purchaseModal').text();

        let productNewCount = $('input[name="productNewCount-purchaseModal"]').val();
        let productNewPrice = $('input[name="productNewPrice-purchaseModal"]').val();
        let total1 = productNewPrice * productNewCount;
        let total2 = parseFloat(productCount) * parseFloat(productAveragePrice);
        productTotalValue = total1 + total2;
        productCount = parseInt(productCount) + parseInt(productNewCount);
        productAveragePrice = parseFloat(productTotalValue) / parseFloat(productCount);

        let productDetail = "Compra de producto";
        let productValue = total1;
        let productcountprocess = productNewCount;
        let providerId = 1;

        if ((productNewCount === '') || (productNewPrice === '')) {
            alert('Por Favor llene todos los campos');
        } else {
            let formData = new FormData();
            formData.append('productMType', productMType);
            formData.append('productId', productId);
            formData.append('productName', productName);
            formData.append('productDescription', productDescription);
            formData.append('productPrice', productPrice);
            formData.append('productIva', productIva);
            formData.append('productDateExpiration', productDateExpiration);
            formData.append('productCount', productCount);
            formData.append('productTotalValue', productTotalValue);
            formData.append('productUtility', productUtility);
            formData.append('productAveragePrice', productAveragePrice);
            formData.append('productDetail', productDetail);
            formData.append('productValue', productValue);
            formData.append('productcountprocess', productcountprocess);
            formData.append('providerId', providerId);


            $.ajax({
//                    url: "/GICO-AD/webresources/product/addproduct",
                url: `${path_services}${path}/managementProduct`, //Traemos informacion del servicio restful
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
                    console.log(status + "Compra: " + errorMsg);
                }});
            $('#windows-purchase-product').toggleClass('hide-modal');
        }
    }



    $(document).on('click', 'a#purchase', function (e) {//Mostrar la ventana modal de agregar stock producto
        e.preventDefault();
        let productId = $(this).attr("productId-data");
        let productName = $(this).attr("productName-data");
        let productDescription = $(this).attr("productDescription-data");
        let productPrice = $(this).attr("productPrice-data");
        let productIva = $(this).attr("productIva-data");
        let productDateExpiration = $(this).attr("productDateExpiration-data");
        let productCount = $(this).attr("productCount-data");
        let productTotalValue = $(this).attr("productTotalValue-data");
        let productUtility = $(this).attr("productUtility-data");
        let productAveragePrice = $(this).attr("productAveragePrice-data");

        $('#windows-purchase-product').removeClass('hide-modal'); //Muestra la ventan modal

        $('#productId-purchaseModal').text(productId);
        $('#productName-purchaseModal').text(productName);
        $('#productDescription-purchaseModal').text(productDescription);
        $('#productPrice-purchaseModal').text(productPrice);
        $('#productIva-purchaseModal').text(productIva);
        $('#productDateExpiration-purchaseModal').text(productDateExpiration);
        $('#productCount-purchaseModal').text(productCount);
        $('#productTotalValue-purchaseModal').text(productTotalValue);
        $('#productUtility-purchaseModal').text(productUtility);
        $('#productAveragePrice-purchaseModal').text(productAveragePrice);

    });
    $(document).on('click', '#closeIcon-purchase', function () {// Cerrar la Ventana Modal desde el icono
        $('#windows-purchase-product').toggleClass('hide-modal');
        $("#id-form-purchase-product")[0].reset();
    });
    $(document).on('click', '#purchase-product-cancel', function () {//Boton CANCELAR modificar producto 
        $('#windows-purchase-product').toggleClass('hide-modal');
        $("#id-form-purchase-product")[0].reset();
    });
    $(document).on('click', '#purchase-product', function () {//Boton ACEPTAR modificar producto 
        purchaseproduct();
        $("#id-form-purchase-product")[0].reset();
    });


    /*------------------------------RETURN PURCHASE product----------------------------------------*/

    function returnpurchaseproduct() {
        let productMType = "2";

        let productId = $('#productId-purchaseModal').text();
        let productName = $('#productName-purchaseModal').text();
        let productDescription = $('#productDescription-purchaseModal').text();
        let productPrice = $('#productPrice-purchaseModal').text();
        let productIva = $('#productIva-purchaseModal').text();
        let productDateExpiration = $('#productDateExpiration-purchaseModal').text();
        let productCount = $('#productCount-purchaseModal').text();
        let productCountRequest = $('#productCount-purchaseModal').text();
        let productTotalValue = $('#productTotalValue-purchaseModal').text();
        let productUtility = $('#productUtility-purchaseModal').text();
        let productAveragePrice = $('#productAveragePrice-purchaseModal').text();

        let productNewCount = $('input[name="productNewCount-returnpurchaseModal"]').val();
        let productNewPrice = $('input[name="productNewPrice-returnpurchaseModal"]').val();
        let total1 = productNewPrice * productNewCount;
        let total2 = parseFloat(productCount) * parseFloat(productAveragePrice);
        productTotalValue = total2 - total1;
        productCount = parseInt(productCount) - parseInt(productNewCount);
        productAveragePrice = parseFloat(productTotalValue) / parseFloat(productCount);

        let productDetail = "Devolucion en compra de producto";
        let productValue = parseFloat(total1) * (-1);
        let productcountprocess = productNewCount;
        let providerId = 1;

        if ((productNewCount === '') || (productNewPrice === '')) {
            alert('Por Favor llene todos los campos');
        } else if (productNewCount > parseInt(productCountRequest)) {
            alert('ERROR !! \n\
La cantidad que se quiere devolver es mayor a la que se tiene en existencia');
        } else {
            let formData = new FormData();
            formData.append('productMType', productMType);
            formData.append('productId', productId);
            formData.append('productName', productName);
            formData.append('productDescription', productDescription);
            formData.append('productPrice', productPrice);
            formData.append('productIva', productIva);
            formData.append('productDateExpiration', productDateExpiration);
            formData.append('productCount', productCount);
            formData.append('productTotalValue', productTotalValue);
            formData.append('productUtility', productUtility);
            formData.append('productAveragePrice', productAveragePrice);
            formData.append('productDetail', productDetail);
            formData.append('productValue', productValue);
            formData.append('productcountprocess', productcountprocess);
            formData.append('providerId', providerId);


            $.ajax({
//                    url: "/GICO-AD/webresources/product/addproduct",
                url: `${path_services}${path}/managementProduct`, //Traemos informacion del servicio restful
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
                    console.log(status + "Compra: " + errorMsg);
                }});
            $('#windows-returnpurchase-product').toggleClass('hide-modal');
        }
    }



    $(document).on('click', 'a#returnpurchase', function (e) {//Mostrar la ventana modal de agregar stock producto
        e.preventDefault();
        let productId = $(this).attr("productId-data");
        let productName = $(this).attr("productName-data");
        let productDescription = $(this).attr("productDescription-data");
        let productPrice = $(this).attr("productPrice-data");
        let productIva = $(this).attr("productIva-data");
        let productDateExpiration = $(this).attr("productDateExpiration-data");
        let productCount = $(this).attr("productCount-data");
        let productTotalValue = $(this).attr("productTotalValue-data");
        let productUtility = $(this).attr("productUtility-data");
        let productAveragePrice = $(this).attr("productAveragePrice-data");

        $('#windows-returnpurchase-product').removeClass('hide-modal'); //Muestra la ventan modal

        $('#productId-purchaseModal').text(productId);
        $('#productName-purchaseModal').text(productName);
        $('#productDescription-purchaseModal').text(productDescription);
        $('#productPrice-purchaseModal').text(productPrice);
        $('#productIva-purchaseModal').text(productIva);
        $('#productDateExpiration-purchaseModal').text(productDateExpiration);
        $('#productCount-purchaseModal').text(productCount);
        $('#productTotalValue-purchaseModal').text(productTotalValue);
        $('#productUtility-purchaseModal').text(productUtility);
        $('#productAveragePrice-purchaseModal').text(productAveragePrice);

    });
    $(document).on('click', '#closeIcon-returnpurchase', function () {// Cerrar la Ventana Modal desde el icono
        $('#windows-returnpurchase-product').toggleClass('hide-modal');
        $("#id-form-returnpurchase-product")[0].reset();
    });
    $(document).on('click', '#returnpurchase-product-cancel', function () {//Boton CANCELAR modificar producto 
        $('#windows-returnpurchase-product').toggleClass('hide-modal');
        $("#id-form-returnpurchase-product")[0].reset();
    });
    $(document).on('click', '#returnpurchase-product', function () {//Boton ACEPTAR modificar producto 
        returnpurchaseproduct();
        $("#id-form-returnpurchase-product")[0].reset();
    });

    /*------------------------------RETURN SALE product----------------------------------------*/

    function returnsaleproduct() {
        let productMType = "2";

        let productId = $('#productId-saleModal').text();
        let productName = $('#productName-saleModal').text();
        let productDescription = $('#productDescription-saleModal').text();
        let productPrice = $('#productPrice-saleModal').text();
        let productIva = $('#productIva-saleModal').text();
        let productDateExpiration = $('#productDateExpiration-saleModal').text();
        let productCount = $('#productCount-saleModal').text();
        let productTotalValue = $('#productTotalValue-saleModal').text();
        let productUtility = $('#productUtility-saleModal').text();
        let productAveragePrice = $('#productAveragePrice-saleModal').text();

        let productNewCount = $('input[name="productNewCount-returnsale"]').val();
        let total1 = productAveragePrice * productNewCount;
        let total2 = parseFloat(productCount) * parseFloat(productAveragePrice);
        productTotalValue = total2 + total1;
        productCount = parseInt(productCount) + parseInt(productNewCount);
        productAveragePrice = parseFloat(productTotalValue) / parseFloat(productCount);

        let productDetail = "Devolucion en venta de producto";
        let productValue = total1;
        let productcountprocess = productNewCount;
        let providerId = 1;

        if ((productNewCount === '')) {
            alert('Por Favor llene todos los campos');
        } else {
            let formData = new FormData();
            formData.append('productMType', productMType);
            formData.append('productId', productId);
            formData.append('productName', productName);
            formData.append('productDescription', productDescription);
            formData.append('productPrice', productPrice);
            formData.append('productIva', productIva);
            formData.append('productDateExpiration', productDateExpiration);
            formData.append('productCount', productCount);
            formData.append('productTotalValue', productTotalValue);
            formData.append('productUtility', productUtility);
            formData.append('productAveragePrice', productAveragePrice);
            formData.append('productDetail', productDetail);
            formData.append('productValue', productValue);
            formData.append('productcountprocess', productcountprocess);
            formData.append('providerId', providerId);

            $.ajax({
//                    url: "/GICO-AD/webresources/product/addproduct",
                url: `${path_services}${path}/managementProduct`, //Traemos informacion del servicio restful
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
                    console.log(status + "Compra: " + errorMsg);
                }});
            $('#windows-returnsale-product').toggleClass('hide-modal');
        }
    }



    $(document).on('click', 'a#returnsale', function (e) {//Mostrar la ventana modal de agregar stock producto
        e.preventDefault();
        let productId = $(this).attr("productId-data");
        let productName = $(this).attr("productName-data");
        let productDescription = $(this).attr("productDescription-data");
        let productPrice = $(this).attr("productPrice-data");
        let productIva = $(this).attr("productIva-data");
        let productDateExpiration = $(this).attr("productDateExpiration-data");
        let productCount = $(this).attr("productCount-data");
        let productTotalValue = $(this).attr("productTotalValue-data");
        let productUtility = $(this).attr("productUtility-data");
        let productAveragePrice = $(this).attr("productAveragePrice-data");

        $('#windows-returnsale-product').removeClass('hide-modal'); //Muestra la ventan modal

        $('#productId-saleModal').text(productId);
        $('#productName-saleModal').text(productName);
        $('#productDescription-saleModal').text(productDescription);
        $('#productPrice-saleModal').text(productPrice);
        $('#productIva-saleModal').text(productIva);
        $('#productDateExpiration-saleModal').text(productDateExpiration);
        $('#productCount-saleModal').text(productCount);
        $('#productTotalValue-saleModal').text(productTotalValue);
        $('#productUtility-saleModal').text(productUtility);
        $('#productAveragePrice-saleModal').text(productAveragePrice);

    });
    $(document).on('click', '#closeIcon-returnsale', function () {// Cerrar la Ventana Modal desde el icono
        $('#windows-returnsale-product').toggleClass('hide-modal');
        $("#id-form-returnsale-product")[0].reset();
    });
    $(document).on('click', '#returnsale-product-cancel', function () {//Boton CANCELAR modificar producto 
        $('#windows-returnsale-product').toggleClass('hide-modal');
        $("#id-form-returnsale-product")[0].reset();
    });
    $(document).on('click', '#returnsale-product', function () {//Boton ACEPTAR modificar producto 
        returnsaleproduct();
        $("#id-form-returnsale-product")[0].reset();
    });




    /*------------------------------VISUALIZE product----------------------------------------*/

    $(document).on('click', 'a#productvisualize', function (e) {//Mostrar la ventana modal de actualizar producto
        e.preventDefault();
        let productId = $(this).attr("productId-data");
        let productName = $(this).attr("productName-data");
        let productDescription = $(this).attr("productDescription-data");
        let productPrice = $(this).attr("productPrice-data");
        let productIva = $(this).attr("productIva-data");
        let productDateExpiration = $(this).attr("productDateExpiration-data");
        let productCount = $(this).attr("productCount-data");
        let productTotalValue = $(this).attr("productTotalValue-data");
        let productUtility = $(this).attr("productUtility-data");
        let productAveragePrice = $(this).attr("productAveragePrice-data");

        $('#windows-visualize-product').removeClass('hide-modal'); //Muestra la ventan modal

        $('input[name="productId-visualizeModal"]').val(productId); //carga los datos en innput de ventana modal
        $('input[name="productName-visualizeModal"]').val(productName);
        $('input[name="productDescription-visualizeModal"]').val(productDescription);
        $('input[name="productPrice-visualizeModal"]').val(productPrice);
        $('input[name="productIva-visualizeModal"]').val(productIva);
        $('input[name="productDateExpiration-visualizeModal"]').val(productDateExpiration);
        $('input[name="productCount-visualizeModal"]').val(productCount);
        $('input[name="productTotalValue-visualizeModal"]').val(productTotalValue);
        $('input[name="productUtility-visualizeModal"]').val(productUtility);
        $('input[name="productAveragePrice-visualizeModal"]').val(productAveragePrice);
    });
    $(document).on('click', '#closeIcon-visualize', function () {// Cerrar la Ventana Modal desde el icono
        $('#windows-visualize-product').toggleClass('hide-modal');
        $("#form-visualize-product")[0].reset();
    });
    $(document).on('click', '#visualize-product-cancel', function () {//Boton CANCELAR modificar producto 
        $('#windows-visualize-product').toggleClass('hide-modal');
        $("#form-visualize-product")[0].reset();
    });

    $.ajax({
        url: `${path_services}/provider/listProvider`, //Traemos informacion del servicio restful
        type: 'GET',
        dataType: 'json',
        dataSrc: '',
        success: function (data) {
            for (var i = 0; i < data.length; i++) {
                var option = '<option value="' + data[i].providerId + '">' + data[i].providerName;
                option += '</option>';
                document.getElementById("providerId-addModal").innerHTML += option;
            }
        }
    });

});