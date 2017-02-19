package x3.benjamin.playground.apiserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import x3.benjamin.playground.apiserver.dto.CreateUserRequest;
import x3.benjamin.playground.apiserver.dto.CreateUserRequestValidator;
import x3.benjamin.playground.apiserver.model.User;
import x3.benjamin.playground.apiserver.service.UserService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by benjamin on 2017. 2. 14..
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private CreateUserRequestValidator userValidator;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        System.out.println("Controller Layer - users method is called");
        return userService.getUsers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Long> createUser(@RequestBody @Valid CreateUserRequest createUserRequest,
                                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            System.out.println("---- validator count : " + bindingResult.getErrorCount());
            List<ObjectError> errors = bindingResult.getAllErrors();
            for (ObjectError error : errors) {
                System.out.println(error.getObjectName() + ":" + error.getDefaultMessage());
            }
            ResponseEntity responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
            return responseEntity;
        }

        System.out.println("Controller Layer - name : " + createUserRequest.getName());

        return ResponseEntity.ok(1L);
    }


    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }
}
