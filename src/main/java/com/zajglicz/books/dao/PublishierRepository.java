package com.zajglicz.books.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zajglicz.books.entity.Publishier;

public interface PublishierRepository extends JpaRepository<Publishier, Integer>
{


}
