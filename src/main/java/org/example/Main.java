package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // Instant, 현재 시간을 기계 시간으로 표현하는 방법
        Instant instant = Instant.now();
        System.out.println(instant); // 기준시 UTC, GMT 영국 그리니치 천문대 시간

        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);

        // LocalDateTime 인류용 시간 표현 클래스
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime of = LocalDateTime.of(2007, Month.MARCH, 1, 0, 0, 0);

        ZonedDateTime nowInKR = ZonedDateTime.now(ZoneId.of("Asia/Seoul"));
        System.out.println(nowInKR);

        // 기간 Period, Duration
        LocalDate today = LocalDate.now();
        LocalDate nextYearBirthday = LocalDate.of(2025, Month.MARCH, 1);

        Period period = Period.between(today, nextYearBirthday);
        System.out.println(period.getMonths() + " " + period.getDays());

        Period until = today.until(nextYearBirthday);
        System.out.println(until.get(ChronoUnit.DAYS));

        Instant iNow = Instant.now();
        Instant iPlus = iNow.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(iNow, iPlus);

        System.out.println(between.getSeconds());

        // MMddyyyy 포메팅 & 파싱
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter MMddyyyy = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(dateTime.format(MMddyyyy));

        LocalDate parse = LocalDate.parse("03/01/2007", MMddyyyy);
        System.out.println(parse);

        // 레거시 API 지원
        // 여러 시간 관련 타입들이 상호 변환 가능하다


    }

}
