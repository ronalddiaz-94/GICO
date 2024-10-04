<%-- 
    Document   : Principal
    Created on : Mar 1, 2018, 4:15:27 PM
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
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
            var $unidad = "Principal";
        </script>
        <%@include file="templates/header.jsp"%>
        <%@include file="templates/menu.jsp"%>
        <div class="container-reports">
            <div class="columns-unity">
                <div class="container-select">
                    <label style="width: 100%;text-align: center;">COMERCIO</label><br><br>
                    <div id="error_list_per" class="msgerror1"></div>

                </div>
                <div class="container-select">
                    <div id="error_list_ent" class="msgerror1"></div>
                </div>                
            </div>

            <div class="columns-reports"><a href="adminCellar.jsp" name="" class="report val"><i class="fa fa-cubes i fa-4x" aria-hidden="true"></i><h5 class="text">BODEGA</h5></a></div>
            <div class="columns-reports"><a href="adminInventory.jsp" name="" class="report val"><i class="fa fa-archive i fa-4x" aria-hidden="true"></i><h5 class="text">INVENTARIOS</h5></a></div>
            <div class="columns-reports"><a href="adminNotaPedido.jsp" name="" class="report val"><i class="fa fa-sticky-note-o i fa-4x" aria-hidden="true"></i><h5 class="text">NOTA DE PEDIDO</h5></a></div>
            <div class="columns-reports"><a href="adminProvider.jsp" name="" class="report val"><i class="fa fa-handshake-o i fa-4x" aria-hidden="true"></i><h5 class="text">PROVEEDORES</h5></a></div> 
            <div class="columns-reports"><a href="adminProduc.jsp"  name="" class="report val"><i class="fa  fa-cart-plus i fa-4x" aria-hidden="true"></i><h5 class="text">PRODUCTOS</h5></a></div>
            <div class="columns-reports"><a id="unity" name="" href="adminFactura.jsp" class="report val"><i class="fa fa-calculator i fa-4x" aria-hidden="true"></i><h5 class="text">FACTURAS</h5></a></div>
            <div class="columns-reports"><a id="unity" name="" href="adminProforma.jsp" class="report val"><i class="fa fa-file-powerpoint-o i fa-4x" aria-hidden="true"></i><h5 class="text">PROFORMA</h5></a></div>
            <div class="columns-reports"><a id="unity" name="" href="adminReports.jsp" class="report val"><i class="fa fa-file-pdf-o i fa-4x" aria-hidden="true"></i><h5 class="text">REPORTES</h5></a></div>
        </div>
    <main>
        
    </main>
    <%@include file="templates/footer.jsp"%>
    </body>
</html>
