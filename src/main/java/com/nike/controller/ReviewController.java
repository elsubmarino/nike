package com.nike.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nike.dao.ReviewDAO;
import com.nike.dto.Review;

@RestController
@RequestMapping("/reviews/")
public class ReviewController {

	@Autowired
	ReviewDAO reviewDAO;

	@GetMapping("read/{product_num}")
	public ResponseEntity<List<Review>> list(@PathVariable("product_num") int product_num) {
		Map<String, Object> result = new HashMap<>();
		List<Review> reviews = reviewDAO.getList(product_num);
		result.put("reviews", reviews);
		return new ResponseEntity<>(reviews, HttpStatus.OK);
	}
}
