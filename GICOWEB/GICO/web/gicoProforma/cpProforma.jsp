  
<!----------------------Select client---------------------------->
<div class="windows-modal hide-modal" id="windows-select-client" >
    <div class="wrap-form" >
        <form id="form-select-client" name="form_select_client" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>SELECCIONAR CLIENTE</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-add" ></i>
            </div>
            <!--client proforma-->
            <div class="marginselect colum100" >
                <select class="selectList" name="selectClient-addModal" id="selectClient-addModal" style="width:100%;">></select>
            </div>
            <!--days proforma-->
            <div class="input-group colum100">
                <input class="text-updateUser" type="number" name="daysProforma-addModal" id="daysProforma-addModal" required>
                <label class="label" for="daysProforma-addModal">Días validos para proforma</label>
            </div>          

            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-save-add">
                    <label id="add-client" class="button-user">GUARDAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-add" >                                
                    <label class="button-user" id="add-client-cancel" >CANCELAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>


<!----------------------UPDATE-CLIENT---------------------------->
<div class="windows-modal hide-modal" id="windows-update-client" >
    <div class="wrap-form">             
        <form id="form-update-client" name="form_update_client" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>MODIFICAR CLIENTE</label>
            </div>        
            <div class="input-group columIconClose">
                <i class="fa fa-times" id="closeIcon-update" ></i>
            </div>
            <!--client CI-->
            <div class="input-group colum50">
                <input class="text-updateUser" type="text" name="clientCi-updateModal" id="clientCi-updateModal" maxlength="10" required>
                <label class="label active" for="clientCi-updateModal">Cédula</label>
            </div>
            <!--client Name -->
            <div class="input-group colum50">
                <input class="text-updateUser" type="text" id="clientName-updateModal" name="clientName-updateModal" maxlength="100" required>
                <label class="label active" for="clientName-updateModal">Nombre</label>
            </div> 
            <!--client Phone-->
            <div class="input-group colum50">
                <input type="text" class="text-updateUser" name="clientPhone-updateModal" id="clientPhone-updateModal" required maxlength="10">
                <label class="label active" for="clientPhone-updateModal">Teléfono</label>
            </div>
            <!--client cell-->
            <div class="input-group colum50">
                <input type="text" class="text-updateUser" name="clientCell-updateModal" id="clientCell-updateModal" maxlength="10" >
                <label class="label active" for="clientCell-updateModal">Celular</label>
            </div>
            <!--client mail-->
            <div class="input-group colum50">
                <input type="text" class="text-updateUser" name="clientMail-updateModal" id="clientMail-updateModal" value="" required maxlength="90">
                <label class="label active" for="clientMail-updateModal">Correo electrónico</label>
            </div>
            <!--client credit-->
            <div class="input-group colum50">
                <input type="text" class="text-updateUser" name="clientCredit-updateModal" id="clientCredit-updateModal" required maxlength="10">
                <label class="label active" for="clientCredit-updateModal">Crédito</label>
            </div>
            <!--client address-->
            <div class="input-group colum50">
                <input type="text" class="text-updateUser" name="clientAddress-updateModal" id="clientAddress-updateModal" required maxlength="100">
                <label class="label active" for="clientAddress-updateModal">Dirección</label>
            </div>
            <!--client Id-->
            <input  type="hidden" class="text-updateUser" id="clientId-updateModal" name="clientId-updateModal">
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-save-update">
                    <label class="button-user" id="update-client">GUARDAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-update" >                                
                    <label class="button-user" id="update-client-cancel" >CANCELAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>

<!----------------------DELETE-PROVIDER---------------------------->
<div class="windows-modal hide-modal" id="windows-delete-client" >
    <div class="wrap-form" >
        <form id="id-form-delete-client" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>ELIMINAR INFORMACIÓN</label>
            </div>              
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-delete" ></i>
            </div>
            <div class="main-modal__content__box__text-delete">
                <p>¿Seguro desea eliminar el cliente <label id="name-client-delete"></label> ?</p>
                <input type="hidden" id="clientId-deleteModal"/>
                <input type="hidden" id="clientCi-deleteModal"/>
                <input type="hidden" id="clientName-deleteModal"/>
                <input type="hidden" id="clientPhone-deleteModal"/>
                <input type="hidden" id="clientCell-deleteModal"/>
                <input type="hidden" id="clientMail-deleteModal"/>
                <input type="hidden" id="clientCredit-deleteModal"/>
                <input type="hidden" id="clientAddress-deleteModal"/> 
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-delete">
                    <label class="button-user" id="delete-client">ELIMINAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-delete" >                                
                    <label class="button-user" id="delete-client-cancel">CANCELAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>
