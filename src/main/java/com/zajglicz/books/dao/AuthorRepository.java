package com.zajglicz.books.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zajglicz.books.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer>
{

	public List<Author> findAllByOrderByLastNameAsc();
}
