/***
 *
 * @ClassName: DateHelper
 * @Description: 日期工具类
 * @Auther: yecao
 * @Date: 2019/9/21 14:24
 * @version : 1.0
 */
package com.bdp.helper;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelper {
	/**
	 * 默认时间格式化格式
	 */
	/**
	 * 日期转换为字符串
	 * @param date 日期
	 * @return 字符串
	 */
	public static String dateToStr(Date date)
	{
		try {
			return dateToStr(date, Constant.DEFAULT_DATETIME_FORMART);
		} catch (Exception e) {
			return dateToStr(new Date());
		}
	}

	/**
	 * 日期转换为字符串
	 * @param date 日期
	 * @param format 时间格式
	 * @return  日期
	 */
	public static String dateToStr(Date date, String format)
	{
		try {
			if (BaseHelper.isNotEmpty(format)) {
				return new SimpleDateFormat(format).format(date);
			}
			return new SimpleDateFormat(Constant.DEFAULT_DATETIME_FORMART).format(date);
		} catch (Exception e) {
			return dateToStr(new Date());
		}
	}

	/**
	 * 字符串转换为日期
	 * @param str 字符串
	 * @param format 时间格式
	 * @return 日期
	 */
	public static Date strToDate(String str,String format){
		try{
			return new SimpleDateFormat(format).parse(str);
		}catch (Exception e){
			return null;
		}
	}

	/**
	 * 字符串转换为日期
	 * @param str 字符串
	 * @return 日期
	 */
	public static Date strToDate(String str){
		try{
			return new SimpleDateFormat(Constant.DEFAULT_DATETIME_FORMART).parse(str);
		}catch (Exception e){
			return null;
		}
	}

	/**
	 * 时间比较
	 * @param date1 日期
	 * @param date2 日期
	 * @return 比较结果
	 */
	public static Integer compare(Date date1,Date date2) {
		Long d1 = date1.getTime();
		Long d2 = date2.getTime();

		if(d1 > d2){
			return 1;
		}else if(d1 < d2){
			return -1;
		}else{
			return 0;
		}
	}
	/*
	 * 毫秒转化时分秒毫秒
	 */
	public static String formatTime(Long ms) {
		if(BaseHelper.isEmpty(ms)){
			return "";
		}
		Integer ss = 1000;
		Integer mi = ss * 60;
		Integer hh = mi * 60;
		Integer dd = hh * 24;

		Long day = ms / dd;
		Long hour = (ms - day * dd) / hh;
		Long minute = (ms - day * dd - hour * hh) / mi;
		Long second = (ms - day * dd - hour * hh - minute * mi) / ss;
		Long milliSecond = ms - day * dd - hour * hh - minute * mi - second * ss;

		StringBuffer sb = new StringBuffer();
		if(day > 0) {
			sb.append(day+"天");
		}
		if(hour > 0) {
			sb.append(hour+"小时");
		}
		if(minute > 0) {
			sb.append(minute+"分");
		}
		if(second > 0) {
			sb.append(second+"秒");
		}
		if(milliSecond > 0) {
			sb.append(milliSecond+"毫秒");
		}
		return sb.toString();
	}
	public static String getCurrentTimeStamp(String format) {

		return dateToStr(new Date(), format);
	}

	/**
	 * 添加天数
	 * @param date 日期
	 * @param cnt 数量
	 * @return Date
	 */
	public static Date addDate(Date date,Integer cnt){
		Calendar cl = Calendar. getInstance();
		cl.setTime(date);
		cl. add(Calendar.DATE, cnt);
		return cl.getTime();
	}

	public static String getMonthFirstDay(Date date) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DATE,1);

		return dateToStr(calendar.getTime(),Constant.DEFAULT_DATE_FORMART);
	}

	public static String getMonthLastDay(Date date) {


		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH,(calendar.get(Calendar.MONTH)+1));
		calendar.set(Calendar.DATE,0);

		return dateToStr(calendar.getTime(),Constant.DEFAULT_DATE_FORMART);
	}


	public static String getNextMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH,(calendar.get(Calendar.MONTH)+1));
		return dateToStr(calendar.getTime(),Constant.DEFAULT_MONTH_FORMART);
	}

	public static String getPreMonth(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH,(calendar.get(Calendar.MONTH)-1));
		return dateToStr(calendar.getTime(),Constant.DEFAULT_MONTH_FORMART);
	}


	public static void main(String[] args) {

		String str = getNextMonth(new Date());
		System.out.println(str);

	}

}
