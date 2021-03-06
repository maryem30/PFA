package stage.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import stage.entities.user;
@Repository
@CrossOrigin("*")
public interface UserRepository extends JpaRepository<user, Long>{

}
