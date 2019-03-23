package com.lzj;


import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * @author lp
 * @Date 2019/3/23 14:46
 * @Version 1.0
 * Date API  基本操作
 */
public class TestDate {
    public static void main(String[] args) {


        testInstant();






    }

    public static void testLocalDateTime(){
        // LocalDateTime
        LocalDateTime ldt = LocalDateTime.now();
        // 获取系统当前时间
        System.out.println(ldt);
        LocalDateTime ldt2 = LocalDateTime.of(2019, 01, 01, 12, 12, 12, 888000000);
        // 构建LocalDateTime对象ldt
        System.out.println(ldt2);
        // 获取明年此时的时间
        LocalDateTime ldt3 = ldt.plusYears(1);
        System.out.println(ldt3);
        // 获取去年此刻时间
        LocalDateTime ldt4 = ldt.minusYears(1);
        System.out.println(ldt4);
        // 获取年
        System.out.println(ldt.getYear());
        // 获取月份
        System.out.println(ldt.getMonthValue());
        // 获取本月第某天
        System.out.println(ldt.getDayOfMonth());
        // 获取时
        System.out.println(ldt.getHour());
        // 获取分
        System.out.println(ldt.getMinute());
        // 获取秒
        System.out.println(ldt.getSecond());
        // 获取纳秒
        System.out.println(ldt.getNano());
    }

    //时间戳：以Unix元年：1970年1月1日 00:00:00 至目前时间之间的毫秒值
    public static void testInstant(){
        // 时间戳 Instant
        Instant ins1 = Instant.now();
        // 默认获取UTC时间，协调世界时
        System.out.println(ins1);
        OffsetDateTime odt = ins1.atOffset(ZoneOffset.ofHours(8));
        System.out.println(odt);

        System.out.println(ins1.toEpochMilli());

        Instant ins2 = Instant.ofEpochSecond(60);
        System.out.println(ins2);
    }

    //Duration 计算两个时间之间的间隔
    public static void testDuration(String[] args) {
        Instant ins1 = Instant.now();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant ins2 = Instant.now();
        Duration dura = Duration.between(ins1, ins2);
        System.out.println(dura.toMillis());
        System.out.println("----------------------");
        LocalTime lt1 = LocalTime.now();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalTime lt2 = LocalTime.now();
        Duration dura2 = Duration.between(lt1, lt2);
        System.out.println(dura2.toMillis());
    }


    //Period：计算两个日期之间的间隔
    public  static void testPeriod(){
        LocalDate ld1 = LocalDate.of(2015, 2, 2);
        LocalDate ld2 = LocalDate.now();
        Period period = Period.between(ld1, ld2);
        System.out.println(period);
        System.out.println("相差" + period.getYears() + "年"
                + period.getMonths() + "月"
                + period.getDays() + "天");

    }


    // 时间校正器：TemporalAdjuster
    public  static  void testTemporalAdjuster(){
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);
        LocalDateTime ldt2 = ldt.withDayOfMonth(10);
        System.out.println(ldt2);
        LocalDateTime ldt3 = ldt.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
        System.out.println(ldt3);
    }


    // 格式化日期/时间
    public  static  void testDateFormate(){
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt = LocalDateTime.now();
        String strDate = ldt.format(dtf);
        System.out.println(strDate);
        System.out.println("----------------------------");
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        String strDate2 = dtf2.format(ldt);
        System.out.println(strDate2);
        System.out.println("-----------------------------");
        LocalDateTime newDate = ldt.parse(strDate2, dtf2);
        System.out.println(newDate);
    }


    // 时区的处理
    public  static  void testTimeZone(){
        LocalDateTime ldt = LocalDateTime.now(ZoneId.of("Europe/Dublin"));
        System.out.println(ldt);
        LocalDateTime ldt2 = LocalDateTime.now(ZoneId.of("Europe/Dublin"));
        ZonedDateTime zdt = ldt2.atZone(ZoneId.of("Europe/Dublin"));
        System.out.println(zdt);
    }

}
