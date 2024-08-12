package es.fercbrt.springbootcrudjpa.repositories;

import es.fercbrt.springbootcrudjpa.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long>{
}
