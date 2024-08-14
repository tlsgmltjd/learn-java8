package org.example;

import java.util.Optional;

public class Book {
    private Long id;
    private String title;
    private boolean isSold;
    private Tag tag;

    public Book(Long id, String title, boolean isSold) {
        this.id = id;
        this.title = title;
        this.isSold = isSold;
    }

    public Optional<Tag> getTag() {
        return Optional.ofNullable(tag);
    }

    public void setTag(Tag tag) {
        this.tag = tag;
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
