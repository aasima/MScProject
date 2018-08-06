import java.io.Serializable;
import java.util.Date;


public class Form implements Serializable {

	/**
	 * @author Aasima Pathan
	 */
	private static final long serialVersionUID = -4487561063429770184L;

	private int id;
	private Date created;
	private int studentid;
	private int supervisorid;
	private String description;
	private String summary;
	private String progress;
	private String progressExtra;
	private String attendance;
	private String attendanceExtra;
	private int supervisoragrees;
	private int studentagrees;
	private Date due;
	private Date duedate;

	/**
	 * 
	 * @param id
	 * @param created
	 * @param studentid
	 * @param supervisorid
	 * @param description
	 * @param summary
	 * @param progress
	 * @param progressExtra
	 * @param attendance
	 * @param attendanceExtra
	 * @param studentagrees
	 * @param supervisoragrees
	 * @param due
	 * @param duedate
	 */
	public Form(int id, Date created, int studentid, int supervisorid,
			String description, String summary, String progress, String progressExtra,
			String attendance, String attendanceExtra, int studentagrees,
			int supervisoragrees, Date due, Date duedate) {
		this.id = id;
		this.created = created;
		this.studentid = studentid;
		this.supervisorid = supervisorid;
		this.description = description;
		this.summary = summary;
		this.progress = progress;
		this.setProgressExtra(progressExtra);
		this.attendance = attendance;
		this.attendanceExtra = attendanceExtra;
		this.supervisoragrees = supervisoragrees;
		this.studentagrees = studentagrees;
		this.due = due;
		this.duedate = duedate;
	}
	
	
	/**
	 * @return the created
	 */
	public java.util.Date getCreated() {
		return created;
	}
	/**
	 * @param created the created to set
	 */
	public void setCreated(java.util.Date created) {
		this.created = created;
	}
	/**
	 * @return the studentid
	 */
	public int getStudentid() {
		return studentid;
	}
	/**
	 * @param studentid the studentid to set
	 */
	public void setStudentid(int studentid) {
		this.studentid = studentid;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}
	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}
	/**
	 * @return the progress
	 */
	public String getProgress() {
		return progress;
	}
	/**
	 * @param progress the progress to set
	 */
	public void setProgress(String progress) {
		this.progress = progress;
	}
	/**
	 * @return the attendance
	 */
	public String getAttendance() {
		return attendance;
	}
	/**
	 * @param attendance the attendance to set
	 */
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	/**
	 * @return the attendanceExtra
	 */
	public String getAttendanceExtra() {
		return attendanceExtra;
	}
	/**
	 * @param attendanceExtra the attendanceExtra to set
	 */
	public void setAttendanceExtra(String attendanceExtra) {
		this.attendanceExtra = attendanceExtra;
	}
	/**
	 * @return the supervisoragrees
	 */
	public int getSupervisoragrees() {
		return supervisoragrees;
	}
	/**
	 * @param supervisoragrees the supervisoragrees to set
	 */
	public void setSupervisoragrees(int supervisoragrees) {
		this.supervisoragrees = supervisoragrees;
	}
	/**
	 * @return the studentagrees
	 */
	public int getStudentagrees() {
		return studentagrees;
	}
	/**
	 * @param studentagrees the studentagrees to set
	 */
	public void setStudentagrees(int studentagrees) {
		this.studentagrees = studentagrees;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the due
	 */
	public Date getDue() {
		return due;
	}


	/**
	 * @param due the due to set
	 */
	public void setDue(Date due) {
		this.due = due;
	}


	/**
	 * @return the duedate
	 */
	public Date getDuedate() {
		return duedate;
	}


	/**
	 * @param duedate the duedate to set
	 */
	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Form [id=" + id + ", created=" + created + ", studentid="
				+ studentid + ", supervisorid=" + supervisorid
				+ ", description=" + description + ", summary=" + summary
				+ ", progress=" + progress + ", progressExtra=" + progressExtra
				+ ", attendance=" + attendance
				+ ", attendanceExtra=" + attendanceExtra
				+ ", supervisoragrees=" + supervisoragrees + ", studentagrees="
				+ studentagrees + ", due=" + due + ", duedate=" + duedate + "]";
	}


	/**
	 * @return the progressExtra
	 */
	public String getProgressExtra() {
		return progressExtra;
	}


	/**
	 * @param progressExtra the progressExtra to set
	 */
	public void setProgressExtra(String progressExtra) {
		this.progressExtra = progressExtra;
	}
	
	
}
