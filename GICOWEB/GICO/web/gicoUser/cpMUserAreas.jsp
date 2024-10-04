
<!----------------------USERAREA-USER---------------------------->
<div class="windows-modal hide-modal" id="windows-userarea-user" >
    <div class="main-modal" id="main-modal">
        <div class="main-modal__left"></div>
        <div class="main-modal__content">             
            <form id="form-userarea-user" class="" method="POST">
                <div class="main-modal__content__box">
                    <div class="main-modal__content__box__title">
                        <div id="areaName"></div><label>ASIGNACIÓN DE ÁREAS</label>
                        <i class="fa fa-times" id="closeIcon-userarea" ></i>
                        <label class="main-modal__content__box__title__border"></label>
                    </div>

                    <div class="main-user__optionArea">
                        <select class="main-user__optionArea__list" name="select" id="delectArea"></select>
                        <div class="main-user__optionArea__separador"></div>
                        <div class="main-user__optionArea__add" id="id-add-user-area">+ Agregar Area</div>
                    </div>
                    <div class="" >
                        <table id="gblTable_area" class="cell display" cellspacing="0" width="100%" >
                            <thead>
                                <tr>                       
                                    <th>ID</th>
                                    <th>Area</th>
                                    <th>Eliminar</th>
                                </tr>
                            </thead>                                        
                        </table>
                    </div>
                </div>                      
            </form>
        </div>
        <div class="main-modal__right"></div>
    </div>
</div>

<!----------------------DELETE USER AREA---------------------------->

<div class="windows-modal hide-modal" id="windows-delete-user-area" >
    <div class="main-modal" id="main-modal">
        <div class="main-modal__left"></div>
        <div class="main-modal__content">             
            <form id="id-form-delete-user-area" class="" method="POST">
                <div class="main-modal__content__box">
                    <div class="main-modal__content__box__title">
                        <div></div><label>ELIMINAR AREA SELECCIONADA</label>
                        <i class="fa fa-times" id="closeIcon-delete-area" ></i>
                        <label class="main-modal__content__box__title__border"></label>
                    </div>
                    <div class="main-modal__content__box__text-delete">
                        <p>¿Seguro desea eliminar el Usuario <label id="name-user-delete-area"></label> ?</p>
                        <input type="hidden" id="identityCard-user-delete-area"/>
                        <input type="hidden" id="lastname-user-delete-area"/>
                    </div>
                    <div class="main-modal__content__box__column-button" id="button-delete-area">
                        <label class="button-user" id="delete-user-area">ELIMINAR</label>                             
                    </div>
                    <div class="main-modal__content__box__column-button" id="button-cancel-delete-area" >                                
                        <label class="button-user" id="delete-user-cancel-area">CANCELAR</label>
                    </div>
                </div>                      
            </form>
        </div>
        <div class="main-modal__right"></div>
    </div>
</div>

