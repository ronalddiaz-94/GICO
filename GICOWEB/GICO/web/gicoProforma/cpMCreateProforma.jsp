
<!----------------------ADD PRODUCT---------------------------->
<div class="windows-modal hide-modal" id="windows-proforma" >
    <div class="wrap-form" >
        <form id="id-form-proforma" name="id_form_orderProforma" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">        
                <label>AGREGAR A PEDIDO</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-orderProforma" ></i>
            </div>

            <!--product count-->
            <div class="input-group colum100">
                <input class="text-updateUser" type="number" id="productNewCount-orderProforma" name="productNewCount-orderProforma" required>
                <label class="label" for="productNewCount-orderProforma">Cantidad</label>
            </div> 

            <input type="hidden" id="productId-orderProformaModal"/>
            <input type="hidden" id="productName-orderProformaModal"/>
            <input type="hidden" id="productDescription-orderProformaModal"/>
            <input type="hidden" id="productPrice-orderProformaModal"/>
            <input type="hidden" id="productIva-orderProformaModal"/>
            <input type="hidden" id="productDateExpiration-orderProformaModal"/>
            <input type="hidden" id="productCount-orderProformaModal"/>
            <input type="hidden" id="productTotalValue-orderProformaModal"/>
            <input type="hidden" id="productUtility-orderProformaModal"/>
            <input type="hidden" id="productAveragePrice-orderProformaModal"/>   
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-returnsale">
                    <label class="button-user" id="orderProforma-product">PEDIR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-returnsale">                                 
                    <label class="button-user" id="orderProforma-product-cancel">CANCELAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>


<!---------------------Update Select client---------------------------->
<div class="windows-modal hide-modal" id="windows-update-select-client" >
    <div class="wrap-form" >
        <form id="form-update-select-client" name="form_update_select_client" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>MODIFICAR PROFORMA</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-updateProforma" ></i>
            </div>
            <!--days proforma-->
            <div class="input-group colum100">
                <input class="text-updateUser" type="number" name="daysProforma-updateModal" id="daysProforma-updateModal" required>
                <label class="label active" for="daysProforma-updateModal">Días validos para proforma</label>
            </div>          

            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-save-add">
                    <label id="update-client" class="button-user">GUARDAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-add" >                                
                    <label class="button-user" id="update-client-cancel" >CANCELAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>
