package com.ecc.core.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ���ڴ�����
 * 
 * ������ظ�ʽ������д�ڴ˴�
 * 
 * @author guoyl
 * @version 1.0
 * @date 2014.09.16
 */
public class DateUtil {
	
	/*
	 * �� �� �� ʱ �� �� ����  �����  ��� �ֲ� ʱ�� �ղ� �²� ��� 
	 */
	/**
	 * ���ص�ǰ���
	 * @param date
	 * @return
	 * 
	 */
	public static String getYear(Date date){
		return DateUtil.dateFormat(date, "yyyy");
	}
	
	/**
	 * ���ص�ǰ�·�
	 * @param date
	 * @return
	 */
	public static String getMonth(Date date){
		return DateUtil.dateFormat(date, "MM");
	}
	/**
	 * ���ص�ǰ��
	 * @param date
	 * @return
	 */
	public static String getDay(Date date){
		return DateUtil.dateFormat(date, "dd");
	}
	
	/**
	 * ���ص�ǰʱ��  Сʱ 
	 * 24Сʱ��
	 * @param date
	 * @return
	 */
	public static String getHour(Date date){
		return DateUtil.dateFormat(date, "HH");
	}
	 /**
	 * ���ص�ǰʱ��  Сʱ
	 * 12Сʱ��
	 * @param date
	 * @return
	 */
	public static String getHourAP(Date date){
		return DateUtil.dateFormat(date, "HH");
	}
	/**
	 * ���ص�ǰʱ�� ����
	 * @param date
	 * @return
	 */
	public static String getMinute(Date date){
		return DateUtil.dateFormat(date, "mm");
	}
	/**
	 * ���ص�ǰʱ�� �� 
	 * @param date
	 * @return
	 */
	public static String getSecond(Date date){
		return DateUtil.dateFormat(date, "ss");
	}
	
	/**
	 * ���ص�ǰʱ�� ����
	 * @param date
	 * @return
	 */
	public static String getMs(Date date){
		return DateUtil.dateFormat(date, "S");
	}
	
	/**
	 * ��������
	 * @param date
	 * @return
	 * 		yyyy-MM
	 */
	public static String getYM(Date date){
		
		return DateUtil.dateFormat(date, "yyyy-MM");
		
	}
	
	/**
	 * ����������
	 * @param date
	 * @return
	 * 		MM-dd
	 */
	public static String getMD(Date date){
		
		return DateUtil.dateFormat(date, "MM-dd");
		
	}
	
	/**
	 * ����������
	 * @param date
	 * @return
	 * 		yyyy-MM-dd
	 */
	public static String getYMD(Date date){
		
		return DateUtil.dateFormat(date, "yyyy-MM-dd");
		
	}
	
	/**
	 * ����������ʱ����
	 * @param date
	 * @return
	 * 		yyyy-MM-dd HH:mm:ss
	 */
	public static String getYMDHMS(Date date){
		
		return DateUtil.dateFormat(date, "yyyy-MM-dd HH:mm:ss");
		
	}

	/**
	 * ����������ʱ�������
	 * @param date
	 * @return
	 * 		yyyy-MM-dd HH:mm:ss
	 */
	public static String getYMDHMSS(Date date){
		
		return DateUtil.dateFormat(date, "yyyy-MM-dd HH:mm:ss.S");
		
	}
	
	/**
	 * ���������������ĺ�����
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getMsBetween(Date date1,Date date2){
		
		return date1.getTime() - date2.getTime();
		
	}
	/**
	 * ��������������������
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getSecondBetween(Date date1,Date date2){

		return DateUtil.getMsBetween(date1,date2)/1000;

	}
	/**
	 * ���������������ķ�����
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getMinuteBetween(Date date1,Date date2){

		return DateUtil.getSecondBetween(date1,date2)/60;

	}
	/**
	 * ����������������Сʱ��
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getHourBetween(Date date1,Date date2){

		return DateUtil.getMinuteBetween(date1,date2)/60;

	}
	/**
	 * ��������������������
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getDayBetween(Date date1,Date date2){
		return DateUtil.getHourBetween(date1,date2)/24;
	}
	/**
	 * ��������������������
	 * 
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static long getMonthBetween(Date date1,Date date2){
		return DateUtil.getHourBetween(date1,date2)/24;
	}
	/**
	 * �Զ����ʽ��ʽ������
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
