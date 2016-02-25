package com.packt.webstore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.packt.webstore.domain.Product;
import com.packt.webstore.domain.repository.ProductRepository;

@Repository
public class InMemoryProductRepository implements ProductRepository {

	private List<Product> listOfProducts = new ArrayList<Product>();
	public InMemoryProductRepository() {
	    Product iphone = new Product("P1234","iPhone 5s", new BigDecimal(500));
	    iphone.setDescription("Apple iPhone 5s smartphone with 4.00-inch 640x1136 display and 8-megapixel rear camera");
	    iphone.setCategory("Smart Phone");
	    iphone.setManufacturer("Apple");
	    iphone.setUnitPrice(new BigDecimal(600));
	    iphone.setUnitsInStock(1000);
	    
	    Product laptop_dell = new Product("P1235","Dell Inspiron", new BigDecimal(700));
	    laptop_dell.setDescription("Dell Inspiron 14-inch Laptop (Black) with 3rd Generation Intel Core processors");
	    laptop_dell.setCategory("Laptop");
	    laptop_dell.setManufacturer("Dell");
	    laptop_dell.setUnitPrice(new BigDecimal(300));
	    laptop_dell.setUnitsInStock(1000);
	    
	    Product tablet_Nexus = new Product("P1236","Nexus 7", new BigDecimal(300));
	    tablet_Nexus.setDescription("Google Nexus 7 is the lightest 7 inch tablet With a quad-core Qualcomm Snapdragon™ S4 Pro processor");
	    tablet_Nexus.setCategory("Tablet");
	    tablet_Nexus.setManufacturer("Google");
	    tablet_Nexus.setUnitPrice(new BigDecimal(200));
	    tablet_Nexus.setUnitsInStock(1000);

	    Product ipad = new Product("P1237","iPad", new BigDecimal(500));
	    ipad.setDescription("Apple iPad with 10.00-inch 640x1136 display and 8-megapixel rear camera");
	    ipad.setCategory("Tablet");
	    ipad.setManufacturer("Apple");
	    ipad.setUnitPrice(new BigDecimal(400));
	    ipad.setUnitsInStock(1100);
	    
	    listOfProducts.add(iphone);
	    listOfProducts.add(laptop_dell);
	    listOfProducts.add(tablet_Nexus);
	    listOfProducts.add(ipad);

	  }
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return listOfProducts;
	}
	@Override
	public Product getProductById(String productId) {
	    Product productById = null;
	    
	    for(Product product : listOfProducts) {
	      if(product!=null && product.getProductId()!=null && product.getProductId().equals(productId)){
	        productById = product;
	        break;
	      }
	    }
	    
	    if(productById == null){
	      throw new IllegalArgumentException("No products found with the product id: "+ productId);
	    }
	    
	    return productById;
	}
	@Override
	public List<Product> getProductsByCategory(String category) {
	    List<Product> productsByCategory = new ArrayList<>();
	    
	    for(Product product : listOfProducts) {
	      if(product!=null && product.getCategory()!=null && product.getCategory().equalsIgnoreCase(category.replace("\"", ""))){
	    	  productsByCategory.add(product);
	      }
	    }
	    
	    if(productsByCategory.size()==0){
	      throw new IllegalArgumentException("No products found in this category: "+ category);
	    }
	    
	    return productsByCategory;	
	}
	
	@Override
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
	    Set<Product> productsByBrand = new HashSet<Product>();
	    Set<Product> productsByCategory = new HashSet<Product>();
	    
	    Set<String> criterias = filterParams.keySet();
	    
	    if(criterias.contains("brand")) {
	        for(String brandName: filterParams.get("brand")) {
	          for(Product product: listOfProducts) {
	            if(brandName.equalsIgnoreCase(product.getManufacturer())){
	              productsByBrand.add(product);
	            }
	          }
	        }
	      }
	    
	    if(criterias.contains("category")) {
	        for(String category: filterParams.get("category")) {
	          productsByCategory.addAll(this.getProductsByCategory(category));
	        }
	      }
	    productsByCategory.retainAll(productsByBrand);
	    
		return productsByCategory;
	}
	@Override
	public Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterParams) {
		
		Set<Product> productsByLow = new HashSet<Product>();
	    Set<Product> productsByHigh = new HashSet<Product>();
	    
	    Set<String> criterias = filterParams.keySet();
	    
	    if(criterias.contains("low")) {
	        for(String price: filterParams.get("low")) {
	          for(Product product: listOfProducts) {
	            if(product.getUnitPrice().intValue()>=Integer.parseInt(price)){
	              productsByLow.add(product);
	            }
	          }
	        }
	      }
	    
	    if(criterias.contains("high")) {
	        for(String price: filterParams.get("high")) {
	          for(Product product: listOfProducts) {
	            if(product.getUnitPrice().intValue()<=Integer.parseInt(price)){
	              productsByHigh.add(product);
	            }
	          }
	        }
	      }

	    productsByLow.retainAll(productsByHigh);
	    
		return productsByLow;
	}
	@Override
	public Set<Product> getProductsByCategoryPriceManufacturer(String category, Map<String, List<String>> priceParms,
			String manufacturer) {
		
		Set<Product> productsByCategory = new HashSet<Product>();
	    Set<Product> productsByPriceFilter = this.getProductsByPriceFilter(priceParms);
		Set<Product> productsByManufacturer = new HashSet<Product>();
	    
        
		productsByCategory.addAll(this.getProductsByCategory(category));
        productsByManufacturer.addAll(this.getProductsByManufacturer(manufacturer));
	    
        productsByPriceFilter.retainAll(productsByCategory);
        productsByPriceFilter.retainAll(productsByManufacturer);
	    
		return productsByPriceFilter;
	}
	@Override
	public List<Product> getProductsByManufacturer(String manufacturer) {
	    List<Product> productsByManufacturer = new ArrayList<>();
	    
	    for(Product product : listOfProducts) {
	      if(product!=null && product.getManufacturer()!=null && product.getManufacturer().equalsIgnoreCase(manufacturer.replace("\"", ""))){
	    	  productsByManufacturer.add(product);
	      }
	    }
	    
	    if(productsByManufacturer.size()==0){
	      throw new IllegalArgumentException("No products found for this manufacturer: "+ manufacturer);
	    }
	    
	    return productsByManufacturer;	
	}
	@Override
	public void addProduct(Product product) {
		listOfProducts.add(product);
	}

}
