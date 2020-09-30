package com.tech314.DDDataService.rest;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech314.DDDataService.config.Constants;
import com.tech314.DDDataService.service.SecurityService;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/cipher/v1")
public class SecurityControllerImpl implements Security {
	
	@Autowired
	private SecurityService securityService;

	@PostMapping("/encrypt")
	public ResponseEntity<JSONObject> encrypt(@RequestBody String message) {
		String encrypted = securityService.encrypt(message, Constants.SALT_VALUE);
		JSONObject response = new JSONObject();
		response.put("encryptedValue", encrypted);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping("/decrypt")
	public ResponseEntity<JSONObject> decrypt(@RequestBody String message) {
		String decrypted = securityService.decrypt(message, Constants.SALT_VALUE);
		JSONObject response = new JSONObject();
		response.put("decryptedValued", decrypted);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
