import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


/**
 * 
 * @author Aasima Pathan
 *
 */
public class Client {

	
private static Socket client;
private int portNumber = 6630;
private static boolean connected = false;
private static User user;
private static StudentInfo student;
//private static Query query;
private static String query;
//private static DateQuery date;
private static Visa visa; 
private static Form form;
private static String singleForm;
private static String supervisorEmail;
private static String studentEmail;
private static DefaultTableModel model;
private static DefaultTableModel table;
private static ArrayList<String> currentformlist;
private static ArrayList<String> previousformlist;

String message;
private static ObjectOutputStream out;
private static ObjectInputStream in;


    public Client() {
        
            try{
            	client = new Socket("localhost", portNumber); 
            	out = new ObjectOutputStream(client.getOutputStream()); 
            	setIn(new ObjectInputStream(client.getInputStream()));
            	out.flush();
            	connected = true;
            
            LoginGUI login = new LoginGUI();
            login.launch();
            
      
            } catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
    }
    
    public static void main(String[] args){
    	Client c = new Client();
    }

@SuppressWarnings("unchecked")
public static boolean login(String username, String encryptedPassword) {

		Integer result = null;
		Login login = new Login (username, encryptedPassword);
		try {
			out.writeObject(login);
			
			result = (Integer) in.readObject();
			
			if(result.equals(1))
			{
				JOptionPane.showMessageDialog(null, "Log in successful");
				user = (User) in.readObject();
				int usertype = user.getUsertype();
				
				if (usertype == 1){
					student = ((StudentInfo) in.readObject());
					visa = ((Visa) in.readObject());
					form = (Form) in.readObject();
					
					String[] col = {"form", "progress", "attendance", "due", "due date"};
					previousformlist = (ArrayList<String>) in.readObject();
					int listCount = 0;
					Object [][] formlist = new Object [previousformlist.size()/5][5];
					for (int i = 0; i < formlist.length; i++) {
					    for (int j = 0; j < formlist[0].length; j++) {
					        formlist[i][j] = previousformlist.get(listCount);
					        listCount++;
					    }
					}
					model = new DefaultTableModel(formlist,col);

					new StudentMenuGUI().setVisible(true);
					
				} else if (usertype == 2){
					
					String [] col = {"form","studentID", "first name", "last name", "due", "duedate"};
					int listCount = 0;
					currentformlist = (ArrayList<String>) in.readObject();
					Object[][] formlist =  new Object [currentformlist.size()/6][6];					
					for (int i = 0; i < formlist.length; i++) {
					    for (int j = 0; j < formlist[0].length; j++) {
					        formlist[i][j] = currentformlist.get(listCount);
					        listCount++;
					    }
					}
					model = new DefaultTableModel(formlist,col);
					new SupervisorMenuGUI().setVisible(true);
					
				} else if (usertype == 3){
					//model = new DefaultTableModel();
					new AdminMenuGUI().setVisible(true);
					
				}
				
				return true;
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Incorrect ID or password");
				return false;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return false;
	}

	@SuppressWarnings("unchecked")
	public static void adminProcess() {
		
		try{
			Object input = in.readObject();
			String [] col = {"form id", "student id", "supervisor id", "progress", "attendance", "studentagrees", "supervisoragrees","due", "duedate"};
			
			
		if (input instanceof ArrayList<?>){
		ArrayList<String> values = (ArrayList<String>) input;
		
		int valuesCount = 0;
		
		Object [][] formlist = new Object [values.size()/9][9];
		

		for (int i = 0; i < formlist.length; i++) {
		    for (int j = 0; j < formlist[0].length; j++) {
		        formlist[i][j] = values.get(valuesCount);
		        valuesCount++;
		    }
		}
		table = new DefaultTableModel(formlist,col);
		TableViewer view = new TableViewer();
		view.launch();
		
		}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
}




	/**
	 * @return the in
	 */
	public ObjectInputStream getIn() {
		return in;
	}

	/**
	 *  formUpdate sends updated form to the Server to be stored in database.
	 *  Then the method needs to send email to the other user
	 */
		public static void formUpdate() {

			try {
				out.writeObject(form);
				
						 JOptionPane.showMessageDialog(null, "Form updated");
					 

				
				if (user.getUsertype() == 1){
					// form update successful 
				}
				else if (user.getUsertype() == 2){
					// form update successful 
				}
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}



public static void requestForm() {
	try {
		out.writeObject(singleForm);
		
		form = (Form) in.readObject();
		new FormGUI().setVisible(true);
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public static void requestPreviousForm() {
	try {
		out.writeObject(singleForm);
		
		form = (Form) in.readObject();
		new FormView().setVisible(true);
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}

public static void sendQuery() {
	try {
		out.writeObject(query);
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
}
	/**
	 * @param in the in to set
	 */
	public void setIn(ObjectInputStream in) {
		Client.in = in;
	}

	/**
	 * @return the out
	 */
	public ObjectOutputStream getOut() {
		return out;
	}

	/**
	 * @param out the out to set
	 */
	public void setOut(ObjectOutputStream out) {
		Client.out = out;
	}

	/**
	 * @return the user
	 */
	public static User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public static void setUser(User user) {
		Client.user = user;
	}

	/**
	 * @return the student
	 */
	public static StudentInfo getStudent() {
		return student;
	}

	/**
	 * @param student the student to set
	 */
	public static void setStudent(StudentInfo student) {
		Client.student = student;
	}

	/**
	 * @return the visa
	 */
	public static Visa getVisa() {
		return visa;
	}

	/**
	 * @param visa the visa to set
	 */
	public static void setVisa(Visa visa) {
		Client.visa = visa;
	}

	/**
	 * @return the form
	 */
	public static Form getForm() {
		return form;
	}

	/**
	 * @param form the form to set
	 */
	public static void setForm(Form form) {
		Client.form = form;
	}

	/**
	 * @return the formlist
	 */
	public static ArrayList<String> getFormlist() {
		return previousformlist;
	}

	/**
	 * @param formlist the formlist to set
	 */
	public static void setFormlist(ArrayList<String> formlist) {
		Client.previousformlist = formlist;
	}

	/**
	 * @return the currentformlist
	 */
	public static ArrayList<String> getCurrentformlist() {
		return currentformlist;
	}

	/**
	 * @param currentformlist the currentformlist to set
	 */
	public static void setCurrentformlist(ArrayList<String> currentformlist) {
		Client.currentformlist = currentformlist;
	}




/**
 * @return the model
 */
public static TableModel getModel() {
	return model;
}




/**
 * @param model the model to set
 */
public static void setModel(DefaultTableModel model) {
	Client.model = model;
}




/**
 * @return the singleForm
 */
public static String getSingleForm() {
	return singleForm;
}




/**
 * @param singleForm the singleForm to set
 */
public static void setSingleForm(String singleForm) {
	Client.singleForm = singleForm;
}


/**
 * @param query the query to set
 */
public static void setQuery(String query) {
	Client.query = query;
}

/**
 * @return the table
 */
public static TableModel getTable() {
	return table;
}

/**
 * @param table the table to set
 */
public static void setTable(DefaultTableModel table) {
	Client.table = table;
}

public static void logout () {

	String logout = "LOGOUT";
	
	table = null;
	model = null;
	visa = null;
	user = null;
	form = null;
	query = null;
	student=null;
	currentformlist = null;
	previousformlist = null;
	
	try {
		out.writeObject(logout);
		out.close();
		in.close();
		client.close();
		
		connected = false;
	
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

@SuppressWarnings("unchecked")
public static void supervisorProcess() {
	try{
		Object input = in.readObject();
		String [] col = {"form","studentID", "first name", "last name", "due", "duedate"};
		
		
	if (input instanceof ArrayList<?>){
	ArrayList<String> prevForms = (ArrayList<String>) input;
	
	int count = 0;
	
	Object [][] formlist = new Object [prevForms.size()/6][6];
	

	for (int i = 0; i < formlist.length; i++) {
	    for (int j = 0; j < formlist[0].length; j++) {
	        formlist[i][j] = prevForms.get(count);
	        count++;
	    }
	}
	table = new DefaultTableModel(formlist,col);
	PreviousFormSelection select = new PreviousFormSelection();
	select.launch();
	
	}
	
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}







    
}