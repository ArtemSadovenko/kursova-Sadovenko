package proj.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Component
@RequiredArgsConstructor
public class JWTIssuer {
    private final JWTProperties properties;

    public String Issue(Long userId, String email, List<String> userRoles){
        return JWT.create()
                .withSubject(String.valueOf(userId))
//                .withExpiresAt(Instant.now().plus(Duration.ofHours(1)))
                .withClaim("e", email)
                .withClaim("r", userRoles)
                .sign(Algorithm.HMAC256(properties.getSecretKey()));

    }
}
