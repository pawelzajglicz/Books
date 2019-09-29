package com.zajglicz.books.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zajglicz.books.entity.Author;
import com.zajglicz.books.entity.Book;
import com.zajglicz.books.entity.Publishier;
import com.zajglicz.books.service.AuthorService;
import com.zajglicz.books.service.BookService;
import com.zajglicz.books.service.PublishierService;

@Controller
@RequestMapping("/books")
public class BookController
{
	private BookService bookService;
	private AuthorService authorService;
	private PublishierService publishierService;
	
	@Autowired
	public BookController(BookService theBookService, AuthorService theAuthorService, PublishierService thePublishierService)
	{
		bookService = theBookService;
		authorService = theAuthorService;
		publishierService = thePublishierService;
	}
	
	@GetMapping("/list")
	public String listBooks(Model theModel)
	{
		List<Book> theBooks = bookService.findAll();
		
		theModel.addAttribute("books", theBooks);
		
		return "books/list-books";
	}
	
	@GetMapping("/list_search_by_title")
	public String listBooksSearchByTitle(@RequestParam("search") String substring, Model theModel)
	{
		List<Book> theBooks = bookService.findAllWithSubsringInTitle(substring);

		theModel.addAttribute("books", theBooks);
		
		return "books/list-books";
	}
	
	@GetMapping("/list_search_by_author")
	public String listBookssearch(@RequestParam("search") String substring, Model theModel)
	{
		List<Book> theBooks = bookService.findAllWithSubsringInAuthor(substring);
		
		System.out.println("+++++++++");
		System.out.println(theBooks);
		theModel.addAttribute("books", theBooks);
		
		return "books/list-books";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		Book theBook = new Book();
		theModel.addAttribute("book", theBook);
			
		return "books/book-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int theId, Model theModel)
	{
		Book theBook = bookService.findById(theId);
		
		theModel.addAttribute("book", theBook);
		
		return "books/book-form";
	}
	
	@GetMapping("/showFormForUpdateLists")
	public String showFormForUpdateLists(@RequestParam("bookId") int theId, Model theModel)
	{
		Book theBook = bookService.findById(theId);
		
		List<Author> authors = authorService.findAll();
		List<Publishier> publishiers = publishierService.findAll();

		theModel.addAttribute("book", theBook);
		theModel.addAttribute("authors", authors);
		theModel.addAttribute("publishiers", publishiers);
		
		return "books/book-form-lists";
	}
	
	@PostMapping("/save")
	public String saveBook(@ModelAttribute("book") Book theBook)
	{
		bookService.save(theBook);
		
		return "redirect:/books/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("bookId") int theId)
	{
		bookService.deleteById(theId);
		
		return "redirect:/books/list";
	}
}
