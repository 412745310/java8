package com.chelsea.java8.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期格式类实例化本地线程实现
 * 
 * @author shevchenko
 *
 */
public class DateFormatThreadLocal {
	
	private static final ThreadLocal<DateFormat> df = new ThreadLocal<DateFormat>(){
		
		protected SimpleDateFormat initialValue(){
			return new SimpleDateFormat("yyyyMMdd");
		}
		
	};
	
	public static final Date convert(String source) throws ParseException{
		return df.get().parse(source);
	}

}
