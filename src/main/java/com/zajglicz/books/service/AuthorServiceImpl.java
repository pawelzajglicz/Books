package com.zajglicz.books.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zajglicz.books.dao.AuthorRepository;
import com.zajglicz.books.entity.Author;

@Service
public class AuthorServiceImpl implements AuthorService
{

	private AuthorRepository authorRepository;

	@Autowired
	public AuthorServiceImpl(AuthorRepository theAuthorRepository)
	{
		authorRepository = theAuthorRepository;
	}

	@Override
	public List<Author> findAll()
	{
		return authorRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Author findById(int theId)
	{
		Optional<Author> result = authorRepository.findById(theId);

		Author theAuthor = null;
		if (result.isPresent())
		{
			theAuthor = result.get();
		} 
		else
		{
			throw new RuntimeException("Did not find book with id: " + theId);
		}

		return theAuthor;
	}

	@Override
	public void save(Author theAuthor)
	{
		authorRepository.save(theAuthor);
	}

	@Override
	public void deleteById(int theId)
	{
		authorRepository.deleteById(theId);
	}

}
