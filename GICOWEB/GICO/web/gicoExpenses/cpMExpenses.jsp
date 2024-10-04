  
<!----------------------ADD-EXPENSES---------------------------->
<div class="windows-modal hide-modal" id="windows-add-expenses" >
    <div class="wrap-form" >
        <form id="form-add-expenses" name="form_add_expenses" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>INGRESAR GASTO</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-add" ></i>
            </div>
            <!--expenses description-->
            <div class="input-group colum50">
                <input class="text-addUser" type="text" value="" id="expensesDescription-addModal" name="expensesDescription-addModal" required maxlength="100">
                <label class="label" for="expensesDescription-addModal">Descripción</label>
            </div>
            <!--product cost-->
            <div class="input-group colum50">
                <input class="text-addUser" type="text" value="" id="expensesCost-addModal" name="expensesCost-addModal"required maxlength="40">
                <label class="label" for="expensesCost-addModal">Costo</label>
            </div>  
            <!--business id-->
            <div class="">
                <input  type="hidden" class="" id="businessId-addModal" name="businessId-addModal" value="1">
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-save-add">
                    <label id="add-expenses" class="button-user">GUARDAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-add" >                                
                    <label class="button-user" id="add-expenses-cancel" >CANCELAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>
<!----------------------UPDATE-EXPENSES---------------------------->
<div class="windows-modal hide-modal" id="windows-update-expenses" >
    <div class="wrap-form"> 
        <form id="form-expenses-product" name="form_update_expenses" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>MODIFICAR GASTO</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-update" ></i>
            </div>
            <!--expenses Description-->
            <div class="input-group colum50">
                <input class="text-updateUser" type="text" name="expensesDescription-updateModal" id="expensesDescription-updateModal" maxlength="100" required>
                <label class="label active" for="expensesDescription-updateModal">Descripción</label>
            </div>
            <!--expenses cost-->
            <div class="input-group colum50">
                <input class="text-updateUser" type="text" id="expensesCost-updateModal" name="expensesCost-updateModal" maxlength="40"  required>
                <label class="label active" for="expensesCost-updateModal">Descripción</label>
            </div> 
            <!--Business iD-->
            <div class="">
                <input type="hidden" class="text-updateUser" name="businessId-updateModal" id="businessId-updateModal" required>
            </div>
            <!--expenses Id-->
            <div class="">
                <input  type="hidden" class="text-updateUser" id="expensesId-updateModal" name="expensesId-updateModal" placeholder="id de gasto"  disabled>
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-save-update">
                    <label class="button-user" id="update-expenses">GUARDAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-update" >                                
                    <label class="button-user" id="update-expenses-cancel" >CANCELAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>

<!----------------------DELETE-USER---------------------------->
<div class="windows-modal hide-modal" id="windows-delete-expenses" >
    <div class="wrap-form" >
        <form id="id-form-delete-expenses" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>ELIMINAR INFORMACIÓN</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-delete" ></i>
            </div>
            <div class="main-modal__content__box__text-delete">
                <p>¿Seguro desea eliminar el gasto <label id="name-expenses-delete"></label> ?</p>
                <input type="hidden" id="expensesId-deleteModal"/>
                <input type="hidden" id="expensesDescription-deleteModal"/>
                <input type="hidden" id="expensesCost-deleteModal"/>
                <input type="hidden" id="businessId-deleteModal"/>
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-delete">
                    <label class="button-user" id="delete-expenses">ELIMINAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-delete" >                                
                    <label class="button-user" id="delete-expenses-cancel">CANCELAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>
