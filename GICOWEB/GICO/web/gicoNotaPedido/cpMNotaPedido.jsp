<!----------------------VISUALIZE-NOTA PEDIDO---------------------------->
<div class="windows-modal hide-modal" id="windows-visualize-document" >
    <div class="wrap-form"> 
        <form id="form-visualize-document" class="form-modal" method="POST">
            <!--titulo-->
            <div class="input-group columTitle">
                <label>DATOS DEL DOCUMENTO</label> 
            </div>
            <div class="input-group columIconClose">
                <i class="fa fa-times-rectangle" id="closeIcon-visualize" ></i>
            </div>

            <!--documentName-->
            <div class="input-group colum100">
                <input class="text-updateUser" type="text" name="documentName-visualizeModal" id="documentName-visualizeModal" required disabled>
                <label class="label active" for="documentName-visualizeModal">NOMBRE DOCUMENTO</label>
            </div>
            <!--documentClient-->
            <div class="input-group colum100">
                <input class="text-updateUser" type="text" id="documentClient-visualizeModal" name="documentClient-visualizeModal"required disabled>
                <label class="label active" for="documentClient-visualizeModal">CLIENTE</label>
            </div> 

            <!--documentCI-->
            <div class="input-group colum50">
                <input type="text"  class="text-updateUser" name="documentCI-visualizeModal" id="documentCI-visualizeModal" disabled>
                <label class="label active" for="documentCI-visualizeModal">CEDULA</label>
            </div>
            
            <!--documentAddress-->
            <div class="input-group colum50">
                <input type="text"  class="text-updateUser" name="documentAddress-visualizeModal" id="documentAddress-visualizeModal" disabled>
                <label class="label active" for="documentAddress-visualizeModal">DIRECCION</label>
            </div>
            

            <!--documentValue-->
            <div class="input-group colum50">
                <input type="number" class="text-updateUser" name="documentValue-visualizeModal" id="documentValue-visualizeModal" required disabled>
                <label class="label active" for="documentValue-visualizeModal">VALOR</label>
            </div>

            
            <!--documentId-->
            <div class="">
                <input  type="hidden" class="text-updateUser" id="documentId-visualizeModal" name="documentId-visualizeModal"  disabled>
            </div>
            <!--documentType-->
            <div class="">
                <input  type="hidden" class="text-updateUser" id="documenttypeid-visualizeModal" name="documenttypeid-visualizeModal" disabled>
            </div>
            <div class="columBtn">
                <div class="main-modal__content__box__column-button" id="button-cancel-visualize" >                                
                    <label class="button-user" id="visualize-document-cancel">ACEPTAR</label>
                </div>
            </div>                      
        </form>
    </div>
</div>