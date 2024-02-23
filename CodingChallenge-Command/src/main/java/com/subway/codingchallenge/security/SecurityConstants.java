package com.subway.codingchallenge.security;

public class SecurityConstants {

	public static final String SECRET="nawress-rafrafi";
	public static final long EXPIRATION_TIME = 432_000_000; //5 jours : 5 * 24 * 3600 = 432 000
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "authorization";

}
