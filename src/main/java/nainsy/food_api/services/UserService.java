package nainsy.food_api.services;

import nainsy.food_api.database.UserRepository;
import nainsy.food_api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public int addUser(User user)
    {

      User user1= userRepository.save(user);
       return user1.getId();
    }

    public List<User> getUsers()
    {
        ArrayList<User> users= (ArrayList<User>) userRepository.findAll();
       return users;
    }
    public User getUser(int id)
    {
        return userRepository.findById(id).orElse(null);
    }
}
