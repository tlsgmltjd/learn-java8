package org.example;

public interface Foo {
    void print();

    // default 메서드
    // 인터페이스에서 메서드 시그니쳐를 선언하는것 뿐만 아니라 구현체를 제공하는 기능
    // 해당 인터페이스를 구현한 클래스들을 깨뜨리지 않고 기본적으로 제공하는 기능 확장 가능
    // @implSpec이라는 자바독 태그를 활용해서 문서화하자
    // Object가 제공하는 메서드들은 default 메서드로 정의할 수 없다. equals, hashcode
    /**
     * @implSpec 이 구현체는 getName()으로 가져온 문자열을 대문자로 바꿔서 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());

    }

    String getName();

    // 스태틱 메서드
    // 해당 타입 관련 유틸리티 메서드를 제공할 때 인터페이스에 스태틱 메서드 제공 가능
    static void printAnyThing() {
        System.out.println("정적 메서드");
    }
}
