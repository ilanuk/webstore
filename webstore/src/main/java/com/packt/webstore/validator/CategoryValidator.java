package com.packt.webstore.validator;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.packt.webstore.domain.Product;
import com.packt.webstore.exception.ProductNotFoundException;
import com.packt.webstore.service.ProductService;

@Component
public class CategoryValidator implements ConstraintValidator<Category, String>{

	@Autowired
	ProductService productService;
	
	List<String> allowedCategories;
	
	@Override
	public void initialize(Category constraintAnnotation) {
		allowedCategories = new ArrayList<>();
		allowedCategories.add("Smart Phone");
		allowedCategories.add("Tablet");
		allowedCategories.add("Laptop");
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(allowedCategories.contains(value)){
			return true;
		}
		return false;	
	}

}
