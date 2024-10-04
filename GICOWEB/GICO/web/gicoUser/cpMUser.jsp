  
<!----------------------ADD-USER---------------------------->
<div class="windows-modal hide-modal" id="windows-add-user" >
    <div class="wrap-form" >
        <form id="form-add-user" name="form_add_user" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>AGREGAR INFORMACIÓN</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-add" ></i>
            </div>
            
            <!--name-->
            <div class="input-group colum100">
                <input class="text-addUser" type="text" value="" id="userName-addModal" name="userName-addModal"  required maxlength="100">
                <label class="label" for="userName-addModal">Nombre</label>
            </div>  
            <!--user name-->
            <div class="input-group colum100">
                <input  type="text" class="text-addUser" id="userNameUser-addModal" name="userNameUser-addModal" value="" required="true" maxlength="40">
                <label class="label" for="userNameUser-addModal">Nombre de usuario</label>
            </div>
            <!--Identify-->
            <div class="input-group colum50">
                <input class="text-addUser" type="text" value="" id="userCI-addModal" name="userCI-addModal" required maxlength="10">
                <label class="label" for="userCI-addModal">Cédula</label>
            </div>
            <!--user role-->
            <div class="input-group colum50">
                <select class="selectList" name="userRol-addModal" id="userRol-addModal" style="width:100%;"></select>
            </div>
            <div class="input-group colum50">
                <input class="text-addUser" type="password" name="userPass-addModal" id="userPass-addModal" value=""  required maxlength="30">
                <label class="label" for="userPass-addModal">Contraseña</label>
            </div>
            <div class="input-group colum50">
                <input class="text-addUser" type="password" name="userRePass-addModal" id="userRePass-addModal" required maxlength="30">
                <label class="label" for="userRePass-addModal">Repetir Contraseña</label>
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-save-add">
                    <label id="add-user" class="button-user">GUARDAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-add" >                                
                    <label class="button-user" id="add-user-cancel" >CANCELAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>
<!----------------------UPDATE-USER---------------------------->
<div class="windows-modal hide-modal" id="windows-update-user" >
    <div class="wrap-form" >
        <form id="form-update-user"  name="form_update_user" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>MODIFICAR INFORMACIÓN</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-update" ></i>
            </div>
            <!--id user-->
            <div class="input-group colum50">
                <input  type="text" class="text-updateUser" id="userId-updateModal" name="userId-updateModal" placeholder="id de usuario" value="" maxlength="40" disabled>
                <label class="label active" for="userId-updateModal">ID de Usuario</label>
            </div>
            <!--identify-->
            <div class="input-group colum50">
                <input class="text-updateUser" type="text" name="userCI-updateModal" value="" id="userCI-updateModal" maxlength="10" placeholder="Cédula" required>
                <label class="label active" for="userCI-updateModal">Cédula</label>
            </div>
            <!--name-->
            <div class="input-group colum100">
                <input type="hidden" value="" name="id-data" >
                <input class="text-updateUser" type="text" value="" id="userName-updateModal" name="userName-updateModal" maxlength="100" placeholder="Nombre" required>
                <label class="label active" for="userName-updateModal">Nombre</label>
            </div> 
            <!--user name-->
            <div class="input-group colum50">
                <input type="text" class="text-updateUser" name="userNameUser-updateModal" id="userNameUser-updateModal" value="" maxlength="100" required>
                <label class="label active" for="userNameUser-updateModal">Nombre de usuario</label>
            </div>
            <!--user role-->
            <div class="input-group colum50">
                <select class="selectList" name="select" id="userRol-updateModal"></select>
            </div>
            <!--password-->
            <div class="input-group colum100">
                <input type="password" class="text-updateUser" name="userPass-updateModal" id="userPass-updateModal"value="" placeholder="Contraseña" maxlength="30"  required>
                <label class="label active" for="userPass-updateModal">Contraseña</label>
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-save-update">
                    <label class="button-user" id="update-user">GUARDAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-update" >                                
                    <label class="button-user" id="update-user-cancel" >CANCELAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>

<!----------------------DELETE-USER---------------------------->
<div class="windows-modal hide-modal" id="windows-delete-user" >
    <div class="wrap-form" >
        <form id="id-form-delete-user" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>ELIMINAR INFORMACIÓN</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times" id="closeIcon-delete" ></i>
            </div>
            <div class="main-modal__content__box__text-delete">
                <p>¿Seguro desea eliminar el Usuario <label id="name-user-delete"></label> ?</p>
                <input type="hidden" id="userId-deleteModal"/>
                <input type="hidden" id="userPass-deleteModal"/>
                <input type="hidden" id="userName-deleteModal"/>
                <input type="hidden" id="userNameUser-deleteModal"/>
                <input type="hidden" id="userRol-deleteModal"/>
                <input type="hidden" id="userCI-deleteModal"/>
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-delete">
                    <label class="button-user" id="delete-user">ELIMINAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-delete" >                                
                    <label class="button-user" id="delete-user-cancel">CANCELAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>
