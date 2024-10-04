
/*------------------------------DATA TABLE USER----------------------------------------*/
/* global resultEmail */

$(document).ready(function () {
    var cont = 0;
    $("#btnSubmit").click(function () {

        let userNameUser = $('input[name="userNameUser"]').val();
        let userPass = $('input[name="userPass"]').val();

        let formData = new FormData();
        formData.append('userPass', userPass);
        formData.append('userNameUser', userNameUser);

        $.ajax({
            url: "/GICO-AD/webresources/restAutentication/listUserAutentication",
            type: 'POST',
            data: formData,
            cache: false,
            contentType: false,
            processData: false,
            success: function (data) {

                alert(data.message);
                if (data.message === 'Exito') {
                    location.href = "adminPrincipal.jsp";
                    alert(data.userId);
                    var ul = '<input type="hidden" id="userId-login"/>';
                    $('input[name="userId-login"]').val(data.userId);
                    document.getElementById("log").innerHTML += ul;
                    
                   
                } else {
                    cont++;
                    var ul = '<p style="color:red">';
                    ul += 'Usuario o contraseña incorrectos</p>';
                    document.getElementById("mensaje").innerHTML += ul;
                    if (cont === 2) {
                        location.reload();
                        cont = 0;
                    }

                }
//                        table.ajax.reload();
            },
            error: function (jqxhr, status, errorMsg) {
                console.log(status + "Usuario: " + errorMsg);
            }});
    });
});