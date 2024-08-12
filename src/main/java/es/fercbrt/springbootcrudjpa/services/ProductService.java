package es.fercbrt.springbootcrudjpa.services;

import es.fercbrt.springbootcrudjpa.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Product save(Product product);

    Product update(Product product);

    void deleteById(Long id);
}
