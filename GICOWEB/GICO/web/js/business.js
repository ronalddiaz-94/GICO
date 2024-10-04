/*------------------------------DATA TABLE product----------------------------------------*/
/* global resultEmail */

const path_services = "/GICO-AD/webresources";
const path = "/business";
let prueba = "jorge no sapee";
$(document).ready(function () {


    let table = $('#gblTable').DataTable({
        dom: 'Brt',
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
            url: `${path_services}${path}/listBusiness`, //Traemos informacion del servicio restful
            type: 'GET',
            dataType: 'json',
            dataSrc: ''
        },
        columns: [//carga la informacion en cada columna del datatable
            {data: 'businessMission'},
            {data: 'businessView'},
            {data: 'businessName'},
            {data: 'businessAddress'},
            {data: 'businessPhon'},
            {data: 'businessCell'},
            {data: iconUpdate}
        ]

    });
    /*------------------------------ICONOS DATATABLES----------------------------------------*/

    function iconUpdate(data) { // boton actualizar (obtener datos de listado restfull)
        let datas = '<a id="update" title="Modificar" href="#" businessId-data="' + data.businessId + '" businessMission-data="' + data.businessMission + '"businessView-data="' + data.businessView + '"businessName-data="' + data.businessName + '"businessAddress-data="' + data.businessAddress + '"businessCell-data="' + data.businessCell + '" \n\
         businessPhon-data="' + data.businessPhon + '" class="icon-table">\n\
         <i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>';
        return datas;
    }

    /*------------------------------FUNCIONES DE datos generales empresa----------------------------------------*/


    function updatebusiness() {
        let businessMType = "1"; //erecivimos los datos desde la ventan modal
        let businessId = $('input[name="businessId-updateModal"]').val();
        let businessMission = $('input[name="businessMission-updateModal"]').val();
        let businessView = $('input[name="businessView-updateModal"]').val();
        let businessName = $('input[name="businessName-updateModal"]').val();
        let businessAddress = $('input[name="businessAddress-updateModal"]').val();
        let businessPhon = $('input[name="businessPhon-updateModal"]').val();
        let businessCell = $('input[name="businessPhon-updateModal"]').val();

        if ((businessMission === '') || (businessView === '') || (businessName === '') || (businessAddress === '') || (businessPhon === '') || (businessCell === '')) {
            alert('Por Favor llene todos los campos');
        } else {
            let formData = new FormData();
            formData.append('businessMType', businessMType);
            formData.append('businessId', businessId);
            formData.append('businessMission', businessMission);
            formData.append('businessView', businessView);
            formData.append('businessName', businessName);
            formData.append('businessAddress', businessAddress);
            formData.append('businessPhon', businessPhon);
            formData.append('businessCell', businessCell);


            $.ajax({
                url: `${path_services}${path}/managementBusiness`, //Traemos informacion del servicio restful
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
                    console.log(status + "Business: " + errorMsg);
                }});
            $('#windows-update-business').toggleClass('hide-modal');
        }
    }


    /*------------------------------UPDATE CELLAR----------------------------------------*/

    $(document).on('click', 'a#update', function (e) {//Mostrar la ventana modal de actualizar datos generales empresa
        e.preventDefault();
        let businessId = $(this).attr("businessId-data");
        let businessMission = $(this).attr("businessMission-data");
        let businessView = $(this).attr("businessView-data");
        let businessName = $(this).attr("businessName-data");
        let businessAddress = $(this).attr("businessAddress-data");
        let businessPhon = $(this).attr("businessPhon-data");
        let businessCell = $(this).attr("businessCell-data");

        $('#windows-update-business').removeClass('hide-modal'); //Muestra la ventan modal

        $('input[name="businessMission-updateModal"]').val(businessMission); //carga los datos en innput de ventana modal
        $('input[name="businessId-updateModal"]').val(businessId);
        $('input[name="businessView-updateModal"]').val(businessView);
        $('input[name="businessName-updateModal"]').val(businessName);
        $('input[name="businessAddress-updateModal"]').val(businessAddress);
        $('input[name="businessPhon-updateModal"]').val(businessPhon);
        $('input[name="businessCell-updateModal"]').val(businessCell);

    });
    $(document).on('click', '#closeIcon-update', function () {// Cerrar la Ventana Modal desde el icono
        $('#windows-update-business').toggleClass('hide-modal');
        $("#form-update-business")[0].reset();
    });
    $(document).on('click', '#update-business-cancel', function () {//Boton CANCELAR modificar producto 
        $('#windows-update-business').toggleClass('hide-modal');
        $("#form-update-business")[0].reset();
    });
    $(document).on('click', '#update-business', function () {//Boton ACEPTAR modificar producto 
        updatebusiness();
    });

    //------------------------- VENTANA MODAL----------------------------------------  
    var formulario = document.form_update_business,
            elementos = formulario.elements;
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
    for (var i = 0; i < elementos.length; i++) {
        if (elementos[i].type === "text" || elementos[i].type === "number") {
            elementos[i].addEventListener("focus", focusInput);
            elementos[i].addEventListener("blur", blurInput);
        }
    }
    //-------------------------FIN VENTANA MODAL----------------------------------------

});