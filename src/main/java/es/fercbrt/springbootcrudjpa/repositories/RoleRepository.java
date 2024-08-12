package es.fercbrt.springbootcrudjpa.repositories;

import es.fercbrt.springbootcrudjpa.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
}
