package es.fercbrt.springbootcrudjpa.controllers;

import es.fercbrt.springbootcrudjpa.entities.Product;
import es.fercbrt.springbootcrudjpa.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product product = productService.findById(id).orElse(null);

        if (product == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(product);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody @Valid Product product) {
        return ResponseEntity.ok(productService.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> update(@PathVariable Long id, @RequestBody @Valid Product product) {
        Optional<Product> optionalProduct = productService.update(id, product);
        return optionalProduct.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        productService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
