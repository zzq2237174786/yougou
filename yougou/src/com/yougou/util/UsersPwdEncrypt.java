package com.yougou.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.log4j.Logger;


public class UsersPwdEncrypt {
	private static Logger log = Logger.getLogger(UsersPwdEncrypt.class);
	public static byte[] pwdEncrypt(String userspwd)  {
		byte[] userspwds = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(userspwd.getBytes());
			userspwds = md.digest();
			return userspwds;
		} catch (NoSuchAlgorithmException e) {
			log.error("密码转码"+e.getMessage()+"=="+e);
		}	
		return userspwds;
	}
}
