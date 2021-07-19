package com.Project.Services;

import com.Project.DocumentDao.UserDao;
import com.Project.DocumentDao.UserDto;
import com.Project.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(String id) {
       // if(ResponseEntity<HttpStatus.OK>)
        try {
            //if (userDao.existsById(id)) {
                return userDao.findById(id).get();
            //}
        }
        catch (Exception e)
        {
            ResponseEntity.status(HttpStatus.BAD_REQUEST);
            e.printStackTrace();
            return null;
        }
    }



    @Override
    public User addNewUser(User user) {
        User user1 = new User(user.getId(),user.getBorn(),user.getEmail(),user.getFileName(),user.getFirstName(),user.getLastName(),user.getPasswordHash(),user.getPhoneNumber(),user.getUsername());
        return userDao.save(user1);
    }
    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}
