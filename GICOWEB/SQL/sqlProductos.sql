
    INSERT INTO public.products(
            productid, productname, productdescription, productprice, productiva, 
            productdateexpiration, productcount)
    VALUES (default, 'chuepe','chupe melos' , 30.0, 12, , 49);

    INSERT INTO public.providerproduct(
            productid, providerid)
    VALUES (?, ?);


    UPDATE public.products
   SET productname='Papitas', productdescription='papitas x40', productprice=29, 
       productiva=12, productdateexpiration='12-11-2018', productcount=59
 WHERE productid=2;


 DELETE FROM public.products
 WHERE productid=fproductId;



-----------------------------------FUNCION PARA GESTION USUARIO-------------------------
CREATE OR REPLACE FUNCTION productmanagement(
            band numeric, 
            fproductid integer, 
            fproductname varchar, 
            fproductdescription varchar, 
            fproductprice money, 
            fproductiva numeric, 
            fproductdateexpiration date, 
            fproductcount numeric,
            fproviderid numeric) RETURNS Integer as $$

BEGIN
    case band
    WHEN 1 then
            INSERT INTO public.products(
            productid,productname, productdescription, productprice, productiva, 
            productdateexpiration, productcount)
            VALUES (default,fproductname, fproductdescription, fproductprice, fproductiva, 
            fproductdateexpiration, fproductcount);
            
            INSERT INTO public.providerproduct(
            productid, providerid)
            VALUES ((select max(productid) from public.products) , fproviderid);

            INSERT INTO public.cellarproduct(
            productid, cellarid, productcountcellar)
            VALUES (fproductid, 1, productcount);

	    return 1;

    WHEN 2 then
            UPDATE public.products
            SET productname=fproductname, productdescription=fproductdescription, productprice=fproductprice, 
            productiva=fproductiva, productdateexpiration=fproductdateexpiration, productcount=fproductcount
            WHERE productid=fproductid;
        return 1;

    WHEN 3 then
        DELETE FROM public.providerproduct
        WHERE productid=fproductId and providerid=fproviderid;
        DELETE FROM public.products
        WHERE productid=fproductId;
        return 1;
    end case;
    return 0;
end
$$ language plpgsql;


--DATOS PRUEBA--
SELECT public.productmanagement(3,57,'Chupetes','Chupetesx30',3.0,12,'2019-05-11',35,1);


-- Function: public.productmanagement(numeric, integer, character varying, character varying, numeric, numeric, date, numeric, numeric, numeric, numeric, character varying, numeric, numeric, numeric)

-- DROP FUNCTION public.productmanagement(numeric, integer, character varying, character varying, numeric, numeric, date, numeric, numeric, numeric, numeric, character varying, numeric, numeric, numeric);

CREATE OR REPLACE FUNCTION public.productmanagement(
    band numeric,
    fproductid integer,
    fproductname character varying,
    fproductdescription character varying,
    fproductprice numeric,
    fproductiva numeric,
    fproductdateexpiration date,
    fproductcount numeric,
    fproducttotalvalue numeric,
    fproductutility numeric,
    fproductaverageprice numeric,
    fproductdetail character varying,
    fproductvalue numeric,
    fproductcountprocess numeric,
    fproviderid numeric)
  RETURNS integer AS
$BODY$

BEGIN
    case band
    WHEN 1 then
            INSERT INTO public.products(
            productid,productname, productdescription, productprice, productiva, 
            productdateexpiration, productcount, producttotalvalue, productutility, productaverageprice,productstate)
            VALUES (default,fproductname, fproductdescription, fproductprice, fproductiva, 
            fproductdateexpiration, fproductcount, fproducttotalvalue, fproductutility, fproductaverageprice,1);
            
            INSERT INTO public.providerproduct(
            productid, providerid)
            VALUES ((select max(productid) from public.products) , fproviderid);

            INSERT INTO public.activity(
            activityid,activityproduct, activitydetail, activityvalue, activitycount)
            VALUES (default,fproductname, fproductdetail, fproductvalue, fproductcountprocess);

	    INSERT INTO public.cellarproduct(
            productid, cellarid, productcountcellar)
            VALUES ((select productid from public.products ORDER BY productid DESC LIMIT 1), 1, fproductcount);

        return 1;

    WHEN 2 then
            UPDATE public.products 
            SET productname=fproductname, productdescription=fproductdescription, productprice=fproductprice, 
            productiva=fproductiva, productdateexpiration=fproductdateexpiration, productcount=fproductcount, 
            producttotalvalue=fproducttotalvalue, productutility=fproductutility, productaverageprice=fproductaverageprice
            WHERE productid=fproductid;

            INSERT INTO public.activity(
            activityid,activityproduct, activitydetail, activityvalue, activitycount)
            VALUES (default,fproductname, fproductdetail, fproductvalue, fproductcountprocess);

        return 1;

    WHEN 3 then
            UPDATE public.products 
            SET productname=fproductname, productdescription=fproductdescription, productprice=fproductprice, 
            productiva=fproductiva, productdateexpiration=fproductdateexpiration, productcount=fproductcount, 
            producttotalvalue=fproducttotalvalue, productutility=fproductutility, productaverageprice=fproductaverageprice
            WHERE productid=fproductid;
            
        return 1;

    WHEN 4 then
	DELETE FROM public.cellarproduct
	WHERE productid=fproductid;

        DELETE FROM public.providerproduct
        WHERE productid=fproductid and providerid=fproviderid;
        
        UPDATE public.products 
        SET productstate='0'
        WHERE productid=fproductid;
 
        return 1;
    end case;
    return 0;
end
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION public.productmanagement(numeric, integer, character varying, character varying, numeric, numeric, date, numeric, numeric, numeric, numeric, character varying, numeric, numeric, numeric)
  OWNER TO postgres;
