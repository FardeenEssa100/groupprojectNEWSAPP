package com.stackroute.favouriteservice.service;

import java.util.List;

import com.stackroute.favouriteservice.model.News;
//import com.stackroute.favouriteservice.exception.NewsAlreadyExistsException;
//import com.stackroute.favouriteservice.exception.NewsNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.favouriteservice.repository.NewsRepository;

@Service
public class NewsService {
	@Autowired
	private NewsRepository newsrepository;
	
	public void save(News news) {
		this.newsrepository.save(news);
	}
	public List<News> getAllNews(){
		return this.newsrepository.findAll();
	}
	public List<News> updateNewsyId(News news){
		if(this.newsrepository.existsById(news.getUserId())) {
			this.newsrepository.save(news);
			return this.newsrepository.findAll();
		}else
			return null;
	}
	public boolean deleteNewsById(int id) {
		this.newsrepository.deleteById(id);
		return true;
	}
}


//	boolean saveNews(News news) throws NewsAlreadyExistsException;
	
	//boolean deleteNewsById(int id) throws NewsNotFoundException;
	
	//List<News> getNews(String userId) throws NewsNotFoundException;

	//List<News> getAllNews();
