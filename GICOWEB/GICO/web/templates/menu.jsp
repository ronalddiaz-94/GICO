<div class="main-body">
    <div class="main-body__nav-toggle" id="main-nav-toggle"></div>
    <div class="main-body__text" id="main-body__text"><p id="textMenu">MENÚ</p></div>
    <div class="main-body__title" id="main-body__title"></div>

    <div class="" id="dinamicMenu"></div>
    <nav class="main-nav" id="main-nav">
        <ul class="main-menu" id="main-menu">
            <a class="" id="icon-close"><i class="fa fa-times main-menu__icon" ></i>CERRAR</a>

            <li class="main-menu__row"><a class="main-menu__link" href="adminPrincipal.jsp">Principal</a></li>                                              

            <li class="main-menu__row"><a class="main-menu__link" href="adminTeam.jsp">Equipo</a>
                <ul>
                    <li ><a class="main-menu__link" href="adminClient.jsp">Clientes</a></li>
                    <li ><a class="main-menu__link" href="adminUser.jsp">Usuarios</a></li>
                    <li ><a class="main-menu__link" href="adminUserType.jsp">Tipo de usuarios</a></li>
                </ul>
            </li>

            <li class="main-menu__row"><a class="main-menu__link" href="adminComercio.jsp">Comercio</a>    
                <ul>
                    <li class=""><a class="main-menu__link" href="adminCellar.jsp">Bodega</a></li>
                    <li class=""><a class="main-menu__link" href="adminInventory.jsp">Inventarios</a></li>
                    <li class=""><a class="main-menu__link" href="adminNotaPedido.jsp">Nota de Pedido</a></li>
                    <li class=""><a class="main-menu__link" href="adminProduc.jsp">Productos</a></li>
                    <li class=""><a class="main-menu__link" href="adminProforma.jsp">Proformas</a></li>
                    <li class=""><a class="main-menu__link" href="adminProvider.jsp">Proveedores</a></li>
                </ul> 
            </li>   

            <li class="main-menu__row"><a class="main-menu__link" href="adminReports.jsp">Reportes</a>
                <ul>
                    <li class=""><a class="main-menu__link" href="adminReporteNotaPedido.jsp">Nota de Pedido</a></li>
                </ul> 
            </li> 
            <li class="main-menu__row"><a class="main-menu__link" href="adminCompany.jsp">Empresa</a>                                            
                <ul>
                    <li class=""><a class="main-menu__link" href="adminBusinnes.jsp">Empresa</a>
                </ul> 
            </li>
        </ul> 

    </nav>
    <script src="js/templates.js"></script>
    <script src="js/ed-grid.js"></script>
    <script>
        edgrid.menu('main-nav', 'main-menu', 'icon-close');
    </script>
</div>


