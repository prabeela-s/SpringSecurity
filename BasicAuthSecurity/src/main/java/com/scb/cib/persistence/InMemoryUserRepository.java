package com.scb.cib.persistence;

import java.util.ArrayList;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import com.scb.cib.model.User;

public class InMemoryUserRepository implements UserRepository {

    private static AtomicLong counter = new AtomicLong();

    private final ConcurrentMap<Long, User> users = new ConcurrentHashMap<Long, User>();

    //

    @Override
    public ArrayList<User> findAll() {
    	System.out.println("inside find all");
    	if(this.users==null || this.users.isEmpty()) {
    		User user = new User();
    		user.setUsername("Rita");
    		user.setEmail("rita.tom@xyz.com");
    		
    		System.out.println("inside find all");
    		
    		
    		save(user);
    	}
    	
    	
        return (ArrayList<User>) this.users.values().stream().collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public User save(User user) {
        Long id = user.getId();
        if (id == null) {
            id = counter.incrementAndGet();
            user.setId(id);
        }
        this.users.put(id, user);
        return user;
    }

    @Override
    public User findUser(Long id) {
        return this.users.get(id);
    }

    @Override
    public void deleteUser(Long id) {
        this.users.remove(id);
    }

}
