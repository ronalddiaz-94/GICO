-- Proforma
CREATE TABLE public.proforma
(
  proformaid integer NOT NULL DEFAULT nextval('products_productid_seq'::regclass),
  clientid integer NOT NULL,
  proformatotal numeric,
  proformatime numeric,
  proformastate numeric,
  proformadate date,
  CONSTRAINT proforma_pkey PRIMARY KEY (proformaid),
  CONSTRAINT fk_client FOREIGN KEY (clientid)
      REFERENCES public.client (clientid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
 )

CREATE TABLE public.proformaproduct
(
  productid integer NOT NULL,
  proformaid integer NOT NULL,
  proformaproductprice numeric,
  proformaproductiva double precision,
  proformaproductcount numeric,
  proformaproductutility numeric,
  CONSTRAINT proformaproduct_pkey PRIMARY KEY (productid, proformaid),
  CONSTRAINT fk_proformaproduct FOREIGN KEY (productid)
      REFERENCES public.products (productid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_proforma FOREIGN KEY (proformaid)
      REFERENCES public.proforma (proformaid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
CREATE TABLE public.facturaproduct
(
  productid integer NOT NULL,
  facturaid integer NOT NULL,
  facturaproductprice numeric,
  facturaproductiva double precision,
  facturaproductcount numeric,
  facturaproductutility numeric,
  facturaiva numeric,
  CONSTRAINT facturaproduct_pkey PRIMARY KEY (productid, facturaid),
  CONSTRAINT fk_factura FOREIGN KEY (facturaid)
      REFERENCES public.factura (facturaid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_facturaproduct FOREIGN KEY (productid)
      REFERENCES public.products (productid) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)

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

--fuciona para ingresar productos a profoma




CREATE OR REPLACE FUNCTION proforproductmamanagement(
    band numeric,
    fproductid integer, 
    fproformaid integer, 
    fproformaproductprice numeric, 
    fproformaproductiva numeric, 
    fproformaproductcount numeric, 
    fproformaproductutility numeric
    ) RETURNS Integer as $$

BEGIN
    case band
    WHEN 1 then
           INSERT INTO public.proformaproduct(
            productid, proformaid, proformaproductprice, proformaproductiva, 
            proformaproductcount, proformaproductutility)
    VALUES (fproductid, fproformaid, fproformaproductprice, fproformaproductiva, 
            fproformaproductcount, fproformaproductutility);

	    return 1;
    end case;
    return 0;
end
$$ language plpgsql;

SELECT public.proformamanagement(1,1,3,133,8,1,'2018-10-10');
