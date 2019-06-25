package Ordermanager.Testing.controller;

import Ordermanager.Testing.entities.User;
import Ordermanager.Testing.service.UserService1;
import Ordermanager.Testing.service.UserServiceImp1;
import Ordermanager.Testing.utils.Helper;
import Ordermanager.Testing.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/registration")
public class RegistrationController {
    @Autowired
    private UserService1 userService1;
@Autowired
private UserServiceImp1 userServiceImp1;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<? extends Object> registration(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService1.registration(user), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/current")
    public Response currentUserName() {
        Helper helper = new Helper(userServiceImp1);
        return new Response("Current user information",true,helper.getUser());
    }
}
