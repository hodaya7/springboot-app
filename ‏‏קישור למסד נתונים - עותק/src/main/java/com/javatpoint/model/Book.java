package com.javatpoint.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//מפתח יגדל בצורה אוטומטית    private Long id;
    private  Long id;

    private String title;
    private String author;
    private String summary;
    private  int pageCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="category_id")
    private Category category;
    @OneToMany(mappedBy = "book")
    private List<Lend> lends;
    public Book() {
    }

    public Book(Long id,String title, String author, String summary, int pageCount) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.summary = summary;
        this.pageCount = pageCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Lend> getLends() {
        return lends;
    }

    public void setLends(List<Lend> lends) {
        this.lends = lends;
    }
//    public Category getCategory() {
//        return category;
//    }

}
