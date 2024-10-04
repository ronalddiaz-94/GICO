-- Listar invetario general 
-- Informacion mas relevate

SELECT sum(productprice) as productsprice, sum(productcount) as productscount  FROM public.products;


-- Listar inventario 

SELECT * FROM public.cellar as c inner join public.cellarproduct as cp on (c.cellarid=cp.cellarid) inner join public.products as p on (p.productid = cp.productid)




    INSERT INTO public.cellar(
            cellarid, cellarname, cellarmanager)
    VALUES (default, 'principal','Jorge Luis');


    UPDATE public.cellar
   SET cellarname='Principal', cellarmanager='jorgito Luis'
 WHERE cellarid=1;


 DELETE FROM public.cellar
 WHERE cellarid=fcellarid;



-----------------------------------FUNCION PARA GESTION BODEGA-------------------------
CREATE OR REPLACE FUNCTION cellarmanagement(
            band numeric, 
            fcellarid integer, 
            fcellarname varchar, 
            fcellarmanager varchar) RETURNS Integer as $$

BEGIN
    case band
    WHEN 1 then
            INSERT INTO public.cellar(
            cellarid, cellarname, cellarmanager)
            VALUES (default,fcellarname, fcellarmanager);
	    return 1;

    WHEN 2 then
            UPDATE public.cellar
            SET cellarname=fcellarname, cellarmanager=fcellarmanager
            WHERE cellarid=fcellarid;
        return 1;

    WHEN 3 then
        DELETE FROM public.cellar
        WHERE cellarid=fcellarid;
        return 1;
    end case;
    return 0;
end
$$ language plpgsql;


--DATOS PRUEBA--
SELECT public.cellarmanagement(3,1,'Principal','Jorge');
