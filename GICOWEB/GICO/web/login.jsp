<%-- 
    Document   : prueba
    Created on : May 18, 2017, 3:48:22 AM
    Author     : jorge
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/styleGICO.css">
        <link rel="stylesheet" href="css/styleLogin.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LOGIN</title>
    </head>
    <body>
        <div class="loginBox">
            <img src="images/user.png" class="user">
            <h2>Ingresar a GICO</h2>
            <form  method="post">
                <p>Usuario</p>
                <input type="text" name="userNameUser" placeholder="ingrese su usuario">
                <p>Contraseña</p>
                <input type="password" name="userPass" placeholder="••••••">
                <input type="button" id="btnSubmit" value="Ingresar">
                <a href="#">¿Olvido su contraseña?</a>
                <div id="mensaje"></div>
            </form>
        </div>
            <%@include file="templates/footer.jsp"%>
        <script src="js/login.js" type="text/javascript"></script>

    </body>
</html>
