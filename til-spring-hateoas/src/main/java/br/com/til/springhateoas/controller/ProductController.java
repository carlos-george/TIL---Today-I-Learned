package br.com.til.springhateoas.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.til.springhateoas.model.Product;
import br.com.til.springhateoas.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getAllProducts() {
		
		List<Product> products = this.productService.getProducts();
		
		if(products.isEmpty()) {
			
			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		} else {
			for (Product product : products) {
				Long id = product.getId();
				Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getProduct(id)).withSelfRel();
				product.add(link);
			}
			return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
		}
		
	}
	
	@GetMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProduct(@PathVariable(value="id") Long id) {
		Optional<Product> product = productService.getProduct(id);
		
		if(!product.isPresent()) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		} else {
			Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(ProductController.class).getAllProducts()).withRel("lista de produtos");
			product.get().add(link);
			return new ResponseEntity<Product>(product.get(), HttpStatus.OK);
		}
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
		
		Product newProduct = productService.addProduct(product);
		
		return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);
	}

	@DeleteMapping(value="/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable(value="id") Long id) {
		
		productService.deleteProduct(id);
		return new ResponseEntity<Product>(HttpStatus.OK);
	}
}
