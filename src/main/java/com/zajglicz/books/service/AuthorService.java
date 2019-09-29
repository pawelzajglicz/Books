package com.zajglicz.books.service;

import java.util.List;

import com.zajglicz.books.entity.Author;

public interface AuthorService
{
	public List<Author> findAll();
	
	public Author findById(int theId);
	
	public void save(Author theAuthor);
	
	public void deleteById(int theId);
}
