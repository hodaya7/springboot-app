package com.javatpoint.model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity //כרגע המחלקה הזאת תהפך לטבלה במסד הנתונים
public class Lend {
    @Id//זה יהיה הקוד של הטבלה
    @GeneratedValue(strategy =GenerationType.AUTO)//מפתח יגדל בצורה אוטומטית    private Long id;
    private Long id;

    private LocalDate lendingDate;
    private LocalDate returnDate;


    @ManyToOne
    @JoinColumn(name = "book_id")//מפתח זר לטבלה
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="borrower_id")//מפתח זר לטבלה
    private Borrower borrower;

    public Lend() {
    }

    public Lend(Long id, LocalDate lendingDate, LocalDate returnDate) {
        this.id = id;
        this.lendingDate = lendingDate;
        this.returnDate = returnDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getLendingDate() {
        return lendingDate;
    }

    public void setLendingDate(LocalDate lendingDate) {
        this.lendingDate = lendingDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }
}
