package com.example.wealthmanagement;

import com.example.wealthmanagement.entity.User;
import com.example.wealthmanagement.repo.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
public class UserRepositoryTests {
    @Autowired private UserRepository repo;

    @Test
    public void testAddNew(){

        User user= new User();
        user.setEmail("Rajreja@gmail.com");
        user.setPassword("raj123");
        user.setFirstName("Raj");
        user.setLastName("Reja");

        User savedUser =repo.save(user);
        Assertions.assertThat(savedUser).isNotNull();
        Assertions.assertThat(savedUser.getId()).isGreaterThan(0);
    }
    @Test
    public void testListAll(){

        Iterable<User> users = repo.findAll();
        Assertions.assertThat(users).hasSizeGreaterThan(0);

        for(User user:users){
            System.out.println(user);
        }
    }
    @Test
    public void testUpdate(){

        Integer userid=1;
        Optional<User> optionalUser=repo.findById(userid);
        User user= optionalUser.get();
        user.setPassword("Hello1234");
        repo.save(user);

        User updatedUser = repo.findById(userid).get();
        Assertions.assertThat(updatedUser.getPassword()).isEqualTo("Hello1234");

    }
    @Test
    public void testGet(){
        Integer userid=2;
        Optional<User> optionalUser=repo.findById(userid);

        Assertions.assertThat(optionalUser).isPresent();
        System.out.println(optionalUser.get());

    }
    @Test
    public void testDelete(){

        Integer userid= 2;
        repo.deleteById(userid);

        Optional<User> optionalUser= repo.findById(userid);
        Assertions.assertThat(optionalUser).isNotPresent();
    }
    @Test
    public void testFindUserByEmail(){
        String email="Rajreja@gmail.com";
        User user = repo.findByEmail(email);
        Assertions.assertThat(user).isNotNull();
    }
}
