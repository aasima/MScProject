import java.io.IOException;
import java.net.ServerSocket;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 
 * @author Aasima Pathan
 *
 */
public class Server {

	private ServerSocket server;
	private int portNumber = 6630;	
	private static Database db;
	private boolean running = false;

	/**
	 * 
	 * @return isRunning() boolean value
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * Set running variable
	 * @param running
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}

	/**
	 * @return the db
	 */
	public static Database getDb() {
		return db;
	}

	/**
	 * @param db the db to set
	 */
	public void setDb(Database db) {
		this.db = db;
	}

	/**
	 * Constructor for server connects to database and sets up ServerSocket ("handshake point") to a specified port
	 */
	public Server(){
		
	
				try {
					setDb(new Database());
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				
				 try {
					 server = new ServerSocket(portNumber);
					 running = true;
					 System.out.println("Server running");
					 
					 while (running) {
			            new ServerThread(server.accept()).start(); // accepts connection and assigns each client a new ServerThread
			        }
					 
				 } catch (IOException e) {
		            System.out.println("Could not listen on port " + portNumber);
		            
		        }
			 
	}

	public static void main(String[] args) {
		Server s = new Server();
	}



	

}
