package es.fercbrt.springbootcrudjpa.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "`user`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Size(min = 4, max = 16)
    @Column(name = "name", nullable = false, unique = true)
    private String username;
    @NotBlank
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Size(min = 8, max = 60)
    @Column(nullable = false)
    private String password;
    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @ManyToMany
    @JoinTable(
        name = "user_role",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id"),
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "role_id"})
    )
    private List<Role> roles;

    // When the attribute is a primitive boolean, the default value is false
    @Transient
    @JsonProperty("isAdmin")
    private boolean isAdmin;

    @PrePersist
    public void prePersist() {
        this.enabled = true;
    }
}
