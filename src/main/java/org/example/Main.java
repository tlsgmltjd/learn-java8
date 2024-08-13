package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book(1L, "스프링 레전드", true);
        Book book2 = new Book(2L, "스프링 ㅋㅋㅋㅋ", true);
        Book book3 = new Book(3L, "스프링 해라 그냥 레전드", true);
        Book book4 = new Book(4L, "스프링 진짜? 레전드", false);
        Book book5 = new Book(5L, "스프링 진짜로 레전드", false);

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        books.stream().filter(b -> b.getTitle().startsWith("스프링"))
                .forEach(b -> System.out.println(b.getTitle()));

        System.out.println();


        books.stream().filter(Predicate.not(Book::isSold))
                .forEach(b -> System.out.println(b.getTitle()));

        System.out.println();

        books.stream().map(Book::getTitle)
                .forEach(System.out::println);


        Book book10 = new Book(10L, "자바 레전드", false);
        Book book11 = new Book(11L, "자바 ㅋㅋㅋㅋ", true);
        Book book12 = new Book(12L, "자바 해라 그냥 레전드", true);
        Book book13 = new Book(13L, "자바 진짜? 레전드", false);
        Book book14 = new Book(14L, "자바 진짜로 레전드", false);

        List<Book> javaBooks = new ArrayList<>();
        javaBooks.add(book10);
        javaBooks.add(book11);
        javaBooks.add(book12);
        javaBooks.add(book13);
        javaBooks.add(book14);

        List<List<Book>> bbook = new ArrayList<>();
        bbook.add(books);
        bbook.add(javaBooks);

        System.out.println();

        // flatMap: List<List<Object>> stream에 List타입의 데이터가 흐를때 그 리스크를 각각의 요소들로 flatten 시키는 map
        bbook.stream().flatMap(list -> list.stream())
                .forEach(book -> System.out.println(book.getTitle()));

        System.out.println();

        // 10 ~ i+1... 무제한 스트림에서 앞에 10개 빼고 최대 10개까지 잘라서 출력
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println();

        boolean b1 = javaBooks.stream().anyMatch(b -> b.getTitle().contains("자바"));
        System.out.println(b1);

        System.out.println();

        List<String> 스프링 = books.stream().filter(b -> b.getTitle().contains("스프링"))
                .map(b -> b.getTitle())
                .collect(Collectors.toList());

        for (String s : 스프링) {
            System.out.println("s = " + s);
        }


    }

}
