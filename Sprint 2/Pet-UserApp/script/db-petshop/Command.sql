-------------------------------------------------------------
------------------ PET SHOP DERBY COMMANDS ------------------
-------------------------------------------------------------

CMD$>  	java -jar D:\db-derby-10.2.1.6-bin\lib\derbyrun.jar ij

ij>		run 'D:\Sogeti_NL_Repo\parent\Pet-UserApp\script\db-petshop\petshop.sql';

ij>  	connect 'jdbc:derby://localhost:1527/petshopdb' user 'pet' password 'pet';

ij> 	select s.schemaname || '.' || t.tablename  
     	from sys.systables t, sys.sysschemas s  
     	where t.schemaid = s.schemaid 
        and t.tabletype = 'T' 
     	order by s.schemaname, t.tablename;
     	
		PET.ADMIN_HISTORY
		PET.CATEGORY
		PET.IMAGE
		PET.ORDER_ITEM
		PET.PRODUCT
		PET.USERS


ij>		run 'D:\Sogeti_NL_Repo\parent\Pet-UserApp\script\db-petshop\petshop-dump.sql';
		
ij> 	select * from PET.ADMIN_HISTORY;

ij> 	select * from PET.CATEGORY;

ij> 	select * from PET.IMAGE;

ij> 	select * from PET.ORDERS;

ij> 	select * from PET.ORDER_ITEM;

ij> 	select * from PET.PRODUCT;

ij> 	select * from PET.USERS;


SELECT 
    C.CONSTRAINTNAME,
    T.TABLENAME 
FROM 
    SYS.SYSCONSTRAINTS C, 
    SYS.SYSSCHEMAS S,
    SYS.SYSTABLES T 
WHERE 
    C.SCHEMAID = S.SCHEMAID 
AND 
    C.TABLEID = T.TABLEID
AND 
    S.SCHEMANAME = 'PET');
    
      
    
   	DROP TABLE PET.ADMIN_HISTORY;

	DROP TABLE  PET.CATEGORY;

	DROP TABLE PET.IMAGE;

	DROP TABLE PET.ORDERS;

	DROP TABLE  PET.ORDER_ITEM;

	DROP TABLE  PET.PRODUCT;

 	DROP TABLE  PET.USERS;
-------------------------------------------------------------