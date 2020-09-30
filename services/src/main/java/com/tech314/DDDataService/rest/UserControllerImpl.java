package com.tech314.DDDataService.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

import com.tech314.DDDataService.model.User;

public class UserControllerImpl implements UserController {

	@Override
	public ResponseEntity<User> getUser(JSONObject request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<JSONObject> authenticate(JSONObject request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<JSONObject> generateOtp(JSONObject request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<JSONObject> verifyOtp(JSONObject request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<Long> createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<User> updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<JSONObject> checkEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<JSONObject> checkUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<JSONObject> changePassword(JSONObject request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<JSONObject> checkSession(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

}
