package org.example;

import java.util.Arrays;

@Chicken("양념")
@Chicken("간장")
@Chicken("후라이드")
public class Annotation {
    public static void main(String[] args) {

        Chicken[] chickens = Annotation.class.getAnnotationsByType(Chicken.class);
        Arrays.stream(chickens).forEach(c -> {
            System.out.println(c.value());
        });

        ChickenContainer chickenContainer = Annotation.class.getAnnotation(ChickenContainer.class);
        Arrays.stream(chickenContainer.value()).forEach(c -> {
            System.out.println(c.value());
        });
    }
}
