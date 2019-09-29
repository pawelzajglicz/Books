package com.zajglicz.books.service;

import java.util.List;

import com.zajglicz.books.entity.Publishier;

public interface PublishierService
{
	public List<Publishier> findAll();
	
	public Publishier findById(int theId);
	
	public void save(Publishier thePublishier);
	
	public void deleteById(int theId);
}
