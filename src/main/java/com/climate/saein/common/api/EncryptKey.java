package com.climate.saein.common.api;

import iros.pubc.cmm.util.cipher.Cipher;

public class EncryptKey {

	public String encrypt(String encType, String inData, String secKey) throws Exception {
		try {
			return Cipher.encrypt(encType, inData, secKey);
		}catch(Exception e) {
			e.getMessage();
			throw e;
		}
	}
	
	public String decrypt(String encType, String inData, String secKey) throws Exception {
		try {
			return Cipher.decrypt(encType, inData, secKey);
		}catch(Exception e) {
			e.getMessage();
			throw e;
		}
	}
	
	public String returnEncKey(String key,String parameter){
		
		String encType = "ARIA";
		String inData = parameter;
		String outData = "";
		
		try {
			
			outData = this.encrypt(encType, inData, key);
			System.out.println(outData);
			
			String temp = this.decrypt(encType, outData, key);
			System.out.println(temp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return outData;
	}
}
