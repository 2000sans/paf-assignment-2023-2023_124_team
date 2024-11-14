package uni.sliit.pafproject.service;



import uni.sliit.pafproject.externalfunctionalities.RandomIdGenerator;
import uni.sliit.pafproject.model.User;
import uni.sliit.pafproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository user_repository;
    //CRUD CREATE READ UPDATE DELETE

    public User addUser(User user){

        RandomIdGenerator obj = new RandomIdGenerator();
        String generatedUserId = obj.getGeneratedId(user.getUserType()).toString();

        user.setUserId(generatedUserId);
        user.setUserLoginState("signed-in");

        if(user.getUserPassword() == null)
            user.setUserPassword(UUID.randomUUID().toString());

        user.setUserHref("http://localhost:8080/users");
        user.setUserSelf("http://localhost:8080/users/" + generatedUserId);

        return user_repository.save(user);
    }
    public List<User> findAllUsers(){
        return user_repository.findAll();

    }

    public User getUserByUserId(String userId){
        return user_repository.findById(userId).get();
    }
    public List<User> getUserByUserType(String userType){
        return user_repository.findByUserType(userType);
    }

    public List<User> getUserByUserName(String userName){
        return user_repository.getsUserByUserName(userName);
    }
    public User updateUserDetails(User userRequest){
        User existingUser = user_repository.findById(userRequest.getUserId()).get();
        existingUser.setUserName(userRequest.getUserName());
        existingUser.setUserPassword(userRequest.getUserPassword());
        return user_repository.save(existingUser);
    }

    public String deleteUser(String userId){
        user_repository.deleteById(userId);
        return userId + " user deleted from database";
    }

    public boolean userExists(String username) {
        return user_repository.existsByUsername(username);
    }

}
