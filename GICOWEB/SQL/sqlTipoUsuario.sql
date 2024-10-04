
    INSERT INTO public.usertype(
            usertypeid, usertypedescription)
    VALUES (default, 'QMV');


    UPDATE public.usertype
   SET usertypedescription='Papitas'
 WHERE usertypeid=1;


 DELETE FROM public.usertype
 WHERE usertypeid=fusertypeid;



-----------------------------------FUNCION PARA GESTION PROVEEDOR-------------------------
CREATE OR REPLACE FUNCTION usertypemanagement(
            band numeric, 
            fusertypedescription varchar,
            fusertypeid integer) RETURNS Integer as $$

BEGIN
    case band
    WHEN 1 then
            INSERT INTO public.usertype(
            usertypeid, usertypedescription)
            VALUES (default, fusertypedescription); 

	    return 1;

    WHEN 2 then
            UPDATE public.usertype
            SET usertypedescription=fusertypedescription
            WHERE usertypeid=fusertypeid;
        return 1;

    WHEN 3 then
        DELETE FROM public.usertype
        WHERE usertypeid=fusertypeid;
        return 1;
    end case;
    return 0;
end
$$ language plpgsql;


--DATOS PRUEBA--
SELECT public.clientmanagement(3,1,'QMV','Ambato' , 'qmv@gma', '0985321458','0321456745' , 8,'sdfsdfsf');
