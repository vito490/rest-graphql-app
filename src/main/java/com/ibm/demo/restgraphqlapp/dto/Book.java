package com.ibm.demo.restgraphqlapp.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    private int id;
    private String name;
    private String isbn;

    public Book(int id, String name, String isbn) {
        this.id = id;
        this.name = name;
        this.isbn = isbn;
    }

    public Book() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Book)) return false;
        final Book other = (Book) o;
        return other.getId() == id && other.getName().equals(name) && other.getIsbn().equals(isbn);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Book;
    }

    @Override
    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object name = this.getName();
        result = result * PRIME + (name == null ? 43 : name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Book(id=" + this.getId() + ", name=" + this.getName() + ", isbn= " + isbn + ")";
    }
}
