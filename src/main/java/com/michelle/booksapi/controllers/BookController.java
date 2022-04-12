package com.michelle.booksapi.controllers;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.michelle.booksapi.models.Book;
import com.michelle.booksapi.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books/{id}")
	public String seeBookById(@PathVariable("id") Long id, Model model) {
		Book book = bookService.findBook(id);
		model.addAttribute("book",book);
		return "show.jsp";
	}
	
//	@GetMapping("/books")
//	public String showAllBooks(Model model) {
//		List<Book> books = bookService.allBooks();
//		model.addAttribute("books",books);
//		return "home.jsp";
//	}
}
