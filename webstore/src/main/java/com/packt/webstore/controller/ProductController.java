package com.packt.webstore.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(Model model,@MatrixVariable(pathVar="ByCriteria") Map<String, List<String>> filterParams) {
		Set<String> keys = filterParams.keySet();
		if(filterParams.containsKey("brand") || filterParams.containsKey("category"))
			model.addAttribute("products",productService.getProductsByFilter(filterParams));
		else
			model.addAttribute("products",productService.getProductsByPriceFilter(filterParams));
		return "products";
		
	}
	
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model) {
	  model.addAttribute("product", productService.getProductById(productId));
	  return "product";
	}
	
	@RequestMapping("/{MyCategory}/{price}")
	public String getProductsByAll(Model model,@PathVariable("MyCategory") String category,@MatrixVariable(pathVar="price") Map<String, List<String>> price,@RequestParam("manufacturer") String manufacturer) {
		model.addAttribute("products",productService.getProductsByCategoryPriceManufacturer(category,price,manufacturer));
		return "products";
		
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
//	public String getAddNewProductForm(Model model) {
//	   Product newProduct = new Product();
//	   model.addAttribute("newProduct", newProduct);
// In below way, Spring automatically creates an object of type Product
// and attach it to model under the name newProduct
	public String getAddNewProductForm(@ModelAttribute("newProduct") Product newProduct) {
	   return "addProduct";
	}
	   
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewProductForm(@ModelAttribute("newProduct") Product productToBeAdded) {
	   productService.addProduct( productToBeAdded);
	   return "redirect:/products";
	}
}
