package uni.sliit.pafproject.repository;

import uni.sliit.pafproject.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {

    List<User> findByUserType(String userType);

    @Query("{userName:?0 }")
    List<User> getsUserByUserName(String userName);

    boolean existsByUsername(String username);

}
