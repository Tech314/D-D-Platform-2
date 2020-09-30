package com.tech314.DDDataService.service;

public interface SecurityService {

	String encrypt(String message, String salt);
	String decrypt(String message, String salt);
}
