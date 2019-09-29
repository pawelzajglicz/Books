package com.zajglicz.books.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zajglicz.books.dao.BookRepository;
import com.zajglicz.books.entity.Book;

@Service
public class BookServiceImpl implements BookService
{

	private BookRepository bookRepository;

	@Autowired
	public BookServiceImpl(BookRepository theBookRepository)
	{
		bookRepository = theBookRepository;
	}

	@Override
	public List<Book> findAll()
	{
		return bookRepository.findAllByOrderByTitleAsc();
	}

	@Override
	public Book findById(int theId)
	{
		Optional<Book> result = bookRepository.findById(theId);

		Book theBook = null;
		if (result.isPresent())
		{
			theBook = result.get();
		} 
		else
		{
			throw new RuntimeException("Did not find book with id: " + theId);
		}

		return theBook;
	}

	@Override
	public void save(Book theBook)
	{
		bookRepository.save(theBook);
	}

	@Override
	public void deleteById(int theId)
	{
		bookRepository.deleteById(theId);
	}

	@Override
	public List<Book> findAllWithSubsringInTitle(String substring)
	{
		return bookRepository.findByTitleContaining(substring);
	}

	@Override
	public List<Book> findAllWithSubsringInAuthor(String substring)
	{
		return bookRepository.findByAuthorContaining(substring);
	}
}
