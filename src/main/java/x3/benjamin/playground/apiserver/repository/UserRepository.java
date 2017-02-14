package x3.benjamin.playground.apiserver.repository;

import org.springframework.stereotype.Repository;
import x3.benjamin.playground.apiserver.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by benjamin on 2017. 2. 14..
 */
@Repository
public class UserRepository {

    public List<User> findAll(){

        System.out.println("Repository Layer - users method is called");
        List<User> users = new ArrayList<>();

        users.add(new User(1L, "Benjmain", "Bundang"));
        users.add(new User(2L, "Manti", "Suwon"));
        users.add(new User(3L, "Yoda", "Suwon"));
        users.add(new User(4L, "Dugi", "Seoul"));
        users.add(new User(5L, "Franky", "Bundang"));

        return users;
    }
}
