package org.example;

import java.util.Objects;
import java.util.function.*;

public class Main {
    public static void main(String[] args) {
        Function<Integer, Integer> plusTen = (i) -> i + 10;
        Function<Integer, Integer> multiplyTwo = (i) -> i * 2;

        // function1.compose(function2) -> function2 and function1

        Function<Integer, Integer> multiplyTwoAndPlusTen = plusTen.compose(multiplyTwo);
        System.out.println(multiplyTwoAndPlusTen.apply(10));

        // function1.andThen(function2) -> function1 and function2

        Function<Integer, Integer> plusTenAndMultiplyTwo = plusTen.andThen(multiplyTwo);
        System.out.println(plusTenAndMultiplyTwo.apply(10));

        BiFunction<Integer, Integer, Integer> sumsum = (a, b) -> a + b;

        // Consumer 리턴값이 void이다.
        Consumer<String> logging = (i) -> System.out.println("log : " + i);
        logging.accept("hello!");

        // Supplier 파라미터를 받지 않고 반환값의 타입만 받는다. .get()
        Supplier<Integer> getting = () -> 10;
        System.out.println(getting.get());

        Predicate<String> isAdmin = (name) -> Objects.equals(name, "admin");
        System.out.println(isAdmin.test("user"));
        System.out.println(isAdmin.test("admin"));


//        Function<Integer, Integer> samesame = (i) -> i + 10;
        // Function의 입력 값의 타입과 반환 값의 타입이 같을 때 -> UnaryOperator
        UnaryOperator<Integer> samesame = (i) -> i + 10;


//        BiFunction<Integer, Integer, Integer> sumsumsame = (a, b) -> a + b;
        // BiFunction의 입력 값들의 타입과 반환 값의 타입이 같을 때 -> BinaryOperator
        BinaryOperator<Integer> sumsumsame = (a, b) -> a + b;
    }
}
