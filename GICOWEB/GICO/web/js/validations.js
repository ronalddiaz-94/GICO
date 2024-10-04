//validar cedula
function validarCedula(identityCard)
{
    var ci = true;
    var i;
    var cedula;
    var acumulado;
    cedula = identityCard;
    var instancia;
    acumulado = 0;
    for (i = 1; i <= 9; i++)
    {
        if (i % 2 != 0)
        {
            instancia = cedula.substring(i - 1, i) * 2;
            if (instancia > 9)
                instancia -= 9;
        } else
            instancia = cedula.substring(i - 1, i);
        acumulado += parseInt(instancia);
    }
    while (acumulado > 0)
        acumulado -= 10;
    if (cedula.substring(9, 10) != (acumulado * -1))
    {
        alert("Cedula no valida!!");
        ci = false;
    }
    return ci;
}
//validar e-mail
function validarEmail(email) {
    let result = true;
    expr = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
    if (!expr.test(email))
    {
        result = false;
        alert("Error: La dirección de correo " + email + " es incorrecta.");
    }
    return result;
}
//Validacion General
(function (a) {
    a.fn.field = function (b) {
        a(this).on({keypress: function (a) {
                var c = a.which, d = a.keyCode, e = String.fromCharCode(c).toLowerCase(), f = b;
                (-1 != f.indexOf(e) || 9 == d || 37 != c && 37 == d || 39 == d && 39 != c || 8 == d || 46 == d && 46 != c) && 161 != c || a.preventDefault()
            }})
    }
})(jQuery);
//Función Usuario
$(function () {
    $('#name-user').field(' abcdefghijklmnñopqrstuvwxyzáéiou');
    $('#name-data').field(' abcdefghijklmnñopqrstuvwxyzáéiou');
    $('#ci-user').field('0123456789');
    $('#ci-data').field('0123456789');
    $('#passport-user').field('abcdefghijklmnñopqrstuvwxyzáéiou1234567890-_');
    $('#passport-data').field('abcdefghijklmnñopqrstuvwxyzáéiou1234567890-_');
});
//función Criterio
$(function () {
    $('#height-criterion').field('0123456789,');
    $('#low-criterion').field('0123456789,');
    $('#weight-criterion').field('0123456789,');
    $('#height-criterion-data').field('0123456789,');
    $('#low-criterion-data').field('0123456789,');
    $('#weight-criterion-data').field('0123456789,');
    $('#name-criterion-data').field(' abcdefghijklmnñopqrstuvwxyzáéíóú.');
    $('#name-criterion').field(' abcdefghijklmnñopqrstuvwxyzáéíóú.123456789');
});

