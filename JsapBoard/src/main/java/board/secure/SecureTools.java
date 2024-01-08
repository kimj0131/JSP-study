package board.secure;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecureTools {

	public static String genHashedPassword(String password) {
		
		try {
			byte[] hashed = MessageDigest.getInstance("SHA256")
					.digest(password.getBytes());
			
			StringBuilder builder = new StringBuilder();
			
			for(byte b : hashed) {
				builder.append(String.format("%02X", b));
			}
			
			return builder.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
