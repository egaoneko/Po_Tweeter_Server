/*
 * ���α׷� �̸� : Po Tweeter
 * ���� : Version 0.9
 * ���ϸ� : Date.java
 * ���� : ���� ��¥ ���
 * ���� ���� ��¥ : 14.02.09
 */

import java.util.Calendar;
import java.util.TimeZone;

public class Date {
	public static String getdateS(){
		Calendar call=Calendar.getInstance();
		TimeZone tz = TimeZone.getTimeZone("GMT+09:00");
		call.setTimeZone(tz);
		int year=call.get(Calendar.YEAR);
		int month=call.get(Calendar.MONTH)+1;
		int day=call.get(Calendar.DATE);
		int hour=call.get(Calendar.HOUR);
		int minute=call.get(Calendar.MINUTE);
		int second=call.get(Calendar.SECOND);
		String date= year+"�� "+month+"�� " +day+"�� "+ hour+"�� "+minute+"�� "+second+"��"; 		
		return date;
	}
	public static String getdateD(){
		Calendar call=Calendar.getInstance();
		TimeZone tz = TimeZone.getTimeZone("GMT+09:00");
		call.setTimeZone(tz);
		int year=call.get(Calendar.YEAR);
		int month=call.get(Calendar.MONTH)+1;
		int day=call.get(Calendar.DATE);
		String date= year+"-"+month+"-" +day; 		
		return date;
	}
	public static String getdateSD(){
		Calendar call=Calendar.getInstance();
		TimeZone tz = TimeZone.getTimeZone("GMT+09:00");
		call.setTimeZone(tz);
		int year=call.get(Calendar.YEAR);
		int month=call.get(Calendar.MONTH)+1;
		int day=call.get(Calendar.DATE);
		int hour=call.get(Calendar.HOUR);
		int minute=call.get(Calendar.MINUTE);
		int second=call.get(Calendar.SECOND);
		String date=" | " + year+"-"+month+"-" +day+ " | " + hour+" : "+minute+" : "+second+" | "; 		
		return date;
	}
}
