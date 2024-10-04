  
<!----------------------ADD-PROVIDER---------------------------->
<div class="windows-modal hide-modal" id="windows-add-provider" >
    <div class="wrap-form" >
        <form id="form-add-provider" name="form_add_provider" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>INGRESAR PROVEEDOR</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-add" ></i>
            </div>
            <!--provider name-->
            <div class="input-group colum100">
                <input class="text-addUser" type="text" value="" id="providerName-addModal" name="providerName-addModal" required maxlength="20">
                <label class="label" for="providerName-addModal">Nombre</label>
            </div>
            <!--provider address-->
            <div class="input-group colum100">
                <input class="text-addUser" type="text" value="" id="providerAddress-addModal" name="providerAddress-addModal" required maxlength="100">
                <label class="label" for="providerAddress-addModal">Dirección</label>
            </div>  
            <!--provider mail-->
            <div class="input-group colum50">
                <input  type="text" class="text-addUser" id="providerMail-addModal" name="providerMail-addModal" value="" required="true" maxlength="50">
                <label class="label" for="providerMail-addModal">Correo electrónico</label>
            </div>
            <!--provider phone-->
            <div class="input-group colum50">
                <input class="text-addUser" type="text" name="providerPhone-addModal" id="providerPhone-addModal" value="" required maxlength="10">
                <label class="label" for="providerPhone-addModal">Teléfono</label>
            </div>
            <!--provider Cell 1-->
            <div class="input-group colum50">
                <input  type="text" class="text-addUser" id="providerCell1-addModal" name="providerCell1-addModal" required="true" maxlength="10">
                <label class="label" for="providerCell1-addModal">Celular 1</label>
            </div>
            <!--provider Cell 2-->
            <div class="input-group colum50">
                <input  type="text" class="text-addUser" id="providerCell2-addModal" name="providerCell2-addModal"required="true" maxlength="10">
                <label class="label" for="providerCell2-addModal">Celular 2</label>
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-save-add">
                    <label id="add-provider" class="button-user">GUARDAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-add" >                                
                    <label class="button-user" id="add-provider-cancel" >CANCELAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>
<!----------------------UPDATE-PROVIDER---------------------------->
<div class="windows-modal hide-modal" id="windows-update-provider" >
    <div class="wrap-form" >
        <form id="form-update-provider" name="form_update_provider" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>MODIFICAR PROVEEDOR</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-update" ></i>
            </div>

            <!--provider Name-->
            <div class="input-group colum100">
                <input class="text-updateUser" type="text" name="providerName-updateModal" id="providerName-updateModal" maxlength="40" required>
                <label class="label active" for="providerName-updateModal">Nombre</label>
            </div>
            <!--provider Address-->
            <div class="input-group colum100">
                <input class="text-updateUser" type="text" id="providerAddress-updateModal" name="providerAddress-updateModal" maxlength="100" required>
                <label class="label active" for="providerAddress-updateModal">Dirección</label>
            </div> 
            <!--provider Mail-->
            <div class="input-group colum50">
                <input type="text" class="text-updateUser" name="providerMail-updateModal" id="providerMail-updateModal" required>
                <label class="label active" for="providerMail-updateModal">Correo electrónico</label>
            </div>
            <!--provider Phone-->
            <div class="input-group colum50">
                <input type="text" class="text-updateUser" name="providerPhone-updateModal" id="providerPhone-updateModal" maxlength="10" >
                <label class="label active" for="providerPhone-updateModal">Teléfono</label>
            </div>
            <!--provider Cell 1-->
            <div class="input-group colum50">
                <input type="text" class="text-updateUser" name="providerCell1-updateModal" id="providerCell1-updateModal" value="" required maxlength="10">
                <label class="label active" for="providerCell1-updateModal">Celular 1</label>
            </div>
            <!--provider Cell 2-->
            <div class="input-group colum50">
                <input type="text" class="text-updateUser" name="providerCell2-updateModal" id="providerCell2-updateModal" required maxlength="10">
                <label class="label active" for="providerCell2-updateModal">Celular 2</label>
            </div>
            <!--provider Id-->
            <div class="">
                <input  type="hidden" class="text-updateUser" id="providerId-updateModal" name="providerId-updateModal">
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-save-update">
                    <label class="button-user" id="update-provider">GUARDAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-update" >                                
                    <label class="button-user" id="update-provider-cancel" >CANCELAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>

<!----------------------DELETE-PROVIDER---------------------------->
<div class="windows-modal hide-modal" id="windows-delete-provider" >
    <div class="wrap-form" >
        <form id="id-form-delete-provider" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>ELIMINAR INFORMACIÓN</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-delete" ></i>
            </div>
            <div class="main-modal__content__box__text-delete">
                <p>¿Seguro desea eliminar el proveedor <label id="name-provider-delete"></label> ?</p>
                <input type="hidden" id="providerId-deleteModal"/>
                <input type="hidden" id="providerName-deleteModal"/>
                <input type="hidden" id="providerAddress-deleteModal"/>
                <input type="hidden" id="providerMail-deleteModal"/>
                <input type="hidden" id="providerPhone-deleteModal"/>
                <input type="hidden" id="providerCell1-deleteModal"/>
                <input type="hidden" id="providerCell2-deleteModal"/>
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-delete">
                    <label class="button-user" id="delete-provider">ELIMINAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-delete" >                                
                    <label class="button-user" id="delete-provider-cancel">CANCELAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>
