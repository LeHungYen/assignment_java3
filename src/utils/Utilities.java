package utils;

import java.security.MessageDigest;
import java.util.regex.Pattern;

public class Utilities {
	public static String hashingPassword(String password) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			
			messageDigest.update(password.getBytes());
			
			byte[] resultByteArray = messageDigest.digest();
			
			StringBuilder stringBuilder = new StringBuilder();
			
			for (byte b : resultByteArray) {
				stringBuilder.append(String.format("%02x", b));
			}
		return stringBuilder.toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public static String regexCheckGmail (String gmail) {
		Pattern pattern = Pattern.compile("^[a-zA-Z][a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+){1,3}$");
		if(pattern.matcher(gmail).find()) {
			return "true";
		}
		return "false";
	}
	
	public static String regexCheckFullName(String fullName) {
		Pattern pattern = Pattern.compile("[A-Z][a-z]{1,4}+ [A-Z][a-z]{1,4}+ [A-Z][a-z]{1,4}");
		if(pattern.matcher(fullName).find()) {
			return "true";
		}
		return "false";
	}
	
	public static String regexCheckPhoneNumber(String phoneNumber) {
		Pattern pattern = Pattern.compile("0+[0-9]{9,10}");
		if(pattern.matcher(phoneNumber).find()) {
			return "true";
		}
		return "false";
	}
	public static int splitDate(String yyyyMMdd) {
		int date =  Integer.parseInt(yyyyMMdd.substring(8, 10));
		return date;
	}
	public static int splitMonth(String yyyyMMdd) {
		int month = Integer.parseInt(yyyyMMdd.substring(5, 7));
		return month;
	}
	public static int splitYear(String yyyyMMdd) {
		int year =  Integer.parseInt(yyyyMMdd.substring(0, 4));
		return year;
	}
	
	public static void main(String[] args) {
		System.out.println(splitDate("2022-06-25"));
		System.out.println(splitMonth("2022-06-25"));
		System.out.println(splitYear("2022-06-25"));
	}
	
}
