package com.example.demo.java.utils.datetime;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Days;
import org.junit.Test;

/**
 * @author: lihui
 * @date: 2020-06-22
 */
public class JodaTimeMain {

    public static final DateTimeZone TIMEZONE_US = DateTimeZone.forID("US/Eastern");
    public static final DateTimeZone TIMEZONE_HK = DateTimeZone.forID("Asia/Hong_Kong");
    public static final DateTimeZone TIMEZONE_CN = DateTimeZone.forID("Asia/Shanghai");
    public static final DateTimeZone TIMEZONE_UK = DateTimeZone.forID("Europe/London");
    public static final DateTimeZone TIMEZONE_NZ = DateTimeZone.forID("Pacific/Auckland");
    public static final DateTimeZone TIMEZONE_SI = DateTimeZone.forID("Asia/Singapore");

    public static void main(String[] args) {
    }

    @Test
    public void testNew() {
        DateTime dateTime1 = new DateTime("2020-05-02", TIMEZONE_HK);
        DateTime dateTime2 = new DateTime("2020-05-02", TIMEZONE_US);
        System.out.println(dateTime1);
        System.out.println(dateTime2);
        System.out.println(dateTime1.getMillis() + " " + dateTime2.getMillis());

        DateTime dateTime3 = new DateTime(1588392000000L, TIMEZONE_HK);
        DateTime dateTime4 = new DateTime(1588392000000L, TIMEZONE_US);
        System.out.println(dateTime3);
        System.out.println(dateTime4);
        System.out.println(dateTime3.getMillis() + " " + dateTime4.getMillis());

        DateTime dateTime5 = new DateTime("2020-05-02", TIMEZONE_HK);
        DateTime dateTime6 = new DateTime("2020-05-02", TIMEZONE_SI);
        System.out.println(dateTime5);
        System.out.println(dateTime6);
        System.out.println(dateTime5.getMillis() + " " + dateTime6.getMillis());

        DateTime now = DateTime.now();
        DateTime usNow = new DateTime(now, TIMEZONE_US);
        DateTime cnNow = new DateTime(now, TIMEZONE_CN);
        System.out.println(usNow + " " + cnNow);
        System.out.println(usNow.getMillis() + " " + cnNow.getMillis());

        now = now.withHourOfDay(9);
        System.out.println(now.getMinuteOfDay());

        DateTime dateTime = null;
        System.out.println(new DateTime(dateTime));
    }

    @Test
    public void testTimeZone() {
        DateTime now = DateTime.now();
        DateTime us = new DateTime(now, TIMEZONE_US);
        DateTime hk = new DateTime(now, TIMEZONE_HK);
        DateTime cn = new DateTime(now, TIMEZONE_CN);
        DateTime uk = new DateTime(now, TIMEZONE_UK);
        DateTime si = new DateTime(now, TIMEZONE_SI);

        System.out.println(us);
        System.out.println(hk);
        System.out.println(cn);
        System.out.println(uk);
        System.out.println(si);

        System.out.println(us.getMillis());
        System.out.println(hk.getMillis());
        System.out.println(cn.getMillis());
        System.out.println(uk.getMillis());
        System.out.println(si.getMillis());

        System.out.println(us.toDate().equals(hk.toDate()));
    }

    @Test
    public void testMinusMonthOfLastDay() {
        DateTime dateTime = new DateTime(2020, 7, 31, 12, 0);
        System.out.println(dateTime);
        System.out.println(dateTime.minusMonths(1));
    }

    @Test
    public void testDays() {
        DateTime end = DateTime.now().withTimeAtStartOfDay();
        DateTime begin = end.minusDays(2).withTimeAtStartOfDay();
        int days = Days.daysBetween(begin, end).getDays();
        System.out.println(begin + " " + end + " " + days);

        System.out.println(durationDays(begin.toDate(), end.toDate()));
    }

    @Test
    public void minus() {
        DateTime date1 = new DateTime(new DateTime("2020-02-01").toDate());
        DateTime date2 = new DateTime(new DateTime("2020-02-01T05:06").toDate());
        System.out.println(date1);
        System.out.println(date2);
        System.out.println(Days.daysBetween(date1, date2).getDays());
    }

    public static final long DAY_MILLIS = TimeUnit.DAYS.toMillis(1);

    public static long durationDays(Date date1, Date date2) {
        return Math.abs((date2.getTime() - date1.getTime()) / DAY_MILLIS);
    }

    @Test
    public void withTimeTest() {
        DateTime SIDateTime = DateTime.now(TIMEZONE_SI);
        DateTime USDateTime = DateTime.now(TIMEZONE_US);
        SIDateTime = SIDateTime.withTimeAtStartOfDay();
        USDateTime = USDateTime.withTimeAtStartOfDay();
        System.out.println(SIDateTime + " " + USDateTime);
        System.out.println(SIDateTime.getMillis() + " " + USDateTime.getMillis());
        System.out.println(new DateTime(SIDateTime, TIMEZONE_CN) + " " + new DateTime(USDateTime, TIMEZONE_CN));
        System.out.println(SIDateTime.toDate() + " " + USDateTime.toDate());
    }
}
