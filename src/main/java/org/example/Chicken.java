package org.example;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE_USE)
@Repeatable(ChickenContainer.class)
public @interface Chicken {
    // 자바 8에서는 어노테이션을 타입 선언부, 중복해서 사용이 가능하다

    String value();
}
