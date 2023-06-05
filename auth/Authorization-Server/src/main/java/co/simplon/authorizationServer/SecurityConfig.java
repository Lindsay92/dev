package co.simplon.authorizationServer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.auth0.jwt.algorithms.Algorithm;

@Configuration // spring va lire les fichiers de config
public class SecurityConfig {

    // LIVE CODING @Bean for provide AuthHelper
    // + liens avec @Value => récupération des properties

    @Value("${itschool.auth.rounds}")
    private int rounds;
    @Value("${itschool.auth.issuer}")
    private String issuer;
    @Value("${itschool.auth.secret}")
    private String secret;
    @Value("${itschool.auth.tokenExpiration}")
    private long tokenExpiration;

    @Bean
    public AuthHelper authHelper() {
	Algorithm algorithm = Algorithm.HMAC256(secret);// algorithme fournis
							// par JWT
	PasswordEncoder encoder = new BCryptPasswordEncoder(rounds);

	return new AuthHelper.Builder().algorithm(algorithm)
		.passwordEncoder(encoder).issuer(issuer)
		.expiration(tokenExpiration).build();
    }

}