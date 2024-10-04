$(document).ready(function () {
    $('#example').DataTable({
        "dom": 'lBfrtip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ],

        "lengthChange": true,
        "pageLength": 10,
        lengthMenu: [5, 10, 25, 50],
        "columnDefs": [{
                "targets": 3,
                "createdCell": function (td, cellData, rowData, row, col) {
                    if (cellData < 1) {
                        $(td).css('color', 'red')
                    }
                }
            }]
    });
});

