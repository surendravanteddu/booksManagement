package com.booksManagement.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MultivaluedMap;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

@PreMatching
public class FilterService implements ContainerResponseFilter, ContainerRequestFilter {

	JWTTokenService jwtToken = new JWTTokenService();
	String username = null;

	@Override
	public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
		MultivaluedMap<String, Object> headers = response.getHeaders();
		headers.add("Access-Control-Allow-Origin", "*");
		headers.add("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT,OPTIONS");
		headers.add("Access-Control-Allow-Headers", "Content-Type,x-jwt-token");

		int status = response.getStatus();

		if(!request.getMethod().equals("OPTIONS")){
			if (!(status == 200 || status == 201)) {
				if (status == 401) {
					response.setEntity("unauthorized");
				}
			}
			else {
				if (username != null) {
					response.getHeaders().add("x-jwt-token", jwtToken.createJWT(username));
				}
			}	
		}else{
			response.setStatus(204);
		}
	}

	@Override
	public void filter(ContainerRequestContext request) throws IOException {

		String path = request.getUriInfo().getPath();
		List<String> openPaths = Arrays.asList("myresource");// Include all the paths that
													// does not need
													// authentication here with
													// comma separation.
													// Example:
													// Arrays.asList("samplepath1","samplePath2");

		if (!request.getMethod().equals("OPTIONS")) {
			if (path.contains("login") || path.contains("register")) {
				String json = IOUtils.toString(request.getEntityStream());
				// do whatever you need with json
				JSONObject user = new JSONObject(json);
				username = user.get("email").toString();
				// replace input stream for Jersey as we've already read it
				InputStream in = IOUtils.toInputStream(json);
				request.setEntityStream(in);
			}
			// Checks if path needs authentication.
			else if (!openPaths.contains(path) && !path.contains("validatetoken")) {
				if ((request.getHeaderString("x-jwt-token") == null
						|| !jwtToken.parseJWT(request.getHeaderString("x-jwt-token")))
						&& !request.getMethod().equals("OPTIONS")) {
					throw new NotAuthorizedException("Bearer error=\"invalid_token\"");
				} else {
					username = jwtToken.getUsernameFromToken(request.getHeaderString("x-jwt-token"));
				}
			}
		}
		return;
	}
}
