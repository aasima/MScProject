

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Aasima Pathan
 *
 */
public class StudentInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2880797491742514693L;
	private int supervisorid;
	private String status;
	private Date completion;
	private String home_overseas;
	private double attendance;
	

	/**
	 * Constructor for adding a Student to database
	 * @param supervisorid
	 * @param status
	 * @param home_overseas
	 * @param attendance
	 */
	public StudentInfo(int supervisorid, String status, String home_overseas, double attendance){
		this.supervisorid = supervisorid;
		this.status = status;
		this.home_overseas = home_overseas;
		this.attendance = attendance;
	}

	/**
	 * Constructor for Student to view their details
	 * @param status
	 * @param home_overseas
	 * @param attendance
	 * @param supervisorid
	 * @param completion
	 */
	public StudentInfo(String status, String home_overseas, double attendance,
			int supervisorid, Date completion) {
		this.status = status;
		this.home_overseas = home_overseas;
		this.attendance = attendance;
		this.supervisorid = supervisorid;
		this.completion = completion;
	}

	/**
	 * @return the supervisorid
	 */
	public int getSupervisorid() {
		return supervisorid;
	}

	/**
	 * @param supervisorid the supervisorid to set
	 */
	public void setSupervisorid(int supervisorid) {
		this.supervisorid = supervisorid;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the completion
	 */
	public Date getCompletion() {
		return completion;
	}

	/**
	 * @param completion the completion to set
	 */
	public void setCompletion(Date completion) {
		this.completion = completion;
	}

	/**
	 * @return the home_overseas
	 */
	public String getHome_overseas() {
		return home_overseas;
	}

	/**
	 * @param home_overseas the home_overseas to set
	 */
	public void setHome_overseas(String home_overseas) {
		this.home_overseas = home_overseas;
	}

	/**
	 * @return the attendance
	 */
	public double getAttendance() {
		return attendance;
	}

	/**
	 * @param attendance the attendance to set
	 */
	public void setAttendance(double attendance) {
		this.attendance = attendance;
	}


	
	@Override
	public String toString() {
		return "supervisorid: " + supervisorid + ", status: "
				+ status + ", completion: " + completion + ", home_overseas: "
				+ home_overseas + ", attendance: " + attendance ;
	}
	
	
	
}