//package com.cts.configuration;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.cts.service.CustomerServiceImpl;
//
////import com.cts.bms.service.JwtUserDetailsService;
//
//import io.jsonwebtoken.ExpiredJwtException;
//
//
//@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//	@Autowired
//	private CustomerServiceImpl customerServiceImpl;
//
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
//
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
//			throws ServletException, IOException {
//
//		final String requestTokenHeader = request.getHeader("Authorization");
//
//		String username = null;
//		String jwtToken = null;
//		// JWT Token is in the form "Bearer token". Remove Bearer word and get only the Token
//		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
//			jwtToken = requestTokenHeader.substring(7);
//			try {
//				username = jwtTokenUtil.getUsernameFromToken(jwtToken);
//			} catch (IllegalArgumentException e) {
//				System.out.println("Unable to get JWT Token");
//			} catch (ExpiredJwtException e) {
//				System.out.println("JWT Token has expired");
//			}
//		} else {
//			logger.warn("JWT Token does not begin with Bearer String");
//		}
//
//		//Once we get the token validate it.
//				if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//
//					UserDetails userDetails = this.customerServiceImpl.loadUserByUsername(username);
//
//					// if token is valid configure Spring Security to manually set authentication
//					if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
//
//						UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
//								userDetails, null, userDetails.getAuthorities());
//						usernamePasswordAuthenticationToken
//								.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//						// After setting the Authentication in the context, we specify
//						// that the current user is authenticated. So it passes the Spring Security Configurations successfully.
//						SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//					}
//				}
//				chain.doFilter(request, response);
//			}
//
//		}
//
//
//
////package com.cts.configuration;
////import io.jsonwebtoken.ExpiredJwtException;
////import io.jsonwebtoken.SignatureException;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
////import org.springframework.security.core.authority.SimpleGrantedAuthority;
////import org.springframework.security.core.context.SecurityContextHolder;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.core.userdetails.UserDetailsService;
////import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
////import org.springframework.web.filter.OncePerRequestFilter;
////import javax.servlet.FilterChain;
////import javax.servlet.ServletException;
////import javax.servlet.http.HttpServletRequest;
////import javax.servlet.http.HttpServletResponse;
////
////import static com.cts.configuration.SecurityConstants.HEADER_STRING;
////import static com.cts.configuration.SecurityConstants.TOKEN_PREFIX;
////
////import java.io.IOException;
////import java.util.Arrays;
////
/////*
//// Unlike Normal Servlet Filters, OncePerRequestFilter prevents this behavior. 
//// For our one request, this filter will execute exactly one time (no more no less). 
//// This behavior is very useful while working with security authentication.
//// */
////public class JwtAuthenticationFilter extends OncePerRequestFilter {
////
////	@Autowired
////	private UserDetailsService userDetailsService;
////
////	@Autowired
////	private JwtTokenUtil jwtTokenUtil;
////
////	@Override
////	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
////			throws IOException, ServletException {
////		String header = req.getHeader(HEADER_STRING);
////		String username = null;
////		String authToken = null;
////		if (header != null && header.startsWith(TOKEN_PREFIX)) {
////			authToken = header.replace(TOKEN_PREFIX, "");
////			try {
////				username = jwtTokenUtil.getUsernameFromToken(authToken);
////			} catch (IllegalArgumentException e) {
////				logger.error("an error occured during getting username from token", e);
////			} catch (ExpiredJwtException e) {
////				logger.warn("the token is expired and not valid anymore", e);
////			} catch (SignatureException e) {
////				logger.error("Authentication Failed. Username or Password not valid.");
////			}
////		} else {
////			logger.warn("couldn't find bearer string, will ignore the header");
////		}
////		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
////
////			UserDetails userDetails = userDetailsService.loadUserByUsername(username);
////
////			if (jwtTokenUtil.validateToken(authToken, userDetails)) {
////				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
////						userDetails, null, Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
////				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
////				logger.info("authenticated user " + username + ", setting security context");
////				SecurityContextHolder.getContext().setAuthentication(authentication);
////			}
////		}
////
////		chain.doFilter(req, res);
////	}
////
////}
////
