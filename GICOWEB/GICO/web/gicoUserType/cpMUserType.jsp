  
<!----------------------ADD-USERTYPE---------------------------->
<div class="windows-modal hide-modal" id="windows-add-usertype" >
    <div class="wrap-form" >
        <form id="form-add-usertype" name="form_add_usertype" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>INGRESAR TIPO DE USUARIO</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-add" ></i>
            </div>
            <!--usertype description-->
            <div class="input-group colum100">
                <input class="text-addUser" type="text" value="" id="usertypeDescription-addModal" name="usertypeDescription-addModal" required maxlength="50">
                <label class="label" for="usertypeDescription-addModal">Descripción</label>
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-save-add">
                    <label id="add-usertype" class="button-user">GUARDAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-add" >                                
                    <label class="button-user" id="add-usertype-cancel" >CANCELAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>
<!----------------------UPDATE-USERTYPE---------------------------->
<div class="windows-modal hide-modal" id="windows-update-usertype" >
    <div class="wrap-form" >
        <form id="form-update-usertype" name="form_update_usertype" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>MODIFICAR TIPO DE USUARIO</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-update" ></i>
            </div>
            <!--usertype Description-->
            <div class="input-group colum100">
                <input class="text-updateUser" type="text" name="usertypeDescription-updateModal" id="usertypeDescription-updateModal" maxlength="100"  required>
                <label class="label active" for="usertypeDescription-addModal">Descripción</label>
            </div>
            <!--usertype Id-->
            <div class="">
                <input  type="hidden" class="text-updateUser" id="usertypeId-updateModal" name="usertypeId-updateModal">
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-save-update">
                    <label class="button-user" id="update-usertype">GUARDAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-update" >                                
                    <label class="button-user" id="update-usertype-cancel" >CANCELAR</label> 
                </div>
            </div>                      
        </form>
    </div>
</div>

<!----------------------DELETE-USERTYPE---------------------------->
<div class="windows-modal hide-modal" id="windows-delete-usertype" >
    <div class="wrap-form" >
        <form id="id-form-delete-usertype" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>ELIMINAR INFORMACIÓN</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-delete" ></i>
            </div> 
            <div class="main-modal__content__box__text-delete">
                <p>¿Seguro desea eliminar el tipo de usuario <label id="name-usertype-delete"></label> ?</p>
                <input type="hidden" id="usertypeId-deleteModal"/>
                <input type="hidden" id="usertypeDescription-deleteModal"/>
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-delete">
                    <label class="button-user" id="delete-usertype">ELIMINAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-delete" >                                
                    <label class="button-user" id="delete-usertype-cancel">CANCELAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>

