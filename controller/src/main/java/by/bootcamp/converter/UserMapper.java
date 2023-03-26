package by.bootcamp.converter;

import by.bootcamp.controller.request.RequestForCreateUser;
import by.bootcamp.controller.responce.UserResponse;
import by.bootcamp.domain.User;
import org.mapstruct.Mapper;

@Mapper(uses = RoleMapper.class)
public interface UserMapper {

    User mapToCreate(RequestForCreateUser userRequest);

    UserResponse mapToResponse(User user);
}
