
    INSERT INTO public.client(
            clientid, clientci, clientname, clientphone, clientcell, 
            clientmail, clientcredit, clientaddress)
    VALUES (default, 'QMV','Ambato' , 'qmv@gma', '0985321458','0321456745' , 8,'sdfsdfsf');


    UPDATE public.client
   SET clientci='Papitas',clientname='Papitas', clientphone='papitasx40', clientcell='as@gmail.com', 
       clientmail='014785236', clientcredit=12, clientaddress='111111111'
 WHERE clientid=1;


 DELETE FROM public.client
 WHERE clientid=fclientid;



-----------------------------------FUNCION PARA GESTION PROVEEDOR-------------------------
CREATE OR REPLACE FUNCTION clientmanagement(
            band numeric, 
            fclientid integer, 
            fclientci varchar, 
            fclientname varchar, 
            fclientphone varchar, 
            fclientcell varchar, 
            fclientmail varchar, 
            fclientcredit double precision,
            fclientaddress varchar) RETURNS Integer as $$

BEGIN
    case band
    WHEN 1 then
            INSERT INTO public.client(
            clientid, clientci, clientname, clientphone, clientcell, 
            clientmail, clientcredit, clientaddress)
            VALUES (default, fclientci, fclientname, fclientphone, fclientcell, 
            fclientmail, fclientcredit,fclientaddress); 

	    return 1;

    WHEN 2 then
            UPDATE public.client
            SET clientci=fclientci,clientname=fclientname, clientphone=fclientphone, clientcell=fclientcell, 
       clientmail=fclientmail, clientcredit=fclientcredit, clientaddress=fclientaddress
            WHERE clientid=fclientid;
        return 1;

    WHEN 3 then
        DELETE FROM public.client
        WHERE clientid=fclientid;
        return 1;
    end case;
    return 0;
end
$$ language plpgsql;


--DATOS PRUEBA--
SELECT public.clientmanagement(3,1,'QMV','Ambato' , 'qmv@gma', '0985321458','0321456745' , 8,'sdfsdfsf');
