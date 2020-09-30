package com.tech314.DDDataService.config;

public class Constants {
	
	// Error descriptions
	public static final String PROFILE_NOT_FOUND = "No profile found for identifier ";
	public static final String INVALID_PROFILE_TYPE = " is not a valid idType";
	public static final String INVALID_PASSWORD = "The password provided is incorrect";
	
	// Errors
	public static final String INVALID_USER_TYPE_ERROR = "invalid_user_type";
	public static final String USER_NOT_FOUND_ERROR = "user_not_found";
	public static final String INVALID_PASSWORD_ERROR = "invalid_password";
	
	// Misc
	public static final String SALT_VALUE = System.getenv("SALT_VALUE") != null ? System.getenv("SALT_VALUE") : "Do you mind?";
}
