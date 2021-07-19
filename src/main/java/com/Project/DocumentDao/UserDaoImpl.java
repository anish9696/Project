/*
package com.Project.DocumentDao;

import com.Project.Entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class UserDaoImpl implements UserDao{

    */
/*@Override
    public User getUserById(Long id) {
        return
    }

    @Override
    public List<User> getAllUsers() {
        Query query = getEntityManager().createQuery("SELECT a FROM User a",User.class);
        return query.getResultList();
    }

    @Override
    public User addNewUsers(UserDto userDto) {
        User user = new User();
        setUserValues(user,userDto);
        getEntityManager().merge(user);
        return user;
    }

    private void setUserValues(User user,UserDto userDto)
    {
        user.setUsername(userDto.getUsername());
        if(userDto.getPasswordHash()!=null && !userDto.getPasswordHash().isEmpty())
        {
            user.setPasswordHash(userDto.getPasswordHash());
        }
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPhoneNumber(Long.parseLong(userDto.getPhoneNumber()));
        user.setBorn(userDto.getBirthDate());
        user.setFileName(userDto.getFileName());
    }*//*


}
*/
