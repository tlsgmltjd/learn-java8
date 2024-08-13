package org.example;

public class Book {
    private Long id;
    private String title;
    private boolean isSold;

    public Book(Long id, String title, boolean isSold) {
        this.id = id;
        this.title = title;
        this.isSold = isSold;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isSold() {
        return isSold;
    }
}
