package es.fercbrt.springbootcrudjpa.repositories;

import es.fercbrt.springbootcrudjpa.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    boolean existsByUsername(String username);
}
