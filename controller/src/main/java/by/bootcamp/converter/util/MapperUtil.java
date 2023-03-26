package by.bootcamp.converter.util;

import by.bootcamp.domain.UserRoles;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MapperUtil {

    private MapperUtil() {
    }

    public static Set<UserRoles> getUserRoles(List<String> userRoles) {

        Set<UserRoles> roles = new HashSet<>(userRoles.size());

        for (String userRole : userRoles) {

            roles.add(UserRoles.valueOf("ROLE_" + userRole.toUpperCase()));
        }

        return roles;
    }
}
