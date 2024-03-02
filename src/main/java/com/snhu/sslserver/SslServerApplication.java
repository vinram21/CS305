package com.snhu.sslserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;  


@SpringBootApplication
public class SslServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SslServerApplication.class, args);
	}

}
//FIXME: Add route to enable check sum return of static data example:  String data = "Hello World Check Sum!";
@RestController
class ServerController{
//FIXME:  Add hash function to return the checksum value for the data string that should contain your name.    
    @RequestMapping("/hash")
    public String myHash(){
    	//String data = "Hello Vinodh Ramesh!";
    	String data = "Hello World Check Sum!";
    	Hasher hasher = new Hasher();
    	StringBuffer buffer = new StringBuffer(100);
    	buffer.append("<p>Data:<b>");
    	buffer.append(data);
    	buffer.append("</b></p><br/><p>");
    	buffer.append("SHA-256 Checksum value : <b>");
    	buffer.append(hasher.secureHash(data));
    	buffer.append("</b></p>");
        return buffer.toString();
    }
    
}

class Hasher {
	String hexString = "0123456789abcdef";

	public String secureHash(String data) {
    	// Step 1: Create object of MessageDigest class
        MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
	        
	        // Step 2: Initialize the object with an appropriate algorithm cipher
	        byte[] hashValue = md.digest(data.getBytes());
	        
	        // Step 3: Convert the hash value to hex using bytesToHex function
	        return bytesToHex(hashValue);    	
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "NoHashAvailable";
		}
    }
    
    private String bytesToHex(byte[] array) {
    	char result[] = new char[array.length * 2];
    	int pos = 0;
    	for (byte val : array) {
    		result[pos++] = hexString.charAt((val >> 4) & 15); 
    		result[pos++] = hexString.charAt(val & 15); 
    	}
    	return new String(result);
    }	
}
