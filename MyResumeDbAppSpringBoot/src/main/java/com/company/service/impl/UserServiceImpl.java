package com.company.service.impl;

import com.company.dao.impl.UserRepositoryCustom;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author asgar
 */
@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {

    @Autowired
    @Qualifier("userDao1")
    private UserRepositoryCustom userDao2;


    @Override
//    @Cacheable("users")
    public List<User> getAll(String name, String surname, Integer nationalityId) {
        return userDao2.getAll(name, surname, nationalityId);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        return userDao2.findByEmailAndPassword(email, password);
    }

    @Override
    public User findByEmail(String email) {
        return userDao2.findByEmail(email);
    }


    public boolean updateUser(User u) {
        return userDao2.updateUser(u);
    }

    @Override
    public boolean removeUser(int id) {
        return userDao2.removeUser(id);
    }

    @Override
    public User getById(int userId) {
        return userDao2.getById(userId);
    }


    @Override
    //@CacheEvict(value = "employees", allEntries=true)       // It will clear cache when new employee save to database
    public boolean addUser(User u) {
        return userDao2.addUser(u);
    }


}
