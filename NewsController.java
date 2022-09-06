package com.stackroute.favouriteservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

//import com.stackroute.favouriteservice.exception.NewsAlreadyExistsException;
//import com.stackroute.favouriteservice.exception.NewsNotFoundException;
import com.stackroute.favouriteservice.model.News;
import com.stackroute.favouriteservice.repository.NewsRepository;
import com.stackroute.favouriteservice.service.NewsService;

@RestController
@RequestMapping("/api/")
public class NewsController {
	
		@Autowired
		private NewsService newsservice;
		
		//Handlers
		@PostMapping("news")
		public ResponseEntity<String> save(@RequestBody News newsdb){
			this.newsservice.save(newsdb);
			return new ResponseEntity<String>("CREATED", HttpStatus.CREATED);
		}
		@GetMapping("news")
		public ResponseEntity<List<News>> getAllNewsDB(){
			List<News> list=this.newsservice.getAllNews();
			return new ResponseEntity<List<News>>(list, HttpStatus.OK);
			
		}
		//@PutMapping("news")
		//public ResponseEntity<?> updateNewsById(@RequestBody News news) {
			//List<News> list=this.newsdbservice.updateNewsById(news);
			//if(list!=null) 
				//return new ResponseEntity<List<News>>(list,HttpStatus.OK);
			//else
				//return new ResponseEntity<String>("Resource-Not-Found", HttpStatus.NOT_FOUND);
		//}
		@DeleteMapping("news/{id}")
		public ResponseEntity<?> deleteNewsDBById(@PathVariable int id) {
			boolean b=this.newsservice.deleteNewsById(id);
			if(b)
				return new ResponseEntity<Object>("SUCCESSFULLY DELETED",HttpStatus.OK);
			else
				return new ResponseEntity<Object>("Not-Found",HttpStatus.NOT_FOUND);
		}
	}

