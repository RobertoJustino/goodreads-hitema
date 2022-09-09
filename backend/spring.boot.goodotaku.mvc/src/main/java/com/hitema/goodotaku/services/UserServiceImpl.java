package com.hitema.goodotaku.services;


import com.hitema.goodotaku.entities.Role;
import com.hitema.goodotaku.entities.User;
import com.hitema.goodotaku.repositories.RoleRepository;
import com.hitema.goodotaku.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Autowired
    RoleRepository roleRepo;

    public List<User> listAll(String keyword) {
        if (keyword != null) {
            return userRepo.search(keyword);
        }
        return userRepo.findAll();
    }

    public User get(Long id) {
        return userRepo.findById(id).get();
    }

    public List<Role> listRoles() {
        return roleRepo.findAll();
    }

    public void save(User user) {
        userRepo.save(user);
    }

    public void delete(Long id) {
        userRepo.deleteById(id);
    }



}
