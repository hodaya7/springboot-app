package com.javatpoint.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.javatpoint.model.Book;
import com.javatpoint.model.Borrower;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

public class LendDTO {
    @JsonProperty("id")
    private String id;

    @JsonProperty("borrowerId")
    private String borrowerId;
    @JsonProperty("borrowerFirstName")
    private String borrowerFirstName;
    @JsonProperty("borrowerLastName")
    private String borrowerLastName;
    @JsonProperty("bookId")
    private String bookId;
    @JsonProperty("bookTitle")
    private String bookTitle;
    //localdate??
    @JsonProperty("lendingDate")
    private LocalDate lendingDate;
    @JsonProperty("returnDate")
    private LocalDate returnDate;



  //  private Book book;


   // private Borrower borrower;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public String getBorrowerFirstName() {
        return borrowerFirstName;
    }

    public void setBorrowerFirstName(String borrowerFirstName) {
        this.borrowerFirstName = borrowerFirstName;
    }

    public String getBorrowerLastName() {
        return borrowerLastName;
    }

    public void setBorrowerLastName(String borrowerLastName) {
        this.borrowerLastName = borrowerLastName;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
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

//    public Book getBook() {
//        return book;
//    }
//
//    public void setBook(Book book) {
//        this.book = book;
//    }
//
//    public Borrower getBorrower() {
//        return borrower;
//    }
//
//    public void setBorrower(Borrower borrower) {
//        this.borrower = borrower;
//    }
}
