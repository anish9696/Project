package com.Project.DocumentDao;

import com.Project.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserDao extends JpaRepository<User,String> {
    /*User getUserById(Long id);
    List<User> getAllUsers();
    User addNewUsers(UserDto userDto);*/
}
