package com.hitema.goodotaku.services;


import com.hitema.goodotaku.entities.Role;
import com.hitema.goodotaku.entities.User;

import java.util.List;

public interface UserService {

    List<User> listAll(String keyword);

    List<Role> listRoles();

    User get(Long id);

    void save(User user);

    void delete(Long id);
}
