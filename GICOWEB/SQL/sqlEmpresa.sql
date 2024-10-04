
    INSERT INTO public.business(
            businessid, businessMission, businessView, businessName, businessAddress, businessPhon, businessCell)
    VALUES (default, 'QMV','asasffds', 'sfsdfs','holssssss','qwetyhgfdcvbhgf','123654','45874444');


    UPDATE public.business
   SET businessMission='Papitas', businessView='sdsdfdsf', businessName='qwdqdqwdq', businessAddress='dddddddddd', businessPhon='iiiii', businessCell='4444'
 WHERE businessid=1;





-----------------------------------FUNCION PARA GESTION PROVEEDOR-------------------------
CREATE OR REPLACE FUNCTION businessmanagement(
            band numeric, 
            fbusinessid integer, 
            fbusinessMission varchar, 
            fbusinessView varchar, 
            fbusinessName varchar,
            fbusinessAddress varchar,
            fbusinessPhon varchar,
            fbusinessCell varchar) RETURNS Integer as $$

BEGIN
    case band
    WHEN 1 then
            UPDATE public.business
            SET businessMission=fbusinessMission, businessView=fbusinessView, businessName=fbusinessName, businessAddress=fbusinessAddress, businessPhon=fbusinessPhon, businessCell=fbusinessCell
            WHERE businessid=fbusinessid;
        return 1;
    end case;
    return 0;
end
$$ language plpgsql;


--DATOS PRUEBA--
SELECT public.businessmanagement(1,1,'Qeewre','Qeewre','Qeewre','Qeewre','Qeewre','Qeewre');