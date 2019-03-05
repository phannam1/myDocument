package utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HashUtils {
	public String hashmd5(String pass) {
        byte[] hash;
        String strTemp = "";
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				hash = md.digest(pass.getBytes("UTF8"));
	            strTemp = Base64.getEncoder().encodeToString(hash);
			} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
      
        return strTemp;
    }
}
