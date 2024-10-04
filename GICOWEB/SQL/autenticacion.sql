-----------------------------------FUNCION PARA AUTENTICAR USUARIOS-------------------------
create or replace function autenticationuser(varchar,varchar) returns varchar
 as
	'SELECT * FROM public.users where usernameuser=$1 and userpass=$2;'
 language sql;

--DATOS PRUEBA--
select autenticationuser('carlosuser','pass');


SELECT *  FROM public.users where usernameuser='carlosuser' and userpass = 'pass';
