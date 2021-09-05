package br.com.til.springhateoas.service;

import java.util.List;
import java.util.Optional;

import br.com.til.springhateoas.model.Product;

public interface ProductService {
	
	List<Product> getProducts();
	
	Product addProduct(Product product);
	
	Optional<Product> getProduct(Long id);
	
	void deleteProduct(Long id);
	
	Product updateProduct(Product product);

}
