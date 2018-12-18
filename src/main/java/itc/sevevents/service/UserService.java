package itc.sevevents.service;

import itc.sevevents.repos.UserRepo;
import itc.sevevents.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    public void saveUser(User user){
        userRepo.save(user);
    }

    public void removeUser(User user){
        userRepo.delete(user);
    }

    public User getUser(User user) {
        return userRepo.getOne(user.getId());
    }
}
