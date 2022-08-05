package com.javatpoint.dao;

import com.javatpoint.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;


public interface  BookRepository extends JpaRepository<Book,Long> {
    default List<Book> findAllByAge(int age){

        return this.findAll().stream().filter(boo->boo.getCategory().equals(age)).collect(Collectors.toList());
    }

    default List<Book> findAllByStr(String str){
        return  this.findAll().stream().filter(boo-> boo.getTitle().contains(str)).collect(Collectors.toList());

    }
}
