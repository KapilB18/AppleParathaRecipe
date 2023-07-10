package com.appleparatha.jwtutility;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtUtil {

	 @Value("${jwt.secret}")
	private String SECRET_KEY;

	public String extractUsername(String token) {
		return extractClaims(token, Claims::getSubject);
	}

	private Date extractExpiration(String token) {
		return extractClaims(token, Claims::getExpiration);
	}

	private <T> T extractClaims(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllclaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllclaims(String token) {
		return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	}

	private boolean isTokenExpired(String token) {
		// TODO Auto-generated method stub
		return extractExpiration(token).before(new Date());
	}

	public String generateToken(UserDetails userdetail) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userdetail.getUsername());
	}

	private String createToken(Map<String, Object> claims, String username) {
		
		 
		String encodedString = Base64.getEncoder().encodeToString(SECRET_KEY.getBytes());
		
		return Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
				.signWith(SignatureAlgorithm.HS256, encodedString).compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

}
