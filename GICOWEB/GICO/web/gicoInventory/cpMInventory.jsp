  
<!----------------------UPDATE-CELLAR---------------------------->
<div class="windows-modal hide-modal" id="windows-update-cellar" >
    <div class="wrap-form">       
        <form id="form-update-inventory" name="form_update_inventory" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>MODIFICAR BODEGA</label>
            </div>
            <div class="input-group columIconClose">|
                <i class="fa fa-times-rectangle" id="closeIcon-update" ></i>
            </div>
            <!--cellar Id-->
            <div class="">
                <input  type="hidden" class="text-updateUser" id="cellarId-updateModal" name="cellarId-updateModal" placeholder="id de bodega"  >
            </div>
            <!--cellar Name-->
            <div class="input-group colum50">
                <input class="text-updateUser" type="text" name="cellarName-updateModal" id="cellarName-updateModal" maxlength="40" required>
                <label class="label active" for="cellarName-updateModal">Nombre</label>     
            </div>
            <!--cellar Manager-->
            <div class="input-group colum50">
                <input class="text-updateUser" type="text" id="cellarManager-updateModal" name="cellarManager-updateModal" maxlength="100" required>
                <label class="label active" for="cellarManager-updateModal">Responsable</label>     
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
        <form id="id-form-delete-cellar" class="" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>ELIMINAR INFORMACIÓN</label>
            </div>
            <div class="input-group columIconClose">   
                <i class="fa fa-times" id="closeIcon-delete" ></i>
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
                <div class="btnlateral">
                </div>
                <div class="">
                    <label class="button-user" id="visualize-product-cancel">ACEPTAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>
