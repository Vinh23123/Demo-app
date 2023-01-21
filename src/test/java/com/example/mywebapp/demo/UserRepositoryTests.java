package com.example.mywebapp.demo;

import com.example.mywebapp.demo.user.User;
import com.example.mywebapp.demo.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.function.BooleanSupplier;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo;

    @Test
    public void testAddNew(){
        User user = new User();
        user.setEmail("Vinh.stevenson@gmail.com");
        user.setPassword("Vinh123456");
        user.setFirstname("Vinh");
        user.setLastname("Stevenson");
        User savedUser = repo.save(user);

        Assertions.assertNotNull(savedUser);
        // Asserttions.assertThat(savedUser.getid()).isGreaterThan(0);

    }
    @Test
    public void testListAll(){
        Iterable<User> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for (User user :users){
            System.out.println(user);
        }
    }


}
