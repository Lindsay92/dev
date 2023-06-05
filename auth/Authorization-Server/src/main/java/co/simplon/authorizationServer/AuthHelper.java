package co.simplon.authorizationServer;

import java.time.Instant;
import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class AuthHelper {

    private final String issuer;
    private final long expiration;
    private final Algorithm algorithm;
    private final PasswordEncoder encoder; // interface donné par spring
					   // autority

    public AuthHelper(Builder builder) {
	this.issuer = builder.issuer;
	this.algorithm = builder.algorithm; // classe utilitaire
	this.encoder = builder.passwordEncoder;
	this.expiration = builder.expiration;
    }

    public String encode(String password) {
	return encoder.encode(password);
	// methode permettant d'encoder notre passe
    }

    public Boolean matches(String candidate, String hash) {
	return encoder.matches(candidate, hash);
	// dans le contexte du sign in
	// candidate: string du ????
	// hash: string qui vient de la bbd
	// permet de savoir si les 2 crendentials match ensemble
	// permet d'avoir un vrai ou un faux

    }

    public String createJWT(List<String> roles, String name) {
	Instant now = Instant.now();
	Instant expirationTime = now.plusSeconds(expiration);
	String[] rolesAsArray = roles.toArray(new String[roles.size()]); // création
									 // de
	// tableau car la
	// librairie qu'on
	// utilise n'accepte
	// pas les listes
	// (String[]) = un cast
	return JWT.create().withIssuer(issuer).withSubject(name)
		.withIssuedAt(now).withExpiresAt(expirationTime)
		.withArrayClaim("roles", rolesAsArray).sign(algorithm);
	// création de JWT
	// si methode matches vrai = création token
	// builder: design pattern qui permet de créer des objets complexes
	// claims principaux (4 premiers)
	// claims personnalisé = customs ligne 47
	// toujours finir avec sign(algorithm)
    }

    public static class Builder {
	private String issuer;
	private long expiration;
	private Algorithm algorithm;
	private PasswordEncoder passwordEncoder;

	public Builder() {

	}

	public Builder issuer(String issuer) {
	    this.issuer = issuer;
	    return this;
	}

	public Builder expiration(long expiration) {
	    this.expiration = expiration;
	    return this;
	}

	public Builder algorithm(Algorithm algorithm) {
	    this.algorithm = algorithm;
	    return this;
	}

	public Builder passwordEncoder(PasswordEncoder passwordEncoder) {
	    this.passwordEncoder = passwordEncoder;
	    return this;
	}

	public AuthHelper build() {
	    return new AuthHelper(this);
	}
    }
}
