package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Book book2 = new Book(2L, "스프링 ㅋㅋㅋㅋ", true);
        Book book3 = new Book(3L, "스프링 해라 그냥 레전드", true);
        Book book4 = new Book(4L, "스프링 진짜? 레전드", false);
        Book book5 = new Book(5L, "스프링 진짜로 레전드", false);

        List<Book> books = new ArrayList<>();
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        Book book1 = new Book(1L, "스프링 레전드", true);
        books.add(book1);


        if (book1.getTag().isPresent()) {
            book1.getTag().get().getTagName();
        }


    }

}
