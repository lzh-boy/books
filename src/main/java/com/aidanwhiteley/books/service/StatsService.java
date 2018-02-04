package com.aidanwhiteley.books.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aidanwhiteley.books.domain.Book.Rating;
import com.aidanwhiteley.books.repository.BookRepository;
import com.aidanwhiteley.books.service.dtos.SummaryStats;

@Service
public class StatsService {
	
	@Autowired
	BookRepository bookRepository;
	
	public SummaryStats getSummaryStats() {
			
		return SummaryStats.builder(). 
			count(bookRepository.count()). 
			bookByGenre(bookRepository.countBooksByGenre()).
			booksByRating(bookRepository.countBooksByRating()).
			build();
	}

}
