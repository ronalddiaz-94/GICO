
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
            var $unidad = "Gestion de Notas de Pedido";
            var $tituloheader = "Notas de pedido";
        </script>
        <%@include file="templates/header.jsp"%>
        <%@include file="templates/menu.jsp"%>
        <main class="principalUserCP">
            <div class="imgLogo">
                <div class="contenidoLogo1">
                </div>
                <div class="contenidoLogo">
                    <a href="adminComercio.jsp" class="report">
                        <i class="fa fa-arrow-left fa-2x" aria-hidden="true"></i>
                    </a>
                    <a href="adminPrincipal.jsp" class="report">
                        <i class="fa fa-home fa-2x" aria-hidden="true"></i>
                    </a>
                </div>
            </div>
            <section class="principalUserCP_contenido">
                <%@include file="gicoNotaPedido/cpMNotaPedido.jsp"%><%-- Ventanas modales gestion de productos --%>
                <%@include file="gicoNotaPedido/cpDT.jsp"%><%-- Data table de gestion produtos --%>
            </section>
        </main>
        <%@include file="templates/footer.jsp"%>
        <script src="js/notaPedido.js" type="text/javascript"></script>
        <script src="js/templates.js" type="text/javascript"></script>
        <script src="js/validations.js" type="text/javascript"></script>

    </body>
</html>
