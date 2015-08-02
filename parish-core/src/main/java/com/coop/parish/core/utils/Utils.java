package com.coop.parish.core.utils;

import java.util.Random;

public class Utils {
	
	private static char[] SPECIAL_CHARS = {'!','@','#','$','%','&','*','(',')','_'};
	
	public static String generateRandomKey() {
		Random random = new Random();
		float randomNum = random.nextFloat();
		int num = (int)(randomNum*1000);
		int index = (int)(randomNum*10);

		StringBuilder builder = new StringBuilder("Parish").append(SPECIAL_CHARS[index]).append(num);
		return builder.toString();
	}
}
