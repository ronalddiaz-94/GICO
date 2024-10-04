
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/styleGICO.css">
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="dataTables/jquery.dataTables.min.css"/>       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>GICO</title>
    </head>
    <body>
        <script >
            var $unidad = "gestion de clientes";
        </script>
        <%@include file="templates/header.jsp"%>
        <%@include file="templates/menu.jsp"%>
        <main class="principalUserCP">
            <div class="imgLogo">
                <div class="contenidoLogo">
                    <h1>Factura</h1>
                </div>
            </div>
            <section class="principalUserCP_contenido"> 
                <%@include file="gicoFactura/cpDT.jsp"%><%-- Ventanas modales gestion de proveedores --%>
                <%@include file="gicoFactura/cpFactura.jsp"%><%-- Data table de gestion proveedores --%>
            </section>
        </main>
        <%@include file="templates/footer.jsp"%>
        <script src="js/factura.js" type="text/javascript"></script>
        <script src="js/templates.js" type="text/javascript"></script>
        <script src="js/validations.js" type="text/javascript"></script>

    </body>
</html>