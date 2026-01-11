// Imported required modules and packages

package com.example.jspdemo.controller;

import com.example.jspdemo.model.Books;
import com.example.jspdemo.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

// Handles web requests
@Controller
public class BooksController {

    //    Injects the BooksService to interact with book data
    @Autowired
    BooksService booksService;

    //    GET Operation (Displays the lsot of all books)
    @GetMapping({"/", "/viewBookList"})
    public String viewBookList(@ModelAttribute("message") String message, Model model) {

//        Fetches all books and then adds them to the model
        model.addAttribute("bookList", booksService.getAllBooks());
        model.addAttribute("message", message);
        return "ViewBookList";
    }

    //    PUT Operation (Shows the form to add a new book)
    @GetMapping("/addBook")
    public String addBook(@ModelAttribute("message") String message, Model model) {
//        Adds an empty book object for the form
        model.addAttribute("book", new Books());
        model.addAttribute("message", message);
        return "AddBook";
    }

    //    POST Operation (Saves a new book to the database)
    @PostMapping("/saveBook")
    public String saveBook(Books book, RedirectAttributes redirectAttributes) {
        if (booksService.saveOrUpdateBook(book)) {
            redirectAttributes.addFlashAttribute("message", "Successfully saved");
            return "redirect:/viewBookList";
        } else {
            redirectAttributes.addFlashAttribute("message", "Failed to save");
        }
        return "redirect:/addBook";
    }

    //    Shows the form to edit an existing book
    @GetMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") Long id, Model model) {
//        Adds the book to the model for editing
        model.addAttribute("book", booksService.getBook(id));
        return "EditBook";
    }

    //    Saves the edited book details
    @PostMapping("/editSaveBook")
    public String editSaveBook(Books book, RedirectAttributes redirectAttributes) {
        if (booksService.saveOrUpdateBook(book)) {
            redirectAttributes.addFlashAttribute("message", "Successfully edited");
            return "redirect:/viewBookList";
        } else {
            redirectAttributes.addFlashAttribute("message", "Failed to edit");
        }
        return "redirect:/editBook/" + book.getId();
    }

    //    DELETE Operation (Deletes a book by its ID)
    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        if (booksService.deleteBook(id)) {
            redirectAttributes.addFlashAttribute("message", "Successfully deleted");
        } else {
            redirectAttributes.addFlashAttribute("message", "Failed to delete");
        }
        return "redirect:/viewBookList";
    }
}
