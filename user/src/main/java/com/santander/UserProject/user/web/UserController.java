package com.santander.UserProject.user.web;

import com.santander.UserProject.user.model.User;
import com.santander.UserProject.user.model.UsersAplication;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import java.util.SortedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.TreeMap;

@RestController
@RequestMapping("/User")
public class UserController {

    private final UsersAplication usersAplication;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    public UserController() {
        this.usersAplication = new UsersAplication();
    }

    private void logNullParameters(){
        logger.error("Null parameters");
    }
    @GetMapping("/users")
    public UsersAplication getUsersAplication() {
        return usersAplication;
    }

    @GetMapping("/user")
    public SortedMap<String,User> getUser(@RequestParam String dni) {
        SortedMap<String,User> userResponse = new TreeMap<>();
        if (dni == null) {logNullParameters();}
        else {
            User user = null;
            user = usersAplication.getUser(dni);
            if (user == null) {logger.error("User not found");}
            else {
                userResponse.put(dni,user);
                logger.debug("User: {}", user);
            }
        }
        return userResponse;
    }

    @PostMapping("/addUser")
    public void addUser(@RequestBody String dni,@RequestBody String name, @RequestBody String surname) {
        if (dni == null || name == null || surname == null) {  logNullParameters();}
        else {
            User user = new User(name, surname);
            if (usersAplication.addUser(dni, user))
                logger.info("User added successfully");
            else
                logger.warn("User not added successfully");
        }
    }

    @PostMapping("/updateUser")
    public void updateUser(@RequestBody String newDni,@RequestBody String oldDni) {
        if (newDni == null || oldDni == null) {  logNullParameters();}
        else {
            if (usersAplication.updateUser(oldDni,newDni))
                logger.info("User update successfully");
            else
                logger.warn("User not update successfully");
        }
    }

    @PostMapping("/deleteUser")
    public void deleteUser(@RequestBody String dni) {
        if (dni == null) {  logNullParameters();}
        else {
            if (usersAplication.deleteUser(dni))
                logger.info("User delete successfully");
            else
                logger.warn("User not delete successfully");
        }
    }


}
