package com.bzcareer.monitord.core.repository;
import com.bzcareer.monitord.core.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.lang.String;
import java.util.List;

public interface UserRepository extends MongoRepository<Users,String> {

	List<Users> findByUsername(String username); 
	List<Users> findByTeam(String team);

}
