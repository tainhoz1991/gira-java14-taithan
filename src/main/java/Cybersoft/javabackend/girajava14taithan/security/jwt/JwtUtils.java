package Cybersoft.javabackend.girajava14taithan.security.jwt;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;

// tao token va kiem tra
@Component
@Slf4j
public class JwtUtils {
	
	@Value("${gira.security.jwt.expiration}")
	private String jwtExpiration;
	
	@Value("${gira.security.jwt.secret}")
	private String secret; // chu ky cua minh
	
	// tao mot cai token
	public String generateJwtToken(Authentication auth) {
		// lay ra nhung thong tin
		if (auth == null) {
			return null;
		}
		
		UserDetails userInfo = (UserDetails)auth.getPrincipal();
		Date now = new Date();
		
		return Jwts.builder() // cac thong tin can co de tao jwt
				.setSubject(userInfo.getUsername()) // payload
				.setIssuedAt(now)
				.setExpiration(new Date(now.getTime() + Long.parseLong(jwtExpiration)))
				.signWith(SignatureAlgorithm.HS512, secret) // header + signature
				.compact();
	}
	
	public String generateFakeJwtToken(String username) {
		Date now = new Date();
		
		return Jwts.builder() // cac thong tin can co de tao jwt
				.setSubject(username)
				.setIssuedAt(now)
				.setExpiration(new Date(now.getTime() + Long.parseLong(jwtExpiration)))
				.signWith(SignatureAlgorithm.HS512, secret)
				.compact();
	}
	
	public boolean validateJwtToken(String token) {
		try {
			// so sanh cai chu ky secret co giong chu ky token gui len khong
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (SignatureException ex) { // khong dung chu ky
			log.error("Invalid JWT signature: {}", ex.getMessage());
		} catch (ExpiredJwtException ej) { // loi het han
			log.error("JWT token is expired: {}", ej.getMessage());
		} catch (MalformedJwtException me) { // loi khong dung chuan
			log.error("JWT token invalid: {}", me.getMessage());
		} catch (IllegalArgumentException ie) { // thong tin trong token khong hop le
			log.error("JWT clamis string is empty: {}", ie.getMessage());
		} catch (UnsupportedJwtException ue) { // token khong co ho tro
			log.error("JWT is not supported: {}", ue.getMessage());
		}
		return false;
	}
	
	// lay ra cai token do request gui len nam trong Header
	public String getJwtTokenFromRequest(HttpServletRequest req) {
		String bearer = req.getHeader("Authorization");
		// truong hop nao null thi tra ve null
		if (bearer == null) {
			return null;
		}
		// neu ko null.substring -> null exception
		return bearer.substring("Bearer".length()).trim();
	}

	public String getUsernameFromToken(String token) {
		
		return Jwts.parser().setSigningKey(secret)
					.parseClaimsJws(token)
					.getBody()
					.getSubject();
	}
}
