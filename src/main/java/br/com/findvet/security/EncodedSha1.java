package br.com.findvet.security;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.password.PasswordEncoder;

public class EncodedSha1 implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
	        digest.reset();
	        digest.update(((String) rawPassword).getBytes("utf8"));
	        String sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
	        return sha1;
		} catch (Exception e){
			 e.printStackTrace();
			 return "A senha não foi criptografada";
		}

	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		String sha1 = "";
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-1");
			digest.reset();
		    digest.update(((String) rawPassword).getBytes("utf8"));
		    sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	    if(encodedPassword.equals(sha1)){    
			return true;
		}
		
		return false;
	}

}
