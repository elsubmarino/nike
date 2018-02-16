package com.nike.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nike.dao.ColorDAO;
import com.nike.dao.ProductDAO;
import com.nike.dao.ReviewDAO;
import com.nike.dao.SizeDAO;
import com.nike.dto.Color;
import com.nike.dto.Review;
import com.nike.dto.Size;
import com.nike.vo.Criteria;
import com.nike.vo.PageMaker;

@Controller
@RequestMapping("/product/")
public class ProductController {
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	SizeDAO sizeDAO;
	
	@Autowired
	ColorDAO colorDAO;
	
	@Autowired
	ReviewDAO reviewDAO;

	@GetMapping("list")
	public String list(Criteria cri, Model model) {
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		int totalCount = productDAO.getTotalCount(cri);
		pageMaker.setTotalCount(totalCount);
		List<Object> products = productDAO.getList(cri);
		model.addAttribute("pageMaker", pageMaker);
		model.addAttribute("products", products);
		return "/product/list";
	}
	@GetMapping("read")
	public String read(Model model, int num,@ModelAttribute PageMaker pageMaker) {
		List<Object> product= productDAO.getProductDetails(num);
		List<Size> size=sizeDAO.getList(num);
		List<Color> colors=colorDAO.getList(num);
		float ratings=reviewDAO.getAverageRatings(num);
		int countOfReviews=reviewDAO.getTotalCount(num);
		model.addAttribute("product", product);
		model.addAttribute("sizes",size);
		model.addAttribute("colors",colors);
		model.addAttribute("countOfReviews",countOfReviews);
		model.addAttribute("ratings",ratings);
		return "/product/read";
	}

}
