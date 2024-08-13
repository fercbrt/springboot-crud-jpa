package es.fercbrt.springbootcrudjpa.repositories;

import es.fercbrt.springbootcrudjpa.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
    Optional<Role> findByName(String name);
}
