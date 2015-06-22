Changing the application to use the Derby Embedded Driver
Restaurants.java accessed the Derby database, myDB using the Derby Network Client Driver. The values for loading the driver and the Database connection URL are shown below.

Driver name org.apache.derby.jdbc.ClientDriver

Database connection URL jdbc:derby://localhost:1527/myDB;create=true;user=me;password=mine

To change the application to use the Derby Embedded Driver we need to change these values to:

Driver name org.apache.derby.jdbc.EmbeddedDriver

Database connection URL jdbc:derby:myDB;create=true;user=me;password=mine


<?xml version="1.0" encoding="UTF-8"?>
<classpath>
	<classpathentry kind="src" path="src"/>
	<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER"/>
	<classpathentry kind="lib" path="lib/commons-logging.jar"/>
	<classpathentry kind="lib" path="lib/derby.jar"/>
	<classpathentry kind="lib" path="lib/log4j-1.2.15.jar"/>
	<classpathentry kind="lib" path="lib/spring-jdbc.jar"/>
	<classpathentry kind="lib" path="lib/spring.jar"/>
	<classpathentry kind="output" path="bin"/>
</classpath>


java -jar %DERBY_HOME%\lib\derbyrun.jar ij

'jdbc:derby:firstdb'