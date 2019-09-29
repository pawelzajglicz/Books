package com.zajglicz.books.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zajglicz.books.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer>
{

	public List<Book> findAllByOrderByTitleAsc();
	
	public List<Book> findByTitleContaining(String substring);

	//@Query("FROM ReleaseDateType AS rdt LEFT JOIN rdt.cacheMedias AS cm WHERE cm.id = ?1")
	@Query("FROM Book AS bk LEFT JOIN bk.author AS ar WHERE ar.firstName LIKE %?1%  OR ar.lastName LIKE %?1%")
	public List<Book> findByAuthorContaining(String substring);
}
