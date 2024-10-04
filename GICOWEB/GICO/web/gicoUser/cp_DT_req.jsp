 <!----------------------ADD-USER---------------------------->
                <div class="windows-modal hide-modal" id="windows-add-user" >
                    <div class="main-modal" id="main-modal">
                        <div class="main-modal__left"></div>
                        <div class="main-modal__content">             
                            <form id="form-add-user" class="" method="POST">
                                <div class="main-modal__content__box">
                                    <div class="main-modal__content__box__title">
                                        <b><label>AGREGAR REQUERIMIENTO</label></b>
                                        <i class="fa fa-times" id="closeIcon-add" ></i>
                                        <label class="main-modal__content__box__title__border"></label>
                                    </div>
                                    <div class="main-modal__content__box__column-add">
                                        <label class="labelUser-add">Tipo Producto</label><br>
                                        <input class="text-addReq" type="text" value="" id="reqtypeproduct-add" name="reqtypeproduct-add" placeholder="Tipo Producto" required maxlength="10">
                                        <input type="hidden" id="type-user" value="3"/>
                                    </div>
                                    <div class="main-modal__content__box__column-add">
                                        <label class="labelUser-add">Sugerido</label><br>
                                        <input class="text-addReq" type="text" value="" id="reqsugerido-add" name="reqsugerido-add" placeholder="Sujerido" required maxlength="100">
                                    </div>                            
                                    <div class="main-modal__content__box__column-add">
                                        <label class="labelUser-add">BID</label><br>
                                        <input  class="text-addReq" id="reqBID-add" placeholder="BID" name="reqBID-add" value="" required="true" maxlength="100">
                                    </div>
                                    <div class="main-modal__content__box__column-add">
                                        <label class="labelUser-add"># Operación</label><br>
                                        <input  class="text-addReq" id="reqNOperacion-add" placeholder="Número de operación" name="reqNOperacion-add" value="" required="true" maxlength="100">
                                    </div>

                                    <div class="main-modal__content__box__column-add">
                                        <label class="labelUser-add">Código de Proyecto</label><br>
                                        <input  class="text-addReq" id="reqcodProyecto-add" placeholder="Código de Proyecto" name="reqcodProyecto-add" value="" required="true" maxlength="20">
                                    </div>
                                    <div class="main-modal__content__box__column-add">
                                        <label class="labelUser-add">Tipo de regimen</label><br>
                                        <input  class="text-addUser" id="reqtipoRegimen-add" placeholder="Tipo de Regimen" name="reqtipoRegimen-add" value="" required="true" maxlength="20">
                                    </div>

                                    <div class="main-modal__content__box__column-button" id="button-save-add">
                                        <label id="add-user" class="button-user">GUARDAR</label>                             
                                    </div>
                                    <div class="main-modal__content__box__column-button" id="button-cancel-add" >                                
                                        <label class="button-user" id="add-user-cancel" >CANCELAR</label>
                                    </div>
                                </div>                      
                            </form>
                        </div>
                        <div class="main-modal__right"></div>
                    </div>
                </div>
                <!----------------------UPDATE-USER---------------------------->
                <div class="windows-modal hide-modal" id="windows-update-user" >
                    <div class="main-modal" id="main-modal">
                        <div class="main-modal__left"></div>
                        <div class="main-modal__content">             
                            <form id="form-update-user" class="" method="POST">
                                <div class="main-modal__content__box">
                                    <div class="main-modal__content__box__title">
                                        <b><label>MODIFICAR USUARIO</label></b>
                                        <a href="#"><i class="fa fa-times" id="closeIcon-update" ></i></a>
                                        <label class="main-modal__content__box__title__border"></label>
                                    </div>
                                    <div class="main-modal__content__box__column-update-fields">

                                        <div class="fields">
                                            <input type="hidden" value="" name="id-data" >
                                            <label class="labelUser-update">Tipo de Porducto</label>
                                            <input class="text-updateUser" type="text" value="" id="typeProduct-req" name="typeProduct-req" maxlength="100" placeholder="Tipo de Producto" required>
                                            <input type="hidden" id="reqid-req-update"/>
                                        </div>                            
                                        <div class="fields">
                                            <label class="labelUser-update">Sugerido</label>
                                            <input  class="text-updateUser" name="suggestedp-req" id="suggestedp-req" placeholder="Sugerido" value="" maxlength="100" required>
                                        </div>
                                        <div class="fields">
                                            <label class="labelUser-update">BID</label>
                                            <input  class="text-updateUser" name="modeybid-req" id="modeybid-req" placeholder="BID" value="" maxlength="100" required>
                                        </div>
                                        <div class="fields">
                                            <label class="labelUser-update">Número de Operación</label>
                                            <input  type="text" class="text-updateUser" id="operationnum-req" name="operationnum-req" placeholder="Número de Operación" value="" maxlength="40" required>
                                        </div>
                                        <div class="fields">
                                            <label class="labelUser-update">Código de Proyecto</label>
                                            <input  class="text-updateUser" name="projectcode-req" id="projectcode-req" placeholder="Código de Proyecto" value="" maxlength="100" required>
                                        </div>
                                        <div class="fields">
                                            <label class="labelUser-update">Tipo de Regimen</label>
                                            <input  class="text-updateUser" name="regimetype-req" id="regimetype-req" placeholder="Celular" value="" maxlength="100" required>
                                        </div>


                                    </div>

                                    <div class="main-modal__content__box__column-button" id="button-save-update">
                                        <label class="button-user" id="update-user">GUARDAR</label>                             
                                    </div>
                                    <div class="main-modal__content__box__column-button" id="button-cancel-update" >                                
                                        <label class="button-user" id="update-user-cancel" >CANCELAR</label>
                                    </div>
                                </div>                      
                            </form>
                        </div>
                        <div class="main-modal__right"></div>
                    </div>
                </div>

                <!----------------------DELETE-USER---------------------------->
                <div class="windows-modal hide-modal" id="windows-delete-user" >
                    <div class="main-modal" id="main-modal">
                        <div class="main-modal__left"></div>
                        <div class="main-modal__content">             
                            <form id="id-form-delete-user" class="" method="POST">
                                <div class="main-modal__content__box">
                                    <div class="main-modal__content__box__title" id="close-delete">                                
                                        <a href="#"><i class="fa fa-times" id="closeIcon-delete"></i></a>                                
                                    </div>
                                    <div class="main-modal__content__box__text-delete">
                                        <p>¿Seguro desea eliminar el Usuario <label id="name-user-delete"></label> ?</p>
                                        <input type="hidden" id="identityCard-user-delete"/>
                                        <input type="hidden" id="lastname-user-delete"/>
                                        <input type="hidden" id="address-user-delete"/>
                                        <input type="hidden" id="email-user-delete"/>
                                        <input type="hidden" id="telcon-user-delete"/>
                                        <input type="hidden" id="telcel-user-delete"/>
                                        <input type="hidden" id="fnac-user-delete"/>
                                        <input type="hidden" id="file-user-delete"/>

                                    </div>
                                    <div class="main-modal__content__box__column-button" id="button-delete">
                                        <label class="button-user" id="delete-user">ELIMINAR</label>                             
                                    </div>
                                    <div class="main-modal__content__box__column-button" id="button-cancel-delete" >                                
                                        <label class="button-user" id="delete-user-cancel">CANCELAR</label>
                                    </div>
                                </div>                      
                            </form>
                        </div>
                        <div class="main-modal__right"></div>
                    </div>
                </div>

                <!----------------------MAIN-USER---------------------------->          
                <div class="main-user">          
                    <%@include file="../templates/date.jsp" %>
                    <div class="main-user__option">
                        <div class="main-user__option__add" id="id-add-user">+ Agregar Requerimiento</div>
                        <div class="main-user__option__search"><i class="fa fa-search"></i></div>
                    </div>
                    <div class="main-user__content table">
                        <table id="gblTable" class="cell display" cellspacing="0" width="100%" >
                            <thead>
                                <tr>                       
                                    <th></th>
                                    <th></th>
                                    <th>#</th>
                                    <th>CPC</th>
                                    <th>T. COMPRA</th>
                                    <th>D. PRODUCTO</th>
                                    <th>C-ANUAL</th>
                                    <th>UNIDAD</th>
                                    <th>C-UNITARIO</th>
                                    <th>C-TOTAL</th>
                                    <th>C-TOTAL IVA</th>
                                    <th>C-1</th>
                                    <th>C-2</th>
                                    <th>C-3</th>
                                    <th>T. PRODUCTO</th>
                                    <th>CATALOGO E.</th>
                                    <th>PRO. SUGERIDO</th>
                                    <th>F. BID</th>
                                    <th>COD. OPERACION</th>
                                    <th>COD. PROYECTO</th>
                                    <th>T. REGIMEN</th>
                                    <th>PRESUPUESTO</th>
                                    <th>DEPENDENCIA</th>
                                    <th>OEI</th>
                                    <th>T. PROYECTO</th>
                                    <th>ACTIVIDAD</th>
                                    <th>DESCRIPCION REQ</th> 
                                    <%--28 DATOS --%>
                                </tr>
                            </thead>                                        
                        </table>
                        <div class="main-modal__content__box__column-button" id="button-enviar-add" >                                
                            <label class="button-user" id="envar-data" >ENVIAR</label>
                        </div>
                    </div>
                    <div id="list"> </div>
                </div>
            </section>
            <section class="informacion"></section>
