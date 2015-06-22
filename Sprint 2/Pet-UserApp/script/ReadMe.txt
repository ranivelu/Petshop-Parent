 To do this, add the following lines inside the GlobalNamingResources element of $CATALINA_HOME/conf/server.xml:
 
    <!-- Pet Shop Application DataSource -->
    <Resource auth="Container" 
	    driverClassName="org.apache.derby.jdbc.EmbeddedDriver" 
	    maxActive="8" maxIdle="4" 
	    name="jdbc/petshopDS" type="javax.sql.DataSource" 
	    url="jdbc:derby:petshopdb;create=true" 
	    username="pet" password="pet" />