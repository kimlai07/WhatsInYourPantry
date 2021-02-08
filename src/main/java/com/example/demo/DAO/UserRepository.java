package com.example.demo.DAO;

import com.example.demo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@Slf4j
public class UserRepository {

    List<User> userList;

    public void saveUser(User newUser) {
        userList.add(newUser);
    }
    public UserRepository(){
        userList = new ArrayList<>();
    }

    public User getUserById(UUID userId) throws Exception {

        User requestedUser = userList.stream().filter(user ->  user.getUuid().equals(userId)).findFirst().orElseThrow(Exception::new);
        return requestedUser;
    }
}
