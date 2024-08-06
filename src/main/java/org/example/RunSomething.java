package org.example;

@FunctionalInterface
public interface RunSomething {
    int doIt(int number);

    // 함수형 인터페이스는 추상 클래스가 하나인 인터페이스이다.
    // 다른 형태의 메서드가 있어도 상관없다.

    static void printName() {
        System.out.println("hello");
    }

    default void printAge() {
        System.out.println("hello");
    }
}
