package by.bootcamp.service;

import by.bootcamp.domain.User;
import by.bootcamp.service.request.RequestForCreateUser;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(Long id);

    void create(RequestForCreateUser user);
}
