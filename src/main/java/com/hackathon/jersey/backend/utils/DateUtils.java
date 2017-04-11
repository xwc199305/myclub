package com.hackathon.jersey.backend.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * Created At:2016年8月19日<br>
 * Copyright © 1995-2016, Oracle and/or its affiliates. All rights reserved.<br>
 * Data format utils</br>
 * 
 * <b>
 * <ul>
 * <li>默认使用 "yyyy-MM-dd HH:mm:ss" 格式化日期</li>
 * </ul>
 * </b>
 * 
 * @author weixiche
 * @version 1.0.0
 */
public class DateUtils {

	/**
	 * 英文简写（默认）如：2010-12-01
	 */
	public static String FORMAT_SHORT = "yyyy-MM-dd";

	/**
	 * 英文简写 如：12-01 10:33
	 */
	public static String FORMAT_MIDDLE = "MM-dd HH:mm";

	/**
	 * 英文全称 如：2010-12-01 23:15:06
	 */
	public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 精确到毫秒的完整时间 如：yyyy-MM-dd HH:mm:ss.S
	 */
	public static String FORMAT_FULL = "yyyy-MM-dd HH:mm:ss.S";

	/**
	 * 中文简写 如：2010年12月01日
	 */
	public static String FORMAT_SHORT_CN = "yyyy年MM月dd";

	/**
	 * 中文全称 如：2010年12月01日 23时15分06秒
	 */
	public static String FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒";

	/**
	 * 精确到毫秒的完整中文时间
	 */
	public static String FORMAT_FULL_CN = "yyyy年MM月dd日  HH时mm分ss秒SSS毫秒";

	/**
	 * 一天的毫秒数
	 */
	public final static long TIME_DAY_MILLISECOND = 86400000;

	/**
	 * 一小时的毫秒数
	 */
	public final static long TIME_HOUR_MILLISECOND = 3600000;

	/**
	 * 一分钟的毫秒数
	 */
	public final static long TIME_MINUTE_MILLISECOND = 60000;

	/**
	 * 一秒的毫秒数
	 */
	public final static long TIME_SECOND_MILLISECOND = 1000;

	/**
	 * 获得默认的 date pattern
	 */
	public static String getDatePattern() {
		return FORMAT_LONG;
	}

	/**
	 * 根据预设格式返回当前日期
	 * 
	 * @return
	 */
	public static String getNow() {
		return format(new Date());
	}

	/**
	 * 根据用户格式返回当前日期
	 * 
	 * @param format
	 * @return
	 */
	public static String getNow(String format) {
		return format(new Date(), format);
	}

	/**
	 * 使用预设格式格式化日期
	 * 
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		return format(date, getDatePattern());
	}

	/**
	 * 使用用户格式格式化日期
	 * 
	 * @param date
	 *            日期
	 * @param pattern
	 *            日期格式
	 * @return
	 */
	public static String format(Date date, String pattern) {
		String returnValue = "";
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			returnValue = df.format(date);
		}
		return (returnValue);
	}

	/**
	 * 使用预设格式提取字符串日期
	 * 
	 * @param strDate
	 *            yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date parse(String strDate) {
		return parse(strDate, getDatePattern());
	}

	/**
	 * 使用用户格式提取字符串日期
	 * 
	 * @param strDate
	 *            日期字符串
	 * @param pattern
	 *            日期格式
	 * @return
	 */
	public static Date parse(String strDate, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			return df.parse(strDate);
		} catch (ParseException e) {
			throw new IllegalArgumentException(e.getMessage());
		}
	}

	/**
	 * 在日期上增加数个整月
	 * 
	 * @param date
	 *            日期
	 * @param n
	 *            要增加的月数
	 * @return
	 */
	public static Date addMonth(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}

	/**
	 * 在日期上增加天数
	 * 
	 * @param date
	 *            日期
	 * @param n
	 *            要增加的天数
	 * @return
	 */
	public static Date addDay(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, n);
		return cal.getTime();
	}

	/**
	 * 在日期上增加天数
	 * 
	 * @param date
	 *            日期
	 * @param n
	 *            要增加的天数
	 * @return
	 */
	public static Timestamp addDay(Timestamp ts, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(ts);
		cal.add(Calendar.DATE, days);
		return new Timestamp(cal.getTimeInMillis());
	}

	/**
	 * 获取时间戳
	 */
	public static String getTimeString() {
		SimpleDateFormat df = new SimpleDateFormat(FORMAT_FULL);
		Calendar calendar = Calendar.getInstance();
		return df.format(calendar.getTime());
	}

	/**
	 * 获取日期年份
	 * 
	 * @param date
	 *            日期
	 * @return
	 */
	public static String getYear(Date date) {
		return format(date).substring(0, 4);
	}

	/**
	 * 按默认格式的字符串距离今天的天数
	 * 
	 * @param date
	 *            日期字符串
	 * @return
	 */
	public static int countDays(String date) {
		long t = Calendar.getInstance().getTime().getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(parse(date));
		long t1 = c.getTime().getTime();
		return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
	}

	/**
	 * 按用户格式字符串距离今天的天数
	 * 
	 * @param date
	 *            日期字符串
	 * @param format
	 *            日期格式
	 * @return
	 */
	public static int countDays(String date, String format) {
		long t = Calendar.getInstance().getTime().getTime();
		Calendar c = Calendar.getInstance();
		c.setTime(parse(date, format));
		long t1 = c.getTime().getTime();
		return (int) (t / 1000 - t1 / 1000) / 3600 / 24;
	}

	/**
	 * 取得当前系统时间戳
	 *
	 * @see java.sql.Timestamp
	 * @return java.sql.Timestamp 系统时间戳
	 */
	public static java.sql.Timestamp getCurrTimestamp() {
		return new java.sql.Timestamp(System.currentTimeMillis());
	}

	/**
	 * 获得两个Date型日期之间相差的天数（第2个减第1个）
	 *
	 * @param Date
	 *            first, Date second
	 * @return long 相差的天数
	 */
	public static long getDaysBetweenDates(Date first, Date second) {
		Long diff = second.getTime() - first.getTime();
		return diff / TIME_DAY_MILLISECOND;
	}

	/**
	 * 获得两个String型日期之间相差的天数（第2个减第1个）
	 *
	 * @param String
	 *            first 'YYYY-MM-dd'
	 * @param String
	 *            second 'YYYY-MM-dd'
	 * @return long 相差的天数
	 */
	public static long getDaysBetweenDates(String first, String second) {
		Date d1 = parse(first, FORMAT_SHORT);
		Date d2 = parse(second, FORMAT_SHORT);
		return getDaysBetweenDates(d1, d2);
	}

	/**
	 * 获得两个Date型日期之间相差的天数（第2个减第1个）
	 * 
	 * @param first
	 * @param second
	 * @return long 相差的小时数
	 */
	public static long getHoursBetweenDates(Date first, Date second) {
		Long diff = second.getTime() - first.getTime();
		return diff / TIME_HOUR_MILLISECOND;
	}

	/**
	 * 获得两个Date型日期之间相差的分钟数（第2个减第1个）
	 * 
	 * @param first
	 * @param second
	 * @return long 相差的分钟数
	 */
	public static long getMinutesBetweenDates(Date first, Date second) {
		Long diff = second.getTime() - first.getTime();
		return diff / TIME_MINUTE_MILLISECOND;
	}

	/**
	 * 获得两个Date型日期之间相差的秒数（第2个减第1个）
	 * 
	 * @param first
	 * @param second
	 * @return long 相差的秒数
	 */
	public static long getSecondsBetweenDates(Date first, Date second) {
		Long diff = second.getTime() - first.getTime();
		return diff / TIME_SECOND_MILLISECOND;
	}

	/**
	 * determine the date before now or not
	 * 
	 * @param time
	 * @return if before now return true, else return false
	 */
	public static boolean beforeNow(java.sql.Timestamp time) {
		return time.before(new Date());
	}

	/**
	 * determine the date after now or not
	 * 
	 * @param time
	 * @return if after now return true, else return false
	 */
	public static boolean afterNow(java.sql.Timestamp time) {
		return time.after(new Date());
	}
	
	public static long getCalandarDaysBetweenDates(Date first, Date second) {
		Long t1 = first.getTime();
		Long t2 = second.getTime();
		int result = (int)Math.ceil((t2 - t1)/86400000.0);
		return result;
	}
}
