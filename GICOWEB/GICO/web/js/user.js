
/*------------------------------DATA TABLE USER----------------------------------------*/
/* global resultEmail */

const path_services = "/GICO-AD/webresources";
const path = "/user";
$(document).ready(function () {
    $.ajax({
        url: "/GICO-AD/webresources/usertype/listUserType",
        type: 'GET',
        dataType: 'json',
        dataSrc: '',
        success: function (datas) {
            console.log(datas);
            console.log(datas.length);
            console.log(datas[0].userTypeDescription);
            $(document).ready(function () {
                $("#userRol-updateModal").select2();
            });
            $(document).ready(function () {
                $("#userRol-addModal").select2();
            });
            if (temp === 0) {
                temp++;
                for (var i = 0; i < datas.length; i++) {
                    $("#userRol-updateModal").append(
                            '<option value="' + datas[i].userTypeId + '">' + datas[i].userTypeDescription + '</option>'
                            );
                }
                for (var i = 0; i < datas.length; i++) {
                    $("#userRol-addModal").append(
                            '<option value="' + datas[i].userTypeId + '">' + datas[i].userTypeDescription + '</option>'
                            );
                }

            }
        }
    });
//-----------------------MODAL.-------------------------------
    var formularioAdd = document.form_add_user,
            elementosAdd = formularioAdd.elements,
            formularioUpdate = document.form_update_user,
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
        if (elementosAdd[i].type === "text" || elementosAdd[i].type === "number" || elementosAdd[i].type === "email" || elementosAdd[i].type === "password") {
            elementosAdd[i].addEventListener("focus", focusInput);
            elementosAdd[i].addEventListener("blur", blurInput);
        }
    }
    for (var i = 0; i < elementosUpdate.length; i++) {
        if (elementosUpdate[i].type === "text" || elementosUpdate[i].type === "number" || elementosUpdate[i].type === "email" || elementosUpdate[i].type === "password") {
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
            url: `${path_services}${path}/listUser`, //Traemos informacion del servicio restful
            type: 'GET',
            dataType: 'json',
            dataSrc: ''
        },
        columns: [//carga la informacion en cada columna del datatable
            {data: 'userId'},
            {data: 'userName'},
            {data: 'userPass'},
            {data: 'userNameUser'},
            {data: 'userTypeDescription'},
            {data: iconUpdate},
            {data: iconDelete}
        ]

    });
    /*------------------------------ICONOS DATATABLES----------------------------------------*/
    function iconUserType(data) {
        let datas = '<a id="userType" title="Asignar tipo de usuario" href="#" userTypeId-data="' + data.userCI + '"\n\
     class="icon-table">\n\
         <i class="fa fa-check-square" aria-hidden="true"></i></a>';
        return datas;
    }
    function iconUpdate(data) { // boton actualizar (obtener datos de listado restfull)
        let datas = '<a id="update" title="Modificar" href="#" userCI-data="' + data.userCI + '"userName-data="' + data.userName + '" \n\
         userNameUser-data="' + data.userNameUser + '" \n\
         userTypeDescription-data="' + data.userTypeDescription + '" \n\
         userRol-data="' + data.userRol + '"userId-data="' + data.userId + '"\n\
         userPass-data="' + data.userPass + '" class="icon-table">\n\
         <i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>';
        return datas;
    }
    function iconDelete(data) {
        let datas = '<a id="delete" title="Modificar" href="#" userCI-data="' + data.userCI + '"userName-data="' + data.userName + '" \n\
         userNameUser-data="' + data.userNameUser + '" \n\
         userRol-data="' + data.userRol + '"userId-data="' + data.userId + '"\n\
         userPass-data="' + data.userPass + '" class="icon-table">\n\
         <i class="fa fa-trash" aria-hidden="true" ></i></a></td>';
        return datas;
    }

    /*------------------------------FUNCIONES DE USUARIO----------------------------------------*/

    function deleteUser() {
        let userMType = "3";

        let userId = $('#userId-deleteModal').text();
        let userPass = $('#userPass-deleteModal').text();
        let userName = $('#userName-deleteModal').text();
        let userNameUser = $('#userNameUser-deleteModal').text();
        let userRol = $('#userRol-deleteModal').text();
        let userCI = $('#userCI-deleteModal').text();

        let formData = new FormData();
        formData.append('userMType', userMType);
        formData.append('userId', userId);
        formData.append('userPass', userPass);
        formData.append('userName', userName);
        formData.append('userNameUser', userNameUser);
        formData.append('userRol', userRol);
        formData.append('userCI', userCI);

        $.ajax({
            //url: "/GICO-AD/webresources/user/managementUser",
            url: `${path_services}${path}/managementUser`,
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
        $('#windows-delete-user').toggleClass('hide-modal');
    }

    function updateUser() {
        let userMType = "2"; //erecivimos los datos desde la ventan modal
        let userId = $('input[name="userId-updateModal"]').val();
        let userPass = $('input[name="userPass-updateModal"]').val();
        let userName = $('input[name="userName-updateModal"]').val();
        let userNameUser = $('input[name="userNameUser-updateModal"]').val();
        let userRol = $('#userRol-updateModal').val();
        let userCI = $('input[name="userCI-updateModal"]').val();

        if ((userCI === '') || (userName === '') || (userNameUser === '') || (userPass === '')) {
            alert('Por Favor llene todos los campos');
        } else {
            let cedula = $('#userCI-updateModal').val();
            let resultCedula = validarCedula(cedula);
            if (resultCedula === true) {
                let formData = new FormData();
                formData.append('userMType', userMType);
                formData.append('userId', userId);
                formData.append('userPass', userPass);
                formData.append('userName', userName);
                formData.append('userNameUser', userNameUser);
                formData.append('userRol', userRol);
                formData.append('userCI', userCI);
                $.ajax({
                    //url: "/GICO-AD/webresources/user/managementUser",
                    url: `${path_services}${path}/managementUser`,
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
                $('#windows-update-user').toggleClass('hide-modal');
            }
        }
    }

    function addUser() {
        let userMType = "1";
        let userId = "1";
        let userPass = $('input[name="userPass-addModal"]').val();
        let userRePass = $('input[name="userRePass-addModal"]').val();
        let userName = $('input[name="userName-addModal"]').val();
        let userNameUser = $('input[name="userNameUser-addModal"]').val();
        let userRol = $('#userRol-addModal').val();
        let userCI = $('input[name="userCI-addModal"]').val();


        if ((userPass === userRePass)) {
            if ((userCI === '') || (userName === '') || (userNameUser === '') || (userPass === '')) {
                alert('Por Favor llene todos los campos');
            } else {
                let cedula = $('#userCI-addModal').val();
                let resultCedula = validarCedula(cedula);
                if (resultCedula === true) {
                    let formData = new FormData();
                    formData.append('userMType', userMType);
                    formData.append('userName', userName);
                    formData.append('userCI', userCI);
                    formData.append('userNameUser', userNameUser);
                    formData.append('userPass', userPass);
                    formData.append('userRol', userRol);
                    formData.append('userId', userId);
                    alert(userMType + userName + userCI + userNameUser + userPass + userRol + userId);
                    $.ajax({
                        url: `${path_services}${path}/managementUser`,
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
        } else {
            alert('Contraseña incorrecta');
        }
    }

    /*------------------------------ACCIONES EVENTO CLIC    BOTONES----------------------------------------*/
    $(document).on('click', 'a#delete', function (e) { //Mostrar la ventana modal de eliminar Usuario
        e.preventDefault();
        let userId = $(this).attr("userId-data");
        let userCI = $(this).attr("userCI-data");
        let userName = $(this).attr("userName-data");
        let userNameUser = $(this).attr("userNameUser-data");
        let userPass = $(this).attr("userPass-data");
        let userRol = $(this).attr("userRol-data");

        $('#windows-delete-user').removeClass('hide-modal'); //Desoculta la ventana modal

        $('#userId-deleteModal').text(userId);
        $('#userCI-deleteModal').text(userCI);
        $('#userName-deleteModal').text(userName);
        $('#userNameUser-deleteModal').text(userNameUser);
        $('#userPass-deleteModal').text(userPass);
        $('#userRol-deleteModal').text(userRol);
    });
    $(document).on('click', '#closeIcon-delete', function () {// Cerrar la Ventana Modal de eliminar Usuario
        $('#windows-delete-user').toggleClass('hide-modal');
    });
    $(document).on('click', '#delete-user', function (e) {//Boton ACEPTAR eliminar usuario
        e.preventDefault();
        deleteUser();
    });
    $(document).on('click', '#delete-user-cancel', function () { //Boton CANCELAR eliminar usuario    
        $('#windows-delete-user').toggleClass('hide-modal');
    });
    /*------------------------------UPDATE USER----------------------------------------*/
    var temp = 0;
    $(document).on('click', 'a#update', function (e) {//Mostrar la ventana modal de actualizar Usuario
        e.preventDefault();
        let userId = $(this).attr("userId-data");
        let userCI = $(this).attr("userCI-data");
        let userName = $(this).attr("userName-data");
        let userNameUser = $(this).attr("userNameUser-data");
        let userPass = $(this).attr("userPass-data");
        let userRol = $(this).attr("userRol-data");


        $('#windows-update-user').removeClass('hide-modal'); //Muestra la ventan modal

        $('input[name="userId-updateModal"]').val(userId); //carga los datos en innput de ventana modal
        $('input[name="userCI-updateModal"]').val(userCI);
        $('input[name="userName-updateModal"]').val(userName);
        $('input[name="userNameUser-updateModal"]').val(userNameUser);
        $('input[name="userPass-updateModal"]').val(userPass);
        //$('input[name="userRol-updateModal2"]').val("userTypeDescription");
    });
    $(document).on('click', '#closeIcon-update', function () {// Cerrar la Ventana Modal desde el icono
        $('#windows-update-user').toggleClass('hide-modal');
        $("#form-update-user")[0].reset();
    });
    $(document).on('click', '#update-user-cancel', function () {//Boton CANCELAR modificar usuario 
        $('#windows-update-user').toggleClass('hide-modal');
        $("#form-update-user")[0].reset();
    });
    $(document).on('click', '#update-user', function () {//Boton ACEPTAR modificar usuario 
        updateUser();
    });
    $(document).on('click', '#id-add-user', function () {// Mostrar ventana modal ingresar usuario    
        $("#form-add-user")[0].reset();
        $('#windows-add-user').removeClass('hide-modal');

    });
    $(document).on('click', '#closeIcon-add', function () {// Cerrar la Ventana Modal desde el icono
        $('#windows-add-user').toggleClass('hide-modal');
    });
    $(document).on('click', '#add-user', function () {// Boton ACEPTAR ingresar usuario
        addUser();
    });
    $(document).on('click', '#add-user-cancel', function () {// Boton CANCELAR ingresar Usuario    
        $('#windows-add-user').toggleClass('hide-modal');
    });
//   




//    /*-------------------------------MENU-DINAMICO-----------------------------------------*/
//    $.ajax({
//
//        url: "UserControl?accion=listUserAreaMenu", //LIST USER FOR DATATABLE 
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