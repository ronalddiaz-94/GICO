

-----------------------------------FUNCION PARA GESTION PROVEEDOR-------------------------
CREATE OR REPLACE FUNCTION usermanagement(
            band numeric, 
            fusername varchar, 
            fuserci varchar,
            fusernameuser varchar, 
            fuserpass varchar, 
            fuserrol varchar, 
            fuserid integer
            ) RETURNS Integer as $$

BEGIN
    case band
    WHEN 1 then
          INSERT INTO public.users(
            userid, userpass, username, usernameuser, userrol, userci)
          VALUES (fuserid, fuserpass, fusername, fusernameuser, fuserrol, fuserci);

	    return 1;

    WHEN 2 then
           UPDATE public.users
   SET userpass=fuserpass, username=fusername, usernameuser=fusernameuser, userrol=fuserrol, 
       userci=fuserci
 WHERE userid=fuserid;
        return 1;

    WHEN 3 then
        DELETE FROM public.users
        WHERE userid=fuserid;

        return 1;
    end case;
    return 0;
end
$$ language plpgsql;


--DATOS PRUEBA--
SELECT public.clientmanagement(3,1,'QMV','Ambato' , 'qmv@gma', '0985321458','0321456745' , 8,'sdfsdfsf');
