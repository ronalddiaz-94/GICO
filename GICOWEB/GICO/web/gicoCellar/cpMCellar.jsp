  
<!----------------------ADD-CELLAR---------------------------->
<div class="windows-modal hide-modal" id="windows-add-cellar" >
    <div class="wrap-form" >
        <form id="form-add-cellar" name="form_add_cellar" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>INGRESAR BODEGA</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-add" ></i>
            </div>

            <!--cellar name-->
            <div class="input-group colum50">
                <input class="text-addUser" type="text" value="" id="cellarName-addModal" name="cellarName-addModal" required maxlength="30">
                <label class="label" for="cellarName-addModal">Nombre Bodega</label>
            </div>

            <!--cellar manager-->
            <div class="input-group colum50">
                <input class="text-addUser" type="text" value="" id="cellarManager-addModal" name="cellarManager-addModal" required maxlength="100">
                <label class="label" for="cellarManager-addModal">Responsable Bodega</label>
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-save-add">
                    <label id="add-cellar" class="button-user">GUARDAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-add" >                                
                    <label class="button-user" id="add-cellar-cancel" >CANCELAR</label>
                </div>
            </div>
        </form>
    </div>
</div>
<!----------------------UPDATE-CELLAR---------------------------->
<div class="windows-modal hide-modal" id="windows-update-cellar" >
    <div class="wrap-form">             
        <form id="form-update-cellar" name="form_update_cellar" class="form-modal" method="POST">
            <div class="input-group columTitle">    
                <label>MODIFICAR BODEGA</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-update" ></i>
            </div>

            <!--cellar Name-->
            <div class="input-group colum50">
                <input class="text-updateUser" type="text" name="cellarName-updateModal" id="cellarName-updateModal" maxlength="40" required>
                <label class="label active" for="cellarName-updateModal">Nombre de Bodega</label>
            </div>
            <!--cellar Manager-->
            <div class="input-group colum50">
                <input class="text-updateUser" type="text" id="cellarManager-updateModal" name="cellarManager-updateModal" maxlength="100" required>
                <label class="label active" for="cellarManager-updateModal">Responsable de Bodega</label>
            </div>
            <!--cellar Id-->

            <div class="">
                <input  type="hidden" class="text-updateUser" id="cellarId-updateModal" name="cellarId-updateModal" placeholder="id de bodega"  >
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-save-update">
                    <label class="button-user" id="update-cellar">GUARDAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-update" >                                
                    <label class="button-user" id="update-cellar-cancel" >CANCELAR</label>
                </div>
            </div>
        </form>
    </div>
</div>
<!----------------------DELETE-CELLAR---------------------------->
<div class="windows-modal hide-modal" id="windows-delete-cellar" >
    <div class="wrap-form" >
        <form id="id-form-delete-cellar" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>ELIMINAR INFORMACIÓN</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-delete" ></i>
            </div>

            <div class="main-modal__content__box__text-delete">
                <p>¿Seguro desea eliminar la bodega <label id="name-cellar-delete"></label> ?</p>
                <input type="hidden" id="cellarId-deleteModal"/>
                <input type="hidden" id="cellarName-deleteModal"/>
                <input type="hidden" id="cellarManager-deleteModal"/>                       
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-delete">
                    <label class="button-user" id="delete-cellar">ELIMINAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-delete" >                                
                    <label class="button-user" id="delete-cellar-cancel">CANCELAR</label>
                </div>
            </div>
        </form>
    </div>
</div>

