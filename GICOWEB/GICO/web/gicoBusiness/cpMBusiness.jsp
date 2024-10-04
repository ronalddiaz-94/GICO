
<!----------------------UPDATE-BUSINESS---------------------------->
<div class="windows-modal hide-modal" id="windows-update-business" >
    <div class="wrap-form" >
        <form id="form-update-business" name="form_update_business" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>MODIFICAR DATOS DE LA EMPRESA</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-update" ></i>
            </div>

            <!--business Mision-->
            <div class="input-group colum100">
                <input class="text-updateUser" type="text" name="businessMission-updateModal" id="businessMission-updateModal" maxlength="300" equired>
                <label class="label active" for="businessMission-updateModal">Misión</label>
            </div>
            <!--business View-->
            <div class="input-group colum100">
                <input class="text-updateUser" type="text" id="businessView-updateModal" name="businessView-updateModal" maxlength="300" required>
                <label class="label active" for="businessView-updateModal">Visión</label>
            </div> 
            <!--business Name-->
            <div class="input-group colum100">
                <input class="text-updateUser" type="text" id="businessName-updateModal" name="businessName-updateModal" maxlength="60" required>
                <label class="label active" for="businessName-updateModal">Nombre de la Empresa</label>
            </div> 
            <!--business Address-->
            <div class="input-group colum100">
                <input class="text-updateUser" type="text" id="businessAddress-updateModal" name="businessAddress-updateModal" maxlength="100" required>
                <label class="label active" for="businessAddress-updateModal">Dirección</label>
            </div> 
            <!--business Phone-->
            <div class="input-group colum100">
                <input class="text-updateUser" type="text" id="businessPhon-updateModal" name="businessPhon-updateModal" maxlength="15"  required>
                <label class="label active" for="businessPhon-updateModal">Teléfono</label>
            </div> 
            <!--business Cell-->
            <div class="input-group colum100">
                <input class="text-updateUser" type="text" id="businessCell-updateModal" name="businessCell-updateModal" maxlength="10" required>
                <label class="label active" for="businessCell-updateModal">Celular</label>
            </div> 
            <!--business Id-->
            <div class="">
                <input  type="hidden" class="text-updateUser" id="businessId-updateModal" name="businessId-updateModal" required>
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-save-update">
                    <label class="button-user" id="update-business">GUARDAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-update" >                                
                    <label class="button-user" id="update-business-cancel" >CANCELAR</label>
                </div>
            </div>
        </form>
    </div>
</div>



