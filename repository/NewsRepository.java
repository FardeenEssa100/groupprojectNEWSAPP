package com.stackroute.favouriteservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.favouriteservice.model.News;



public interface NewsRepository extends JpaRepository<News, Integer> 
{
	//List<News> findByUserId(String userId);
	
	//Optional<News> findByUserIdAndTitle(String userId,String getTitle  );

//	List<News> getNews( );

}
