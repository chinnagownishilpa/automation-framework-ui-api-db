package Utils;

import java.util.UUID;

public class TestDataUtil {
	public static String getRandomUsername() {
		return "user_"+UUID.randomUUID().toString().substring(0,5);
	}
	
	public static String getRandomNumber() {
		return String.valueOf(System.currentTimeMillis()).substring(7);
	}

}
