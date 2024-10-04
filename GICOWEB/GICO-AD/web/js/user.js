//Path
var validador = $('.formularios').validate();
var validador_update = $('.formulario_update').validate();
const dir = "sgia_img/";
const path_services = "/GICO-AD/webresources";
const path = "/user";
let c = 0;
let Control = new Controller("");
//Listar Usuarios DataTables
$(document).ready(function () {
    let table = $('#gblTable').DataTable({
        lengthMenu: [5, 10, 25, 50],
        columnDefs: [
            {className: "dt-center", targets: [2, 3, 4, 5, 6]},
            {targets: 5, bSortable: false},
            {targets: 6, bSortable: false}
        ],
        "scrollX": true,
        responsive: true,
        "language": {"url": "dataTables/languaje.json"},
        ajax: {
            url: `${path_services}${path}/listUser`,
            dataSrc: ''
        },
        columns: [
            {data: 'identityCard'},
            {data: 'name'},
            {data: 'passport'},
            {data: 'email'},
            {data: 'tipo'},
            {data: iconUpdate},
            {data: iconDelete}
        ]
    });

    function iconUpdate(data) {
        let datas = '<a id="update" href="#" id-data="' + data.id + '" name-data="' + data.name + '" \n\
         ci-data="' + data.identityCard + '" passport-data="' + data.passport + '" \n\
         email-data="' + data.email + '" type-data="' + data.type + '" password-data="' + data.password + '"\n\
         photo-data="' + data.photo + '" class="icon-table">\n\
         <i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>';
        return datas;
    }

    function iconDelete(data) {
        let datas = '<a id="delete" href="#" id-data="' + data.id + '" \n\
        name-data="' + data.name + '" class="icon-table">\n\
        <i class="fa fa-trash" aria-hidden="true" ></i></a></td>';
        return datas;
    }

    function deleteUser() {
        let id = $('#id-user-delete').val();
        $.ajax({
            url: `${path_services}${path}/deleteUser/${id}`,
            type: 'PUT',
            success: function (data) {
                alert(data.message);
                table.ajax.reload();
            },
            error: function (jqxhr, status, errorMsg) {
                console.log(status + "Usuario: " + errorMsg);
            }});
        $('#windows-delete-user').toggleClass('hide-modal');
    }

    function readFile(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#image-update').attr('src', e.target.result);
            },
                    reader.readAsDataURL(input.files[0]);
        }
    }

    function updateUser() {
        let id = $('input[name="id-data"]').val();
        let name = $('input[name="name-data"]').val();
        let identityCard = $('input[name="ci-data"]').val();
        let passport = $('input[name="passport-data"]').val();
        let email = $('input[name="email-data"]').val();
        let password = $('input[name="password-data"]').val();
        let fileName = $('input[name="file-name-user"]').val();
        let file = $('input[name="file-data"]').get(0).files[0];
        let tipo = $('select[name="tipo-user"]').val();
        if (validador_update.form()) {
            //  alert('Campos Vacios');
            //} else {
            let email = $('#email-data').val();
            let resultEmail = validarEmail(email);
            let cedula = $('#ci-data').val();
            let resultCedula = validarCedula(cedula);
            if (passport === '') {
                passport = "No ingresado";
            }
            if (resultCedula === true && resultEmail === true) {
                let formData = new FormData();
                formData.append('id', id);
                formData.append('name', name);
                formData.append('identityCard', identityCard);
                formData.append('passport', passport);
                formData.append('email', email);
                formData.append('password', password);
                formData.append('file', file);
                formData.append('fileName', fileName);
                formData.append('type', tipo);
                $.ajax({
                    url: `${path_services}${path}/updateUser`,
                    type: 'PUT',
                    data: formData,
                    cache: false,
                    contentType: false,
                    processData: false,
                    success: function (data) {
                        alert(data.message);
                        table.ajax.reload();
                    },
                    error: function (jqxhr, status, errorMsg) {
                        console.log(status + "Usuario: " + errorMsg);
                    }});
                $('#windows-update-user').toggleClass('hide-modal');
                $("#form-update-user")[0].reset();
            }
        }
    }

    function addUser() {
        let name = $('input[name="name-user"]').val();
        let identityCard = $('input[name="identityCard-user"]').val();
        let passport = $('input[name="passport-user"]').val();
        let email = $('input[name="email-user"]').val();
        let password = $('input[name="password-user"]').val();
        let imgVal = $('input[name="file-user"]').val();
        let file = $('input[name="file-user"]').get(0).files[0];
        let tipo = $('select[name="tipo-user-add"]').val();
        if (validador.form()) {
            //   alert('Por Favor llene todos los campos');
            // } else {
            let email = $('#email-user').val();
            let resultEmail = validarEmail(email);
            let cedula = $('#ci-user').val();
            let resultCedula = validarCedula(cedula);
            if (passport === '') {
                passport = "No ingresado";
            }
            if (resultCedula === true && resultEmail === true) {
                let formData = new FormData();
                formData.append('name', name);
                formData.append('identityCard', identityCard);
                formData.append('passport', passport);
                formData.append('email', email);
                formData.append('password', password);
                formData.append('file', file);
                formData.append('type', tipo);
                $.ajax({
                    url: `${path_services}${path}/addUser`,
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
                        console.log(status + "Usuario: " + errorMsg);
                    }});
                $('#windows-add-user').toggleClass('hide-modal');
            }
        }
    }
//Mostrar la ventana modal de eliminar Usuario
    $(document).on('click', 'a#delete', function (e) {
        e.preventDefault();
        let id = $(this).attr("id-data");
        let name = $(this).attr("name-data");
        $('#windows-delete-user').removeClass('hide-modal');
        $('#name-user-delete').text(name);
        $('#id-user-delete').val(id);
    });
// Cerrar la Ventana Modal de eliminar Usuario
    $(document).on('click', '#closeIcon-delete', function ()
    {
        $('#windows-delete-user').toggleClass('hide-modal');
    });
//Boton ACEPTAR eliminar usuario
    $(document).on('click', '#delete-user', function (e) {
        e.preventDefault();
        deleteUser();
    });
//Boton CANCELAR eliminar usuario    
    $(document).on('click', '#delete-user-cancel', function ()
    {
        $('#windows-delete-user').toggleClass('hide-modal');
    });
//Previsualizar Imagen en la modal actualizar
    $("#fileUser-update").change(function () {
        readFile(this);
    });
//Mostrar la ventana modal de actualizar Usuario
    $(document).on('click', 'a#update', function (e) {
        //e.preventDefault();
        $('#typeUserId').empty();
        Control.datA = "typeEntId";
        Control.datB = "typeEntDescription";
        Control.datE = "typeUserId";
        Control.value = "s";
        Control.findAllAsyn("type?grp=USUARIO", Control.fillSelect);

        let type = $(this).attr("type-data");
        let id = $(this).attr("id-data");
        let name = $(this).attr("name-data");
        let identityCard = $(this).attr("ci-data");
        let passport = $(this).attr("passport-data");
        let password = $(this).attr("password-data");
        let email = $(this).attr("email-data");
        let photo = $(this).attr("photo-data");
        $('#windows-update-user').removeClass('hide-modal');
        $('input[name="id-data"]').val(id);
        $('input[name="name-data"]').val(name);
        $('input[name="ci-data"]').val(identityCard);
        $('input[name="passport-data"]').val(passport);
        $('input[name="password-data"]').val(password);
        $('input[name="email-data"]').val(email);
        $('input[name="file-name-user"]').val(photo);
        $("#typeUserId option[value='" + type + "']").prop("selected", true);
        $("#image-update").attr('src', image_src);
    });
// Cerrar la Ventana Modal desde el icono
    $(document).on('click', '#closeIcon-update', function ()
    {
        validador_update.resetForm();
        $('#windows-update-user').toggleClass('hide-modal');
        $("#form-update-user")[0].reset();
    });
//Boton CANCELAR modificar usuario 
    $(document).on('click', '#update-user-cancel', function ()
    {
        validador_update.resetForm();
        $('#windows-update-user').toggleClass('hide-modal');
        $("#form-update-user")[0].reset();
    });
//Boton ACEPTAR modificar usuario 
    $(document).on('click', '#update-user', function () {
        validador_update.resetForm();
        updateUser();
    });
// Mostrar ventana modal ingresar usuario    
    $(document).on('click', '#id-add-user', function () {
        $('#typeEntId').empty();
        Control.datA = "typeEntId";
        Control.datB = "typeEntDescription";
        Control.datE = "typeEntId";
        Control.value = "s";
        Control.findAll("type?grp=USUARIO", Control.fillSelect);
        $("#form-add-user")[0].reset();
        $('#windows-add-user').removeClass('hide-modal');
    });
// Cerrar la Ventana Modal desde el icono
    $(document).on('click', '#closeIcon-add', function ()
    {
        validador.resetForm();
        $('#windows-add-user').toggleClass('hide-modal');
    });
// Boton ACEPTAR ingresar usuario
    $(document).on('click', '#add-user', function ()
    {
        addUser();
    });
// Boton CANCELAR ingresar Usuario    
    $(document).on('click', '#add-user-cancel', function ()
    {
        validador.resetForm();
        $('#windows-add-user').toggleClass('hide-modal');

    });
});

