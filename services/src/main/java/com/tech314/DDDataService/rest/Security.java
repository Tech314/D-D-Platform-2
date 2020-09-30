package com.tech314.DDDataService.rest;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;

public interface Security {

	ResponseEntity<JSONObject> encrypt(String message);
	ResponseEntity<JSONObject> decrypt(String message);
}
