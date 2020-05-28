package com.scb.cib.controller;

import java.net.URI;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.scb.cib.persistence.UserRepository;
import com.scb.cib.model.User;

@Controller
@RequestMapping("/users")
public class UserController {

	
    private final UserRepository userRepository;

    //

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping(path="/view", produces = "application/json")
    public ResponseEntity<List<User>> list() {
    	System.out.println("Inside View Controller..");
    	
    	List<User> userList=this.userRepository.findAll();
    	 if (userList.isEmpty()) {
             return new ResponseEntity(HttpStatus.NO_CONTENT);
             // You many decide to return HttpStatus.NOT_FOUND
         }
         return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    	//return new ArrayList<User>(new User());
        
    }


    @GetMapping(value= "/admin")
    public ResponseEntity<String> admin() {
        System.out.println("Showing administrator page.");
        return new ResponseEntity<String>("Welcome to secure/admin page!", HttpStatus.OK);
    }
    
    
    @PostMapping(path= "/add", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addUser(@RequestBody User user) 
    {
    	this.userRepository.save(user);
         
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(user.getId())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }
}
