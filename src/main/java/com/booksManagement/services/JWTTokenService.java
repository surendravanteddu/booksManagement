package com.booksManagement.services;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import com.booksManagement.dao.AppProps;
import com.booksManagement.util.ErrorMessages;

import java.security.Key;

import io.jsonwebtoken.*;

import java.util.Date;

public class JWTTokenService {

	private String tokenSecret = AppProps.tokenSecret;

	protected String createJWT(String username) {
		long ttlMillis = (24*60*60000);
		 
	    //The JWT signature algorithm we will be using to sign the token
	    SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	 
	    long nowMillis = System.currentTimeMillis();
	    Date now = new Date(nowMillis);
	 
	    //We will sign our JWT with our ApiKey secret
	    byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(tokenSecret);
	    Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
	 
	    //Let's set the JWT Claims
	    JwtBuilder builder = Jwts.builder().setIssuedAt(now)
	                                .setSubject(username)
	                                .signWith(signatureAlgorithm, signingKey);
	 
	    //if it has been specified, let's add the expiration
	    if (ttlMillis >= 0) {
	    long expMillis = nowMillis + ttlMillis;
	        Date exp = new Date(expMillis);
	        builder.setExpiration(exp);
	    }
	 
	    //Builds the JWT and serializes it to a compact, URL-safe string
	    return builder.compact();
	}
	
	protected boolean parseJWT(String jwt) {
		try{
		//This line will throw an exception if it is not a signed JWS (as expected)
	    Jwts.parser()         
	       .setSigningKey(DatatypeConverter.parseBase64Binary(tokenSecret))
	       .parseClaimsJws(jwt).getBody();
	    return true;
		}catch(Exception ex){
			System.out.println(ex.getMessage());
			return false;
		}
	}
	
	protected String getUsernameFromToken(String jwt){
		try{
			Claims claims = Jwts.parser()         
				       .setSigningKey(DatatypeConverter.parseBase64Binary(tokenSecret))
				       .parseClaimsJws(jwt).getBody();
			return claims.getSubject();
		}
		catch(Exception ex){
			System.out.println(ex.getMessage());
			return ErrorMessages.bad_token;
		}
	}
	
}
