  
<!----------------------ADD-CLIENT---------------------------->
<div class="windows-modal hide-modal" id="windows-add-client" >
    <div class="wrap-form" >
        <form id="form-add-client" name="form_add_client" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>INGRESAR CLIENTE</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-add" ></i>
            </div>
            <!--client name-->
            <div class="input-group colum100">
                <input class="text-addUser" type="text" value="" id="clientName-addModal" name="clientName-addModal" required maxlength="100">
                <label class="label" for="clientName-addModal">Nombre</label>
            </div>
            <!--client ci-->
            <div class="input-group colum50">
                <input class="text-addUser" type="text" value="" id="clientCi-addModal" name="clientCi-addModal"  required maxlength="10">
                <label class="label" for="clientCi-addModal">Cédula</label>
            </div>
            <!--client phone-->
            <div class="input-group colum50">
                <input  type="text" class="text-addUser" id="clientPhone-addModal"  name="clientPhone-addModal" value="" required="true" maxlength="10">
                <label class="label" for="clientPhone-addModal">Teléfono</label>
            </div>
            <!--client cell-->
            <div class="input-group colum50">
                <input class="text-addUser" type="text" name="clientCell-addModal" id="clientCell-addModal" value=""required maxlength="10">
                <label class="label" for="clientCell-addModal">Celular</label>
            </div>
            <!--client mail-->
            <div class="input-group colum50">
                <input  type="text" class="text-addUser" id="clientMail-addModal" name="clientMail-addModal" required="true" maxlength="90">
                <label class="label" for="clientMail-addModal">Correo electrónico</label>
            </div>
            <!--client credit-->
            <div class="input-group colum50">
                <input  type="number" class="text-addUser" id="clientCredit-addModal" name="clientCredit-addModal" required="true" maxlength="20">
                <label class="label" for="clientCredit-addModal">Crédito</label>
            </div>
            <!--client address-->
            <div class="input-group colum50">
                <input  type="text" class="text-addUser" id="clientAddress-addModal" name="clientAddress-addModal" required="true" maxlength="80">
                <label class="label" for="clientAddress-addModal">Dirección</label>
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
                <i class="fa fa-times-rectangle" id="closeIcon-update" ></i>
            </div>
            <!--client Name -->
            <div class="input-group colum100">
                <input class="text-updateUser" type="text" id="clientName-updateModal" name="clientName-updateModal" maxlength="100" required>
                <label class="label active" for="clientName-updateModal">Nombre</label>
            </div> 
            <!--client CI-->
            <div class="input-group colum50">
                <input class="text-updateUser" type="text" name="clientCi-updateModal" id="clientCi-updateModal" maxlength="10" required>
                <label class="label active" for="clientCi-updateModal">Cédula</label>
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
                <input type="number" class="text-updateUser" name="clientCredit-updateModal" id="clientCredit-updateModal" required maxlength="10">
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
