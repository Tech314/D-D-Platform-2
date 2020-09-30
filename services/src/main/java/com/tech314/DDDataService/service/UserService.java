package com.tech314.DDDataService.service;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;

import com.tech314.DDDataService.model.User;

public interface UserService {

	User getUser(JSONObject request);
	User createUser(User user);
	User updateUser(User user);
	JSONObject authenticate(JSONObject request);
	JSONObject generateTempPin(JSONObject request);
	JSONObject verifyTempPin(JSONObject request);
	JSONObject checkSession(HttpServletRequest request);
}
