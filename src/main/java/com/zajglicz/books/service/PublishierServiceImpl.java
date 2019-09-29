package com.zajglicz.books.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zajglicz.books.dao.PublishierRepository;
import com.zajglicz.books.entity.Publishier;

@Service
public class PublishierServiceImpl implements PublishierService
{

	private PublishierRepository publishierRepository;

	@Autowired
	public PublishierServiceImpl(PublishierRepository thePublishierRepository)
	{
		publishierRepository = thePublishierRepository;
	}

	@Override
	public List<Publishier> findAll()
	{
		return publishierRepository.findAll();
	}

	@Override
	public Publishier findById(int theId)
	{
		Optional<Publishier> result = publishierRepository.findById(theId);

		Publishier thePublishier = null;
		if (result.isPresent())
		{
			thePublishier = result.get();
		} 
		else
		{
			throw new RuntimeException("Did not find publishier with id: " + theId);
		}

		return thePublishier;
	}

	@Override
	public void save(Publishier thePublishier)
	{
		publishierRepository.save(thePublishier);
	}

	@Override
	public void deleteById(int theId)
	{
		publishierRepository.deleteById(theId);
	}

}
