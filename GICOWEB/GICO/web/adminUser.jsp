<%-- 
    Document   : prueba
    Created on : May 18, 2017, 3:48:22 AM
    Author     : jorge
--%>
<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>

<!DOCTYPE html>
<%
    HttpSession sesionOk = request.getSession();
    String strCedula = (String) sesionOk.getAttribute("Cedula");
    String strNombre = (String) sesionOk.getAttribute("Nombre");
    Integer Area = (Integer) sesionOk.getAttribute("Area");
    String AreaN = (String) sesionOk.getAttribute("Area_nombre");
    Integer tipo = (Integer) sesionOk.getAttribute("Tipo Usuario_id");
    if (strCedula == null) {
        response.sendRedirect("index.html");
    }
%>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <link rel="stylesheet" href="css/styleGICO.css">
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="dataTables/jquery.dataTables.min.css"/>       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GICO</title>
    </head>
    <body>
        <script >
            var $unidad = "Gestión de Usuarios";
            var $tituloheader = "Usuarios";
        </script>
        <%@include file="templates/header.jsp"%>
        <%@include file="templates/menu.jsp"%>
        <main class="principalUserCP">
            <div class="imgLogo">
                <div class="contenidoLogo1">
                </div>
                <div class="contenidoLogo">
                    <a href="adminTeam.jsp" class="report">
                        <i class="fa fa-arrow-left fa-2x" aria-hidden="true"></i>
                    </a>
                    <a href="adminPrincipal.jsp" class="report">
                        <i class="fa fa-home fa-2x" aria-hidden="true"></i>
                    </a>
                </div>
            </div>
            <section class="principalUserCP_contenido">
                <%@include file="gicoUser/gicoTypeUser.jsp"%> <%-- ventana modal para asignacion de tipo de usuario--%>
                <%@include file="gicoUser/cpMUser.jsp"%><%-- Ventanas modales gestion de usuario --%>
                <%@include file="gicoUser/cpDT.jsp"%><%-- Data table de gestion usuarios --%>
            </section>
        </main>
        <%@include file="templates/footer.jsp"%>
        <script src="js/user.js" type="text/javascript"></script>
        <script src="js/templates.js" type="text/javascript"></script>
        <script src="js/validations.js" type="text/javascript"></script>

    </body>
</html>
