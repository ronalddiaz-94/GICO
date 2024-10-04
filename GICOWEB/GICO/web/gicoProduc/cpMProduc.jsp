  
<!----------------------ADD-USER---------------------------->
<div class="windows-modal hide-modal" id="windows-add-product" >
    <div class="wrap-form">
        <form id="form-add-product" name="form_add_product" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>INGRESAR PRODUCTO</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-add" ></i>
            </div>
            <!--nombre de producto-->
            <div class="input-group colum100">
                <input type="text" id="productName-addModal" name="productName-addModal" required maxlength="20">
                <label class="label" for="productName-addModal">Nombre</label>
            </div>
            <!--descripción del producto-->
            <div class="input-group colum100">
                <input class="text-addUser" type="text" id="productDescription-addModal" name="productDescription-addModal" required maxlength="100">
                <label class="label" for="productDescription-addModal">Descripción</label>
            </div>
            <!--product provider -->
            <div class="input-group colum100">
                <select class="selectList"  name="select" id="providerId-addModal" ></select>
                <label class="label active" for="select">Proveedor</label>
            </div>
            <!--precio del producto-->
            <div class="input-group colum50">
                <input  type="number" class="text-addUser" id="productPrice-addModal" name="productPrice-addModal" required="true maxlength="40">
                <label class="label" for="productPrice-addModal">Precio</label>
            </div>
            <!--iva del producto-->
            <div class="input-group colum50">
                <input class="text-addUser" type="number" name="productIva-addModal" id="productIva-addModal" value="12"  required maxlength="30">
                <label class="label active" for="productIva-addModal">IVA</label>
            </div>
            <!--Fecha de caducidad del producto-->
            <div class="input-group colum50">
                <input  type="date" class="text-addUser" id="productDateExpiration-addModal" name="productDateExpiration-addModal" required="true" >
                <label class="label active" for="productDateExpiration-addModal">Fecha de caducidad</label>
            </div>
            <!--cantidad del producto-->
            <div class="input-group colum50">
                <input  type="number" class="text-addUser" id="productCount-addModal" name="productCount-addModal" required="true" >
                <label class="label" for="productCount-addModal">Cantidad</label>
            </div>
            <!--pvp del producto-->
            <div class="input-group colum50">
                <input type="number" class="text-addUser" name="productPVP-addModal" id="productPVP-addModal">
                <label id="lblpvp" class="label" for="productPVP-addModal">PVP</label>
            </div>
            <!--utilidad del producto-->
            <div class="input-group colum50">
                <input type="number" class="text-addUser" name="productUtility-addModal" id="productUtility-addModal">
                <label id="lblutility" class="label" for="productUtility-addModal">% Utilidad</label>
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-save-add">
                    <label id="calcPVP-product" class="button-user">CALCULAR PVP</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-add">                                
                    <label class="button-user" id="calcUtility-product">CALCULAR UTILIDAD %</label>
                </div>
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-save-add">
                    <label id="add-product" class="button-user">GUARDAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-add" >                                
                    <label class="button-user" id="add-product-cancel" >CANCELAR</label>
                </div>
            </div>
        </form>
    </div>
</div>
<!----------------------UPDATE-PRODUCT---------------------------->
<div class="windows-modal hide-modal" id="windows-update-product" >
    <div class="wrap-form">    
        <form id="form-update-product" name="form_update_product" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>MODIFICAR PRODUCTO</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-update" ></i>
            </div>

            <!--product Name-->
            <div class="input-group colum100">
                <input class="text-updateUser" type="text" name="productName-updateModal" id="productName-updateModal" maxlength="40"required>
                <label class="label active" for="productName-updateModal">Nombre</label>
            </div>
            <!--product Description-->
            <div class="input-group colum100">
                <input class="text-updateUser" type="text" id="productDescription-updateModal" name="productDescription-updateModal" maxlength="100" required>
                <label class="label active" for="productDescription-updateModal">Descripción</label>
            </div> 

            <!--product Iva-->
            <div class="input-group colum50">
                <input  type="number" class="text-updateUser" name="productIva-updateModal" id="productIva-updateModal" >
                <label class="label active" for="productIva-updateModal">IVA</label>
            </div>
            <!--product Date Expiration-->
            <div class="input-group colum50">
                <input type="date" class="text-updateUser" name="productDateExpiration-updateModal" id="productDateExpiration-updateModal" required>
                <label class="label active" for="productDateExpiration-updateModal">Fecha de caducidad</label>
            </div>
            <!--Product utility-->
            <div class="input-group colum50">
                <input disabled=”disabled” type="text" class="text-updateUser" name="productUtility-updateModal" id="productUtility-updateModal" required>
                <label class="label active" for="productUtility-updateModal">Utilidad</label>
            </div>
            <!--count product-->
            <div class="input-group colum50">
                <input disabled=”disabled” type="number" class="text-updateUser" name="productCount-updateModal" id="productCount-updateModal" required disabled>
                <label class="label active" for="productCount-updateModal">Cantidad</label>
            </div>
            <!--Product price-->
            <div class="input-group colum50">
                <input disabled=”disabled” type="number" class="text-updateUser" name="productPrice-updateModal" id="productPrice-updateModal" required disabled>
                <label class="label active" for="productPrice-updateModal">Précio</label>
            </div>
            <!--product valor total-->
            <div class="input-group colum50">
                <input disable class="text-updateUser" type="text" id="productTotalValue-updateModal"  disabled name="productTotalValue-updateModal" maxlength="100" required>
                <label class="label active" for="productTotalValue-updateModal">Total</label>
            </div> 

            <!--product Precio Promedio-->
            <div class="input-group colum100">
                <input disabled=”disabled”  type="number" class="text-updateUser" name="productAveragePrice-updateModal" id="productAveragePrice-updateModal" disabled>
                <label class="label active" for="productAveragePrice-updateModal">Promedio</label>
            </div>
            <!--product Id-->
            <div class="">
                <input  type="hidden" class="text-updateUser" id="productId-updateModal" name="productId-updateModal" placeholder="id de producto"  disabled>
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-save-update">
                    <label class="button-user" id="update-product">GUARDAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-update" >                                
                    <label class="button-user" id="update-product-cancel" >CANCELAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>

<!----------------------DELETE-PRODUCT---------------------------->
<div class="windows-modal hide-modal" id="windows-delete-product" >
    <div class="wrap-form" >
        <form id="id-form-delete-product" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>ELIMINAR INFORMACIÓN</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-delete" ></i>
            </div>
            <div class="main-modal__content__box__text-delete">
                <p>¿Seguro desea eliminar el producto <label id="name-product-delete"></label> ?</p>
                <input type="hidden" id="productId-deleteModal"/>
                <input type="hidden" id="productName-deleteModal"/>
                <input type="hidden" id="productDescription-deleteModal"/>
                <input type="hidden" id="productPrice-deleteModal"/>
                <input type="hidden" id="productIva-deleteModal"/>
                <input type="hidden" id="productDateExpiration-deleteModal"/>
                <input type="hidden" id="productCount-deleteModal"/>
                <input type="hidden" id="productTotalValue-deleteModal"/>
                <input type="hidden" id="productUtility-deleteModal"/>
                <input type="hidden" id="productAveragePrice-deleteModal"/>
                <input type="hidden" id="productProviderId-deleteModal"/>
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-delete">
                    <label class="button-user" id="delete-product">ELIMINAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-delete" >                                
                    <label class="button-user" id="delete-product-cancel">CANCELAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>


<!----------------------PURCHASE-PRODUCT---------------------------->
<div class="windows-modal hide-modal" id="windows-purchase-product" >
    <div class="wrap-form" >
        <form id="id-form-purchase-product" name="id_form_purchase_product" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>Agregar Stock del Producto</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-purchase" ></i>
            </div>

            <!--product count-->
            <div class="input-group colum50">
                <input class="text-updateUser" type="number" id="productNewCount-purchaseModal" name="productNewCount-purchaseModal" maxlength="4" required>
                <label class="label" for="productNewCount-purchaseModal">Cantidad de producto que va a ingresar</label>
            </div> 

            <!--product price-->
            <div class="input-group colum50">
                <input  class="text-updateUser" type="number" name="productNewPrice-purchaseModal" id="productNewPrice-purchaseModal" >
                <label class="label" for="productNewPrice-purchaseModal">Precio al que se compro el producto</label>
            </div>

            <div class="main-modal__content__box__text-delete">
                <input type="hidden" id="productId-purchaseModal"/>
                <input type="hidden" id="productName-purchaseModal"/>
                <input type="hidden" id="productDescription-purchaseModal"/>
                <input type="hidden" id="productPrice-purchaseModal"/>
                <input type="hidden" id="productIva-purchaseModal"/>
                <input type="hidden" id="productDateExpiration-purchaseModal"/>
                <input type="hidden" id="productCount-purchaseModal"/>
                <input type="hidden" id="productTotalValue-purchaseModal"/>
                <input type="hidden" id="productUtility-purchaseModal"/>
                <input type="hidden" id="productAveragePrice-purchaseModal"/>
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-purchase">
                    <label class="button-user" id="purchase-product">ACEPTAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-purchase">                                 
                    <label class="button-user" id="purchase-product-cancel">CANCELAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>

<!----------------------DEVOLUCION EN COMPRAS-PRODUCT---------------------------->
<div class="windows-modal hide-modal" id="windows-returnpurchase-product" >
    <div class="wrap-form"> 
        <form id="id-form-returnpurchase-product" name="id_form_returnpurchase_product" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>Devolución en compras del Producto</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-returnpurchase" ></i>
            </div>

            <!--product count-->
            <div class="input-group colum50">
                <input class="text-updateUser" type="number" id="productNewCount-returnpurchaseModal" name="productNewCount-returnpurchaseModal" maxlength="4" required>
                <label class="label" for="productNewCount-returnpurchaseModal">Cantidad a devolver</label>
            </div> 

            <!--product price-->
            <div class="input-group colum50">
                <input  class="text-updateUser" type="number" name="productNewPrice-returnpurchaseModal" id="productNewPrice-returnpurchaseModal">
                <label class="label" for="productNewPrice-returnpurchaseModal">Precio al que se compro el producto</label>
            </div>

            <div class="main-modal__content__box__text-delete">
                <input type="hidden" id="productId-purchaseModal"/>
                <input type="hidden" id="productName-purchaseModal"/>
                <input type="hidden" id="productDescription-purchaseModal"/>
                <input type="hidden" id="productPrice-purchaseModal"/>
                <input type="hidden" id="productIva-purchaseModal"/>
                <input type="hidden" id="productDateExpiration-purchaseModal"/>
                <input type="hidden" id="productCount-purchaseModal"/>
                <input type="hidden" id="productTotalValue-purchaseModal"/>
                <input type="hidden" id="productUtility-purchaseModal"/>
                <input type="hidden" id="productAveragePrice-purchaseModal"/>
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-returnpurchase">
                    <label class="button-user" id="returnpurchase-product">ACEPTAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-returnpurchase">                                 
                    <label class="button-user" id="returnpurchase-product-cancel">CANCELAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>

<!----------------------DEVOLUCION EN VENTAS-PRODUCT---------------------------->
<div class="windows-modal hide-modal" id="windows-returnsale-product" >
    <div class="wrap-form">     
        <form id="id-form-returnsale-product" name="id_form_returnsale_product" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">        
                <label>Devolución en ventas del Producto</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-returnsale" ></i>
            </div>

            <!--product count-->
            <div class="input-group colum100">
                <input class="text-updateUser" type="number" id="productNewCount-returnsale" name="productNewCount-returnsale" maxlength="4" required>
                <label class="label" for="productNewCount-returnsale">Cantidad que nos devuelven</label>
            </div> 

            <div class="main-modal__content__box__text-delete">
                <input type="hidden" id="productId-saleModal"/>
                <input type="hidden" id="productName-saleModal"/>
                <input type="hidden" id="productDescription-saleModal"/>
                <input type="hidden" id="productPrice-saleModal"/>
                <input type="hidden" id="productIva-saleModal"/>
                <input type="hidden" id="productDateExpiration-saleModal"/>
                <input type="hidden" id="productCount-saleModal"/>
                <input type="hidden" id="productTotalValue-saleModal"/>
                <input type="hidden" id="productUtility-saleModal"/>
                <input type="hidden" id="productAveragePrice-saleModal"/>
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-returnsale">
                    <label class="button-user" id="returnsale-product">ACEPTAR</label>                             
                </div>
                <div class="main-modal__content__box__column-button" id="button-cancel-returnsale">                                 
                    <label class="button-user" id="returnsale-product-cancel">CANCELAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>


<!----------------------VISUALIZE-PRODUCT---------------------------->
<div class="windows-modal hide-modal" id="windows-visualize-product" >
    <div class="wrap-form"> 
        <form id="form-visualize-product" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>DATOS DEL PRODUCTO</label>
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-visualize" ></i>
            </div>

            <!--product Name-->
            <div class="input-group colum100">
                <input class="text-updateUser" type="text" name="productName-visualizeModal" id="productName-visualizeModal" maxlength="40" required disabled>
                <label class="label active" for="productName-visualizeModal">Nombre</label>
            </div>
            <!--product Description-->
            <div class="input-group colum100">
                <input class="text-updateUser" type="text" id="productDescription-visualizeModal" name="productDescription-visualizeModal" maxlength="100" required disabled>
                <label class="label active" for="productDescription-visualizeModal">Descripción</label>
            </div> 

            <!--product Iva-->
            <div class="input-group colum50">
                <input type="number"  class="text-updateUser" name="productIva-visualizeModal" id="productIva-visualizeModal" disabled>
                <label class="label active" for="productIva-visualizeModal">IVA</label>
            </div>
            <!--product Date Expiration-->
            <div class="input-group colum50">
                <input type="date" class="text-updateUser" name="productDateExpiration-visualizeModal" id="productDateExpiration-visualizeModal"value="" required disabled>
                <label class="label active" for="productDateExpiration-visualizeModal">Fecha de caducidad</label>
            </div>
            <!--Product utility-->
            <div class="input-group colum50">
                <input type="text" class="text-updateUser" name="productUtility-visualizeModal" id="productUtility-visualizeModal" required disabled>
                <label class="label active" for="productUtility-visualizeModal">Fecha de Utilidad</label>
            </div>
            <!--count product-->
            <div class="input-group colum50">
                <input type="number" class="text-updateUser" name="productCount-visualizeModal" id="productCount-visualizeModal" required disabled>
                <label class="label active" for="productCount-visualizeModal">Cantidad</label>
            </div>
            <!--Product price-->
            <div class="input-group colum50">
                <input type="number" class="text-updateUser" name="productPrice-visualizeModal" id="productPrice-visualizeModal" placeholder="Precio" required disabled>
                <label class="label active" for="productPrice-visualizeModal">Precio</label>
            </div>
            <!--product valor total-->
            <div class="input-group colum50">
                <input class="text-updateUser" type="text" id="productTotalValue-visualizeModal"  disabled name="productTotalValue-visualizeModal" maxlength="100" placeholder="Valor total en producto" required>
                <label class="label active" for="productTotalValue-visualizeModal">Total</label>
            </div> 

            <!--product Precio Promedio-->
            <div class="input-group colum100">
                <input type="number" class="text-updateUser" name="productAveragePrice-visualizeModal" id="productAveragePrice-visualizeModal" placeholder="Precio Promedio" disabled>
                <label class="label active" for="productAveragePrice-visualizeModal">Promedio</label>
            </div>
            <!--product Id-->
            <div class="">
                <input  type="hidden" class="text-updateUser" id="productId-visualizeModal" name="productId-visualizeModal" placeholder="id de producto"  disabled>
            </div>
            <div class="columBtn">
                <div class="btnlateral" id="" >                                
                </div>
                <div class="" id="" >                                
                    <label class="button-user" id="visualize-product-cancel">ACEPTAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>
