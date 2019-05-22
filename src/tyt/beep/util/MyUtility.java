package tyt.beep.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyUtility {
	
	
	static SimpleDateFormat simpleformat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
   public	static String currentTime(){
		return simpleformat.format(new Date());
	}

}
