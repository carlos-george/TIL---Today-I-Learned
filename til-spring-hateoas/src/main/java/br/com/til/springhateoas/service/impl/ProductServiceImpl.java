package br.com.til.springhateoas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.til.springhateoas.model.Product;
import br.com.til.springhateoas.repo.ProductRepository;
import br.com.til.springhateoas.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	
	public List<Product> getProducts() {
		
		List<Product> products = productRepository.findAll();
		
		return products;
	}


	public Product addProduct(Product product) {
		
		return productRepository.save(product);
	}


	public Optional<Product> getProduct(Long id) {
		return productRepository.findById(id);
	}


	public void deleteProduct(Long id) {

		productRepository.deleteById(id);
	}


	public Product updateProduct(Product product) {
		
		return productRepository.save(product);
	}

}
