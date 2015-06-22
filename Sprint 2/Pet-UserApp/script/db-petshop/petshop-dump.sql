-- Connect to database

connect 'jdbc:derby://localhost:1527/petshopdb' user 'pet' password 'pet';

-- Data Dumps 

INSERT INTO IMAGE VALUES (00001, 'CannedMilk','Food and Treats, Canned','img/canfood', 'P','jpg');
INSERT INTO IMAGE VALUES (00002, 'calciummilkbone','Food and Treats, Dry','img/dryfood', 'P','jpg');
INSERT INTO IMAGE VALUES (00003, 'royalcaninboxerjuniorrs','Food and Treats, Dry','img/dryfood', 'P','jpg');


INSERT INTO CATEGORY VALUES (00001, 'Food and Treats',	'All kind of foods for Dogs(petsgonut)',	0,	00001);
INSERT INTO CATEGORY VALUES (00002, 'Dry Food',	'All',	00001,	00001);
INSERT INTO CATEGORY VALUES (00003, 'Wet Food',	'All',	00001,	00001);
INSERT INTO CATEGORY VALUES (00004, 'Canned Food',	'All',	00001,	00001);
INSERT INTO CATEGORY VALUES (00005, 'Doggy Treats',	'All',	00001,	00001);
INSERT INTO CATEGORY VALUES (00006, 'Doggy Biscuits',	'All',	00001,	00001);


INSERT INTO PRODUCT VALUES (00001, 'Royal Canin Baby Dog Milk',  'Canned Food 400gm', 342, 00001 ,00004);
INSERT INTO PRODUCT VALUES (00002, 'Royal Calcium Milk Bone',  'Dry Food 1400gm', 420, 00002 ,00002);
INSERT INTO PRODUCT VALUES (00003, 'Royal Canin Boxer Juniorrs',  'Dry Food 200gm', 402, 00003 ,00002);


INSERT INTO USERS VALUES (00001, 'Rani Velu',  'welcome', 'ravelu', 'C' , 0, 'rani.velu@capgemini.com', 'PSN, Cresent2, Bangalore, IN');
INSERT INTO USERS VALUES (00003, 'Rani Velu',  'welcome', 'ravelu1', 'C' , 0, 'rani.velu@capgemini.com', 'PSN, Cresent2, Bangalore, IN');

COMMIT;