package ir.apk.dm.ui.util;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;

/**
 * Created by shahin on 4/29/2016 AD.
 */
public class PasswordEncryptionService {

	public boolean authenticate(String attemptedPassword, byte[] encryptedPassword, byte[] salt) {
		byte[] encryptedAttemptedPassword = new byte[0];
		encryptedAttemptedPassword = getEncryptedPassword(attemptedPassword, salt);
		return Arrays.equals(encryptedPassword, encryptedAttemptedPassword);
	}

	public byte[] getEncryptedPassword(String password, byte[] salt) {
		String algorithm = "PBKDF2WithHmacSHA1";
		int derivedKeyLength = 160;
		int iterations = 20000;
		KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, iterations, derivedKeyLength);
		SecretKeyFactory f;
		try {
			f = SecretKeyFactory.getInstance(algorithm);
			return f.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
			return null;
		}
	}

	public byte[] generateSalt() {
		SecureRandom random = null;
		byte[] salt = new byte[8];
		try {
			random = SecureRandom.getInstance("SHA1PRNG");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		assert random != null;
		random.nextBytes(salt);
		return salt;
	}

}
