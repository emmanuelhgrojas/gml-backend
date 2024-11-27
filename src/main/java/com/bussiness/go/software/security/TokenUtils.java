package com.bussiness.go.software.security;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class TokenUtils {

	private static final String ACCESS_TOKEN_SECRET = "OZPS3Ñ7J2JI4GFM3OXML3FU6JU8VPJJX4O51CEK5S86UGOHOHC";
	private static final Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000l;
	
	
	public static String createToken(String username, String email) {
		Long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1000;
		Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);
		
		Map<String, Object> payloadToken = new HashMap<>();
		payloadToken.put("username", username);
		payloadToken.put("email", email);
		
		return Jwts.builder()
				.setSubject(email)
				.setExpiration(expirationDate)
				.addClaims(payloadToken)
				.signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
				.compact();
	}
	
	public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
		try {
			Claims claims = Jwts.parserBuilder()
					.setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
					.build()
					.parseClaimsJws(token)
					.getBody();			
			String email = claims.getSubject();		
			return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
		}catch(JwtException jwtE) {
			return null;
		}
	}
	
	
	
}
