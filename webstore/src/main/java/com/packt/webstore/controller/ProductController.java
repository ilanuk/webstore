package com.packt.webstore.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.packt.webstore.domain.Product;
import com.packt.webstore.service.ProductService;

@RequestMapping("/products")
@Controller
public class ProductController {
	@Autowired
	private ProductService productService; 
	
	@RequestMapping
	public String list(Model model) {

		model.addAttribute("products", productService.getAllProducts());
	    return "products";
	}

	@RequestMapping("/all")
	public String allProducts(Model model) {
	  model.addAttribute("products", productService.getAllProducts());
	  
	return "products";
	}
	
	@RequestMapping("/{myCategoryId}")
	public String listProductsByCategory(Model model,@PathVariable("myCategoryId") String categoryId) {
		  model.addAttribute("products", productService.getProductsByCategory(categoryId));
			return "products";
	}
	
	@RequestMapping("/modelview")
	public ModelAndView allProducts() {
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("products", productService.getAllProducts());
		modelView.setViewName("products");
		return modelView;
	}

}
