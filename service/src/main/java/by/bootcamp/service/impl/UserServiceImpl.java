package by.bootcamp.service.impl;

import by.bootcamp.domain.Role;
import by.bootcamp.domain.User;
import by.bootcamp.domain.UserRoles;
import by.bootcamp.exception.EntityAlreadyExistException;
import by.bootcamp.exception.NoSuchEntityException;
import by.bootcamp.repository.RoleRepository;
import by.bootcamp.repository.UserRepository;
import by.bootcamp.service.UserService;
import by.bootcamp.service.request.RequestForCreateUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new NoSuchEntityException(String.format("User with this id \"%s\" not found", id)));
    }

    @Transactional
    @Override
    public void create(RequestForCreateUser request) {
        if (checkUserEmailForNotExistInDB(request)) {

            User user = mapRequestToUser(request);

            for (Role role : user.getRoles()) {

                role.getUsers().add(user);
            }

            userRepository.save(user);
        }
    }

    private boolean checkUserEmailForNotExistInDB(final RequestForCreateUser user) {

        String userEmail = user.getEmail();
        Optional<User> userByEmail = userRepository.findByEmail(userEmail);

        if (userByEmail.isPresent()) {

            throw new EntityAlreadyExistException(
                    String.format("User with this email \"%s\" already exists", userEmail));
        }

        return true;
    }

    private User mapRequestToUser(final RequestForCreateUser request) {

        User user = new User();
        user.setSurname(request.getName());
        user.setName(request.getName());
        user.setPatronymic(request.getPatronymic());
        user.setEmail(request.getEmail());
        user.setRoles(getRolesFromRequest(request));

        return user;
    }

    private Set<Role> getRolesFromRequest(final RequestForCreateUser request) {

        final Set<Role> userRoles = new HashSet<>();

        for (UserRoles role : request.getRoles()) {

            userRoles.add(roleRepository.findByRoleName(role));
        }

        return userRoles;
    }
}
