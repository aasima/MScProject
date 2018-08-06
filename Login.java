

import java.io.Serializable;




 /* Check DB for username and password match (success if true, dialogue if false)
  * If user is Student, open new Student client, etc
  */

/**
 * 
 * @author Aasima Pathan
 *
 */
public class Login implements Serializable {
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 5825668906707252344L;
	private String username;
	private String password; 

	
	public Login (String username, String encryptedPassword){
		this.setUsername(username);
		this.setPassword(encryptedPassword);
	}



	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}



	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}



	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "Login [username=" + username + ", password=" + new String(Encryption.encryptPassword(new String(password))) + "]";
	}

	

}
