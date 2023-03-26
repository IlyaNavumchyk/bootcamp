package by.bootcamp.controller;

import by.bootcamp.controller.responce.UserResponse;
import by.bootcamp.converter.UserMapper;
import by.bootcamp.domain.User;
import by.bootcamp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

import static by.bootcamp.controller.DefaultResponseTag.USERS;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class WelcomeController {

    private static final int DEFAULT_PAGE_NUMBER = 0;
    private static final int DEFAULT_PAGE_SIZE = 10;
    private static final String DEFAULT_SORT_VALUE = "email";
    private static final Sort.Direction DEFAULT_SORT_DIRECTION = Sort.Direction.ASC;

    private final UserService userService;
    private final UserMapper userMapper;

    @GetMapping()
    public ResponseEntity<Map<String, Page<UserResponse>>> findAll() {

        return findAll(null);
    }

    @GetMapping("/{page_number}")
    public ResponseEntity<Map<String, Page<UserResponse>>> findAll(
            @PathVariable(value = "page_number", required = false) String pageNumber) {

        Pageable pageable = getPageable(pageNumber);

        Page<User> page = userService.findAll(pageable);

        return new ResponseEntity<>(
                Collections.singletonMap(USERS, page.map(userMapper::mapToResponse)),
                HttpStatus.OK);
    }

    private Pageable getPageable(String pageNumber) {

        int numberOfPage;

        if (pageNumber == null) {
            numberOfPage = DEFAULT_PAGE_NUMBER;
        } else {
            numberOfPage = Integer.parseInt(pageNumber);
        }

        return PageRequest.of(numberOfPage, DEFAULT_PAGE_SIZE, DEFAULT_SORT_DIRECTION, DEFAULT_SORT_VALUE);
    }
}
