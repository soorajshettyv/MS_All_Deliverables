package com.ms.cat.jwt;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;



public class AuthTokenFilter extends OncePerRequestFilter {
	@Autowired
	private JwtUtils jwtUtils;

	@Autowired
	//private UserDetailsServiceImpl userDetailsService;

	private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			String jwt = parseJwt(request);
			if (jwt != null && jwtUtils.validateJwtToken(jwt)) {
				String username = jwtUtils.getUserNameFromJwtToken(jwt);

				//UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				//UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
				//		userDetails, null, userDetails.getAuthorities());
				List<SimpleGrantedAuthority> authorities = (List<SimpleGrantedAuthority>) jwtUtils.getAuthoritiesFromJwtToken(jwt) ;
				//Claims claims = Jwts.parser().setSigningKey("mySecretKey").parseClaimsJws(jwt).getBody();
				
				/*List<SimpleGrantedAuthority> authorities =
				        Arrays.stream(claims.get("ROLE").toString().split(","))
				            .map(SimpleGrantedAuthority::new)
				            .collect(Collectors.toList());*/
				
				System.out.println("Username: "+username);
				System.out.println("ROLES: "+Arrays.toString(authorities.toArray()));
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						 username, null, authorities.stream().collect(Collectors.toList()));
				/*UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						 username, null, Arrays.stream(claims.get("ROLE").toString().split(","))
				            .map(SimpleGrantedAuthority::new)
				            .collect(Collectors.toList()));*/
				
				
				System.out.println("authentication object: "+authentication.toString());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		} catch (Exception e) {
			logger.error("Cannot set user authentication: {}", e);
		}

		filterChain.doFilter(request, response);
	}

	private String parseJwt(HttpServletRequest request) {
		String headerAuth = request.getHeader("Authorization");

		if (StringUtils.hasText(headerAuth) && headerAuth.startsWith("Bearer ")) {
			return headerAuth.substring(7, headerAuth.length());
		}

		return null;
	}
}

