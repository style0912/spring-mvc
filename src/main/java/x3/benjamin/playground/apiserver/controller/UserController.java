package x3.benjamin.playground.apiserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import x3.benjamin.playground.apiserver.model.User;
import x3.benjamin.playground.apiserver.service.UserService;

import java.util.List;

/**
 * Created by benjamin on 2017. 2. 14..
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        System.out.println("Controller Layer - users method is called");
        return userService.getUsers();
    }

    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    public String getUserByUserId(@PathVariable(name = "userId") Long userId,
                                  ModelMap model) {
        System.out.println("Controller Layer - users method is called");
        User rt = userService.getUsers().stream().filter(user -> user.getUserId().equals(userId)).findFirst().get();

        model.addAttribute("user", rt);
        return "user";
    }
}
