package org.example;

public class Main {
    public static void main(String[] args) {
        // 익명 내부 클래스 anonymous inner class
        RunSomething runSomething = new RunSomething() {
            @Override
            public int doIt(int number) {
                return 10 + number;
            }
        };

        // 자바8 -> 람다 표현식
        RunSomething runSomething2 = (number) -> 10 + number;
    }
}