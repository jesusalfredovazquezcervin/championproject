/**
 * @AUTHOR: RCASTANEDA - KOOMONI 2012
 * ESTO ES PA' OBTENER EL MD5 DE UNA CADENA
 */

package com.koomoni.utilerias;

import java.security.MessageDigest;

public class MD5 {
	
	private MessageDigest md5;
	
	public MD5() {
		super();
		try {
			 md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			System.out.println("ERROR AL GENERAR EL MD5");
		}
	}

	public String getMD5(String param){
		 
		md5.reset();
		md5.update(param.getBytes());
		
//		byte[] messageDigest = md5.digest();
//			
//		StringBuffer hexString = new StringBuffer();
//		for (int i=0;i<messageDigest.length;i++) {
//			hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
//		}
//		System.out.println(" md5 version is "+bytesToHex( md5.digest()));
		return bytesToHex( md5.digest());
		
	}
	
	private static String bytesToHex(byte[] b) {
	      char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7',
	                         '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	      StringBuffer buf = new StringBuffer();
	      for (int j=0; j<b.length; j++) {
	         buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
	         buf.append(hexDigit[b[j] & 0x0f]);
	      }
	      return buf.toString();
	   }


}
