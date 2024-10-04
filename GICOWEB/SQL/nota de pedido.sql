-- nota de pedido
CREATE TABLE public.notapedido
(
  npedidoid integer NOT NULL DEFAULT nextval('products_productid_seq'::regclass),
  providerid integer NOT NULL,
  npedidototal numeric,
  proformadate date,
  CONSTRAINT npedido_pkey PRIMARY KEY (npedidoid),
  CONSTRAINT fk_provider FOREIGN KEY (providerid)
      REFERENCES public.provider (providerid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
 )

CREATE TABLE public.notapedidoproduct
(
  productid integer NOT NULL,
  npedidoid integer NOT NULL,
  CONSTRAINT npedidoproduct_pkey PRIMARY KEY (productid, npedidoid),
  CONSTRAINT fk_npedidoidproduct FOREIGN KEY (productid)
      REFERENCES public.products (productid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_npedido FOREIGN KEY (npedidoid)
      REFERENCES public.notapedido (npedidoid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

-- FUNCION PARA INGRESAR PRODUCTOS DE PROFORMA

CREATE OR REPLACE FUNCTION public.proformaproductmanagement(
    band numeric,
    fproformaproductid integer,
    fproformaproductname character varying,
    fproformaproductdescription character varying,
    fproformaproductprice numeric,
    fproformaproductiva numeric,
    fproformaproductdateexpiration date,
    fproformaproductcount numeric,
    fproformaproducttotalvalue numeric,
    fproformaproductutility numeric,
    fproformaproductaverageprice numeric) RETURNS Integer as $$

BEGIN
   case band
    WHEN 1 then
          INSERT INTO public.proformaproduct(
            proformaproductid, proformaproductname, proformaproductdescription, 
            proformaproductprice, proformaproductiva, proformaproductdateexpiration, 
            proformaproductcount, proformaproducttotalvalue, proformaproductutility, 
            proformaproductaverageprice)
          VALUES (default, fproformaproductname, fproformaproductdescription, 
            fproformaproductprice, fproformaproductiva, fproformaproductdateexpiration, 
            fproformaproductcount, fproformaproducttotalvalue, fproformaproductutility, 
            fproformaproductaverageprice);

            INSERT INTO public.productproforma(
            proformaproductid, proformaid)
            VALUES ((SELECT proformaproductid FROM public.proformaproduct ORDER BY proformaproductid DESC LIMIT 1), (SELECT proformaid FROM public.proforma ORDER BY proformaid DESC LIMIT 1));
        return 1;

    WHEN 2 then
            UPDATE public.proformaproduct
            SET proformaproductname=fproformaproductname, proformaproductdescription=fproformaproductdescription, 
                proformaproductprice=fproformaproductprice, proformaproductiva=fproformaproductiva, proformaproductdateexpiration=fproformaproductdateexpiration, 
                proformaproductcount=fproformaproductcount, proformaproducttotalvalue=fproformaproducttotalvalue, proformaproductutility=fproformaproductutility, 
                proformaproductaverageprice=fproformaproductaverageprice
            WHERE proformaproductid=fproformaproductid;
        return 1;
    end case;
    return 0;
end
$$ language plpgsql;



SELECT public.proformaproductmanagement(2,62,'papitas','papitas x 21',12,12,'2020-12-13',50,200,15,13);

--FUNCION PARA INGRESAR NUEVA PROFORMA

CREATE OR REPLACE FUNCTION proformamanagement(
    band numeric,
    fproformaid integer,
    fclientid integer,
    fproformatotal numeric,
    fproformatime numeric,
    fproformastate numeric,
    fproformadate date) RETURNS Integer as $$

BEGIN
    case band
    WHEN 1 then
           INSERT INTO public.proforma(
            proformaid, clientid, proformatotal, proformatime, proformastate, 
            proformadate)
    VALUES (default, fclientid, fproformatotal, fproformatime, fproformastate, 
            fproformadate);

	    return 1;
    WHEN 2 then
            UPDATE public.proforma
            SET proformaid=fproformaid, clientid=fclientid, proformatotal=fproformatotal, proformatime=fproformatime, proformastate=fproformastate, 
            proformadate=fproformadate
            WHERE proformaid=fproformaid;

        return 1;
    WHEN 3 then
            DELETE FROM public.proforma
            WHERE  proformaid=fproformaid;

        return 1;
    end case;
    return 0;
end
$$ language plpgsql;

SELECT public.proformamanagement(1,1,3,133,8,1,'2018-10-10');
