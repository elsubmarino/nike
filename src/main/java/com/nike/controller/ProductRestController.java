package com.nike.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nike.dao.ProductDAO;
import com.nike.dao.ReviewDAO;
import com.nike.dto.Review;
import com.nike.vo.Criteria;
import com.nike.vo.PageMaker;

@RestController
@RequestMapping("/product/")
public class ProductRestController {
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	ReviewDAO reviewDAO;
	
	@PostMapping("product")
	public ResponseEntity<Map<String,Object>> list(Criteria cri) {
		System.out.println(cri.getPage()+" pageNum");
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		int totalCount = productDAO.getTotalCount(cri);
		pageMaker.setTotalCount(totalCount);
		System.out.println(cri.getStartPage()+" startPage");
		List<Object> products = productDAO.getList(cri);
		Map<String,Object> hashMap=new HashMap<>();
		hashMap.put("products", products);
		hashMap.put("pageMaker", pageMaker);
		System.out.println(hashMap+" hashMap");
		return new ResponseEntity<>(hashMap,HttpStatus.OK);
	}
	
	@PostMapping("reviews")
	public ResponseEntity<List<Review>> reveiws(@RequestParam("num") int num){
		List<Review> reviews=reviewDAO.getList(num);
		return new ResponseEntity<>(reviews,HttpStatus.OK);
	}

}
