package com.example.jspdemo.repo;

import com.example.jspdemo.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Annotates this interface as a repository
@Repository
public interface BooksRepository extends JpaRepository<Books, Long> {
}
