package br.com.til.springhateoas.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.til.springhateoas.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
