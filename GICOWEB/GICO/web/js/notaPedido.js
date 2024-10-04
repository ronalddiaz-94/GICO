/*------------------------------DATA TABLE product----------------------------------------*/
/* global resultEmail, elementos, add, product */



const path_services = "/GICO-AD/webresources";
const path = "/document";
let prueba = "jorge sapee";
$(document).ready(function () {



//-------------------------------------------------------------------
    let table = $('#gblTable').DataTable({
        dom: 'Blfrtip',
        lengthMenu: [5, 10, 25, 50],
        buttons: [
                 'pdf', 'print'
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
            url: `${path_services}${path}/listDocument`, //Traemos informacion del servicio restful
            type: 'GET',
            dataType: 'json',
            dataSrc: ''
        },
        columns: [//carga la informacion en cada columna del datatable
            {data: 'documentCi'},
            {data: 'documentClient'},
            {data: 'documentName'},
            {data: 'documentValue'},
            {data: iconVisualize}, 
            {data: iconPDF} 
        ]

    });
    /*------------------------------ICONOS DATATABLES----------------------------------------*/
    function iconVisualize(data) {
        let datas = '<a id="documentvisualize" title="Visualizar" href="#" documentId-data="' + data.documentId + '"documentName-data="' + data.documentName + '" \n\
         documentClient-data="' + data.documentClient + '" \n\
         documentCi-data="' + data.documentCi + '" \n\
         documenttypeid-data="' + data.documenttypeid + '"documentAddress-data="' + data.documentAddress + '"\n\
         documentValue-data="' + data.documentValue + '" class="icon-table">\n\
         <i class="fa fa-eye" aria-hidden="true"></i></a>';
        return datas;
    }
    
    function iconPDF(data) {
        let datas = '<a id="documentopen" title="Abrir Documento" href="#" class="icon-table">\n\
         <i class="fa fa-file-pdf-o" aria-hidden="true"></i></a>';
        return datas;
    }

    /*------------------------------VISUALIZE document----------------------------------------*/

    $(document).on('click', 'a#documentvisualize', function (e) { 
        e.preventDefault();
        let documentId = $(this).attr("documentId-data");
        let documentName = $(this).attr("documentName-data");
        let documentClient = $(this).attr("documentClient-data");
        let documentCi = $(this).attr("documentCi-data");
        let documenttypeid = $(this).attr("documenttypeid-data");
        let documentAddress = $(this).attr("documentAddress-data");
        let documentValue = $(this).attr("documentValue-data");


        $('#windows-visualize-document').removeClass('hide-modal'); //Muestra la ventan modal

        $('input[name="documentId-visualizeModal"]').val(documentId); //carga los datos en innput de ventana modal
        $('input[name="documentName-visualizeModal"]').val(documentName);
        $('input[name="documentClient-visualizeModal"]').val(documentClient);
        $('input[name="documentCI-visualizeModal"]').val(documentCi);
        $('input[name="documenttypeid-visualizeModal"]').val(documenttypeid);
        $('input[name="documentAddress-visualizeModal"]').val(documentAddress);
        $('input[name="documentValue-visualizeModal"]').val(documentValue);

    });
    $(document).on('click', '#closeIcon-visualize', function () {// Cerrar la Ventana Modal desde el icono
        $('#windows-visualize-document').toggleClass('hide-modal');
        $("#form-visualize-document")[0].reset();
    });
    $(document).on('click', '#visualize-document-cancel', function () {//Boton CANCELAR modificar producto 
        $('#windows-visualize-document').toggleClass('hide-modal');
        $("#form-visualize-document")[0].reset();
    });
    
    $(document).on('click', '#id-create-note', function () {
        pagina="adminReporteNotaPedido.jsp";
        location.href=pagina;
    });

});