import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ConvertStringToJavaSQLDateExample {
	public static void main(String args[]) throws ParseException{
		//string containing date
		String strDate = "2011-12-31";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
	    java.util.Date date = sdf.parse(strDate);
	    java.sql.Date sqlDate = new Date(date.getTime());
	    System.out.println("String converted to java.sql.Date :" + sqlDate);

		//test
		try{
		String da = sdf.format(sqlDate);
		System.out.println(da);
		} catch (Exception e){
			System.out.print(e);
		}
	}
 
/*
Output of above given String to java.sql.Date example would be
2011-01-31
*/
}
