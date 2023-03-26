package by.bootcamp.repository;

import by.bootcamp.domain.Role;
import by.bootcamp.domain.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRoleName(UserRoles roleNames);
}
