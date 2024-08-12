package es.fercbrt.springbootcrudjpa.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name cannot be empty")
    @Column(name="name", nullable = false)
    private String name;

    @NotNull(message = "Price cannot be empty")
    @Column(name="price", nullable = false)
    private Float price;

    @NotEmpty(message = "Description cannot be empty")
    @Column(name="description", nullable = false)
    private String description;
}
