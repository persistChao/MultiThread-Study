package com.answer.java8;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author answer
 * @version 1.0.0
 * @date 2020/6/9 7:32 下午
 **/
public class TestDate {
    @Test
    public void testD1() {
        Date date = new Date();
        Date date1 = new Date(1000L);
        System.out.println(date);
        System.out.println(date1.toGMTString());
    }

    @Test
    public void testLocalDate() {
        LocalDate localDate = LocalDate.of(2020, 06, 9);
        System.out.println(localDate);
        int year = localDate.getYear();
        System.out.println(year);
        System.out.println(localDate.format(DateTimeFormatter.BASIC_ISO_DATE));
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        System.out.println(dayOfWeek);
    }

    @Test
    public void testLocalDateTime() {
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);
        System.out.println(localDateTime.toLocalTime());
    }

    @Test
    public void testInstant() {
        Instant instant = Instant.now();
        System.out.println(instant);
    }

    @Test
    public void testDuration() {
       LocalDateTime localDateTime1 = LocalDateTime.of(2020, 6, 1, 10, 10);
        LocalDateTime localDateTime2 = LocalDateTime.of(2020, 6, 6, 20, 10);
        LocalDateTime l3 = LocalDateTime.of(2020, 6, 6, 20, 40);
        Duration d1 = Duration.between(l3, localDateTime2);
        Duration duration = Duration.between(localDateTime1, localDateTime2);
        long toDays = duration.toDays();
        long toHours = duration.toHours();
        long toMinite = d1.toMinutes();
        System.out.println("todays=" + toDays);
        System.out.println("toHours=" + toHours);
        System.out.println("toMinite=" + toMinite);

    }

    @Test
    public void testStopWatch() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        Thread.sleep(10000L);
        stopwatch.stop();
        System.out.println(stopwatch.elapsed().toMinutes()/60L);
    }
}
