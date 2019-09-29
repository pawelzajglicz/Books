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
import com.zajglicz.books.service.AuthorService;

@Controller
@RequestMapping("/authors")
public class AuthorController
{
	private AuthorService authorService;
	
	@Autowired
	public AuthorController(AuthorService theAuthorService)
	{
		authorService = theAuthorService;
	}
	
	@GetMapping("/list")
	public String listAuthors(Model theModel)
	{
		List<Author> theAuthors = authorService.findAll();
		
		theModel.addAttribute("authors", theAuthors);
		
		return "authors/list-authors";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel)
	{
		Author theAuthor = new Author();
		theModel.addAttribute("author", theAuthor);
			
		return "authors/author-form";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("authorId") int theId, Model theModel)
	{
		Author theAuthor = authorService.findById(theId);
		
		theModel.addAttribute("author", theAuthor);
		
		return "authors/author-form";
	}
	
	@PostMapping("/save")
	public String saveAuthor(@ModelAttribute("author") Author theAuthor)
	{
		authorService.save(theAuthor);
		
		return "redirect:/authors/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("authorId") int theId)
	{
		authorService.deleteById(theId);
		
		return "redirect:/authors/list";
	}
}
