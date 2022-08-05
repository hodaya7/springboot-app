package com.javatpoint.dao;

import com.javatpoint.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.stream.Collectors;


public interface  BookRepository extends JpaRepository<Book,Long> {
     //ממשק שמכיל את כל הפעולות הבסיסיות של crud
    default List<Book> findAllByAge(int age){

        //this -הרפוזיטורי
        return this.findAll().stream().filter(boo->boo.getCategory().equals(age)).collect(Collectors.toList());
    }

    default List<Book> findAllByStr(String str){
        return  this.findAll().stream().filter(boo-> boo.getTitle().contains(str)).collect(Collectors.toList());

    }
}
