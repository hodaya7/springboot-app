package com.javatpoint.model;

import javax.persistence.*;
import java.util.List;

@Entity //כרגע המחלקה הזאת תהפך לטבלה במסד הנתונים
public class Category {
    @Id//זה יהיה הקוד של הטבלה
    @GeneratedValue(strategy = GenerationType.AUTO)//מפתח יגדל בצורה אוטומטית    private Long id;
    private Long id;

    private String name;
    private String description;
    private String color;

    @OneToMany(mappedBy = "category")
    private List<Book> books;

    @OneToMany(mappedBy = "category")
    private List<Borrower> borrowers;

    public Category() {
    }

    public Category(Long id, String name, String description, String color) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Borrower> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(List<Borrower> borrowers) {
        this.borrowers = borrowers;
    }
}
