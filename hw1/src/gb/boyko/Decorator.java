package gb.boyko;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Decorator {

	public static String decorate(String note) {
		String date = new SimpleDateFormat("yyyy.MM.dd_HH:mm").format(Calendar.getInstance().getTime());
		return String.format("%s ---> %s",date, note);
	}
}


