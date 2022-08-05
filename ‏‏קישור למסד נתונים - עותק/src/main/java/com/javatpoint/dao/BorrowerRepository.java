package com.javatpoint.dao;

import com.javatpoint.model.Borrower;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BorrowerRepository extends JpaRepository<Borrower,Long> {

}
