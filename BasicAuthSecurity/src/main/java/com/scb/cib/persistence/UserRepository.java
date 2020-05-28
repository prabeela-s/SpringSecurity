package com.scb.cib.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.scb.cib.model.User;

public interface UserRepository {

	ArrayList<User> findAll();

    User save(User user);

    User findUser(Long id);

    void deleteUser(Long id);

}
