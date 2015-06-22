package test.product;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CurrentDate {

	public static void main(String[] args) throws ParseException {
	       //getting current date and time using Date class
//		/SimpleDateFormat("dd/MM/yy HH:mm:ss");
	       DateFormat df = new SimpleDateFormat("dd/MM/yy");
	       Date dateobj = new Date();
	       System.out.println(df.format(dateobj));

	       /*getting current date time using calendar class 
	        * An Alternative of above*/
	       Calendar calobj = Calendar.getInstance();
	       System.out.println(df.format(calobj.getTime()));
	       
	       SimpleDateFormat sdfmt1 = new SimpleDateFormat("dd/MM/yy");
	       SimpleDateFormat sdfmt2= new SimpleDateFormat("dd-MMM-yyyy");
	       java.util.Date dDate = sdfmt1.parse( df.format(calobj.getTime()) );
	       System.out.println(dDate);
	       String strOutput = sdfmt2.format( dDate );
	    }
}
