package x3.benjamin.playground.apiserver.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import x3.benjamin.playground.apiserver.model.User;
import x3.benjamin.playground.apiserver.repository.UserRepository;
import x3.benjamin.playground.apiserver.service.UserService;

import java.util.List;

/**
 * Created by benjamin on 2017. 2. 14..
 */
@Service
public class UserServiceImpl implements UserService {

    @Value("#{system['api.log.host']}")
    private String host;

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        System.out.println("Service Layer - users method is called. api.log.host=" + host);
        return userRepository.findAll();
    }
}
