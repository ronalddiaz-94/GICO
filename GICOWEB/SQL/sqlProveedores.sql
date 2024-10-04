
    INSERT INTO public.provider(
            providerid, providername, provideraddress, providermail, providerphone, 
            providercell1, providercell2)
    VALUES (default, 'QMV','Ambato' , 'qmv@gmail.com', '0985321458','0321456745' , '7896541230');


    UPDATE public.provider
   SET providername='Papitas', provideraddress='papitas x40', providermail='papitas@gmail.com', 
       providerphone='014785236', providercell1='121111111', providercell2='111111111'
 WHERE providerid=1;


 DELETE FROM public.provider
 WHERE providerid=fproviderid;



-----------------------------------FUNCION PARA GESTION PROVEEDOR-------------------------
CREATE OR REPLACE FUNCTION providermanagement(
            band numeric, 
            fproviderid integer, 
            fprovidername varchar, 
            fprovideraddress varchar, 
            fprovidermail varchar, 
            fproviderphone varchar, 
            fprovidercell1 varchar, 
            fprovidercell2 varchar) RETURNS Integer as $$

BEGIN
    case band
    WHEN 1 then
            INSERT INTO public.provider(
            providerid, providername, provideraddress, providermail, providerphone, 
            providercell1, providercell2)
            VALUES (default, fprovidername, fprovideraddress, fprovidermail, fproviderphone, 
            fprovidercell1, fprovidercell2);

	    return 1;

    WHEN 2 then
            UPDATE public.provider
            SET providername=fprovidername, provideraddress=fprovideraddress, providermail=fprovidermail, 
            providerphone=fproviderphone, providercell1=fprovidercell1, providercell2=fprovidercell2
            WHERE providerid=fproviderid;
        return 1;

    WHEN 3 then
        DELETE FROM public.provider
        WHERE providerid=fproviderid;
        return 1;
    end case;
    return 0;
end
$$ language plpgsql;


--DATOS PRUEBA--
SELECT public.providermanagement(3,1,'Qeewre','sdgdfsgd','sdgdfasafa','sdgdfsgd','2307658','789654125','4521452');
