import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class CheckDB extends TimerTask {

	Calendar nextCheck;
	Calendar today;
	
	Calendar formCreation;
	Calendar formReminder;
	
	
  public void run() {
    System.out.println("Generating report");
    //TODO generate report
  }


/**
 * @return the nextCheck
 */
public Calendar getNextCheck() {
	return nextCheck;
}


/**
 * @param nextCheck the nextCheck to set
 */
public void setNextCheck(Calendar nextCheck) {
	this.nextCheck = nextCheck;
}


/**
 * @return the today
 */
public Calendar getToday() {
	return today;
}


/**
 * @param today the today to set
 */
public void setToday(Calendar today) {
	this.today = today;
}


/**
 * @return the formCreation
 */
public Calendar getFormCreation() {
	return formCreation;
}


/**
 * @param formCreation the formCreation to set
 */
public void setFormCreation(Calendar formCreation) {
	this.formCreation = formCreation;
}


/**
 * @return the formReminder
 */
public Calendar getFormReminder() {
	return formReminder;
}


/**
 * @param formReminder the formReminder to set
 */
public void setFormReminder(Calendar formReminder) {
	this.formReminder = formReminder;
}

}

class MainApplication {

  public static void main(String[] args) {
    Timer timer = new Timer();
    Calendar date = Calendar.getInstance();
    
    date.set(Calendar.HOUR, 0);
    date.set(Calendar.MINUTE, 0);
    date.set(Calendar.SECOND, 0);
    date.set(Calendar.MILLISECOND, 0);
    
    timer.schedule(new CheckDB(), date.getTime(), 1000 * 60 * 60 * 24 );
  }
}
	

