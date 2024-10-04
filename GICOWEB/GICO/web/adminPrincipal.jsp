<%-- 
    Document   : Principal
    Created on : Mar 1, 2018, 4:15:27 PM
    Author     : jorge
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 3.2 Final//EN">
<%
    HttpSession sesionOk = request.getSession();
    Integer userId = (Integer) sesionOk.getAttribute("userId");
    if (userId == null) {
        response.sendRedirect("login.jsp");
    }
%>
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
    <main>
        <div class="container-reports">
            <div class="columns-unity">
                <div class="container-select">
                    <div id="error_list_per" class="msgerror1"></div>

                </div>
                <div class="container-select">
                    <div id="error_list_ent" class="msgerror1"></div>
                </div>                
            </div>

            <div class="columns-reports"><a href="adminTeam.jsp" name="" class="report val"><i class="fa fa-group i fa-4x" aria-hidden="true"></i><h5 class="text">EQUIPO</h5></a></div>
            <div class="columns-reports"><a href="adminComercio.jsp" name="" class="report val"><i class="fa fa-shopping-cart i fa-4x" aria-hidden="true"></i><h5 class="text">COMERCIO</h5></a></div>
            <div class="columns-reports"><a href="adminReports.jsp" name="" class="report val"><i class="fa fa-file-pdf-o i fa-4x" aria-hidden="true"></i><h5 class="text">REPORTES</h5></a></div>
            <div class="columns-reports"><a id="unity" name="" href="adminCompany.jsp" class="report val"><i class="fa fa-building-o i fa-4x" aria-hidden="true"></i><h5 class="text">EMPRESA</h5></a></div>
        </div>
    </main>
    <%@include file="templates/footer.jsp"%>
    </body>
</html>
