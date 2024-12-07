package org.dimativator.itmomadhouse.jwt;

import org.dimativator.itmomadhouse.model.Role;
import org.springframework.security.core.Authentication;

public interface UserAuthProvider {
    String createToken(String login, Role role);

    String getLoginFromJwt(String token);

    Authentication validateToken(String token);
}