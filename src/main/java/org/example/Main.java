package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Book book2 = new Book(2L, "스프링 ㅋㅋㅋㅋ", true);
        Book book3 = new Book(3L, "스프링 해라 그냥 레전드", true);
        Book book4 = new Book(4L, "스프링 진짜? 레전드", false);
        Book book5 = new Book(5L, "스프링 진짜로 레전드", false);
        Book book1 = new Book(1L, "스프링 레전드", true);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        // 스트림 Api중 Otional을 리턴하는 종료 Operation도 있음
        Optional<Book> startWith스 = books.stream()
                .filter(b -> b.getTitle().startsWith("스"))
                .findFirst();

        boolean present = startWith스.isPresent();
        System.out.println(present);

        // .get()으로 옵셔널을 벗겨낼 수 있음
        // 만약 Optional안에 값이 없다면 예외가 발생할 여지가 있어 check가 필요하다.
        // 왠만해서는 get으로 꺼내지 않고 아래의 api로 꺼내올 수 있음
//        Book book = startWith스.get();
//        System.out.println(book.getTitle());

        startWith스.ifPresent(b -> System.out.println("isPresent : " + b.getTitle()));

        // 값이 있더라도 orElse()에 메서드를 넘긴다면 해당 메서드를 Optional의 값 유무와 관계 없이 실행시킨다.
        // 함수의 return 값을 알기 위해 함수를 실행시킨다.
        Book realBook = startWith스.orElse(Book.createNewBook());

        // orElseGet를 사용하면 Supplier를 넘기기 때문에 람다 함수를 lazy하게 다루므로 메서드 실행이 강제되지 않는다.
        Book realBook2 = startWith스.orElseGet(() -> Book.createNewBook());

        // Optional에 값이 없다면 Ex Throw
        Book realBook3 = startWith스.orElseThrow(RuntimeException::new);

        // Optional.empty() 라면 값이 나오지 않는다.
        Optional<Book> realBook4 = startWith스.filter(b -> b.getId() == 1);
        System.out.println(realBook4.isPresent());

        // map 타입을 꺼낼 수 있는 오퍼레이터도 지원한다.
        // flatMap도 지원한다.

    }

}
