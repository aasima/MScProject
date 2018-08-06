
import java.io.Serializable;



/**
 * @author Aasima Pathan
 *
 */



public class User implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8223827320877148437L;
	private int userid;
	private int usertype;
	private String username;
	private String password;
	private String first;
	private String last;
	private String email;
	
	private boolean isStudent;
	private StudentInfo studentinfo;
	
/**
 * Constructor for a User to view their details	
 * @param userid
 * @param usertype
 * @param username
 * @param first
 * @param last
 * @param email
 */
public User(int userid, int usertype, String username, String first, String last, String email){
	this.userid = userid;
	this.usertype = usertype;
	this.username = username;
	this.first = first;
	this.last = last;
	this.email = email;
}

/**
 * Constructor for an Admin to add a new user to the system's database
 * @param userid
 * @param usertype
 * @param username
 * @param password
 * @param first
 * @param last
 * @param email
 */
public User(int userid, int usertype, String username, String password, String first, String last, String email){
	this.userid = userid;
	this.usertype = usertype;
	this.username = username;
	this.password = password;
	this.first = first;
	this.last = last;
	this.email = email;
}


	/**
	 * @return the usertype
	 */
	public int getUsertype() {
		return usertype;
	}


	/**
	 * @param usertype the usertype to set
	 */
	public void setUsertype(int usertype) {
		this.usertype = usertype;
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
	 * @return the first
	 */
	public String getFirst() {
		return first;
	}


	/**
	 * @param first the first to set
	 */
	public void setFirst(String first) {
		this.first = first;
	}


	/**
	 * @return the last
	 */
	public String getLast() {
		return last;
	}


	/**
	 * @param last the last to set
	 */
	public void setLast(String last) {
		this.last = last;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the isStudent
	 */
	public boolean isStudent() {
		return isStudent;
	}


	/**
	 * @param isStudent the isStudent to set
	 */
	public void setStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}


	/**
	 * @return the studentinfo
	 */
	public StudentInfo getStudentinfo() {
		return studentinfo;
	}


	/**
	 * @param studentinfo the studentinfo to set
	 */
	public void setStudentinfo(StudentInfo studentinfo) {
		this.studentinfo = studentinfo;
	}


	/**
	 * @return the userid
	 */
	public int getUserid() {
		return userid;
	}


	/**
	 * @param userid the userid to set
	 */
	public void setUserid(int userid) {
		this.userid = userid;
	}


	@Override
	public String toString() {
		return "userid: " + userid + ", usertype: " + usertype
				+ ", username: " + username + ", password: " + password
				+ ", first: " + first + ", last: " + last + ", email: " + email
				+ ", isStudent: " + isStudent + ", studentinfo: " + studentinfo;
	}
	
	
	
}
