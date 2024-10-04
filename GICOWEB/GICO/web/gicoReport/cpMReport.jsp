
<!----------------------REPORT PRODUCT---------------------------->
<div class="windows-modal hide-modal" id="windows-orderNote-product" >
    <div class="wrap-form" >
        <form id="id-form-orderNote-product" class="form-modal" name="form_orderNote_report" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>AGREGAR A PEDIDO</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-orderNote" ></i>
            </div>

            <!--product count-->
            <div class="input-group colum100">
                <input class="text-updateUser" type="number" id="productNewCount-orderNote" name="productNewCount-orderNote" maxlength="4" required>
                <label class="label">Cantidad</label>
            </div> 
            <input type="hidden" id="productId-orderNoteModal"/>
            <input type="hidden" id="productName-orderNoteModal"/>
            <input type="hidden" id="productDescription-orderNoteModal"/>
            <input type="hidden" id="productPrice-orderNoteModal"/>
            <input type="hidden" id="productIva-orderNoteModal"/>
            <input type="hidden" id="productDateExpiration-orderNoteModal"/>
            <input type="hidden" id="productCount-orderNoteModal"/>
            <input type="hidden" id="productTotalValue-orderNoteModal"/>
            <input type="hidden" id="productUtility-orderNoteModal"/>
            <input type="hidden" id="productAveragePrice-orderNoteModal"/>   
           
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-save-add">
                    <label id="orderNote-product" class="button-user">PEDIR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-add" >                                
                    <label class="button-user" id="orderNote-product-cancel" >CANCELAR</label>
                </div>

            </div>    
        </form>
    </div>
</div>


<!----------------------ADD-provider-Information---------------------------->
<div class="windows-modal hide-modal" id="windows-add-provider" >
    <div class="wrap-form" >
        <form id="form-add-report" class="form-modal" name="form_add_provider" method="POST">
            <div class="input-group columTitle">
                <label>Seleccionar Proveedor</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-add" ></i>
            </div>
            <!--provider report-->
            <div class="input-group colum100">
                <select class="text-addUser" id="providerId-addModal" ></select>
            </div> 
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-save-add">
                    <label id="add-report" class="button-user">ASIGNAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-add" >                                
                    <label class="button-user" id="add-report-cancel" >CANCELAR</label>
                </div>

            </div>                      
        </form>
    </div>
</div>