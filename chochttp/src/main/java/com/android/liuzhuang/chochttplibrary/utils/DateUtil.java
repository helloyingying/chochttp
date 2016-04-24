package com.android.liuzhuang.chochttplibrary.utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Util about date.
 * Created by liuzhuang on 16/4/23.
 */
public class DateUtil {

    /**
     * compare the two date in format "EEE, dd MMM yyyy HH:mm:ss zzz"
     * @param dateStr dateStr date
     * @return -1 if dateStr before, 0 if equals, 1 if dateStr after.
     * @throws ParseException
     */
    public static int compareToNow(String dateStr) throws ParseException {
        DateFormat rfc1123 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        rfc1123.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = rfc1123.parse(dateStr);
        Date now = getNow();
        if (date.before(now)) {
            return -1;
        } else if (now.before(date)) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * get during time from dateStr to now
     * @param dateStr date in format "EEE, dd MMM yyyy HH:mm:ss zzz"
     * @return the during time in millis.
     * @throws ParseException
     */
    public static long getMillisFromDate(String dateStr) throws ParseException {
        DateFormat rfc1123 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US);
        rfc1123.setTimeZone(TimeZone.getTimeZone("GMT"));
        Date date = rfc1123.parse(dateStr);
        long now = System.currentTimeMillis();
        return now - date.getTime();
    }

    /**
     * get now in Date format.
     * @return
     */
    public static Date getNow() {
        Timestamp stamp = new Timestamp(System.currentTimeMillis());
        Date date = new Date(stamp.getTime());
        return date;
    }
}