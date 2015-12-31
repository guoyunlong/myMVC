package com.ecc.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期处理类
 * 
 * 日期相关格式化参数写在此处
 * 
 * @author guoyl
 * @version 1.0
 * @date 2014.09.16
 */
public class DateUtil {
	
	/*
	 * 年 月 日 时 分 秒 毫秒  毫秒差  秒差 分差 时差 日差 月差 年差 
	 */
	/**
	 * 返回当前年份
	 * @param date
	 * @return
	 * 
	 */
	public static String getYear(Date date){
		return DateUtil.dateFormat(date, "yyyy");
	}
	
	/**
	 * 返回当前月份
	 * @param date
	 * @return
	 */
	public static String getMonth(Date date){
		return DateUtil.dateFormat(date, "MM");
	}
	/**
	 * 返回当前日
	 * @param date
	 * @return
	 */
	public static String getDay(Date date){
		return DateUtil.dateFormat(date, "dd");
	}
	
	/**
	 * 返回当前时间  小时 
	 * 24小时制
	 * @param date
	 * @return
	 */
	public static String getHour(Date date){
		return DateUtil.dateFormat(date, "HH");
	}
	 /**
	 * 返回当前时间  小时
	 * 12小时制
	 * @param date
	 * @return
	 */
	public static String getHourAP(Date date){
		return DateUtil.dateFormat(date, "HH");
	}
	/**
	 * 返回当前时间 分钟
	 * @param date
	 * @return
	 */
	public static String getMinute(Date date){
		return DateUtil.dateFormat(date, "mm");
	}
	/**
	 * 返回当前时间 秒 
	 * @param date
	 * @return
	 */
	public static String getSecond(Date date){
		return DateUtil.dateFormat(date, "ss");
	}
	
	/**
	 * 返回当前时间 毫秒
	 * @param date
	 * @return
	 */
	public static String getMs(Date date){
		return DateUtil.dateFormat(date, "S");
	}
	
	/**
	 * 返回年月
	 * @param date
	 * @return
	 * 		yyyy-MM
	 */
	public static String getYM(Date date){
		
		return DateUtil.dateFormat(date, "yyyy-MM");
		
	}
	
	/**
	 * 返回年月日
	 * @param date
	 * @return
	 * 		MM-dd
	 */
	public static String getMD(Date date){
		
		return DateUtil.dateFormat(date, "MM-dd");
		
	}
	
	/**
	 * 返回年月日
	 * @param date
	 * @return
	 * 		yyyy-MM-dd
	 */
	public static String getYMD(Date date){
		
		return DateUtil.dateFormat(date, "yyyy-MM-dd");
		
	}
	
	/**
	 * 返回年月日时分秒
	 * @param date
	 * @return
	 * 		yyyy-MM-dd HH:mm:ss
	 */
	public static String getYMDHMS(Date date){
		
		return DateUtil.dateFormat(date, "yyyy-MM-dd HH:mm:ss");
		
	}

	/**
	 * 返回年月日时分秒毫秒
	 * @param date
	 * @return
	 * 		yyyy-MM-dd HH:mm:ss
	 */
	public static String getYMDHMSS(Date date){
		
		return DateUtil.dateFormat(date, "yyyy-MM-dd HH:mm:ss.S");
		
	}
	
	/**
	 * 返回两个日期相差的毫秒数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getMsBetween(Date date1,Date date2){
		
		return date1.getTime() - date2.getTime();
		
	}
	/**
	 * 返回两个日期相差的秒数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getSecondBetween(Date date1,Date date2){

		return DateUtil.getMsBetween(date1,date2)/1000;

	}
	/**
	 * 返回两个日期相差的分钟数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getMinuteBetween(Date date1,Date date2){

		return DateUtil.getSecondBetween(date1,date2)/60;

	}
	/**
	 * 返回两个日期相差的小时数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getHourBetween(Date date1,Date date2){

		return DateUtil.getMinuteBetween(date1,date2)/60;

	}
	/**
	 * 返回两个日期相差的天数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getDayBetween(Date date1,Date date2){
		return DateUtil.getHourBetween(date1,date2)/24;
	}
	/**
	 * 返回两个日期相差的月数
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getMonthBetween(Date date1,Date date2){
		return DateUtil.getHourBetween(date1,date2)/24;
	}
	/**
	 * 自定义格式格式化日期
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String dateFormat(Date date,String pattern){
		if(date == null){
			return "";
		}
		if(pattern==null||"".equals(pattern)){
			return DateUtil.getYMD(date);
		}
		return new SimpleDateFormat(pattern).format(date);
	}
	
	public static void main(String args[]){
		System.out.println(DateUtil.dateFormat(new Date(), " w F W D d"));
	}
	
}
