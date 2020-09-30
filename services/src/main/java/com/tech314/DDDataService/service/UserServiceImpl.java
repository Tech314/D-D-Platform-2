package com.tech314.DDDataService.service;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.tech314.DDDataService.Repository.UserRepository;
import com.tech314.DDDataService.config.Constants;
import com.tech314.DDDataService.exceptions.DnDException;
import com.tech314.DDDataService.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SecurityService securityService;

	public User getUser(JSONObject request) {
		String identifier = request.getString("idType");
		User foundUser;
		if (identifier == "user_id") {
			foundUser = userRepository.findByUserId(request.getLong("idValue"));
		} else if (identifier == "user_name") {
			foundUser = userRepository.findByUserName(request.getString("idValue"));
		} else if (identifier == "email") {
			foundUser = userRepository.findByEmail(request.getString("idValue"));
		} else {
			throw new DnDException(Constants.INVALID_USER_TYPE_ERROR, HttpStatus.BAD_REQUEST, identifier + Constants.INVALID_PROFILE_TYPE);
		}
		
		if (foundUser == null) {
			throw new DnDException(Constants.USER_NOT_FOUND_ERROR, HttpStatus.NOT_FOUND, Constants.PROFILE_NOT_FOUND + request.getString("idValue"));
		} else {
			return foundUser;
		}
	}

	public JSONObject authenticate(JSONObject request) {
		JSONObject retrieveUser = new JSONObject();
		retrieveUser.put("idType", "user_name");
		retrieveUser.put("idValue", request.get("userName"));
		
		User foundUser = getUser(retrieveUser);
		if (compare(request.getString("password"), Constants.SALT_VALUE, foundUser.getUserPass(), foundUser.getUserSalt())) {
			JSONObject response = new JSONObject();
			if (foundUser.getMustChangePassword()) {
				response.put("userId", foundUser.getUserId());
			} else {
				response.put("action", "change_password");
			}
			return response;
		} else {
			throw new DnDException(Constants.INVALID_PASSWORD_ERROR, HttpStatus.BAD_REQUEST, Constants.INVALID_PASSWORD);
		}
	}

	public JSONObject generateTempPin(JSONObject request) {
		User user = getUser(request);
		Date currentDate = new Date();
		if (user.getTempPass() == null || currentDate.after(user.getTempPassExp())) {
			user.setTempPass(generatePin());
			user.setTempPassExp(currentDate);
			updateUser(user);
		}
		sendPin(user);
		
		JSONObject response = new JSONObject();
		response.put("userId", user.getUserId());
		response.put("otp_expiration", user.getTempPassExp().toString());
		return response;
	}

	public JSONObject verifyTempPin(JSONObject request) {
		// TODO Auto-generated method stub
		return null;
	}

	public User createUser(User user) {
		User persisted = userRepository.save(user);
		return persisted;
	}

	public User updateUser(User user) {
		User persisted = userRepository.save(user);
		return persisted;
	}
	
	public JSONObject checkSession(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private String generatePin() {
		String otp = "";
		Random random = new Random();
		while (otp.length() < 6) {
			otp += random.nextInt(10);
		}
		return otp;
	}
	
	private void sendPin(User user) {
		
	}
	
	private boolean compare(String messageOne, String saltOne, String messageTwo, String saltTwo) {
		return securityService.decrypt(messageOne, saltOne) == securityService.decrypt(messageTwo, saltTwo);
	}
}
