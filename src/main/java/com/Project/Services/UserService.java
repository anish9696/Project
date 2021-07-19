package com.Project.Services;

import com.Project.DocumentDao.UserDto;
import com.Project.Entity.User;

import java.util.List;

public interface UserService {
    User getUserById(String id);
    User addNewUser(User user);
    List<User> getAllUsers();
}
