package com.tech314.DDDataService.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

import com.tech314.DDDataService.model.User;

public interface UserController {
	
	ResponseEntity<User> getUser(JSONObject request);
	ResponseEntity<JSONObject> authenticate(JSONObject request);
	ResponseEntity<JSONObject> generateOtp(JSONObject request);
	ResponseEntity<JSONObject> verifyOtp(JSONObject request);
	
	ResponseEntity<Long> createUser(User user);
	ResponseEntity<User> updateUser(User user);
	ResponseEntity<JSONObject> changePassword(JSONObject request);
	
	ResponseEntity<JSONObject> checkEmail(String email);
	ResponseEntity<JSONObject> checkUserName(String userName);
	ResponseEntity<JSONObject> checkSession(HttpServletRequest request, HttpServletResponse response);

}
