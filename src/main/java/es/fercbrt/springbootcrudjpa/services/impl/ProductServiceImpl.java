package es.fercbrt.springbootcrudjpa.services.impl;

import es.fercbrt.springbootcrudjpa.entities.Product;
import es.fercbrt.springbootcrudjpa.repositories.ProductRepository;
import es.fercbrt.springbootcrudjpa.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Optional<Product> update(Long id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if (optionalProduct.isPresent()) {
            Product productToUpdate = optionalProduct.get();
            productToUpdate.setName(product.getName());
            productToUpdate.setPrice(product.getPrice());
            productToUpdate.setDescription(product.getDescription());
            return Optional.of(productRepository.save(productToUpdate));
        }
        return optionalProduct;
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
