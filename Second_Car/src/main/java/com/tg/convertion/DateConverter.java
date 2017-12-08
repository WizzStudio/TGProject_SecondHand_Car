package com.tg.convertion;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.util.StrutsTypeConverter;

public class DateConverter extends StrutsTypeConverter {

	public static Logger logger = Logger.getLogger(DateConverter.class);
	public static final String DEFAULT_DATE_FORMAT = "yyyy/MM/dd";
	public static final String DATE_FORMAT = "yyyy-MM-dd";
	public DateConverter()
	{
		
	}
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		if(values[0] ==null||values[0].trim().equals(""))
		{
			return  null;
		}
		SimpleDateFormat format = null;
		if(values[0].indexOf('/')!=-1)	//DEFAULT_DATE_FORMAT = "yyyy/MM/dd"
		{
			format = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		}else{
			format= new SimpleDateFormat(DATE_FORMAT);  //DATE_FORMAT = "yyyy-MM-dd"
		}
		try {
			Date date = format.parse(values[0]);
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("can not format the string :"+values[0]);
		return null;
	}

	@Override
	public String convertToString(Map context, Object o) {
		SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
		format.format(o);
		return null;
	}

}
