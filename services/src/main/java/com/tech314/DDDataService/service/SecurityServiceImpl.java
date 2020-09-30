package com.tech314.DDDataService.service;

import java.security.GeneralSecurityException;

import org.springframework.stereotype.Service;

import com.google.crypto.tink.Aead;
import com.google.crypto.tink.KeysetHandle;
import com.google.crypto.tink.aead.AeadConfig;
import com.google.crypto.tink.aead.AeadKeyTemplates;

@Service
public class SecurityServiceImpl implements SecurityService {
	
	private KeysetHandle keysetHandle;
	private Aead aead;
	
	public SecurityServiceImpl () {
		try {
			AeadConfig.register();
			keysetHandle = KeysetHandle.generateNew(AeadKeyTemplates.AES128_GCM);
			aead = keysetHandle.getPrimitive(Aead.class);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public String encrypt(String message, String salt) {
	    try {
			byte[] encrypted = aead.encrypt(message.getBytes(), salt.getBytes());
			return encrypted.toString();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public String decrypt(String message, String salt) {
		try {
			byte[] decrypted = aead.decrypt(message.getBytes(), salt.getBytes());
			return decrypted.toString();
		} catch (GeneralSecurityException e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		}
	}

}
