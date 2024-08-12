package org.example;

public class FooImpl implements Foo, Bar {

    private String name;

    public FooImpl(String name) {
        this.name = name;
    }

    @Override
    public void print() {
        System.out.println(this.name);
    }

    // 만약 implement 하는 여러 인터페이스가 있을때
    // 인터페이스들의 default 메서드명이 중복되어 있다면 컴파일에러가 발생해서 오버라이딩 해줘야함
    @Override
    public void printNameUpperCase() {
        System.out.println("FFFF");

        Foo.printAnyThing();
    }

    @Override
    public String getName() {
        return this.name;
    }
}
