
    INSERT INTO public.expenses(
            expensesid, expensesdescription, expensescost, businessId)
    VALUES (default, 'QMV',250, 1);


    UPDATE public.expenses
   SET expensesdescription='Papitas', expensescost=40, businessId=1
 WHERE expensesid=1;


 DELETE FROM public.expenses
 WHERE expensesid=fexpensesid;



-----------------------------------FUNCION PARA GESTION PROVEEDOR-------------------------
CREATE OR REPLACE FUNCTION expensesmanagement(
            band numeric, 
            fexpensesid integer, 
            fexpensesdescription varchar, 
            fexpensescost double precision, 
            fbusinessId integer) RETURNS Integer as $$

BEGIN
    case band
    WHEN 1 then
            INSERT INTO public.expenses(
            expensesid, expensesdescription, expensescost, businessId)
            VALUES (default, fexpensesdescription, fexpensescost, fbusinessId);
 
	    return 1;

    WHEN 2 then
            UPDATE public.expenses
            SET expensesdescription=fexpensesdescription, expensescost=fexpensescost, businessId=fbusinessId
            WHERE expensesid=fexpensesid;
        return 1;

    WHEN 3 then
        DELETE FROM public.expenses
        WHERE expensesid=fexpensesid;
        return 1;
    end case;
    return 0;
end
$$ language plpgsql;


--DATOS PRUEBA--
SELECT public.expensesmanagement(3,1,'Qeewre',25,1);
