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
                    <div id="error_list_per" class="msgerror1"></div>

                </div>
                <div class="container-select">
                    <div id="error_list_ent" class="msgerror1"></div>
                </div>                
            </div>

            <div class="columns-reports"><a href="adminClient.jsp" name="criterio" class="report val"><i class="fa fa-id-badge i fa-4x" aria-hidden="true"></i><h5 class="text">CLIENTES</h5></a></div>
            <div class="columns-reports"><a href="adminUser.jsp" name="subcriterio" class="report val"><i class="fa  fa-user-plus i fa-4x" aria-hidden="true"></i><h5 class="text">USUARIOS</h5></a></div>
            <div class="columns-reports"><a href="adminUserType.jsp" name="indicador" class="report val"><i class="fa  fa-address-card-o i fa-4x" aria-hidden="true"></i><h5 class="text">TIPOS DE USUARIOS</h5></a></div>
        </div>
    <main>
        
    </main>
    <%@include file="templates/footer.jsp"%>
    </body>
</html>
