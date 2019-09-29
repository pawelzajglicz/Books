package com.zajglicz.books.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="title")
	private String title;
	
	/*@Column(name="author")
	private int author;*/
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="author")
	private Author author;
	
	/*@Column(name="publishier")
	private int publishier;*/
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="publishier")
	private Publishier publishier;
	
	public Book()
	{
		
	}

	@Override
	public String toString()
	{
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", publishier="
				+ publishier + "]";
	}



	/*public Book(int id, String isbn, String title, int author, int publishier)
	{
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publishier = publishier;
	}

	public Book(String isbn, String title, int author, int publishier)
	{
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publishier = publishier;
	}*/

	public Author getAuthor()
	{
		return author;
	}

	public void setAuthor(Author author)
	{
		this.author = author;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getIsbn()
	{
		return isbn;
	}

	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public Publishier getPublishier()
	{
		return publishier;
	}

	public void setPublishier(Publishier publishier)
	{
		this.publishier = publishier;
	}

	public Book(int id, String isbn, String title, Author author, Publishier publishier)
	{
		super();
		this.id = id;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publishier = publishier;
	}

	public Book(String isbn, String title, Author author, Publishier publishier)
	{
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publishier = publishier;
	}

	/*public int getAuthor()
	{
		return author;
	}

	public void setAuthor(int author)
	{
		this.author = author;
	}*/

	

	/*@Override
	public String toString()
	{
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", author=" + author + ", publishier="
				+ publishier + "]";
	}*/
	
	
}
