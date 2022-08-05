package com.javatpoint.dao;

import com.javatpoint.model.Book;
import com.javatpoint.model.Lend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;


public interface LendRepository extends JpaRepository<Lend,Long> {

    default List<Lend> findAllByBookId(long bookId){

        return this.findAll().stream().filter(len->len.getBook().getId().equals(bookId)).collect(Collectors.toList());
    }

    default List<Lend> findAllByBorrowerId(long borrowerId){

        return this.findAll().stream().filter(len->len.getBorrower().getId().equals(borrowerId)).collect(Collectors.toList());
    }
}
