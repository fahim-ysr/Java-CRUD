package com.example.jspdemo.service;

import com.example.jspdemo.model.Books;
import com.example.jspdemo.repo.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooksService {

    @Autowired
    BooksRepository books_repo;

//    Shows all the books
    public List<Books> getAllBooks() {
        List<Books> bookList= new ArrayList<>();
        books_repo.findAll().forEach(book -> bookList.add(book));

        return bookList;
    }

//    Finds a book
    public Books getBook(Long id) {
        return books_repo.findById(id).get();
    }

//  Saves or updates a book
    public boolean saveOrUpdateBook(Books book) {
        Books updatedBook = books_repo.save(book);

        // Checks if the book has been updated successfully
        if (books_repo.findById(updatedBook.getId()) != null) {
            return true;
        }
        return false;
    }

//    Delets a book
    public boolean deleteBook(Long id) {
        books_repo.deleteById(id);

        // Checks if the book exists
        if (books_repo.findById(id) != null) {
            return true;
        }
        return false;
    }
}
