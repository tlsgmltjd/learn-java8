package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat dateFormat = new SimpleDateFormat();

        long time = date.getTime();
        System.out.println(date);
        System.out.println(time);

        Thread.sleep(1000 * 3);
        Date after3Sec = new Date();
        System.out.println(after3Sec);
        after3Sec.setTime(time);
        System.out.println(after3Sec);

// java.util.Date는 Mutable하다 = 객체의 상태를 바꿀 수 있다.
// Thread safe하지 않다.

        // GregorianCalendar의 생성자 파라미터에 month는 0이 1월이라 버그 발생의 여지가 있다. type safe하지 않다.
        Calendar calendar2 = new GregorianCalendar(2007, Calendar.APRIL, 1);

    }

}
