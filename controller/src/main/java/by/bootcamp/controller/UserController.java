package by.bootcamp.controller;

import by.bootcamp.controller.request.RequestForCreateUser;
import by.bootcamp.converter.UserMapper;
import by.bootcamp.domain.User;
import by.bootcamp.domain.UserRoles;
import by.bootcamp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collections;

import static by.bootcamp.controller.DefaultResponseTag.USER;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public ResponseEntity<Object> createUser(@RequestBody @Valid RequestForCreateUser request) {

        User user = userMapper.mapToCreate(request);

        UserRoles roleName = UserRoles.valueOf("ROLE_" + request.getRole().toUpperCase());

        user = userService.create(user, roleName);

        return new ResponseEntity<>(
                Collections.singletonMap(USER, userMapper.mapToResponse(user)),
                HttpStatus.OK
        );
    }
}

