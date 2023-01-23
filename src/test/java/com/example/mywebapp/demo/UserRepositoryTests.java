package com.example.mywebapp.demo;

import com.example.mywebapp.demo.user.User;
import com.example.mywebapp.demo.user.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;
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

        //Assertions.assertNotNull(savedUser);
        // Asserttions.assertThat(savedUser.getid()).isGreaterThan(0);

    }
    //@Test
    //public void testListAll(){
       // Iterable<User> users = repo.findAll();
        //Assertions.assertThat(users).hasSizeGreaterThan(0);

       // for (User user :users){
            //System.out.println(user);
        //}
   // }
    @Test
    public void testUpdate(){
        Integer userId = 1;
        Optional<User> optionalUser = repo.findById(userId);
        User user = optionalUser.get();
        user.setPassword("hello2002");
        repo.save(user);

        //User updatedUser = repo.findById().get();
        //Assertions.assertThat(updatedUser.getPassword()).isEqualTo("hello2000");
    }
    //@Test
    //public void testGet(){
       // Integer userId = 2;
       // Optional<User> optionalUser = repo.findById(userId);
       // Assertions.assertThat(optionalUser).isPresent();
       // System.out.println(optionalUser.get());
    //}

    @Test
    public void testDelete(){
        Integer userId = 5;
        repo.deleteById(userId);

        //Optional<User> optionalUser = repo.findById(userId);
        //Assertions.assertThat(optionalUser).isNotPresent();
    }


}
