
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Aasima Pathan
 *
 */
public class Visa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1209823431676094356L;
	private String visanumber;
	private Date start;
	private Date expiry;
	private String sponsor;
	
	public Visa (){
		this.visanumber = null;
		this.start = null;
		this.expiry = null;
		this.sponsor = null;
		
		
	}
	public Visa (String visanumber, Date start, Date expiry, String sponsor){
		this.visanumber = visanumber;
		this.start = start;
		this.expiry = expiry;
		this.sponsor = sponsor;
	}

	/**
	 * @return the visanumber
	 */
	public String getVisanumber() {
		return visanumber;
	}

	/**
	 * @param visanumber the visanumber to set
	 */
	public void setVisanumber(String visanumber) {
		this.visanumber = visanumber;
	}

	/**
	 * @return the start
	 */
	public Date getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(Date start) {
		this.start = start;
	}

	/**
	 * @return the expiry
	 */
	public Date getExpiry() {
		return expiry;
	}

	/**
	 * @param expiry the expiry to set
	 */
	public void setExpiry(Date expiry) {
		this.expiry = expiry;
	}

	/**
	 * @return the sponsor
	 */
	public String getSponsor() {
		return sponsor;
	}

	/**
	 * @param sponsor the sponsor to set
	 */
	public void setSponsor(String sponsor) {
		this.sponsor = sponsor;
	}
	
	
	@Override
	public String toString() {
		return "visa number: " + visanumber + ", start: " + start
				+ ", expiry: " + expiry + ", sponsor: " + sponsor;
	}

	
}