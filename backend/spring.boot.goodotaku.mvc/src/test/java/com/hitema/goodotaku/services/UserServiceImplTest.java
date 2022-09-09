package com.hitema.goodotaku.services;

import com.hitema.goodotaku.entities.Role;
import com.hitema.goodotaku.entities.User;
import com.hitema.goodotaku.repositories.RoleRepository;
import com.hitema.goodotaku.repositories.UserRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@SpringBootTest
@TestInstance(PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceImplTest {
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setEmail("test@gmail.com");
        user.setUsername("Ravi");

        User savedUser = userRepo.save(user);

        assertNotNull(savedUser.getId());
    }

    @Test
    public void testAddRoleToNewUser() {
        Role roleAdmin = roleRepo.findByName("ROLE_ADMIN");

        User user = new User();
        user.setEmail("mikes.gates@gmail.com");
        user.setUsername("Mike");
        user.setPassword("Gates");
        user.addRole(roleAdmin);

        User savedUser = userRepo.save(user);

        assertThat(savedUser.getRoles().size()).isEqualTo(1);
    }


    @Test
    public void testFindByEmail() {
        String email = "efirst@gmail.com";
        User user = userRepo.findByEmail(email);

        assertThat(user.getEmail()).isEqualTo(email);
    }
}

