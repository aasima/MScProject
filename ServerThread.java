
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;

/**
 * 
 * @author Aasima Pathan
 *
 */
public class ServerThread extends Thread {


	private Socket socket = null;
	private boolean connected = false;
	private ResultSet rs;

	private ObjectOutputStream out;
	private ObjectInputStream in;

	
    public ServerThread(Socket socket) {
        this.socket = socket;
    }
	
	
	public void run(){
	
			 try {
				
				 out = new ObjectOutputStream(socket.getOutputStream());
				 in = new ObjectInputStream(socket.getInputStream());
				 out.flush(); 
				 connected = true; 
	           
	        
				 while (connected){
	        	 process();
	         }
	         
			 } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
	}
		 
	 
	
	
	


	private void process() {
		try {
			Object input = in.readObject();
			
			
			if (input instanceof Login){
				//get username and password
				String username = ((Login) input).getUsername();
				String password = new String (((Login) input).getPassword());
				
				
				
					CallableStatement cs = Server.getDb().getConn().prepareCall("{call Test.dbo.CheckLogin(?,?,?)}");
					cs.setString(1, username);
					cs.setString(2, password);
					cs.registerOutParameter(3, java.sql.Types.TINYINT);
					cs.execute();
					Integer result = cs.getInt(3);
					out.writeObject(result);
					
					if (result == 1){
						User user;
						StudentInfo stud;
						Visa v;
						String getUser = "SELECT id, usertypeid, firstname, lastname, email FROM Test.dbo.[user] where username = ?";
						PreparedStatement pstmt = Server.getDb().getConn().prepareStatement(getUser);
						pstmt.setString(1, username);
						rs = pstmt.executeQuery();
						
						while (rs.next()){
							int id = rs.getInt("id");
							int usertype = rs.getInt("usertypeid");
							String first = rs.getString("firstname");
							String last = rs.getString("lastname");
							String email = rs.getString("email");
							
							user = new User(id, usertype, username, first, last, email);
							out.writeObject(user);
							
							if (usertype ==1){
								String getStudent = "Select * from Test.dbo.[student] where [student].id = ? ";
								PreparedStatement student = Server.getDb().getConn().prepareStatement(getStudent);
								student.setString(1, username);
								ResultSet studentInfo = student.executeQuery();
								while (studentInfo.next()){
									String home = studentInfo.getString("home/overseas");
									String status = studentInfo.getString("status");
									int supervisor = studentInfo.getInt("supervisorid");
									double attendance = studentInfo.getDouble("attendance");
									java.sql.Date completion = studentInfo.getDate("completiondate");
									String visa = studentInfo.getString("visanumber");
									java.sql.Date start = studentInfo.getDate("start");
									java.sql.Date expiry = studentInfo.getDate("expiry");
									String sponsor = studentInfo.getString("sponsornumber");
									
									stud = new StudentInfo(status, home, attendance, supervisor, completion);
									out.writeObject(stud);
									
									if (visa == null && start == null && expiry == null && sponsor == null){
										 v = new Visa();
										out.writeObject(v);
									}
									else {
										 v= new Visa(visa, start, expiry, sponsor);
										 out.writeObject(v);
									}
								}
								
								Form form;
								CallableStatement getForm = Server.getDb().getConn().prepareCall("{call Test.dbo.GetCurrentForm(?)}");
								getForm.setString(1, username);
								ResultSet formInfo = getForm.executeQuery();
								while (formInfo.next()){
									int formid = formInfo.getInt("id");
									Date created = formInfo.getDate("datecreated");
									int stuID = formInfo.getInt("studentid");
									int supID = formInfo.getInt("supervisorid");
									String desc = formInfo.getString("description");
									String summ = formInfo.getString("summary");
									String atten = formInfo.getString("attendance");
									String attenEx  = formInfo.getString("attendanceextra");
									String prog  = formInfo.getString("progress");
									String progEx = formInfo.getString("progressextra");
									int studAg = formInfo.getInt("studentagrees");
									int supAg = formInfo.getInt("supervisoragrees");
									Date due = formInfo.getDate("due");
									Date duedate = formInfo.getDate("duedate");
									
									form = new Form(formid, created, stuID, supID, desc, summ, prog, progEx, atten, attenEx, studAg, supAg, due, duedate);
									out.writeObject(form);
								}
								ArrayList<String> forms = new ArrayList<String>();
								String getForms = "select * from Test.dbo.[form] where form.studentid = ? AND (due < getdate() OR duedate < getdate())" ;
								PreparedStatement pForms = Server.getDb().getConn().prepareStatement(getForms);
								pForms.setString(1, username);
								ResultSet formRS = pForms.executeQuery();
								while (formRS.next()){
									String formid = formRS.getString("id");
									String progress = formRS.getString("progress");
									String attendance = formRS.getString("attendance");
									String due = formRS.getString("due");
									String duedate = formRS.getString("duedate");
									
									forms.add(formid);
									forms.add(progress);
									forms.add(attendance);
									forms.add(due);
									forms.add(duedate);
								}
								out.writeObject(forms);
								
							} else if (usertype == 2){
								CallableStatement getForms = Server.getDb().getConn().prepareCall("{call Test.dbo.SupervisorCurrentForms(?)}");
								getForms.setInt(1, id);
								getForms.execute();
								ResultSet formRS = getForms.getResultSet();
								ArrayList<String> forms = new ArrayList<String>();
								while (formRS.next()){
									
									
									String formid = formRS.getString("id");
									String studentid = formRS.getString("studentid");
									String fname = formRS.getString("firstname");
									String lname = formRS.getString("lastname");
									String due = formRS.getString("due");
									String duedate = formRS.getString("duedate");
									
									forms.add(formid);
									forms.add(studentid);
									forms.add(fname);
									forms.add(lname);
									forms.add(due);
									forms.add(duedate);
								
								}
								out.writeObject(forms);
							}
						}
					}
			}
			else if (input instanceof String){
				String in = input.toString();
				
				//ArrayList<ArrayList<String>> form = new ArrayList<ArrayList<String>>();
				ArrayList<String> row = new ArrayList<String>();
			 if (in.startsWith("SUPPREVFORMS")){
				 //
				 CallableStatement getPrevForms = Server.getDb().getConn().prepareCall("{call Test.dbo.SupervisorPrevForms(?)}");
				 getPrevForms.setString(1, in.substring(12));
				 ResultSet prevForms = getPrevForms.executeQuery();
				 while(prevForms.next()){

						String formid = prevForms.getString("id");
						String studentid = prevForms.getString("studentid");
						String fname = prevForms.getString("firstname");
						String lname = prevForms.getString("lastname");
						String due = prevForms.getString("due");
						String duedate = prevForms.getString("duedate");
						
						row.add(formid);
						row.add(studentid);
						row.add(fname);
						row.add(lname);
						row.add(due);
						row.add(duedate);
					
					}
					out.writeObject(row);
			 }
			 else if (in.startsWith("FORMID")) {
				String getForm = "Select * from Test.dbo.form where form.id =?";
				PreparedStatement PS_Form = Server.getDb().getConn().prepareStatement(getForm);
				PS_Form.setString(1, in.substring(6));
				ResultSet Aform = PS_Form.executeQuery();
				Form aForm;
				while (Aform.next()){
					int formid = Aform.getInt("id");
					Date created = Aform.getDate("datecreated");
					int stuID = Aform.getInt("studentid");
					int supID = Aform.getInt("supervisorid");
					String desc = Aform.getString("description");
					String summ = Aform.getString("summary");
					String atten = Aform.getString("attendance");
					String attenEx  = Aform.getString("attendanceextra");
					String prog  = Aform.getString("progress");
					String progEx = Aform.getString("progressextra");
					int studAg = Aform.getInt("studentagrees");
					int supAg = Aform.getInt("supervisoragrees");
					Date due = Aform.getDate("due");
					Date duedate = Aform.getDate("duedate");
					
					aForm = new Form(formid, created, stuID, supID, desc, summ, prog, progEx, atten, attenEx, studAg, supAg, due, duedate);
					out.writeObject(aForm);
				}
				} else if (in.startsWith("LOGOUT")){
					logout();
				}else if (in.startsWith("VIEWALLFORMS")){
					CallableStatement getForms = Server.getDb().getConn().prepareCall("{call Test.dbo.AllForms}");
					ResultSet table = getForms.executeQuery();
					while (table.next()){
						String formid = table.getString("id");
						String studentid = table.getString("studentid");
						String supervisorid = table.getString("supervisorid");
						String progress = table.getString("progress");
						String attendance = table.getString("attendance");
						String studentagrees = table.getString("studentagrees");
						String supervisoragrees = table.getString("supervisoragrees");
						String due = table.getString("due");
						String duedate = table.getString("duedate");
								
						row.add(formid);
						row.add(studentid);
						row.add(supervisorid);
						row.add(progress);
						row.add(attendance);
						row.add(studentagrees);
						row.add(supervisoragrees);
						row.add(due);
						row.add(duedate);
						
						//form.add(row);
					} out.writeObject(row);
				
					
				}else if (in.startsWith("VIEWFORMSTUDENT")){
					CallableStatement getForms = Server.getDb().getConn().prepareCall("{call Test.dbo.FormsByStudent(?)}");
					String id = in.substring(15);
					getForms.setString(1, id);
					ResultSet table = getForms.executeQuery();
					while (table.next()){
						String formid = table.getString("id");
						String studentid = table.getString("studentid");
						String supervisorid = table.getString("supervisorid");
						String progress = table.getString("progress");
						String attendance = table.getString("attendance");
						String studentagrees = table.getString("studentagrees");
						String supervisoragrees = table.getString("supervisoragrees");
						String due = table.getString("due");
						String duedate = table.getString("duedate");
								
						row.add(formid);
						row.add(studentid);
						row.add(supervisorid);
						row.add(progress);
						row.add(attendance);
						row.add(studentagrees);
						row.add(supervisoragrees);
						row.add(due);
						row.add(duedate);
						
						//form.add(row);
					} out.writeObject(row);
					
				}else if (in.startsWith("VIEWFORMDATE")){
			
					CallableStatement getForms = Server.getDb().getConn().prepareCall("{call Test.dbo.FormsByDate(?,?)}");
					String month = in.substring(12, 14);
					String year = in.substring(14);
					getForms.setString(1, month);
					getForms.setString(2, year);
					ResultSet table = getForms.executeQuery();
					while (table.next()){
						String formid = table.getString("id");
						String studentid = table.getString("studentid");
						String supervisorid = table.getString("supervisorid");
						String progress = table.getString("progress");
						String attendance = table.getString("attendance");
						String studentagrees = table.getString("studentagrees");
						String supervisoragrees = table.getString("supervisoragrees");
						String due = table.getString("due");
						String duedate = table.getString("duedate");
								
						row.add(formid);
						row.add(studentid);
						row.add(supervisorid);
						row.add(progress);
						row.add(attendance);
						row.add(studentagrees);
						row.add(supervisoragrees);
						row.add(due);
						row.add(duedate);
						
						//form.add(row);
					
					} out.writeObject(row);
				}else if (in.startsWith("VIEWFORMOVERSEAS")){
					CallableStatement getForms = Server.getDb().getConn().prepareCall("{call Test.dbo.OverseasForms}");
					ResultSet table = getForms.executeQuery();
					while (table.next()){
						String formid = table.getString("id");
						String studentid = table.getString("studentid");
						String supervisorid = table.getString("supervisorid");
						String progress = table.getString("progress");
						String attendance = table.getString("attendance");
						String studentagrees = table.getString("studentagrees");
						String supervisoragrees = table.getString("supervisoragrees");
						String due = table.getString("due");
						String duedate = table.getString("duedate");
								
						row.add(formid);
						row.add(studentid);
						row.add(supervisorid);
						row.add(progress);
						row.add(attendance);
						row.add(studentagrees);
						row.add(supervisoragrees);
						row.add(due);
						row.add(duedate);
						
						//form.add(row);
					} out.writeObject(row);
					
				}else if (in.startsWith("VIEWFORMHOME")){
					CallableStatement getForms = Server.getDb().getConn().prepareCall("{call Test.dbo.HomeForms}");
					ResultSet table = getForms.executeQuery();
					while (table.next()){
						String formid = table.getString("id");
						String studentid = table.getString("studentid");
						String supervisorid = table.getString("supervisorid");
						String progress = table.getString("progress");
						String attendance = table.getString("attendance");
						String studentagrees = table.getString("studentagrees");
						String supervisoragrees = table.getString("supervisoragrees");
						String due = table.getString("due");
						String duedate = table.getString("duedate");
								
						row.add(formid);
						row.add(studentid);
						row.add(supervisorid);
						row.add(progress);
						row.add(attendance);
						row.add(studentagrees);
						row.add(supervisoragrees);
						row.add(due);
						row.add(duedate);
						
					} out.writeObject(row);
				}else if (in.startsWith("VIEWFORMOVERDUE")){
					CallableStatement getForms = Server.getDb().getConn().prepareCall("{call Test.dbo.OverdueForms}");
					ResultSet table = getForms.executeQuery();
					while (table.next()){
						String formid = table.getString("id");
						String studentid = table.getString("studentid");
						String supervisorid = table.getString("supervisorid");
						String progress = table.getString("progress");
						String attendance = table.getString("attendance");
						String studentagrees = table.getString("studentagrees");
						String supervisoragrees = table.getString("supervisoragrees");
						String due = table.getString("due");
						String duedate = table.getString("duedate");
								
						row.add(formid);
						row.add(studentid);
						row.add(supervisorid);
						row.add(progress);
						row.add(attendance);
						row.add(studentagrees);
						row.add(supervisoragrees);
						row.add(due);
						row.add(duedate);
						
						//form.add(row);
					} out.writeObject(row);
				}
				
				
			}
			else if (input instanceof Form){
				
				int id = ((Form) input).getId();
				//Date created = ((Form) input).getCreated();
				//int studentid = ((Form) input).getStudentid();
				//int supervisorid = ((Form) input).getSupervisorid();
				String description = ((Form) input).getDescription();
				String summary = ((Form) input).getSummary();
				String progress = ((Form) input).getProgress();
				String progressExtra = ((Form) input).getProgressExtra();
				String attendance = ((Form) input).getAttendance();
				String attendanceExtra = ((Form) input).getAttendanceExtra();
				int supervisoragrees = ((Form) input).getSupervisoragrees();
				int studentagrees = ((Form) input).getStudentagrees();
				//Date due = ((Form) input).getDue();
				//Date duedate = ((Form) input).getDuedate();
				
				
				CallableStatement formUpdate = Server.getDb().getConn().prepareCall("{call Test.dbo.UpdateForm(?,?,?,?,?,?,?,?,?)}");
				formUpdate.setString(1, description);
				formUpdate.setString(2, summary);
				formUpdate.setString(3, progress);
				formUpdate.setString(4, progressExtra);
				formUpdate.setString(5, attendance);
				formUpdate.setString(6, attendanceExtra);
				formUpdate.setInt(7, studentagrees);
				formUpdate.setInt(8, supervisoragrees);
				formUpdate.setInt(9, id);
				formUpdate.execute();
				
				
			} 
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	
	}


	private void logout() {
		try {
			out.close();
			in.close();
			socket.close();
			connected = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}



