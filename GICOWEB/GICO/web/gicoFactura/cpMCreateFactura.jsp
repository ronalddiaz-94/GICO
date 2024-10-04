
<!----------------------REPORT PRODUCT---------------------------->
<div class="windows-modal hide-modal" id="windows-orderNote-product" >
    <div class="main-modal" id="main-modal">
        <div class="main-modal__left"></div>
        <div class="main-modal__content">             
            <form id="id-form-orderNote-product" class="" method="POST">
                <div class="main-modal__content__box">
                    <div class="main-modal__content__box__title">
                        <div></div><label>AGREGAR A PEDIDO</label>
                        <i class="fa fa-times" id="closeIcon-orderNote" ></i>
                        <label class="main-modal__content__box__title__border"></label>
                    </div>
                    
                    <!--product count-->
                    <div class="main-modal__content__box__column-add">
                        <label>Cantidad</label><input class="text-updateUser" type="number" id="productNewCount-orderNote" name="productNewCount-orderNote" maxlength="4" placeholder="Cantidad que nos devuelven" required>
                    </div> 
                    
                    <div class="main-modal__content__box__text-delete">
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
                    </div>
                   
                    <div class="main-modal__content__box__column-button" id="button-returnsale">
                        <label class="button-user" id="orderNote-product">PEDIR</label>                             
                    </div>
                    <div class="main-modal__content__box__column-button" id="button-cancel-returnsale">                                 
                        <label class="button-user" id="orderNote-product-cancel">CANCELAR</label>
                    </div>
                </div>                      
            </form>
        </div>
        <div class="main-modal__right"></div>
    </div>
</div>

  
<!----------------------ADD-Client-Information---------------------------->
<div class="windows-modal hide-modal" id="windows-add-client" >
    <div class="main-modal" id="main-modal">
        <div class="main-modal__left"></div>
        <div class="main-modal__content">             
            <form id="form-add-report" class="" method="POST">
                <div class="main-modal__content__box">
                    <div class="main-modal__content__box__title">
                        <div></div><label>Seleccionar Cliente</label>
                        <i class="fa fa-times" id="closeIcon-add" ></i>
                        <label class="main-modal__content__box__title__border"></label>
                    </div>
                    <!--client report-->
                    <div class="main-modal__content__box__column-add">
                        <select class="text-addUser"  name="select" id="clientId-addModal" ></select>
                    </div> 
                    
                    <div class="main-modal__content__box__column-add">
                    </div>
                    
                    <div class="main-modal__content__box__column-button" id="button-save-add">
                        <label id="add-report" class="button-user">ASIGNAR</label>                             
                    </div>
                    <div class="main-modal__content__box__column-button" id="button-cancel-add" >                                
                        <label class="button-user" id="add-report-cancel" >CANCELAR</label>
                    </div>
                    
                </div>                      
            </form>
        </div>
        <div class="main-modal__right"></div>
    </div>
</div>