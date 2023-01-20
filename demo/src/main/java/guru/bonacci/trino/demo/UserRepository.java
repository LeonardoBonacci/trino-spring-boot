package guru.bonacci.trino.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	@Query(value = "select * from user_info where name = ?1", nativeQuery = true)
  Optional<User> findByName(String name);
	
}
