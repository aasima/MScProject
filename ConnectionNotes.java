/**
 * 
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
/**
 * @author Aasima
 *
 */
public class ConnectionNotes {

/*	 private static Connection connection;
	 private static Statement statement;
	 private static ResultSet rs;
	// Server & DB
	
	// jdbc:sqlserver://[serverName[\instanceName][:portNumber]][;property=value[;property=value]]
	
	 //static String serverName = "AASIMA-PC\\SQLEXPRESS";
	//static String instanceName = "/SQLEXPRESS"  
	static String userName = "Aasima-PC\\Aasima";
	 
	static String DB_URL = "jdbc:sqlserver:AASIMA-PC\\SQLEXPRESS;DatabaseName=MSC";
	

	public static void main (String [] args){
		try{
			
		
		connection = DriverManager.getConnection(DB_URL);
		statement = connection.createStatement();
	
		rs = statement.executeQuery("select column_name,* from information_schema.columns where table_name = 'USER';");
		
		System.out.println(rs);
		}
		catch (SQLException sqlException ){
			sqlException.printStackTrace();
			}
	
	}
	*/
	
	public static void main (String [] args){
	
    Connection conn = null;
    String dbName = "MSC";
    String serverip="AASIMA-PC\\SQLEXPRESS";
    String serverport="1433";
    String url = "jdbc:sqlserver://"+serverip+":"+serverport+";databaseName="+dbName+"";
    //Statement stmt = null;
    //ResultSet result = null;
    String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String databaseUserName = "msc";
    String databasePassword = "msc"; 
    
    try {
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url, databaseUserName, databasePassword);
        System.out.println("connection successful");
      //  stmt = conn.createStatement();
        //result = null;
        //String pa,us;
        //result = stmt.executeQuery("select * from USER ")

     /*   while (result.next()) {
            us=result.getString("uname");
            pa = result.getString("pass");              
            System.out.println(us+"  "+pa);
        }
*/
        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
	
	
	}}
	
	
	/*
	 * 
	 * 
	 * 
	 * 
	 */


	
	
	// Client & Server
	
	// Server = ServerSocket
	
	/*
	 * ServerSocket s = new ServerSocket(8189); 
	 * Socket connection = s.accept();
	 * 
	 * BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	 * PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
	 * 
	 */
	
	// Client
	
	/*
	 * String serverAddress = "localhost";
	 * int port = 8189;
	 * 
	 * Socket connection = new Socket( serverAddress, port );
	 * 
	 * BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	 * PrintWriter out = new PrintWriter(connection.getOutputStream(), true);
	 * 
	 * 
	 */

