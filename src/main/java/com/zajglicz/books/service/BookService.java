package com.zajglicz.books.service;

import java.util.List;

import com.zajglicz.books.entity.Book;

public interface BookService
{
	public List<Book> findAll();
	
	public List<Book> findAllWithSubsringInTitle(String substring);
	
	public List<Book> findAllWithSubsringInAuthor(String substring);
	
	public Book findById(int theId);
	
	public void save(Book theBook);
	
	public void deleteById(int theId);
}
