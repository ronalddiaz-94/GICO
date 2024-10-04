/* global evento */

$('#botonlogeo').on('click', function () {
    
    var cedula = $('#useridentif').val();
    var clave = $('#userkey').val();
    
    if (cedula === '') {
        alert('Ingrese su numero de cedula');
    } else {
        if (clave === '') {
            alert('Ingrese su contraseña');
        } else {
            $.ajax({
                data: $('#formu').serialize(),
                url: "controladorUsuario?accion=AutenticarUsuario",
                type: 'POST',
                dataType: 'json'
            })
                    .done(function (response) {
                        
                        //Desdapues de reconoces que tipo de usuario es

                        if (response === "error de conexion")
                        {
                            $('#errormen').html('No se ha podido establecer conexión con la base de datos.');
                            $("#div_carga").css("display", "none");
                        } else
                        {
                            if (response === "Login Incorrecto")
                            {
                                 alert("Usuario no registrado en el sistemao datos incorrectos, vuelva a iniciar sesion");
                                //window.location.href = "hola.html";
                                $('#errormen').html('Datos incorrectos JORGE');
                            }
                            if (response === "Administrador")
                            {
                                alert("aceptado Administrador");
                                window.location.href = "pantalla.jsp";
                            } else if (response === "Decano")
                            {
                                alert("aceptado decano");
                                evento.preventDefault();
                                $("#div_carga").css("display", "inline");
                                window.location.href = "decano/principaldecano.jsp";
                            } else if (response === "Director")
                            {
                                evento.preventDefault();
                                $("#div_carga").css("display", "inline");
                                window.location.href = "director/principaldirector.jsp";
                            } 
                            
                            //Re-link to admin CP Admin
                            else if (response === "ComprasPublicasAdmin")
                            {
                                //evento.preventDefault();
                                alert(response);
                                $("#div_carga").css("display", "inline");                                
                                window.location.href = "FrmCPAdmin.jsp";
                            }
                            
                            //Re-link to user CP User
                            else if (response === "ComprasPublicasUser")
                            {
                                //evento.preventDefault();
                                alert(response);
                                $("#div_carga").css("display", "inline");                                
                                window.location.href = "FrmCPUser.jsp";
                            }
                            
                            else
                            {
                                $('.Mensaje').html('Datos incorrectos2.');
                                $("#div_carga").css("display", "none");
                            }
                        }
                    })
                    .fail(function () {
                        console.log('No existe conexión con la base de datos.');
                    })
                    .complete(function () {
                        console.log('Se completo correctamente')
                                ;
                    });
        }
    }
});


