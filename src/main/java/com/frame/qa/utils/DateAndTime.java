package com.frame.qa.utils;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This method generates & returns the run number based on the date time.
 */
public class DateAndTime      // RunNumber
{


	public static String year;
	public static String month;
	public static String day;
	public static String hour;
	public static String minute;
	public static String seconds;
	public static String mseconds;
    public static Timestamp timestamp = new Timestamp(System.currentTimeMillis());


    /**
     * This method generates the unique run number & returns it.
     * 
     * @return Returns the unique run number as String.
     */
    public static String getRunNumber()
    {
        return getTimestamp();
    }

    
    /**
     * This method generates the generates current timestamp  & returns it.
     * @return Returns the current timestamp in format Year+Month+Day+Hour+Minute+Seconds+MilliSeconds  as String.
     */
    public static String getTimestamp()
    {

    	 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
    	 year =  sdf1.format(timestamp);

        return year;
    }
    
    /**
     * @return Returns the current Year as String.
     */
    public static String getYear()
    {
    	
    	 SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy");
    	 year =  sdf1.format(timestamp);
        return year;
    }
    
    /**
     * @return Returns the current Month as String.
     */
    public static String getMonth()
    {
    	 SimpleDateFormat sdf1 = new SimpleDateFormat("MM");
    	 month =  sdf1.format(timestamp);
        return month;
    }
    
    /**
     * @return Returns the current Date as String.
     */
    public static String getDay()
    {
    	 SimpleDateFormat sdf1 = new SimpleDateFormat("dd");
    	 day =  sdf1.format(timestamp);
        return day;
    }
    
    
    /**
     * @return Returns the current Hour as String.
     */
    public static String getHour()
    {
    	 SimpleDateFormat sdf1 = new SimpleDateFormat("hh");
    	 hour =  sdf1.format(timestamp);
        return hour;
    }
    
    
    /**
     * @return Returns the current Minute as String.
     */
    public static String getMinute()
    {
    	SimpleDateFormat sdf1 = new SimpleDateFormat("mm");
    	minute =  sdf1.format(timestamp);
        return minute;
    }
    
    
    /**
     * @return Returns the current Seconds as String.
     */
    public static String getSecond()
    {
    	SimpleDateFormat sdf1 = new SimpleDateFormat("ss");
    	seconds =  sdf1.format(timestamp);
        return seconds;
    }
    
    
    /**
     * @return Returns the current Milli seconsds as String.
     */
    public static String getMillisecond()
    {
    	SimpleDateFormat sdf1 = new SimpleDateFormat("ss");
    	seconds =  sdf1.format(timestamp);
        return mseconds;
    }

    /**
     * @return Returns the current timestamp as String based on parameter provided.
     * yyyy - for YEAR
     * MM - for Month
     * dd - For Day
     * HH - for Hour
     * mm - for Minute
     * ss - for Second
     * SSS - for milli second
     *  .
     */
    public static String getTimeAnddateInFormat(String timeFormat)
    {
    	try {
        	SimpleDateFormat sdf1 = new SimpleDateFormat(timeFormat);
        	String seconds =  sdf1.format(timestamp);
        	System.out.println(seconds);
        	}catch (IllegalArgumentException e) {
    		e.printStackTrace();
    		}
        return mseconds;
    }
    
}