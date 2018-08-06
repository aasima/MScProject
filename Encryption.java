import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * 
 * @author Aasima Pathan
 * Code taken from:
 * @author http://stackoverflow.com/a/9071224
 * last accessed on 01/08/2014 at 10:00
 */

public class Encryption {

	 
	 public static String encryptPassword(String password)
	 {
	     String sha1 = "";
	     try
	     {
	         MessageDigest crypt = MessageDigest.getInstance("SHA-1");
	         crypt.reset();
	         crypt.update(password.getBytes("UTF-8"));
	         sha1 = byteToHex(crypt.digest());
	     }
	     catch(NoSuchAlgorithmException e)
	     {
	         e.printStackTrace();
	     }
	     catch(UnsupportedEncodingException e)
	     {
	         e.printStackTrace();
	     }
	     return sha1;
	 }

	 public static String byteToHex(final byte[] hash)
	 {
	     Formatter formatter = new Formatter();
	     for (byte b : hash)
	     {
	         formatter.format("%02x", b);
	     }
	     String result = formatter.toString();
	     formatter.close();
	     return result;
	 }

	 
	 
	 
	/* public static void main(String[]args){
		 
		 // Testing the encryption method
		 
		 String p = "test";
		 String q = "test";
		 
		 String a = Encryption.encryptPassword(p);
		 String b = Encryption.encryptPassword(q);
		 
		System.out.println(Encryption.encryptPassword(p));
		System.out.println(Encryption.encryptPassword(q));
		
		// CompareTo method can be used to see if password is correct
		  
		System.out.println(a.compareTo(b)); // '0' means equal
		
		
	 }*/

}